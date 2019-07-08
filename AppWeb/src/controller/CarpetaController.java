package controller;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.ejb.model.Carpeta;
import com.ejb.session.CarpetaSession;
import com.ejb.session.EjbCarpetaSession;

@SuppressWarnings("deprecation")
@ManagedBean(name="carpetaController")
@SessionScoped
public class CarpetaController implements Serializable {


	private static final long serialVersionUID = 1L;
	
	//llame o conecte con la capa de presentacion
	
	@EJB 
	private CarpetaSession ejCarpetaSession; //instancia un objeto carpetasession
	
	//crear un objeto listar
	public Carpeta carpeta ;
		
		//objeto para cargar la lista de carpeta
		DataModel<Carpeta> listarC;
		
		private int estado;
		private String mensaje;
		
		
		//siempre se debe crear para q no genere error de objetos vacios 
		
		public CarpetaController() {
			if  (carpeta != null) {
				carpeta =new Carpeta();
				
			}
		}


		public Carpeta getCarpeta() {
			return carpeta;
		}


		public void setCarpeta(Carpeta carpeta) {
			
			this.carpeta = carpeta;
		}

		//modificar el listar con el metodo listar del EJB
		
		public DataModel<Carpeta> getListarC() {
			listarC=new ListDataModel<Carpeta>(ejCarpetaSession.listar());
			return listarC;
		}


		public void setListarC(DataModel<Carpeta> listarC) {
			this.listarC = listarC;
		}


		public int getEstado() {
			return estado;
		}


		public void setEstado(int estado) {
			this.estado = estado;
		}


		public String getMensaje() {
			return mensaje;
		}


		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		
		//metodo limpiar
		public void limpiar() {
			carpeta = new Carpeta();
			estado=0;
		}
		
		//metodo actualizar y grabar
		public String grabar () {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(getEstado()==1) {
					mensaje=ejCarpetaSession.actualizar(carpeta);
					context.addMessage(null, new FacesMessage(mensaje.toString()));
				}else {
					mensaje=ejCarpetaSession.grabar(carpeta);
					context.addMessage(null, new FacesMessage(mensaje.toString()));
				}
			} catch (Exception e) {
				mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e.toString()).toString();
			}
			return null;
		}
		
		
		public void buscar(ActionEvent  e) throws Exception{
			carpeta = new Carpeta(); 
			carpeta.setId(e.getComponent().
					getAttributes().get("carpetabuscar").hashCode());
			carpeta=ejCarpetaSession.buscar(carpeta);
			
			if(carpeta !=  null) {
				carpeta.getId();
				carpeta.getNombre();
				setEstado(1);
			}
		}
		
		public void eliminar (ActionEvent e) {// actionevent puedo obtener los datos, atributos
			
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				carpeta = new Carpeta();//objtto vcaio
				carpeta.setId(e.getComponent()//cargamos id
						.getAttributes().get("carpetaeliminar").hashCode());//objrto con id
				
				//eliminar
				mensaje=ejCarpetaSession.eliminar(carpeta);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
				
				
				
			} catch (Exception e2) {
				mensaje = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"error",
						e2.toString()).toString();
				e2.printStackTrace();
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			
		}
		
		
	}
	



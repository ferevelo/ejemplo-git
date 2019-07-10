package controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.ejb.model.Canton;
import com.ejb.model.Carpeta;
import com.ejb.model.Pais;
import com.ejb.model.Parroquia;
import com.ejb.model.Provincia;
import com.ejb.session.CantonSession;
import com.ejb.session.CarpetaSession;
import com.ejb.session.EjbCarpetaSession;
import com.ejb.session.PaisSession;
import com.ejb.session.ParroquiaSession;
import com.ejb.session.ProvinciaSession;

@SuppressWarnings("deprecation")
@ManagedBean(name="carpetaController")
@SessionScoped
public class CarpetaController implements Serializable {


	private static final long serialVersionUID = 1L;
	
	//llame o conecte con la capa de presentacion
	
	@EJB 
	private CarpetaSession ejCarpetaSession; //instancia un objeto carpetasession
	
	@EJB 
	private PaisSession ejPaisSession;
	@EJB 
	private ProvinciaSession ejProvinciaSession;
	@EJB 
	private CantonSession ejCantonSession;
	@EJB 
	private ParroquiaSession ejParroquiaSession;
	
	
	//crear un objeto listar
	public Carpeta carpeta ;
		
		//objeto para cargar la lista de carpeta
		DataModel<Carpeta> listarC;
		private ArrayList<SelectItem>PaisArray;
		private ArrayList<SelectItem>ProvinciaArray;
		private ArrayList<SelectItem>CantonArray;
		private ArrayList<SelectItem>ParroquiaArray;
		
		//area de estudio
		List<String> areaEstudioLista =new ArrayList<String>();
		
		private int estado;
		private String mensaje;
		private String pais,provincia,canton,parroquia;
		
		
		//siempre se debe crear para q no genere error de objetos vacios 
		
		public CarpetaController() {
			if  (carpeta != null) {
				carpeta =new Carpeta();
				
			}
		}

		//objeto para cargarlos en tiempo de ejecucion
		
		@PostConstruct //carga datos antes que se ejecute el controller o el form
		public void init() {
			areaEstudioLista =new ArrayList<String>();
			areaEstudioLista.add("administracion");
			areaEstudioLista.add("Investigacion");
			areaEstudioLista.add("educacion");
			areaEstudioLista.add("sistemas");
		}

		
		
		
		public ArrayList<SelectItem> getPaisArray() {
			
			PaisArray = new ArrayList<SelectItem>();
			for(Pais obj:ejPaisSession.listar()) {
				
				PaisArray.add(
						new SelectItem(obj.getId().toString(),
						obj.getDescPais()));
				
			}
			return PaisArray;
		}

		public void setPaisArray(ArrayList<SelectItem> paisArray) {
			PaisArray = paisArray;
		}

		public ArrayList<SelectItem> getProvinciaArray() {
			ProvinciaArray = new ArrayList<SelectItem>();
			for(Provincia obj:ejProvinciaSession.listar()) {
				
				ProvinciaArray.add(
						new SelectItem(obj.getId().toString(),
						obj.getDescProvincia()));
				
			}
			return ProvinciaArray;
		}

		public void setProvinciaArray(ArrayList<SelectItem> provinciaArray) {
			ProvinciaArray = provinciaArray;
		}

		public ArrayList<SelectItem> getCantonArray() {
			
			CantonArray = new ArrayList<SelectItem>();
			for(Canton obj:ejCantonSession.listar()) {
				
				CantonArray.add(
						new SelectItem(obj.getId().toString(),
						obj.getDescCanton()));
				
			}
			return CantonArray;
		}

		public void setCantonArray(ArrayList<SelectItem> cantonArray) {
			CantonArray = cantonArray;
		}

		public ArrayList<SelectItem> getParroquiaArray() {
			
			ParroquiaArray = new ArrayList<SelectItem>();
			for(Parroquia obj:ejParroquiaSession.listar()) {
				
				ParroquiaArray.add(
						new SelectItem(obj.getId().toString(),
						obj.getDescParroquia()));
				
			}
			return ParroquiaArray;
		}

		public void setParroquiaArray(ArrayList<SelectItem> parroquiaArray) {
			ParroquiaArray = parroquiaArray;
		}

		public List<String> getAreaEstudioLista() {
			return areaEstudioLista;
		}

		public void setAreaEstudioLista(List<String> areaEstudioLista) {
			this.areaEstudioLista = areaEstudioLista;
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

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}

		public String getCanton() {
			return canton;
		}

		public void setCanton(String canton) {
			this.canton = canton;
		}

		public String getParroquia() {
			return parroquia;
		}

		public void setParroquia(String parroquia) {
			this.parroquia = parroquia;
		}
		
		
		
		
		
	}
	



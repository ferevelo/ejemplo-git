package puce.web.test;
//import javax.persistence.Entity;

import java.io.Serializable;


//import javax.persistence.*;

import javax.persistence.*;

@Entity //convertir en tabla
@Table (name="Alergia")//nombre de la tabla en bdd
public class Alergia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id //campo principal
	@GeneratedValue(strategy=GenerationType.IDENTITY)//genere automatica
	private Integer id;
	
	private String descripcion;
	
	private String observacion;
	
	public Alergia() {
		
	}

	public void mostrar () {
		System.out.println(getId()+ " " 
	+getDescripcion() +" "+ getObservacion());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}

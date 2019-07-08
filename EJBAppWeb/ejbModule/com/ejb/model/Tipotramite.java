package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ar_tipotramite database table.
 * 
 */
@Entity
@Table(name="ar_tipotramite")
@NamedQuery(name="Tipotramite.findAll", query="SELECT t FROM Tipotramite t")
public class Tipotramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Documentacion
	@OneToMany(mappedBy="arTipotramite")
	private List<Documentacion> arDocumentacions;

	public Tipotramite() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Documentacion> getArDocumentacions() {
		return this.arDocumentacions;
	}

	public void setArDocumentacions(List<Documentacion> arDocumentacions) {
		this.arDocumentacions = arDocumentacions;
	}

	public Documentacion addArDocumentacion(Documentacion arDocumentacion) {
		getArDocumentacions().add(arDocumentacion);
		arDocumentacion.setArTipotramite(this);

		return arDocumentacion;
	}

	public Documentacion removeArDocumentacion(Documentacion arDocumentacion) {
		getArDocumentacions().remove(arDocumentacion);
		arDocumentacion.setArTipotramite(null);

		return arDocumentacion;
	}

}
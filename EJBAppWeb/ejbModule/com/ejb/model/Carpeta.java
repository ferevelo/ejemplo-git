package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ar_carpeta database table.
 * 
 */
@Entity
@Table(name="ar_carpeta")
@NamedQuery(name="Carpeta.findAll", query="SELECT c FROM Carpeta c")
public class Carpeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	public Carpeta() {
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

}
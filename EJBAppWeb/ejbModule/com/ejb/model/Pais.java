package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the th_pais database table.
 * 
 */
@Entity
@Table(name="th_pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="\"descPais\"")
	private String descPais;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="thPai")
	private List<Provincia> thProvincias;

	public Pais() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescPais() {
		return this.descPais;
	}

	public void setDescPais(String descPais) {
		this.descPais = descPais;
	}

	public List<Provincia> getThProvincias() {
		return this.thProvincias;
	}

	public void setThProvincias(List<Provincia> thProvincias) {
		this.thProvincias = thProvincias;
	}

	//listas
	public Provincia addThProvincia(Provincia thProvincia) {
		getThProvincias().add(thProvincia);
		thProvincia.setThPai(this);

		return thProvincia;
	}

	public Provincia removeThProvincia(Provincia thProvincia) {
		getThProvincias().remove(thProvincia);
		thProvincia.setThPai(null);

		return thProvincia;
	}

}
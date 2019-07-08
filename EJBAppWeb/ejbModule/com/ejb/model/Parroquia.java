package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the th_parroquia database table.
 * 
 */
@Entity
@Table(name="th_parroquia")
@NamedQuery(name="Parroquia.findAll", query="SELECT p FROM Parroquia p")
public class Parroquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="\"descParroquia\"")
	private String descParroquia;

	//bi-directional many-to-one association to Canton
	@ManyToOne
	@JoinColumn(name="\"idCanton\"")
	private Canton thCanton;

	public Parroquia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescParroquia() {
		return this.descParroquia;
	}

	public void setDescParroquia(String descParroquia) {
		this.descParroquia = descParroquia;
	}

	public Canton getThCanton() {
		return this.thCanton;
	}

	public void setThCanton(Canton thCanton) {
		this.thCanton = thCanton;
	}

}
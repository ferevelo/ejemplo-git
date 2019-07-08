package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the th_canton database table.
 * 
 */
@Entity
@Table(name="th_canton")
@NamedQuery(name="Canton.findAll", query="SELECT c FROM Canton c")
public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="\"descCanton\"")
	private String descCanton;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="\"idProvincia\"")
	private Provincia thProvincia;

	//bi-directional many-to-one association to Parroquia
	@OneToMany(mappedBy="thCanton")
	private List<Parroquia> thParroquias;

	public Canton() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescCanton() {
		return this.descCanton;
	}

	public void setDescCanton(String descCanton) {
		this.descCanton = descCanton;
	}

	public Provincia getThProvincia() {
		return this.thProvincia;
	}

	public void setThProvincia(Provincia thProvincia) {
		this.thProvincia = thProvincia;
	}

	public List<Parroquia> getThParroquias() {
		return this.thParroquias;
	}

	public void setThParroquias(List<Parroquia> thParroquias) {
		this.thParroquias = thParroquias;
	}

	public Parroquia addThParroquia(Parroquia thParroquia) {
		getThParroquias().add(thParroquia);
		thParroquia.setThCanton(this);

		return thParroquia;
	}

	public Parroquia removeThParroquia(Parroquia thParroquia) {
		getThParroquias().remove(thParroquia);
		thParroquia.setThCanton(null);

		return thParroquia;
	}

}
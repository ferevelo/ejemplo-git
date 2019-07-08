package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ar_documentacion database table.
 * 
 */
@Entity
@Table(name="ar_documentacion")
@NamedQuery(name="Documentacion.findAll", query="SELECT d FROM Documentacion d")
public class Documentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numorden;

	@Column(name="carpeta_id")
	private Integer carpetaId;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechadocumento;

	@Temporal(TemporalType.DATE)
	private Date fecharecepcion;

	private Timestamp horadocumento;

	private Timestamp horarecepcion;

	private String numdocumento;

	private String numhojas;

	private String observaciones;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="user_verifica_id")
	private Integer userVerificaId;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado arEstado;

	//bi-directional many-to-one association to Origenfuente
	@ManyToOne
	@JoinColumn(name="origen_id")
	private Origenfuente arOrigenfuente;

	//bi-directional many-to-one association to Tipodocumento
	@ManyToOne
	@JoinColumn(name="documento_id")
	private Tipodocumento arTipodocumento;

	//bi-directional many-to-one association to Tipotramite
	@ManyToOne
	@JoinColumn(name="tramite_id")
	private Tipotramite arTipotramite;

	//bi-directional many-to-one association to Unidad
	@ManyToOne
	@JoinColumn(name="unidad_id")
	private Unidad arUnidad;

	public Documentacion() {
	}

	public Integer getNumorden() {
		return this.numorden;
	}

	public void setNumorden(Integer numorden) {
		this.numorden = numorden;
	}

	public Integer getCarpetaId() {
		return this.carpetaId;
	}

	public void setCarpetaId(Integer carpetaId) {
		this.carpetaId = carpetaId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechadocumento() {
		return this.fechadocumento;
	}

	public void setFechadocumento(Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}

	public Date getFecharecepcion() {
		return this.fecharecepcion;
	}

	public void setFecharecepcion(Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}

	public Timestamp getHoradocumento() {
		return this.horadocumento;
	}

	public void setHoradocumento(Timestamp horadocumento) {
		this.horadocumento = horadocumento;
	}

	public Timestamp getHorarecepcion() {
		return this.horarecepcion;
	}

	public void setHorarecepcion(Timestamp horarecepcion) {
		this.horarecepcion = horarecepcion;
	}

	public String getNumdocumento() {
		return this.numdocumento;
	}

	public void setNumdocumento(String numdocumento) {
		this.numdocumento = numdocumento;
	}

	public String getNumhojas() {
		return this.numhojas;
	}

	public void setNumhojas(String numhojas) {
		this.numhojas = numhojas;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserVerificaId() {
		return this.userVerificaId;
	}

	public void setUserVerificaId(Integer userVerificaId) {
		this.userVerificaId = userVerificaId;
	}

	public Estado getArEstado() {
		return this.arEstado;
	}

	public void setArEstado(Estado arEstado) {
		this.arEstado = arEstado;
	}

	public Origenfuente getArOrigenfuente() {
		return this.arOrigenfuente;
	}

	public void setArOrigenfuente(Origenfuente arOrigenfuente) {
		this.arOrigenfuente = arOrigenfuente;
	}

	public Tipodocumento getArTipodocumento() {
		return this.arTipodocumento;
	}

	public void setArTipodocumento(Tipodocumento arTipodocumento) {
		this.arTipodocumento = arTipodocumento;
	}

	public Tipotramite getArTipotramite() {
		return this.arTipotramite;
	}

	public void setArTipotramite(Tipotramite arTipotramite) {
		this.arTipotramite = arTipotramite;
	}

	public Unidad getArUnidad() {
		return this.arUnidad;
	}

	public void setArUnidad(Unidad arUnidad) {
		this.arUnidad = arUnidad;
	}

}
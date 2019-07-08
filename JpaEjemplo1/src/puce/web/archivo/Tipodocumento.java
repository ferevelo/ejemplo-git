package puce.web.archivo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ar_tipodocumento database table.
 * 
 */
@Entity
@Table(name="ar_tipodocumento")
@NamedQuery(name="Tipodocumento.findAll", query="SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Documentacion
	@OneToMany(mappedBy="arTipodocumento")
	private List<Documentacion> arDocumentacions;

	public Tipodocumento() {
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
		arDocumentacion.setArTipodocumento(this);

		return arDocumentacion;
	}

	public Documentacion removeArDocumentacion(Documentacion arDocumentacion) {
		getArDocumentacions().remove(arDocumentacion);
		arDocumentacion.setArTipodocumento(null);

		return arDocumentacion;
	}

}
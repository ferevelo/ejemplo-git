package actividad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbproyecto database table.
 * 
 */
@Entity
@Table(name="tbproyecto")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to EmpXProy
	@OneToMany(mappedBy="tbproyecto")
	private List<EmpXProy> tbEmpXProys;

	public Proyecto() {
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

	public List<EmpXProy> getTbEmpXProys() {
		return this.tbEmpXProys;
	}

	public void setTbEmpXProys(List<EmpXProy> tbEmpXProys) {
		this.tbEmpXProys = tbEmpXProys;
	}

	public EmpXProy addTbEmpXProy(EmpXProy tbEmpXProy) {
		getTbEmpXProys().add(tbEmpXProy);
		tbEmpXProy.setTbproyecto(this);

		return tbEmpXProy;
	}

	public EmpXProy removeTbEmpXProy(EmpXProy tbEmpXProy) {
		getTbEmpXProys().remove(tbEmpXProy);
		tbEmpXProy.setTbproyecto(null);

		return tbEmpXProy;
	}

}
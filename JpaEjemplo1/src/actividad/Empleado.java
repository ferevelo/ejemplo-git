package actividad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbempleado database table.
 * 
 */
@Entity
@Table(name="tbempleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empid;

	private String nombre;

	@Column(name="parking_id")
	private Integer parkingId;

	private double sueldobruto;

	//bi-directional many-to-one association to EmpXProy
	@OneToMany(mappedBy="tbempleado")
	private List<EmpXProy> tbEmpXProys;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="dpto_id")
	private Departamento tbdepartamento;

	public Empleado() {
	}

	public Integer getEmpid() {
		return this.empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	public double getSueldobruto() {
		return this.sueldobruto;
	}

	public void setSueldobruto(double sueldobruto) {
		this.sueldobruto = sueldobruto;
	}

	public List<EmpXProy> getTbEmpXProys() {
		return this.tbEmpXProys;
	}

	public void setTbEmpXProys(List<EmpXProy> tbEmpXProys) {
		this.tbEmpXProys = tbEmpXProys;
	}

	public EmpXProy addTbEmpXProy(EmpXProy tbEmpXProy) {
		getTbEmpXProys().add(tbEmpXProy);
		tbEmpXProy.setTbempleado(this);

		return tbEmpXProy;
	}

	public EmpXProy removeTbEmpXProy(EmpXProy tbEmpXProy) {
		getTbEmpXProys().remove(tbEmpXProy);
		tbEmpXProy.setTbempleado(null);

		return tbEmpXProy;
	}

	public Departamento getTbdepartamento() {
		return this.tbdepartamento;
	}

	public void setTbdepartamento(Departamento tbdepartamento) {
		this.tbdepartamento = tbdepartamento;
	}

}
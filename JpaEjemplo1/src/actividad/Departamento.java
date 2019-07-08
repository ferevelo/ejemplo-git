package actividad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.annotations.Fetch;



@Entity
@Table(name="tbdepartamento")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	private Integer deptId;

	private String nombre;

	//bi-directional many-to-one association to Empleado
	/*@OneToMany(mappedBy="tbdepartamento")
	private List<Empleado> tbempleados;*/
	
	@OneToMany(mappedBy="tbdepartamento", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Empleado> tbempleados = new HashSet<Empleado>();

	public Departamento() {
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public List<Empleado> getTbempleados() {
		return this.tbempleados;
	}

	public void setTbempleados(List<Empleado> tbempleados) {
		this.tbempleados = tbempleados;
	}*/
	
	
	public Empleado addTbempleado(Empleado tbempleado) {
		getTbempleados().add(tbempleado);
		tbempleado.setTbdepartamento(this);

		return tbempleado;
	}

	public Set<Empleado> getTbempleados() {
		return tbempleados;
	}

	public void setTbempleados(Set<Empleado> tbempleados) {
		this.tbempleados = tbempleados;
	}

	public Empleado removeTbempleado(Empleado tbempleado) {
		getTbempleados().remove(tbempleado);
		tbempleado.setTbdepartamento(null);

		return tbempleado;
	}

}
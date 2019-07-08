package actividad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_emp_x_proy database table.
 * 
 */
@Entity
@Table(name="tb_emp_x_proy")
@NamedQuery(name="EmpXProy.findAll", query="SELECT e FROM EmpXProy e")
public class EmpXProy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Empleado tbempleado;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="proy_id")
	private Proyecto tbproyecto;

	public EmpXProy() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empleado getTbempleado() {
		return this.tbempleado;
	}

	public void setTbempleado(Empleado tbempleado) {
		this.tbempleado = tbempleado;
	}

	public Proyecto getTbproyecto() {
		return this.tbproyecto;
	}

	public void setTbproyecto(Proyecto tbproyecto) {
		this.tbproyecto = tbproyecto;
	}
	
	public void mostrar() {
		System.out.println(
				"\nID: "+getId()+
				"\nNOMBRE DEL EMPLEADO: "+getTbempleado().getNombre()+
				"\nSUELDO DEL EMPLEADO: "+getTbempleado().getSueldobruto()+
				"\nPARKING DEL EMPLEADO: "+getTbempleado().getParkingId()+
				"\nNOMBRE DEL PROYECTO: "+getTbproyecto().getNombre()
				);
	}

}
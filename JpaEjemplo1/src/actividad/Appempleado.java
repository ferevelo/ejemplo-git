package actividad;

import javax.persistence.*;

import java.util.*;

public class Appempleado {

	static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("persistencia");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		insertOnetoManyempleado();
		//listarEXP();
		//insertManytoMany();
	}
	
	public static void insertOnetoManyempleado() {
		try {
			//llamar la clase departamento
			Departamento departament = new Departamento();
			//departament.setDeptId(1);
			departament.setNombre("diseño");
			
			//llamar a la clase empleado
			Empleado emplead = new Empleado();
			//emplead.setEmpid(1);
			emplead.setNombre("juan");
			emplead.setParkingId(1);
			emplead.setSueldobruto(56);
			
			//llamar la clase departamento
			Departamento departamente = new Departamento();
			//departament.setDeptId(1);
			departamente.setNombre("software");
			
			//llamar a la clase empleado
			Empleado empleadd = new Empleado();
			//emplead.setEmpid(1);
			empleadd.setNombre("juan");
			empleadd.setParkingId(1);
			empleadd.setSueldobruto(56);
			
			//seleccionar el departamento
			emplead.setTbdepartamento(departament);
			empleadd.setTbdepartamento(departamente);
			//agregar el one to many 
			departament.getTbempleados().add(emplead);
			departamente.getTbempleados().add(empleadd);
			
			em.getTransaction().begin();
			em.persist(emplead);
			em.persist(departament);
			em.persist(empleadd);
			em.persist(departamente);
			em.getTransaction().commit();
			
			System.out.println("Datos guardados ok"); 
			
		} catch (Exception e) {
			
			em.getTransaction().rollback();
			
			System.out.println("error " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static void listarEXP() {
		try {
			Query q = em.createQuery("select u from EmpXProy u");
			List l = q.getResultList();
			EmpXProy exp = new EmpXProy();
			for(int i=0; i<l.size(); i++) {
				exp = (EmpXProy)l.get(i);
				exp.mostrar();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void insertManytoMany() {
		try {
			Proyecto project = new Proyecto();
			project.setNombre(" sistema");
			project.setNombre(" diseño");
			
			//llamar a la clase empleado
			Empleado emplead = new Empleado();
			//emplead.setEmpid(1);
			emplead.setNombre("juan");
			emplead.setNombre("juan");
			emplead.setParkingId(1);
			emplead.setSueldobruto(56);
			
			EmpXProy exp = new EmpXProy();
			exp.setTbempleado(emplead);
			
			exp.setTbproyecto(project);
			
			em.getTransaction().begin();
			em.persist(emplead);
			em.persist(project);
			em.persist(exp);
			em.getTransaction().commit();
			
			System.out.println("Datos guardados ok"); 
			
			
		} catch (Exception e) {
			
			em.getTransaction().rollback();
			
			System.out.println("error " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}
	
}

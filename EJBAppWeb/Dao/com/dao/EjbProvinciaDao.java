package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.model.Provincia;;


@Stateless(name="ejbProvinciaDao")

public class EjbProvinciaDao implements ProvinciaDao {
	
	//unir con la persistencia se conecte el archivo tengo acceso a la bd
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	
	@Override
	public Provincia buscar(Provincia p) {
		Provincia obj=null;
		try {
			obj=em.find(Provincia.class, p.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(Provincia p) {
		String msg ="";
		try {
			em.persist(p);
			msg="se grabo correctamente";
		} catch (Exception e) {
			System.out.println("error dao obj no guardado"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(Provincia p) {
		String msg ="";
		try {
			em.merge(p);
			msg="se actualizo correctamente";
		} catch (Exception e) {
			msg="ERROR DAO OBJ NO ACTUALIZADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String eliminar(Provincia p) {
		String msg="";
		try {
			Provincia buscar =em.find(Provincia.class, p.getId());
			em.remove(buscar);
			em.flush();//realiza de manera forzada el comando anterior
			msg="se  elimino correctamente";
		} catch (Exception e) {
			msg="DAO ERROR ELIMINAR"+e.getMessage();
		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> listar() {
		List<Provincia> lista =null;
		try {
			Query q=em.createQuery("Select u from Provincia u");
			lista=q.getResultList();
			
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Provincia buscarporId(int id) {
		Provincia p =null;
		//objeto tipo carpeta
		try {
			p=(Provincia)em.createQuery("Select u from Provincia u" + "Where u.user_id= :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	
}

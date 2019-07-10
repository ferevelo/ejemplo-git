package com.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.model.Pais;


@Stateless(name="ejbPaisDao")

public class EjbPaisDao implements PaisDao {
	
	//unir con la persistencia se conecte el archivo tengo acceso a la bd
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	
	@Override
	public Pais buscar(Pais p) {
		Pais obj=null;
		try {
			obj=em.find(Pais.class, p.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(Pais p) {
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
	public String actualizar(Pais p) {
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
	public String eliminar(Pais p) {
		String msg="";
		try {
			Pais buscar =em.find(Pais.class, p.getId());
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
	public List<Pais> listar() {
		List<Pais> lista =null;
		try {
			Query q=em.createQuery("Select u from Pais u");
			lista=q.getResultList();
			
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Pais buscarporId(int id) {
		Pais p =null;
		//objeto tipo carpeta
		try {
			p=(Pais)em.createQuery("Select u from Pais u" + "Where u.user_id= :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}


}

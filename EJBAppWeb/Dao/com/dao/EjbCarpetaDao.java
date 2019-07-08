package com.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.model.Carpeta;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

@Stateless(name="ejbCarpetaDao")

public class EjbCarpetaDao implements CarpetaDao {
	
	//unir con la persistencia se conecte el archivo tengo acceso a la bd
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	
	@Override
	public Carpeta buscar(Carpeta carpeta) {
		Carpeta obj=null;
		try {
			obj=em.find(Carpeta.class, carpeta.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(Carpeta carpeta) {
		String msg ="";
		try {
			em.persist(carpeta);
			msg="se grabo correctamente";
		} catch (Exception e) {
			System.out.println("error dao obj no guardado"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(Carpeta c) {
		String msg ="";
		try {
			em.merge(c);
			msg="se actualizo correctamente";
		} catch (Exception e) {
			msg="ERROR DAO OBJ NO ACTUALIZADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String eliminar(Carpeta c) {
		String msg="";
		try {
			Carpeta buscar =em.find(Carpeta.class, c.getId());
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
	public List<Carpeta> listar() {
		List<Carpeta> lista =null;
		try {
			Query q=em.createQuery("Select u from Carpeta u");
			lista=q.getResultList();
			
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Carpeta buscarporId(int id) {
		Carpeta p =null;
		//objeto tipo carpeta
		try {
			p=(Carpeta)em.createQuery("Select u from Carpeta u" + "Where u.user_id= :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}

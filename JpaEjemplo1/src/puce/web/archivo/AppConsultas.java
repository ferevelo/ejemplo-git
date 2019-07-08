package puce.web.archivo;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppConsultas {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
	static EntityManager em=emf.createEntityManager();
	
	public static void main(String[] args) {
		listarDocumento();

	}
	
	public static void listarDocumento () {
		try {
			Query q= em.createQuery("select u from Documentacion u");
			List l= q.getResultList(); //guardar en lista
			Documentacion d=new Documentacion();
			for(int i=0; i<l.size(); i++) {
				d=(Documentacion)l.get(i);
				d.mostrar();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ParroquiaDao;
import com.ejb.model.Parroquia;

@Stateless(name="ejbParroquiaSession")

public class EjbParroquiaSession implements ParroquiaSession {

	//unir con el dao los distintos metodos
	@EJB
	private ParroquiaDao ejbParroquiaDao;
	
	
	@Override
	public Parroquia buscar(Parroquia p) {
		
		return ejbParroquiaDao.buscar(p);
	}

	@Override
	public String grabar(Parroquia p) {
		return ejbParroquiaDao.grabar(p);
	}

	@Override
	public String actualizar(Parroquia p) {
		
		return ejbParroquiaDao.actualizar(p);
	}

	@Override
	public String eliminar(Parroquia p) {
	
		return ejbParroquiaDao.eliminar(p);
	}

	@Override
	public List<Parroquia> listar() {
		
		return ejbParroquiaDao.listar();
	}

	@Override
	public Parroquia buscarporId(int id) {
	
		return ejbParroquiaDao.buscarporId(id);
	}





}

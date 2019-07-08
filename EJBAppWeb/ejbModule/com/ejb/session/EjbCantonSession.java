package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CantonDao;
import com.ejb.model.Canton;

@Stateless(name="ejbCantonSession")

public class EjbCantonSession implements CantonSession {

	//unir con el dao los distintos metodos
	@EJB
	private CantonDao ejbCantonDao;
	
	
	@Override
	public Canton buscar(Canton p) {
		
		return ejbCantonDao.buscar(p);
	}

	@Override
	public String grabar(Canton p) {
		return ejbCantonDao.grabar(p);
	}

	@Override
	public String actualizar(Canton p) {
		
		return ejbCantonDao.actualizar(p);
	}

	@Override
	public String eliminar(Canton p) {
	
		return ejbCantonDao.eliminar(p);
	}

	@Override
	public List<Canton> listar() {
		
		return ejbCantonDao.listar();
	}

	@Override
	public Canton buscarporId(int id) {
	
		return ejbCantonDao.buscarporId(id);
	}





}
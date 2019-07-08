package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ProvinciaDao;
import com.ejb.model.Provincia;

@Stateless(name="ejbProvinciaSession")

public class EjbProvinciaSession implements ProvinciaSession {

	//unir con el dao los distintos metodos
	@EJB
	private ProvinciaDao ejbProvinciaDao;
	
	
	@Override
	public Provincia buscar(Provincia p) {
		
		return ejbProvinciaDao.buscar(p);
	}

	@Override
	public String grabar(Provincia p) {
		return ejbProvinciaDao.grabar(p);
	}

	@Override
	public String actualizar(Provincia p) {
		
		return ejbProvinciaDao.actualizar(p);
	}

	@Override
	public String eliminar(Provincia p) {
	
		return ejbProvinciaDao.eliminar(p);
	}

	@Override
	public List<Provincia> listar() {
		
		return ejbProvinciaDao.listar();
	}

	@Override
	public Provincia buscarporId(int id) {
	
		return ejbProvinciaDao.buscarporId(id);
	}





}

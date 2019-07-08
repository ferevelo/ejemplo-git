package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CarpetaDao;
import com.ejb.model.Carpeta;

@Stateless(name="ejbCarpetaSession")

public class EjbCarpetaSession implements CarpetaSession {

	//unir con el dao los distintos metodos
	@EJB
	private CarpetaDao ejbCarpetaDao;
	
	
	@Override
	public Carpeta buscar(Carpeta carpeta) {
		
		return ejbCarpetaDao.buscar(carpeta);
	}

	@Override
	public String grabar(Carpeta carpeta) {
		return ejbCarpetaDao.grabar(carpeta);
	}

	@Override
	public String actualizar(Carpeta c) {
		
		return ejbCarpetaDao.actualizar(c);
	}

	@Override
	public String eliminar(Carpeta c) {
	
		return ejbCarpetaDao.eliminar(c);
	}

	@Override
	public List<Carpeta> listar() {
		
		return ejbCarpetaDao.listar();
	}

	@Override
	public Carpeta buscarporId(int id) {
	
		return ejbCarpetaDao.buscarporId(id);
	}

}

package com.dao;

import java.util.List;

import javax.ejb.Local;


import com.ejb.model.Provincia;

@Local
public interface ProvinciaDao {

	public Provincia buscar(Provincia p);
	public String grabar( Provincia p);
	public String actualizar (Provincia p);
	public String eliminar (Provincia p);
	public List<Provincia   > listar();
	public Provincia   buscarporId(int id);
}

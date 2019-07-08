package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Pais;


@Local
public interface PaisDao {

	public Pais buscar(Pais p);
	public String grabar( Pais p);
	public String actualizar (Pais p);
	public String eliminar (Pais p);
	public List<Pais > listar();
	public Pais buscarporId(int id);
}

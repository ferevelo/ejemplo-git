package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Canton;


@Local
public interface CantonDao {
	
	public Canton buscar(Canton p);
	public String grabar(Canton p);
	public String actualizar (Canton p);
	public String eliminar (Canton p);
	public List<Canton > listar();
	public Canton  buscarporId(int id);
}

package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Parroquia;

@Local
public interface ParroquiaSession {
	public Parroquia buscar(Parroquia p);
	public String grabar( Parroquia p);
	public String actualizar (Parroquia p);
	public String eliminar (Parroquia p);
	public List<Parroquia  > listar();
	public Parroquia  buscarporId(int id);
}

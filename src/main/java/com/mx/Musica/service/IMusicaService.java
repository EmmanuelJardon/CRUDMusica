package com.mx.Musica.service;

import java.util.List;

import com.mx.Musica.dominio.Musica;

public interface IMusicaService {
	
	Musica guardar(Musica a);
	
	Musica editar(Musica a);
	
	Musica buscar(int id);
	
	void eliminar(int id);
	
	List<Musica> listar();

}

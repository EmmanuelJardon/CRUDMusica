package com.mx.Musica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Musica.dao.IMusicaDao;
import com.mx.Musica.dominio.Musica;

@Service
public class MusicaService implements IMusicaService {

	@Autowired
	private IMusicaDao dao;
	
	@Override
	public Musica guardar(Musica mus) {
		return dao.save(mus);
	}

	@Override
	public Musica editar(Musica mus) {
		return dao.save(mus);
	}

	@Override
	public Musica buscar(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Musica> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "discos"));
	}
	
	
	// Metodos Personalizados
	public List<Musica> buscarPorGenero(String genero) {
		return dao.findByGeneroIgnoreCase(genero);
	}
		
		
	public Musica buscarPorNombre(String nombre) {
		return dao.findByNombreIgnoreCase(nombre);
	}
}
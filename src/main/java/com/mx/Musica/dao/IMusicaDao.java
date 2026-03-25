package com.mx.Musica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Musica.dominio.Musica;

@Repository
public interface IMusicaDao extends JpaRepository<Musica, Integer>{
	
	Musica findByNombreIgnoreCase(String nombre);
	
	List<Musica> findByGeneroIgnoreCase(String genero);
	
	@Query(value = "SELECT * FROM MUSICA_DB m WHERE  m.discos = :discos", nativeQuery = true)
	List<Musica> findByDiscos(int discos);

}

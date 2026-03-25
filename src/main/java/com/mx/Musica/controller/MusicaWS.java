package com.mx.Musica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Musica.dominio.Musica;
import com.mx.Musica.service.MusicaService;


@RestController
@RequestMapping("Musica")
public class MusicaWS {
	
	@Autowired
	private MusicaService service;
	
	
	@GetMapping("listar")
	public ResponseEntity<List<Musica>> listar() {
		
		List<Musica> lista = service.listar();
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}
	}
	
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Musica mus) {
		
		Musica musAux = service.buscar(mus.getId());
		
		if(musAux == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(mus));
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: El Id ya existe intenta con otro.");
		}
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id) {
		
		Musica musAux = service.buscar(id);
		
		if(musAux == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(musAux);
		}
	}
	
	@PutMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Musica mus) {
		return ResponseEntity.status(HttpStatus.OK).body(service.editar(mus));
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id) {
		service.eliminar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado exitosamente!");
	}
	
	@GetMapping("buscar-genero/{genero}")
	public ResponseEntity <List<Musica>> buscarPorGenero(@PathVariable String genero) {
		
		List<Musica> lista = service.buscarPorGenero(genero);
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}		
	}
	
	
	@GetMapping("buscar-discos/{discos}")
	public ResponseEntity<List<Musica>> buscarPorDiscos(@PathVariable int discos) {
		
		List<Musica> lista = service.buscarPorDiscos(discos);
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}
	}
	
	@GetMapping("buscar-nombre/{nombre}")
	public ResponseEntity<Musica> buscarPorNombre(@PathVariable String nombre) {
		
		Musica musAux = service.buscarPorNombre(nombre);
		
		if(musAux == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(musAux);
		}
	}
	
	
	
}
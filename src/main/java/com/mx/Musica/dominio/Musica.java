package com.mx.Musica.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MUSICA_DB")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Musica {
	
	// Atributos
	@Id
	private int id;
	private String nombre;
	private String genero;
	private int discos;
	private String pais;

}

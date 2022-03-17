package com.example.demo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
/*
 * La relacion con la tabla pokemones quedo como OneToOne.
 */

//utilizamos la anotacion table para indicarle a spring que nuestra tabla se llama pokemon (sin mayusculas), ya que si no aclarramos esto sprgin automaticamente tomara el nombre de la clase como el nombre de la tabla
@Table(name="entrenador")
public class Entrenador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_entrenador")
	private Long id;
	private String nombre;
	private String apellido;	
	private Long id_del_pokemon;
	
	@JoinColumn(name="id_entrenador")
	@OneToOne(fetch = FetchType.LAZY)
	private Pokemon pokemon;


	
	public Entrenador(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public Entrenador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Long getid_del_pokemon() {
		return id_del_pokemon;
	}
	public void setid_del_pokemon(Long id_del_pokemon) {
		this.id_del_pokemon = id_del_pokemon;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	
	
	
}

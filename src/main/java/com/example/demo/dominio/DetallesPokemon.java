package com.example.demo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Esta tabla tendra una relacion OneToOne con la tabla pokemon
 */
@Entity
@Table(name="detalles_pokemon")

public class DetallesPokemon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalles;
	private String evolucion;
	private int potencia_ataque;
	private Long id_del_pokemon;
	
	@JoinColumn(name="id_detalles")
	@OneToOne(fetch = FetchType.LAZY)
	private Pokemon pokemon;
	
	
	
	
	public DetallesPokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DetallesPokemon(String evolucion, int potencia_ataque) {
		super();
		this.evolucion = evolucion;
		this.potencia_ataque = potencia_ataque;
	}

	public String getEvolucion() {
		return evolucion;
	}
	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}
	public int getPotencia_ataque() {
		return potencia_ataque;
	}
	public void setPotencia_ataque(int potencia_ataque) {
		this.potencia_ataque = potencia_ataque;
	}
	public Long getId_del_pokemon() {
		return id_del_pokemon;
	}
	public void setId_del_pokemon(Long id_del_pokemon) {
		this.id_del_pokemon = id_del_pokemon;
	}
	
	
}

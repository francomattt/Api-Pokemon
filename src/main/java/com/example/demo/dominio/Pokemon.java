package com.example.demo.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
//utilizamos la anotacion table para indicarle a spring que nuestra tabla se llama pokemon (sin mayusculas), ya que si no aclarramos esto sprgin automaticamente tomara el nombre de la clase como el nombre de la tabla
@Table(name="pokemon")
public class Pokemon implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tipo;
	
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pokemon(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}

package com.example.demo.dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;

@Entity
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
	/*
	 * Cuando queremos definir aspectos intrinsecos de la base de datos como por ejemplo que la columna
	 * "nombre" no pueda repetir datos(que es elo que hace la anotacion @Column) o que no pueda ser null ect.
	 * Para esto tenemos que crear la base de datos cuando ejecutamos el programa(para esto deberiamos utilizar la linea spring.jpa.hibernate.ddl-auto=update en el application.properties).
	 *  Si la base de datos ya fue creada previamente esta ya tiene definida todos los detalles de sus columnas o sus tablas. La unica forma
	 * de modifica estos aspectos es modificarla con el gestor de base de datos que utilizamos para crearla.
	 */
	//@Column(unique = true)
	private String nombre;
	private String tipo;
	/*@OneToOne(cascade=CascadeType.ALL, mappedBy = "pokemon", orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private Entrenador entrenador;
	*/
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "pokemon", orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private DetallesPokemon detallesPokemon;
	
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
	
	public DetallesPokemon getDetallesPokemon() {
		return detallesPokemon;
	}
	public void setDetallesPokemon(DetallesPokemon detallesPokemon) {
		this.detallesPokemon = detallesPokemon;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}

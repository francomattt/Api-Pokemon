package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DetallesPokemonDao;
import com.example.demo.dao.EntrenadorDao;
import com.example.demo.dao.PokemonDao;
import com.example.demo.dominio.*;


@Component
public class HardcodeandoPokemonesH2 implements CommandLineRunner {
	/*
	 * Esta clase es utilizada para hardcodear pokemones en la tabla de datos configurada previamente en el
	 * application context. Por lo general se utiliza con h2 ya que es una base de datos volatil. 
	 * 
	 */
	
	/*
	 * Recordar que si omitimos la anotacion autowired, spring por defecto va inyectar las dependencias
	 * en la primera vairbale, en este caso pokemonDao, pero cuando querramos utilizar entreadorDao
	 * no arrojaria un nullexception.
	 * ¿Como puede spring instaciar un dao (que es una interface)?
	 */
	
	/*
	 * En esta relacion OneToOne
	 * +El pokemon no sabe su id hasta que se lo guarda en la abse de datos(se realiza el commit) y esta le asigna el id de forma autoincremental. 
	 * +Configurar bien la clase dao y ojo con las etiquetas @AutoWired
	 * Tabla Pokemon: PK asignarle el valor autoincremental explicitamente.
	 * Tabla detallesPokemon: A la fk habilitarle que pueda ser null.
	 */
	
	

	@Autowired
	PokemonDao pokemonDao;
	@Autowired
	EntrenadorDao entrenadorDao;
	@Autowired
	DetallesPokemonDao detallesPokemonDao;

	@Override
	public void run(String... args) throws Exception {
		

		Pokemon p = new Pokemon("Pikachu", "Electrico");
		
		DetallesPokemon detallesPokemon = new DetallesPokemon("Raichu", 95);
		

		
		//asociamos los objetos pokemon con ataques ya que estos tienen una relacion de 1 a 1
		p.setDetallesPokemon(detallesPokemon);
		pokemonDao.save(p);
		detallesPokemon.setId_del_pokemon(p.getId());
		detallesPokemonDao.save(detallesPokemon);
	
		

		/*pokemonDao.save(new Pokemon("Charmander", "Fuego"));
		pokemonDao.save(new Pokemon("Squirtle", "Agua"));
		pokemonDao.save(new Pokemon("Lapras", "Agua"));
		pokemonDao.save(new Pokemon("Caterpie", "Bicho"));
		pokemonDao.save(new Pokemon("Metapod", "Bicho"));
		pokemonDao.save(new Pokemon("Dragonite", "Dragon"));
		pokemonDao.save(new Pokemon("Magnemite", "Electrico"));*/
		System.out.println("pokemon hardcodeado");
		
		
	}

	public HardcodeandoPokemonesH2(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}
	
	
	
	
}

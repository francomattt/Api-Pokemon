package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.PokemonDao;
import com.example.demo.dominio.Pokemon;


@Component
public class HardcodeandoPokemonesH2 implements CommandLineRunner {
	
	PokemonDao pokemonDao;

	@Override
	public void run(String... args) throws Exception {
		Pokemon p = new Pokemon("Pikachu", "Electrico");
		pokemonDao.save(p);
		pokemonDao.save(new Pokemon("Charmander", "Fuego"));
		pokemonDao.save(new Pokemon("Squirtle", "Agua"));
		pokemonDao.save(new Pokemon("Lapras", "Agua"));
		pokemonDao.save(new Pokemon("Caterpie", "Bicho"));
		pokemonDao.save(new Pokemon("Metapod", "Bicho"));
		pokemonDao.save(new Pokemon("Dragonite", "Dragon"));
		pokemonDao.save(new Pokemon("Magnemite", "Electrico"));
		System.out.println("pokemon hardcodeado");
		
	}

	public HardcodeandoPokemonesH2(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}
	
	
	
	
}

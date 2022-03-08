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
		Pokemon p = new Pokemon("Pikachu", "electrico");
		pokemonDao.save(p);
		System.out.println("pokemon hardcodeado");
		
	}

	public HardcodeandoPokemonesH2(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}
	
	
	
	
}

package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PokemonDao;
import com.example.demo.dominio.Pokemon;


@Service
public class PokemonService { //importante en en la clase service no crear una superposicion de constructores ya que si creamos uno por defecto el controlador eligira ese y cuando vayamos a utilizar esta instancia en la clase service esta sera null y nos arrojara un error
	PokemonDao pokemonDao;
	
	public PokemonService(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}

	

	public void addPokemonService(Pokemon pokemon) {
		
		pokemonDao.save(pokemon);
		
	}
	
	public Pokemon getPokemon(int index) {
		
		Optional<Pokemon> op = pokemonDao.findById((long) index);
		if (op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public ArrayList<Pokemon> getAllPokemon(){
		
		return (ArrayList<Pokemon>) pokemonDao.findAll();
		
	}

	

}

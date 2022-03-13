package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PokemonDao;
import com.example.demo.dominio.Pokemon;


@Service
public class PokemonService { //importante en en la clase service no crear una superposicion de constructores ya que si creamos uno por defecto el controlador eligira ese y cuando vayamos a utilizar esta instancia en la clase service esta sera null y nos arrojara un error
	@Autowired
	PokemonDao pokemonDao;
	
	public PokemonService(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}

	

	public Pokemon addPokemonService(Pokemon pokemon) {
		
		return pokemonDao.save(pokemon);
		
		
		
	}
	
	public Pokemon getPokemon(int index) {
	
		/*
		 * como el metodo puede fallar si no existe el id. Utilizo el tipo optional así en caso de no
		 * existir no nos causa problemas. Para eso siempre vamos a utilizar el metodo isPresent() de la
		 * siguiente manera.
		 * 
		 * 
		 */
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
	
	public ArrayList<Pokemon> obtenerPokemonPorTipo(String tipo) {
		return pokemonDao.findByTipo(tipo);
	}
	public boolean eliminarPokemon(int index) {
		try {
			pokemonDao.deleteById((long) index);
			return true;
		}catch(Exception err){
			return false;
		}
		
	}

	

}

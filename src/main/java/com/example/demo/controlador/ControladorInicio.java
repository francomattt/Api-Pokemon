package com.example.demo.controlador;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PokemonDao;
import com.example.demo.dominio.Pokemon;
import com.example.demo.modelo.PokemonService;


@RestController
public class ControladorInicio {
	@Autowired
	PokemonService pokemonService;
	
	public ControladorInicio(PokemonService pokemonService) {
		super();
		this.pokemonService = pokemonService;
	}

	public ControladorInicio() {
		super();
		// TODO Auto-generated constructor stub
	}
    // Diferencias entre @RequestBody y @RequestParam ver https://es.stackoverflow.com/questions/375398/diferencia-entre-requestparam-y-requestbody
	@GetMapping("/add")
	public String addPokemon(@RequestBody Pokemon pokemon) {
		pokemonService.addPokemonService(pokemon);
		return "pokemon Añadido";
	}
	//la anotacion pathVariable la utilizamos para enviar parametros por dentro de la uri
	@GetMapping("/getPokemon/{index}")
	public String getPokemon(@PathVariable(value="index") Integer index) {
		Pokemon p = pokemonService.getPokemon(index);
		return p.getNombre();
	}
	
	@GetMapping("/getAllPokemones")
	public String listaPokemones() {
		Iterator it= pokemonService.getAllPokemon().iterator();
		String Lista ="";
		while(it.hasNext()) {
			Pokemon p = (Pokemon) it.next();
			//System.out.println(it.next().getNombre());
			Lista= (Lista + p.getNombre() + " \n") ;
			System.out.println(p.getNombre());
			
		}
		return Lista;
	}

}

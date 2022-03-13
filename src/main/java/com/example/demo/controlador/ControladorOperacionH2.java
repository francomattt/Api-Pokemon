package com.example.demo.controlador;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.dao.PokemonDao;
import com.example.demo.dominio.Pokemon;
import com.example.demo.modelo.PokemonService;


@RestController
public class ControladorOperacionH2 {
	/*
	 * Controlador se comunicara con la capa de servicios para poder ejecutar sus metodos(endpoint)
	 * POST: create. Para crear un nuevo recurso
	 * 		♦Operacion no segura y no idempotente
	 * 		♦Respuesta 201 (OK) o el tipo de error
	 * 		♦Recomendable devolver la referencia al nuevo recurso
	 * 		♦Recomendable tambien devolver el nuevo recurso
	 * GET: get. Para obtener un recurso o un conjunto 
	 * 		♦Operacion segura e idempotente
	 * 		♦Respuesta  200 (OK) o el tipo de error
	 * 		♦Recomendable devolver el recurso o el conjutno
	 * PUT: Update. Para actualizar un recurso entero (a diferencia del PATCH)
	 * 		♦ Operacion no segura e idempotente
	 * 		♦ repuesta 200(ok) o el tipo de error
	 * 		♦Recomendable devolver el recurso
	 * DELETE:delete. Para eliminar un recurso
	 * 		♦Operacion no segura e idempotente
	 * 		♦repuesta 204 (ok) sin contenido o el tipo de error
	 * 
	 * Operacion segura = No cambia su estado ni provoca efectos secundarios
	 * Operacion idempotente = Operacion que repetida da siempre el mismo resultado
	 */
	@Autowired
	PokemonService pokemonService;

	
	public ControladorOperacionH2(PokemonService pokemonService) {
		super();
		this.pokemonService = pokemonService;
	}

	public ControladorOperacionH2() {
		super();
		// TODO Auto-generated constructor stub
	}
    // Diferencias entre @RequestBody y @RequestParam ver https://es.stackoverflow.com/questions/375398/diferencia-entre-requestparam-y-requestbody
	@PostMapping("/agregarPokemon")
	public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
		return pokemonService.addPokemonService(pokemon);
		//return "pokemon Añadido";
	}
	//la anotacion pathVariable la utilizamos para enviar parametros por dentro de la uri
	@GetMapping("/ObtenerPokemon/{index}")
	public String getPokemon(@PathVariable(value="index") Integer index) {
		Pokemon p = pokemonService.getPokemon(index);
		return p.getNombre();
	}
	
	@GetMapping("/ObtenerAllPokemones")
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
	
	@GetMapping("/pokemonPorTipo")
	public ArrayList<Pokemon> obtenerPokemonPorTipo(@RequestParam("tipo") String tipo) {
		
		return this.pokemonService.obtenerPokemonPorTipo(tipo);
	}
	@DeleteMapping("/eliminarPokemon/{index}")
	public String eliminarPokemon(@PathVariable(value="index") Integer index) {
		boolean OK = this.pokemonService.eliminarPokemon(index);
		if( OK ) {
			return "pokemon elminado correctamente";
		}else {
			return "no se pudo eliminar pokemon";
		}
	}


}

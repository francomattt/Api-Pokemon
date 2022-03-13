package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dominio.Pokemon;

public interface PokemonDao extends CrudRepository<Pokemon, Long> {
	public abstract ArrayList<Pokemon> findByTipo(String Tipo);

}

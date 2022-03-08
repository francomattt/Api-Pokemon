package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dominio.Pokemon;

public interface PokemonDao extends CrudRepository<Pokemon, Long> {

}

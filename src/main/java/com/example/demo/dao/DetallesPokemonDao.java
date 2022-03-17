package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dominio.DetallesPokemon;

public interface DetallesPokemonDao extends CrudRepository<DetallesPokemon, Long> {

}

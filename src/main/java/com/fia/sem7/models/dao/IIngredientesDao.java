package com.fia.sem7.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.sem7.models.entity.Ingredientes;


public interface IIngredientesDao extends CrudRepository<Ingredientes, String> {
    // Métodos de repositorio
}


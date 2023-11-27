package com.fia.sem7.models.service;

import java.util.List;
import java.util.Optional;

import com.fia.sem7.models.entity.Ingredientes;



public interface IIngredientesService {
	
	public List<Ingredientes> findAll();
	
	public void save(Ingredientes cliente);
	
	public Ingredientes findOne(String id);
	
	public void delete(String id);
	
	public boolean buscarCuenta(Ingredientes cliente);
	
	public Ingredientes buscarXIdentidad(Ingredientes cliente);
	
	public void update(Ingredientes ingredientes);
	
	public Optional<Ingredientes> get(Ingredientes i);
    
}

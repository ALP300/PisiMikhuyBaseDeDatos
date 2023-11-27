package com.fia.sem7.models.service;

import java.util.List;
import java.util.Optional;

import com.fia.sem7.models.entity.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	
	public Producto save(Producto plato);

	public Optional<Producto> get(String id);

	public void update(Producto plato);

	public void delete(String id);

	public Producto findOne(String id);
}

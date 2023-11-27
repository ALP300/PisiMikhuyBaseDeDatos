package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Historial_Compras;
import com.fia.sem7.models.entity.Producto;
import com.fia.sem7.models.entity.Regalo;

public interface IHistorial_ComprasService {
public List<Historial_Compras> findAll();
	
	public void save(Historial_Compras carrito);
	
	public Historial_Compras findOne(String id);
	
	public void delete(String id);
	
	public void update(Historial_Compras plato);
}

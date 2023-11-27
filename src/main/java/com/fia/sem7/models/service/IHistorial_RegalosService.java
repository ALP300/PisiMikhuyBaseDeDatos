package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Historial_Compras;
import com.fia.sem7.models.entity.Historial_Regalos;
import com.fia.sem7.models.entity.Producto;

public interface IHistorial_RegalosService {
public List<Historial_Regalos> findAll();
	
	public void save(Historial_Regalos carrito);
	
	public Historial_Regalos findOne(String id);
	
	public void delete(String id);
	
	public void update(Historial_Regalos plato);
}

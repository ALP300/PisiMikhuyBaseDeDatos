package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Detalle_Carrito;
import com.fia.sem7.models.entity.ItemCarrito;



public interface IItemCarritoService {
	public List<Detalle_Carrito> findAll();
	
	public void save(Detalle_Carrito itemcarrito);
	
	public Detalle_Carrito findOne(Long id);
	
	public void delete(Long id);
	

}

package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Carrito;
import com.fia.sem7.models.entity.Comprobante;

public interface ICarritoService {
	public List<Comprobante> findAll();
	
	public void save(Comprobante carrito);
	
	public Comprobante findOne(Long id);
	
	public void delete(Long id);
}

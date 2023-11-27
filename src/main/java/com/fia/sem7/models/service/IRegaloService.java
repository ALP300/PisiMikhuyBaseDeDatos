package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Comprobante;
import com.fia.sem7.models.entity.Producto;
import com.fia.sem7.models.entity.Regalo;

public interface IRegaloService {
public List<Regalo> findAll();
	
	public void save(Regalo carrito);
	
	public Regalo findOne(Long id);
	
	public void delete(Long id);
	
	public void update(Regalo regalo);

}

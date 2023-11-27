package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Comprobante;
import com.fia.sem7.models.entity.Tipo_Comprobante;

public interface ITipo_ComprobanteService {
	public List<Tipo_Comprobante> findAll();
	
	public void save(Tipo_Comprobante carrito);
	
	public Tipo_Comprobante findOne(String id);
	
	public void delete(String id);

}

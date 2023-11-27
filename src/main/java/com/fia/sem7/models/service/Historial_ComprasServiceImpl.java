package com.fia.sem7.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.sem7.models.dao.IHistorial_ComprasDao;
import com.fia.sem7.models.dao.ITipo_ComprobanteDao;
import com.fia.sem7.models.entity.Historial_Compras;
import com.fia.sem7.models.entity.Producto;
import com.fia.sem7.models.entity.Tipo_Comprobante;

@Service
public class Historial_ComprasServiceImpl implements IHistorial_ComprasService{
	@Autowired
	private IHistorial_ComprasDao carritoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Historial_Compras> findAll() {
		// TODO Auto-generated method stub
		return (List<Historial_Compras>) carritoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Historial_Compras carrito) {
		// TODO Auto-generated method stub
		carritoDao.save(carrito);
	}

	@Override
	@Transactional(readOnly = true)
	public Historial_Compras findOne(String id) {
		// TODO Auto-generated method stub
		return carritoDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		carritoDao.deleteById(id);
	}
	@Override
	@Transactional
	public void update(Historial_Compras plato) {
		// TODO Auto-generated method stub
		carritoDao.save(plato);
	}

}

package com.fia.sem7.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.sem7.models.dao.IHistorial_ComprasDao;
import com.fia.sem7.models.dao.IHistorial_RegalosDao;
import com.fia.sem7.models.entity.Historial_Compras;
import com.fia.sem7.models.entity.Historial_Regalos;
import com.fia.sem7.models.entity.Producto;

@Service
public class Historial_RegalosServiceImpl implements IHistorial_RegalosService{
	@Autowired
	private IHistorial_RegalosDao carritoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Historial_Regalos> findAll() {
		// TODO Auto-generated method stub
		return (List<Historial_Regalos>) carritoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Historial_Regalos carrito) {
		// TODO Auto-generated method stub
		carritoDao.save(carrito);
	}

	@Override
	@Transactional(readOnly = true)
	public Historial_Regalos findOne(String id) {
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
	public void update(Historial_Regalos plato) {
		// TODO Auto-generated method stub
		carritoDao.save(plato);
	}

}

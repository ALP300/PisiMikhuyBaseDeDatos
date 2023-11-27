package com.fia.sem7.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.sem7.models.dao.IPlatoDao;
import com.fia.sem7.models.dao.IProductoDao;
import com.fia.sem7.models.entity.Plato;
import com.fia.sem7.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao platoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) platoDao.findAll();
	}
	
	@Override
	@Transactional
	public Producto save(Producto plato) {
		// TODO Auto-generated method stub
		return platoDao.save(plato);
	}

	@Override
	@Transactional
	public Optional<Producto> get(String id) {
		// TODO Auto-generated method stub
		return platoDao.findById(id);
	}
	
	@Override
	@Transactional
	public void update(Producto plato) {
		// TODO Auto-generated method stub
		platoDao.save(plato);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		platoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(String id) {
		// TODO Auto-generated method stub
		return platoDao.findById(id).orElseGet(null);
	}

}

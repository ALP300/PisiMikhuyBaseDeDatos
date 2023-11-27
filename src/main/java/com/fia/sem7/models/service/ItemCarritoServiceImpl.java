package com.fia.sem7.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.sem7.models.dao.IItemCarritoDao;
import com.fia.sem7.models.entity.Detalle_Carrito;
import com.fia.sem7.models.entity.ItemCarrito;


@Service
public class ItemCarritoServiceImpl implements IItemCarritoService {
	@Autowired
	private IItemCarritoDao itemCarritoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Detalle_Carrito> findAll() {
		// TODO Auto-generated method stub
		return (List<Detalle_Carrito>)itemCarritoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Detalle_Carrito itemCarrito) {
		// TODO Auto-generated method stub
		itemCarritoDao.save(itemCarrito);
	}

	@Override
	@Transactional(readOnly = true)
	public Detalle_Carrito findOne(Long id) {
		// TODO Auto-generated method stub
		return itemCarritoDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemCarritoDao.deleteById(id);
	}
}

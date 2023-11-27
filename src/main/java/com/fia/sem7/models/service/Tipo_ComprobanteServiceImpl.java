package com.fia.sem7.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.fia.sem7.models.dao.ITipo_ComprobanteDao;

import com.fia.sem7.models.entity.Tipo_Comprobante;
@Service
public class Tipo_ComprobanteServiceImpl implements ITipo_ComprobanteService{
	@Autowired
	private ITipo_ComprobanteDao carritoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo_Comprobante> findAll() {
		// TODO Auto-generated method stub
		return (List<Tipo_Comprobante>) carritoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tipo_Comprobante carrito) {
		// TODO Auto-generated method stub
		carritoDao.save(carrito);
	}

	@Override
	@Transactional(readOnly = true)
	public Tipo_Comprobante findOne(String id) {
		// TODO Auto-generated method stub
		return carritoDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		carritoDao.deleteById(id);
	}

}

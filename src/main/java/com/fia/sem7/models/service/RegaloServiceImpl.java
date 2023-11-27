package com.fia.sem7.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.sem7.models.dao.IRegaloDao;
import com.fia.sem7.models.dao.ITipo_ComprobanteDao;
import com.fia.sem7.models.entity.Producto;
import com.fia.sem7.models.entity.Regalo;
import com.fia.sem7.models.entity.Tipo_Comprobante;

@Service
public class RegaloServiceImpl implements IRegaloService{
	@Autowired
	private IRegaloDao carritoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Regalo> findAll() {
		// TODO Auto-generated method stub
		return (List<Regalo>) carritoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Regalo carrito) {
		// TODO Auto-generated method stub
		carritoDao.save(carrito);
	}

	@Override
	@Transactional(readOnly = true)
	public Regalo findOne(Long id) {
		// TODO Auto-generated method stub
		return carritoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carritoDao.deleteById(id);
	}
	@Override
	@Transactional
	public void update(Regalo regalo) {
		// TODO Auto-generated method stub
		carritoDao.save(regalo);
	}

}

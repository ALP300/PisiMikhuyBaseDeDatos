package com.fia.sem7.models.service;

import java.util.List;

import com.fia.sem7.models.entity.Admin;


public interface IAdminService {
	public List<Admin> findAll();
	
	public void save(Admin admin);
	
	public Admin findOne(String id);
	
	public void delete(String id);
	
	public boolean buscarCuenta(Admin admin);
	
	public Admin buscarXIdentidad(Admin admin);
}

package com.fia.sem7.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.sem7.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, String>{

}


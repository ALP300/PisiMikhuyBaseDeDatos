package com.fia.sem7.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.sem7.models.entity.Carrito;
import com.fia.sem7.models.entity.Comprobante;


public interface ICarritoDao extends CrudRepository<Comprobante, Long>{

}

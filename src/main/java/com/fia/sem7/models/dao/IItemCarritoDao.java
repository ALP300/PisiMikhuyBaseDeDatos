package com.fia.sem7.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.sem7.models.entity.Detalle_Carrito;


public interface IItemCarritoDao extends CrudRepository<Detalle_Carrito, Long>{

}

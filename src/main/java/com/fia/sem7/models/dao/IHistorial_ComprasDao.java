package com.fia.sem7.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.sem7.models.entity.Comprobante;
import com.fia.sem7.models.entity.Historial_Compras;

public interface IHistorial_ComprasDao extends CrudRepository<Historial_Compras, String>{

}



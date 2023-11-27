package com.fia.sem7.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.sem7.models.entity.Comprobante;
import com.fia.sem7.models.entity.Regalo;

public interface IRegaloDao extends CrudRepository<Regalo, Long>{

}


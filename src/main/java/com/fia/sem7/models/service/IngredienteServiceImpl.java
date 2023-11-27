package com.fia.sem7.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.sem7.models.dao.IIngredientesDao;
import com.fia.sem7.models.entity.Ingredientes;

@Service
public class IngredienteServiceImpl implements IIngredientesService {

    @Autowired
    private IIngredientesDao ingredienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ingredientes> findAll() {
        return (List<Ingredientes>) ingredienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Ingredientes ingrediente) {
        ingredienteDao.save(ingrediente);
        if (ingrediente.getId_Ingrediente() == null) {
            ingredienteDao.save(ingrediente);
        } else {
            // Aquí puedes manejar cualquier validación o lanzar una excepción si se proporciona un ID para un nuevo ingrediente.
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Ingredientes findOne(String id) {
        return ingredienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(String id) {
        ingredienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean buscarCuenta(Ingredientes cliente) {
        // Implementa la lógica de búsqueda de cuenta aquí
        // Debes definir cómo se busca una cuenta
        return false; // Cambia esto según tu implementación
    }

    @Override
    @Transactional(readOnly = true)
    public Ingredientes buscarXIdentidad(Ingredientes cliente) {
        // Implementa la búsqueda de un ingrediente por identidad aquí
        // Debes definir cómo se busca un ingrediente por su identidad
        return null; // Cambia esto según tu implementación
    }

	
	
	@Override
	@Transactional
	public void update(Ingredientes ingrediente) {
		// TODO Auto-generated method stub
		ingredienteDao.save(ingrediente);
	}

	@Override
	public Optional<Ingredientes> get(Ingredientes i) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	
	
}
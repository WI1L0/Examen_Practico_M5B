package com.edu.proyect.Examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.edu.proyect.Examen.model.Producto;
import com.edu.proyect.Examen.repository.IProductoRepository;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements IProductoService{

	@Autowired
    IProductoRepository Irepository;
	
	@Override
	public CrudRepository<Producto, Integer> getDao() {
		// TODO Auto-generated method stub
		return Irepository;
	}

}

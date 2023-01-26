package com.edu.proyect.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.proyect.Examen.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}

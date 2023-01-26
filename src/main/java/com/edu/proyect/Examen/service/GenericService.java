/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.proyect.Examen.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MAWIL
 */
public interface GenericService <T, ID extends Serializable>{

    public T save(T entity);

    public T findById(ID id);

    public List<T> findByAll();
    
    public T update(ID id, T entity);

    public boolean delete(ID id);


}
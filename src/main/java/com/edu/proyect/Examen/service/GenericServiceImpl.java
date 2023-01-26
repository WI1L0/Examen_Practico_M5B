/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.proyect.Examen.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author MAWIL
 */
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    public abstract CrudRepository<T, ID> getDao();
    
    @Override
    public T save(T Entity) {
        return getDao().save(Entity);
    }

    @Override
    public T findById(ID id) {
        Optional<T> opt = getDao().findById(id);
	return opt.get();
    }

    @Override
    public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(obj -> list.add(obj));
        return list;
    }
    
    @Override
    public boolean delete(ID id){
        if (getDao().existsById(id)) {
            getDao().deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public T update(ID id, T entity){
	Optional<T> opt = getDao().findById(id);
	T T = opt.get();
	T = getDao().save(entity);
	return T;
    }
}

package com.edu.proyect.Examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.proyect.Examen.model.Producto;
import com.edu.proyect.Examen.service.IProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
    IProductoService Service;

    @GetMapping("/listar")
    public ResponseEntity< List<Producto>> obtenerLista() {
        return new ResponseEntity<>(Service.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto c){
    	//evitar datos en 0
    	if(c.getCantidad() > 0 && c.getPrecio() > 0 && c.getDescripcion().toString().length() < 100) {
    		//calcular valor
    		Double valorTotal = c.getCantidad() * c.getPrecio();
    		if (valorTotal > 50) {
				Double descuento = valorTotal * 10 / 100;
				Double iva = valorTotal * 12 / 100;
				Double vTotal = valorTotal - descuento + iva;
				c.setTotal(vTotal);
	    		return new ResponseEntity<>(Service.save(c), HttpStatus.CREATED);
    		} else {
    			Double iva = valorTotal * 12 / 100;
				Double vTotal = valorTotal + iva;
				c.setTotal(vTotal);
    			return new ResponseEntity<>(Service.save(c), HttpStatus.CREATED);
    		}
    	} else {
    		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    	}
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable("id") Integer id){
        return new ResponseEntity<>(Service.findById(id),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(Service.delete(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable("id") Integer id, @RequestBody Producto c){
        return new ResponseEntity<>(Service.update(id, c), HttpStatus.OK);
    }
}

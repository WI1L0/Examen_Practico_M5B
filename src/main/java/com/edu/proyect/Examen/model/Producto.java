package com.edu.proyect.Examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "total")
    private Double total;
	
    
    public Producto() {
		super();
	}
	public Producto(Integer codigo, String descripcion, Double precio, Integer cantidad, Double total) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
	}


	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}

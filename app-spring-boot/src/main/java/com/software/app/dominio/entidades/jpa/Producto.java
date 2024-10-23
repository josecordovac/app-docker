package com.software.app.dominio.entidades.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "productos")  // Nombre de la tabla que se generará
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return nombre; }
    public void setName(String nombre) { this.nombre = nombre; }
    public String getDescription() { return descripcion; }
    public void setDescription(String descripcion) { this.descripcion = descripcion; }
    public double getPrice() { return precio; }
    public void setPrice(double precio) { this.precio = precio; }
}
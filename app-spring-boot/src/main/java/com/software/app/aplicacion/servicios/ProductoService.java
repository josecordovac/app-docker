package com.software.app.aplicacion.servicios;

import com.software.app.dominio.entidades.jpa.Producto;
import com.software.app.infraestructura.datos.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto obtenerProductoPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(int id, Producto producto) {
        Producto existente = obtenerProductoPorId(id);
        if (existente != null) {
            existente.setNombre(producto.getNombre());
            existente.setDescripcion(producto.getDescripcion());
            existente.setPrecio(producto.getPrecio());
            return productoRepository.save(existente);
        }
        return null;
    }

    public void eliminarProducto(int id) {
        productoRepository.deleteById(id);
    }
}
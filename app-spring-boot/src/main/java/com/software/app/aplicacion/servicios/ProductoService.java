package com.software.app.aplicacion.servicios;

import org.springframework.stereotype.Service;

import com.software.app.dominio.entidades.jpa.Producto;
import com.software.app.infraestructura.datos.repositorios.ProductoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Flux<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    public Mono<Producto> getProductById(Long id) {
        return productoRepository.findById(id);
    }

    public Mono<Producto> saveProduct(Producto product) {
        return productoRepository.save(product);
    }

    public Mono<Producto> updateProduct(Long id, Producto newProduct) {
        return productoRepository.findById(id)
            .flatMap(existingProduct -> {
                existingProduct.setName(newProduct.getName());
                existingProduct.setDescription(newProduct.getDescription());
                existingProduct.setPrice(newProduct.getPrice());
                return productoRepository.save(existingProduct);
            });
    }

    public Mono<Void> deleteProductById(Long id) {
        return productoRepository.deleteById(id);
    }
}
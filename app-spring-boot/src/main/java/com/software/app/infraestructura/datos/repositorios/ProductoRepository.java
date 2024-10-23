package com.software.app.infraestructura.datos.repositorios;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.software.app.dominio.entidades.jpa.Producto;

import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {
    Flux<Producto> findByNameContainingIgnoreCase(String name);
}
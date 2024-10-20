package com.software.app.infraestructura.datos.repositorios;

import com.software.app.dominio.entidades.jpa.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
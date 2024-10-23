package com.software.app.presentacion.controladores;

import org.springframework.web.bind.annotation.*;

import com.software.app.aplicacion.servicios.ProductoService;
import com.software.app.dominio.entidades.jpa.Producto;

import io.swagger.v3.oas.annotations.Operation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productService) {
        this.productoService = productService;
    }

    @GetMapping
    @Operation(summary = "Listar productos", description = "Obtiene todos los productos")
    public Flux<Producto> listarProductos() {
        return productoService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto basado en su ID")
    public Mono<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.getProductById(id);
    }

    @PostMapping
    @Operation(summary = "Crear producto", description = "Crea un nuevo producto")
    public Mono<Producto> crearProducto(@RequestBody Producto producto) {
        return productoService.saveProduct(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Actualiza los detalles de un producto existente")
    public Mono<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.updateProduct(id, producto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto de la base de datos")
    public Mono<Void> eliminarProducto(@PathVariable Long id) {
        return productoService.deleteProductById(id);
    }
}

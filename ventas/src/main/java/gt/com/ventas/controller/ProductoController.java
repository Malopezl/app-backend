/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.controller;

import gt.com.ventas.model.Producto;
import gt.com.ventas.service.ProductoService;
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

/**
 *
 * @author malopez
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Integer id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping("")
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return new ResponseEntity(productoService.create(producto), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        return productoService.findById(producto.getIdProducto())
                .map(c -> ResponseEntity.ok(productoService.update(producto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> delete(@PathVariable("id") Integer id) {
        return productoService.findById(id)
                .map(c -> {
                    productoService.delete(id);
                    return ResponseEntity.ok(c);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

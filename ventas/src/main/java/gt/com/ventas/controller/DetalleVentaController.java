/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.controller;

import gt.com.ventas.model.DetalleVenta;
import gt.com.ventas.service.DetalleVentaService;
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
@RequestMapping("/api/detalles")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> findAll() {
        return ResponseEntity.ok(detalleVentaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> findById(@PathVariable("id") Integer id) {
        return detalleVentaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping("")
    public ResponseEntity<DetalleVenta> create(@RequestBody DetalleVenta detalleVenta) {
        return new ResponseEntity(detalleVentaService.create(detalleVenta), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<DetalleVenta> update(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.findById(detalleVenta.getIdDetalleVenta())
                .map(c -> ResponseEntity.ok(detalleVentaService.update(detalleVenta)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleVenta> delete(@PathVariable("id") Integer id) {
        return detalleVentaService.findById(id)
                .map(c -> {
                    detalleVentaService.delete(id);
                    return ResponseEntity.ok(c);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.controller;

import gt.com.ventas.model.TipoProducto;
import gt.com.ventas.service.TipoProductoService;
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
@RequestMapping("/api/tipos")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public ResponseEntity<List<TipoProducto>> findAll() {
        return ResponseEntity.ok(tipoProductoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> findById(@PathVariable("id") Integer id) {
        return tipoProductoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping("")
    public ResponseEntity<TipoProducto> create(@RequestBody TipoProducto tipoProducto) {
        return new ResponseEntity(tipoProductoService.create(tipoProducto), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<TipoProducto> update(@RequestBody TipoProducto tipoProducto) {
        return tipoProductoService.findById(tipoProducto.getIdTipoProducto())
                .map(c -> ResponseEntity.ok(tipoProductoService.update(tipoProducto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoProducto> delete(@PathVariable("id") Integer id) {
        return tipoProductoService.findById(id)
                .map(c -> {
                    tipoProductoService.delete(id);
                    return ResponseEntity.ok(c);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

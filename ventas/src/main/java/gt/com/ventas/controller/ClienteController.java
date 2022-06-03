/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.controller;

import gt.com.ventas.model.Cliente;
import gt.com.ventas.service.ClienteService;
import java.util.ArrayList;
import javax.validation.Valid;
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
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<ArrayList<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping("")
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {
        return clienteService.findById(cliente.getIdCliente())
                .map(c -> ResponseEntity.ok(clienteService.update(cliente)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer id) {
        return clienteService.findById(id)
                .map(c -> {
                    clienteService.delete(id);
                    return ResponseEntity.ok(c);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

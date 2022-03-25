/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.controller;

import gt.com.ventas.model.Persona;
import gt.com.ventas.service.PersonaService;
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
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> findAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable("id") Integer id) {
        return personaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping("")
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        return new ResponseEntity(personaService.create(persona), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        return personaService.findById(persona.getIdPersona())
                .map(c -> ResponseEntity.ok(personaService.update(persona)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id") Integer id) {
        return personaService.findById(id)
                .map(c -> {
                    personaService.delete(id);
                    return ResponseEntity.ok(c);
                        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

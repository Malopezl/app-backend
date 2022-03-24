/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.service;

import gt.com.ventas.model.Persona;
import gt.com.ventas.repository.IPersonaRespository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malopez
 */
@Service
public class PersonaService implements ICRUDService<Persona> {

    @Autowired
    private IPersonaRespository personaRespository;

    @Override
    public List<Persona> findAll() {
        return personaRespository.findAll();
    }

    @Override
    public Optional<Persona> findById(Integer id) {
        return personaRespository.findById(id);
    }

    @Override
    public Persona create(Persona persona) {
        return personaRespository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRespository.save(persona);
    }

    @Override
    public void delete(Integer id) {
        personaRespository.deleteById(id);
    }

}

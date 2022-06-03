/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.service;

import gt.com.ventas.model.Cliente;
import gt.com.ventas.repository.IClienteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malopez
 */
@Service
public class ClienteService implements ICRUDService<Cliente> {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public ArrayList<Cliente> findAll() {
        return (ArrayList<Cliente>) clienteRepo.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepo.findById(id);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        clienteRepo.deleteById(id);
    }

}

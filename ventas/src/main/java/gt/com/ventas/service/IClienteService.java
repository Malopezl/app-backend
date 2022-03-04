/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.com.ventas.service;

import gt.com.ventas.model.Cliente;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author malopez
 */
public interface IClienteService {

    ArrayList<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    Cliente create(Cliente cliente);

    Cliente update(Cliente cliente);

    void delete(Integer id);

}

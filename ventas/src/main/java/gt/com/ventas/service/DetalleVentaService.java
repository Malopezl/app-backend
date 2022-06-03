/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.service;

import gt.com.ventas.model.DetalleVenta;
import gt.com.ventas.repository.IDetalleVentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malopez
 */
@Service
public class DetalleVentaService implements ICRUDService<DetalleVenta>{

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> findById(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta create(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta update(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void delete(Integer id) {
        detalleVentaRepository.deleteById(id);
    }

}

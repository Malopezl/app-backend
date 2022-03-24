/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.service;

import gt.com.ventas.model.TipoProducto;
import gt.com.ventas.repository.ITipoProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malopez
 */
@Service
public class TipoProductoService implements ICRUDService<TipoProducto>{

    @Autowired
    private ITipoProductoRepository tipoProductoRepository;

    @Override
    public List<TipoProducto> findAll() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public Optional<TipoProducto> findById(Integer id) {
        return tipoProductoRepository.findById(id);
    }

    @Override
    public TipoProducto create(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public TipoProducto update(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public void delete(Integer id) {
        tipoProductoRepository.deleteById(id);
    }

}

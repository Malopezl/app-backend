/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.service;

import gt.com.ventas.model.Producto;
import gt.com.ventas.model.Venta;
import gt.com.ventas.repository.IProductoRepository;
import gt.com.ventas.repository.IVentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malopez
 */
@Service
public class VentaService implements ICRUDService<Venta> {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> findById(Integer id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta create(Venta venta) {
        venta.getDetalleVentaList().forEach(detalleVenta -> {
            Optional<Producto> producto = productoRepository.findById(detalleVenta.getProducto().getIdProducto());
            if (producto.isPresent()) {
                Double precioTotal = producto.get().getPrecio() * detalleVenta.getCantidad().doubleValue();
                detalleVenta.setPrecioUnitario(producto.get().getPrecio());
                detalleVenta.setPrecioTotal(precioTotal);
                detalleVenta.setVenta(venta);
            }
        });
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void delete(Integer id) {
        ventaRepository.deleteById(id);
    }

}

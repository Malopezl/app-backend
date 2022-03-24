/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.com.ventas.repository;

import gt.com.ventas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author malopez
 */
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}

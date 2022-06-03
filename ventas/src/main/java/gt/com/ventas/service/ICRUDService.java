/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.com.ventas.service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author malopez
 */
public interface ICRUDService<T> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    T create(T model);

    T update(T model);

    void delete(Integer id);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.repository;

import gt.com.ventas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author malopez
 */
public interface IPersonaRespository extends JpaRepository<Persona, Integer> {

}

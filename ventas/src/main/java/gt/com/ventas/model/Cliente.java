/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Entity
@Data
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull
    @NotBlank(message = "El nit no debe ir vacio")
    @Column(name = "nit")
    private String nit;

    @Column(name = "correo")
    private String correo;

    @OneToOne
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

}

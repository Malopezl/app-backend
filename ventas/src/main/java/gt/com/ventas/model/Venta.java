/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Entity
@Data
@Table(name = "Venta")
public class Venta {

    @Id
    @Column(name = "idVenta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
    private List<DetalleVenta> detalleVentaList;

}

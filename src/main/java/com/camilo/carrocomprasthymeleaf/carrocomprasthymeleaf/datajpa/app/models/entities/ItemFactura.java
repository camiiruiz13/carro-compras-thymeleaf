package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "itemFactura")
public class ItemFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer cantidad;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idProducto")
    private Producto producto;

    public Double calcularImporte() {
        return cantidad.doubleValue() * producto.getPrecio();
    }

}
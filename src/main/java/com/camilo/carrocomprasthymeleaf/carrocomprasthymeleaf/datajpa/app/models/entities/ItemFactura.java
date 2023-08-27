package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "itemfactura")
public class ItemFactura {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer cantidad;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idproducto" , referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_Producto_ItemFacturas"))
    private Producto producto;

    public Double calcularImporte() {
        return cantidad.doubleValue() * producto.getPrecio();
    }



}
package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    private String descripcion;

    private String observacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idfactura")
    private List<ItemFactura> items;

    public Factura() {
        this.items = new ArrayList<ItemFactura>();;
    }

    public void addItemFactura(ItemFactura item) {
        this.items.add(item);
    }

    public Double getTotal() {
        Double total = 0.0;

        int size = items.size();

        for (int i = 0; i < size; i++) {
            total += items.get(i).calcularImporte();
        }
        return total;
    }
}
package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descripcion;

    private String observacion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idfactura")
    private List<ItemFactura> items;


    public Factura() {
        this.items = new ArrayList<>();
    }

    @PrePersist
    public void  prePersist(){
        fechaCreacion = new Date();
    }

    public void addItemFactura(ItemFactura item){
        items.add(item);
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
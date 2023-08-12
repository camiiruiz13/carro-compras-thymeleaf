package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "cliente")
public class Cliente implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    private String email;


    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @Column(name = "foto")
    private String foto;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Cliente() {
        this.facturas = new ArrayList<>();
    }

    private void addFactura(Factura factura){
        facturas.add(factura);
    }

    /*
    @PrePersist
    public void  prePersist(){
        fechaCreacion = new Date();
    }


     */
}
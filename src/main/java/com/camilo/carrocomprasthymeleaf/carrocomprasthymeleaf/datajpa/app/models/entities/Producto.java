package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private Double precio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fechacreacion")
    private Date fechaCreacion;
    @PrePersist
    public void  prePersist(){
        fechaCreacion = new Date();
    }

}
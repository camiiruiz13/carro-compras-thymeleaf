package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repository;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {
}
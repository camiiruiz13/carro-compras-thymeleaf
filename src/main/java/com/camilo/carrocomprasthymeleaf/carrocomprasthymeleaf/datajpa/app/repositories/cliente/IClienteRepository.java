package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repositories.cliente;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c from Cliente c " +
            "join  fetch  c.facturas f " +
            "where c.id=:id")
    Cliente fetchByIdWithFacturas(@Param("id") Long id);
}
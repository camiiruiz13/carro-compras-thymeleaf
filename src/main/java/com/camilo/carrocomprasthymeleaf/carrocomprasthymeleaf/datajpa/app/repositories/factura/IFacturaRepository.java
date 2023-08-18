package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repositories.factura;


import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {

    @Query("SELECT f from Factura f " +
            "join  fetch f.cliente c " +
            "join fetch  f.items it " +
            "join  fetch it.producto p " +
            "where f.id=:id ")
    Factura fetchByIDClienteWithItemFacturaWithProducto(@Param("id") Long id);
}
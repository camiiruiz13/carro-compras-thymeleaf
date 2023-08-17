package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.producto;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findByNombre(String term);

    Producto findProductoById(Long id);
}

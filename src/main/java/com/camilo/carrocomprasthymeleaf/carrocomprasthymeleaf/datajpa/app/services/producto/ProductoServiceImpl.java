package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.producto;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Producto;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repository.IProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Producto> buscarPorNombre(String term) {
        return productoRepository.buscarPorNombre(term);
    }
}

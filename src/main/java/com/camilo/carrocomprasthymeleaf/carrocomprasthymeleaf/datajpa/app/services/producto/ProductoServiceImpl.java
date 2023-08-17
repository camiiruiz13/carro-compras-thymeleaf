package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.producto;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Producto;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repositories.producto.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String term) {
        return  productoDao.buscarPorNombre(term);
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findProductoById(Long id) {
        return productoDao.findById(id).orElse(null);
    }


}

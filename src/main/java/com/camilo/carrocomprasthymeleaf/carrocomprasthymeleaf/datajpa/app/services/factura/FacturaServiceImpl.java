package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.factura;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repository.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private IFacturaRepository facturaRepository;
    @Override
    @Transactional
    public void saveFactura(Factura factura) {
        facturaRepository.save(factura);

    }
}

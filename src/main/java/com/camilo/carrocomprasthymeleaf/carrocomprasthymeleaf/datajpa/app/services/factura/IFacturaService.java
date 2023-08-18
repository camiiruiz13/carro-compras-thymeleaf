package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.factura;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;

public interface IFacturaService {

    void saveFactura(Factura factura);

    Factura findFacturaById(Long id);

    void deleteFactura(Long id);

    Factura fetchFacturaByIDClienteWithItemFacturaWithProducto(Long id);


}

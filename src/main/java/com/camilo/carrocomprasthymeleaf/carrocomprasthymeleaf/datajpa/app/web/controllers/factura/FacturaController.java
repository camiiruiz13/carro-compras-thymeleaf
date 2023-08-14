package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.web.controllers.factura;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Cliente;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.ItemFactura;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Producto;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.cliente.IClienteService;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.factura.IFacturaService;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.producto.IProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
@Slf4j
public class FacturaController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model
    , RedirectAttributes flash){

        Cliente cliente = clienteService.finbById(clienteId);

        if (cliente == null) {
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }

        Factura factura = new Factura();
        factura.setCliente(cliente);

        model.put("factura", factura);
        model.put("titulo", "Crear Factura");

        return "factura/form";
    }

    @GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
    public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
        return productoService.buscarPorNombre(term);
    }


    @PostMapping("/form")
    //@RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Factura factura,
                          @RequestParam(value = "item_id[]", required = false) Long [] itemId,
                          @RequestParam(value = "cantidad[]", required = false) Integer [] cantidad,
                          RedirectAttributes flash, SessionStatus status){

        for (int i = 0; i < itemId.length; i++) {

            Producto producto = productoService.buscarProductoPorId(itemId[i]);

            ItemFactura linea = new ItemFactura();
            linea.setCantidad(cantidad[i]);
            linea.setProducto(producto);

            factura.addItemFactura(linea);

            log.info("ID: " + itemId[i].toString() + ", Cantidad: " + cantidad[i].toString());
        }

        facturaService.saveFactura(factura);
        status.setComplete();

        flash.addFlashAttribute("success", "Factura creada con éxito!");

        return "redirect:/ver/" + factura.getCliente().getId();
    }
}

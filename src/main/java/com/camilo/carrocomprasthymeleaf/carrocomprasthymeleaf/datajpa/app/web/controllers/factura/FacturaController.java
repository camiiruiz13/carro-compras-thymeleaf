package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.web.controllers.factura;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Cliente;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Producto;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.cliente.IClienteService;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.producto.IProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
}

package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.controllers.factura;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Cliente;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Factura;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.ItemFactura;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Producto;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.cliente.IClienteService;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.factura.IFacturaService;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.producto.IProductoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
@Slf4j
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/ver/{id}", method = RequestMethod.GET)
    public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash, Locale locale) {
        Factura factura = facturaService.fetchFacturaByIDClienteWithItemFacturaWithProducto(id);
        //facturaService.findFacturaById(id);

        if(factura == null) {
            flash.addFlashAttribute("error", messageSource.getMessage("text.factura.flash.db.error", null, locale));
            return "redirect:/listar";
        }

        model.addAttribute("factura", factura);
        model.addAttribute("titulo", String.format(messageSource.getMessage("text.factura.ver.titulo", null, locale), factura.getDescripcion()));

        return "factura/ver";
    }


    @RequestMapping(value = "/form/{clienteId}", method = RequestMethod.GET)
    public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
                        RedirectAttributes flash, Locale locale){

        Cliente cliente = clienteService.findOne(clienteId);

        if (cliente == null) {
            flash.addFlashAttribute("error", messageSource.getMessage("text.cliente.flash.db.error", null, locale));
            return "redirect:/listar";
        }

        Factura factura = new Factura();
        factura.setCliente(cliente);

        model.put("factura", factura);
        model.put("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));

        return "factura/form";
    }

    @RequestMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
    public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
        return productoService.findByNombre(term);
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Factura factura, BindingResult result, Model model,
                          @RequestParam(name = "item_id[]", required = false) Long[] itemId,
                          @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
                          SessionStatus status, Locale locale){

        if (result.hasErrors()) {
            model.addAttribute("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));
            return "factura/form";
        }

        if (itemId == null || itemId.length == 0) {
            model.addAttribute("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));
            model.addAttribute("error", messageSource.getMessage("text.factura.flash.lineas.error", null, locale));
            return "factura/form";
        }

        for (int i = 0; i < itemId.length; i++) {
            Producto producto = productoService.findProductoById(itemId[i]);

            ItemFactura linea = new ItemFactura();
            linea.setCantidad(cantidad[i]);
            linea.setProducto(producto);

            factura.addItemFactura(linea);

            log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
        }
        facturaService.saveFactura(factura);
        status.setComplete();
        flash.addFlashAttribute("success", messageSource.getMessage("text.factura.flash.crear.success", null, locale));

        return "redirect:/ver/" + factura.getCliente().getId();
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash, Locale locale){
        Factura factura = facturaService.findFacturaById(id);
        if (factura != null) {
            facturaService.deleteFactura(id);
            flash.addFlashAttribute("success", messageSource.getMessage("text.factura.flash.eliminar.success", null, locale));
            return "redirect:/ver/" + factura.getCliente().getId();
        }
        flash.addFlashAttribute("error", messageSource.getMessage("text.factura.flash.db.error", null, locale));

        return "redirect:/listar";
    }



}

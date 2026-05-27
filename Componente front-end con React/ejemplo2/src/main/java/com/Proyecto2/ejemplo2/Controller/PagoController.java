package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Pago;
import com.Proyecto2.ejemplo2.Service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Guardar pago
    @PostMapping
    public Pago guardar(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    // Listar pagos
    @GetMapping
    public List<Pago> listar() {
        return pagoService.listar();
    }
}
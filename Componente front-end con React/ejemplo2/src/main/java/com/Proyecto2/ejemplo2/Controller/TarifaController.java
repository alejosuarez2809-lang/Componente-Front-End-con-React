package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Tarifa;
import com.Proyecto2.ejemplo2.Service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    // Guardar tarifa
    @PostMapping
    public Tarifa guardar(@RequestBody Tarifa tarifa) {
        return tarifaService.guardar(tarifa);
    }

    // Listar tarifas
    @GetMapping
    public List<Tarifa> listar() {
        return tarifaService.listar();
    }
}

package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Espacio;
import com.Proyecto2.ejemplo2.Service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacios")
public class EspacioController {

    @Autowired
    private EspacioService espacioService;

    // Guardar espacio
    @PostMapping
    public Espacio guardar(@RequestBody Espacio espacio) {
        return espacioService.guardar(espacio);
    }

    // Listar espacios
    @GetMapping
    public List<Espacio> listar() {
        return espacioService.listar();
    }
}

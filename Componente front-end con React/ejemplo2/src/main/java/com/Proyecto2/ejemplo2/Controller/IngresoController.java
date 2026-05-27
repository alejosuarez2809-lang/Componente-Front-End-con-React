package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Ingreso;
import com.Proyecto2.ejemplo2.Service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    // Guardar ingreso
    @PostMapping
    public Ingreso guardar(@RequestBody Ingreso ingreso) {
        return ingresoService.guardar(ingreso);
    }

    // Listar ingresos
    @GetMapping
    public List<Ingreso> listar() {
        return ingresoService.listar();
    }
}

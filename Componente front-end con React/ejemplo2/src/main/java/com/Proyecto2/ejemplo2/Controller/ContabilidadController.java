package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Contabilidad;
import com.Proyecto2.ejemplo2.Service.ContabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contabilidad")
public class ContabilidadController {

    @Autowired
    private ContabilidadService contabilidadService;

    // Guardar registro contable
    @PostMapping
    public Contabilidad guardar(@RequestBody Contabilidad contabilidad) {
        return contabilidadService.guardar(contabilidad);
    }

    // Listar registros contables
    @GetMapping
    public List<Contabilidad> listar() {
        return contabilidadService.listar();
    }
}

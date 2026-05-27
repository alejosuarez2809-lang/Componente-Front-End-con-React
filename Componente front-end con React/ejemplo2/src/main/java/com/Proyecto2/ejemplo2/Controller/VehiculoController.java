package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Vehiculo;
import com.Proyecto2.ejemplo2.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin("*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // Guardar vehículo
    @PostMapping
    public Vehiculo guardar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }

    // Listar vehículos
    @GetMapping
    public List<Vehiculo> listar() {
        return vehiculoService.listar();
    }

    // Eliminar vehículo por ID
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {

        vehiculoService.eliminar(id);

        return "Vehículo eliminado correctamente";
    }
}

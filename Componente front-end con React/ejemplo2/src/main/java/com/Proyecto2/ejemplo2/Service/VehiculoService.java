package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Vehiculo;
import java.util.List;

public interface VehiculoService {

    // Guardar vehículo
    Vehiculo guardar(Vehiculo vehiculo);

    // Listar vehículos
    List<Vehiculo> listar();

    // Eliminar vehículo por ID
    void eliminar(Long id);
}

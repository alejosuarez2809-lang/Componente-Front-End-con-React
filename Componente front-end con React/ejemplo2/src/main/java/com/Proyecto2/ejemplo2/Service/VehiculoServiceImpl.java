package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Vehiculo;
import com.Proyecto2.ejemplo2.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Guardar vehículo
    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // Listar vehículos
    @Override
    public List<Vehiculo> listar() {
        return vehiculoRepository.findAll();
    }

    // Eliminar vehículo por ID
    @Override
    public void eliminar(Long id) {
        vehiculoRepository.deleteById(id);
    }
}

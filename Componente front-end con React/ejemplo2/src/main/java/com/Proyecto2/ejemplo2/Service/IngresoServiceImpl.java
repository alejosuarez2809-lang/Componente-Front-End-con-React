package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Ingreso;
import com.Proyecto2.ejemplo2.Repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoServiceImpl implements IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    @Override
    public Ingreso guardar(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    @Override
    public List<Ingreso> listar() {
        return ingresoRepository.findAll();
    }
}

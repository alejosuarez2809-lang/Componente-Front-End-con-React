package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Tarifa;
import com.Proyecto2.ejemplo2.Repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaServiceImpl implements TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public Tarifa guardar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    @Override
    public List<Tarifa> listar() {
        return tarifaRepository.findAll();
    }
}

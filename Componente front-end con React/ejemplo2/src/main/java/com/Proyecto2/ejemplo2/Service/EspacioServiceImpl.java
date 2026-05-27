package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Espacio;
import com.Proyecto2.ejemplo2.Repository.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioServiceImpl implements EspacioService {

    @Autowired
    private EspacioRepository espacioRepository;

    @Override
    public Espacio guardar(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    @Override
    public List<Espacio> listar() {
        return espacioRepository.findAll();
    }
}

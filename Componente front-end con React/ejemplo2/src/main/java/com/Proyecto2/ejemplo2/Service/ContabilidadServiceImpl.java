package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Contabilidad;
import com.Proyecto2.ejemplo2.Repository.ContabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContabilidadServiceImpl implements ContabilidadService {

    @Autowired
    private ContabilidadRepository contabilidadRepository;

    @Override
    public Contabilidad guardar(Contabilidad contabilidad) {
        return contabilidadRepository.save(contabilidad);
    }

    @Override
    public List<Contabilidad> listar() {
        return contabilidadRepository.findAll();
    }
}

package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Pago;
import com.Proyecto2.ejemplo2.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public List<Pago> listar() {
        return pagoRepository.findAll();
    }
}

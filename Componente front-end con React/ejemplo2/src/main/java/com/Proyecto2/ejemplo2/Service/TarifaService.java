package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Tarifa;
import java.util.List;

public interface TarifaService {

    Tarifa guardar(Tarifa tarifa);

    List<Tarifa> listar();
}

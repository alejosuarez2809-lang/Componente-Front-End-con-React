package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Espacio;
import java.util.List;

public interface EspacioService {

    Espacio guardar(Espacio espacio);

    List<Espacio> listar();
}

package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Ingreso;
import java.util.List;

public interface IngresoService {

    Ingreso guardar(Ingreso ingreso);

    List<Ingreso> listar();
}

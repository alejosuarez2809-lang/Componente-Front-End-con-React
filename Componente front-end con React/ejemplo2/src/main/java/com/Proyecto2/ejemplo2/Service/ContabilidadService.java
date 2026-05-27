package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Contabilidad;
import java.util.List;

public interface ContabilidadService {

    Contabilidad guardar(Contabilidad contabilidad);

    List<Contabilidad> listar();
}

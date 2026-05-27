package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Pago;
import java.util.List;

public interface PagoService {

    Pago guardar(Pago pago);

    List<Pago> listar();
}

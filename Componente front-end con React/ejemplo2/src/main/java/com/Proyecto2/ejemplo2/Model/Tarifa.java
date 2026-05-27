package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarifa {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Tarifa")
    private int id;

    // Tipo de vehículo:
    // CARRO / MOTO / CAMIONETA
    @Column(name = "Tipo Vehiculo", nullable = false, length = 30)
    private String tipoVehiculo;

    // Precio por hora
    @Column(name = "Precio por Hora", nullable = false)
    private double precioHora;
}

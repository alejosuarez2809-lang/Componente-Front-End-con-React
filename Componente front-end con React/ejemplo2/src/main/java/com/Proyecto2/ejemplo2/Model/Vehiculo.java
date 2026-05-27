package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehiculo {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Vehiculo")
    private Long id;

    // Placa del vehículo
    @Column(name = "Placa del Vehiculo", unique = true, nullable = false, length = 10)
    private String placa;

    // Tipo de vehículo:
    // CARRO / MOTO / CAMIONETA
    @Column(name = "Tipo de Vehiculo", nullable = false, length = 30)
    private String tipo;

    // Marca del vehículo
    @Column(name = "Marca del Vehiculo", nullable = false, length = 30)
    private String marca;

    // Color del vehículo
    @Column(name = "Color del Vehiculo", nullable = false, length = 30)
    private String color;

    // Nombre del propietario
    @Column(name = "Nombre del Propietario", nullable = false, length = 50)
    private String propietario;
}

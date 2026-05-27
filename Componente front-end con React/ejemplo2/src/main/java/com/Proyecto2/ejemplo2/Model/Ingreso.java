package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Ingreso {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Ingreso")
    private int id;

    // Fecha y hora de entrada
    @Column(name = "Fecha Entrada", nullable = false)
    private LocalDateTime fechaEntrada;

    // Fecha y hora de salida
    @Column(name = "Fecha Salida")
    private LocalDateTime fechaSalida;

    // Relación con Vehiculo
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    // Relación con Espacio
    @ManyToOne
    @JoinColumn(name = "espacio_id", nullable = false)
    private Espacio espacio;
}

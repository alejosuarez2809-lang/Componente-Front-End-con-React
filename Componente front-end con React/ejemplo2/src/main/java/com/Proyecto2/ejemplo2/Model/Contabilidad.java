package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Contabilidad {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Contabilidad")
    private int id;

    // Fecha del registro contable
    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    // Total de ingresos del día
    @Column(name = "Ingresos", nullable = false)
    private double ingresos;

    // Total de egresos del día
    @Column(name = "Egresos", nullable = false)
    private double egresos;

    // Observaciones adicionales
    @Column(name = "Observaciones", length = 200)
    private String observaciones;
}

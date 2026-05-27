package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Pago {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Pago")
    private int id;

    // Valor pagado
    @Column(name = "Valor", nullable = false)
    private double valor;

    // Método de pago:
    // EFECTIVO / TARJETA / TRANSFERENCIA
    @Column(name = "Metodo de Pago", nullable = false, length = 30)
    private String metodoPago;

    // Fecha del pago
    @Column(name = "Fecha Pago", nullable = false)
    private LocalDate fechaPago;

    // Relación con Ingreso
    @ManyToOne
    @JoinColumn(name = "ingreso_id", nullable = false)
    private Ingreso ingreso;
}

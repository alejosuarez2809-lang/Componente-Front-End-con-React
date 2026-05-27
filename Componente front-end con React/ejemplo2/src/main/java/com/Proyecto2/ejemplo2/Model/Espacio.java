package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Espacio {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Espacio")
    private int id;

    // Número del espacio de parqueo
    @Column(name = "Numero de Espacio", nullable = false, unique = true)
    private int numeroEspacio;

    // Estado del espacio:
    // LIBRE / OCUPADO
    @Column(name = "Estado", nullable = false, length = 20)
    private String estado;

    // Tipo de espacio:
    // CARRO / MOTO / CAMIONETA
    @Column(name = "Tipo", nullable = false, length = 30)
    private String tipo;
}

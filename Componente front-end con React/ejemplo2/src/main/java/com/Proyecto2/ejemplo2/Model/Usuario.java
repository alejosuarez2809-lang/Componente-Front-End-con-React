
package com.Proyecto2.ejemplo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    // ID principal autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id Usuario")
    private int id;

    // Nombre completo del usuario
    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    // Correo electrónico
    @Column(name = "Correo", unique = true, nullable = false, length = 50)
    private String correo;

    // Contraseña de acceso
    @Column(name = "Contraseña", nullable = false, length = 100)
    private String contraseña;

    // Rol del usuario:
    // ADMINISTRADOR, OPERADOR, CLIENTE
    @Column(name = "Rol", nullable = false, length = 30)
    private String rol;
}

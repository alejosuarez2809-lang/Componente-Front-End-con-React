package com.Proyecto2.ejemplo2.Controller;

import com.Proyecto2.ejemplo2.Model.Usuario;
import com.Proyecto2.ejemplo2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Guardar usuario
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    // Listar usuarios
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }
}

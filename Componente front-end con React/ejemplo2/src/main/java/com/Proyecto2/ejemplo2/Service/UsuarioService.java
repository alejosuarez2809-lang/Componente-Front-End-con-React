package com.Proyecto2.ejemplo2.Service;

import com.Proyecto2.ejemplo2.Model.Usuario;
import java.util.List;

public interface UsuarioService {

    Usuario guardar(Usuario usuario);

    List<Usuario> listar();
}
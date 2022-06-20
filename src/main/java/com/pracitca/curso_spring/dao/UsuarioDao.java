package com.pracitca.curso_spring.dao;



import com.pracitca.curso_spring.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuario();

    void deleteUsuario(Long id);


    void addUsuario(Usuario usuario);

    Usuario verificarCredenciales(Usuario usuario);
}

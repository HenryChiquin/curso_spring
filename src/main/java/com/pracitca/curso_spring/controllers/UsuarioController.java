package com.pracitca.curso_spring.controllers;

import com.pracitca.curso_spring.dao.UsuarioDao;
import com.pracitca.curso_spring.models.Usuario;
import com.pracitca.curso_spring.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/usuario",method = RequestMethod.GET)
    public List<Usuario> getUsuario(@RequestHeader(value = "Authorization") String token) {
        if(!validarToken(token)){
            return null;
        }
        return usuarioDao.getUsuario();
    }

    @RequestMapping(value = "api/usuario",method = RequestMethod.POST)
    public void addUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.addUsuario(usuario);
    }



    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if(!validarToken(token)){
            return;
        }
        usuarioDao.deleteUsuario(id);
    }

    private boolean validarToken(String token){
        String idUsuario = jwtUtil.getKey(token);
        return idUsuario !=null;
    }

}

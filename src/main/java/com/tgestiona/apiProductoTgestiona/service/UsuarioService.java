package com.tgestiona.apiProductoTgestiona.service;

import com.tgestiona.apiProductoTgestiona.entities.Usuario;
import com.tgestiona.apiProductoTgestiona.exceptions.UsuarioNotFoundException;
import com.tgestiona.apiProductoTgestiona.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findUserById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado"));
    }

    public List<Usuario> findAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUser(Usuario usuario){
        usuarioRepository.delete(usuario);
    }


}

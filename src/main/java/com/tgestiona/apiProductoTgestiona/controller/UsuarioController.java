package com.tgestiona.apiProductoTgestiona.controller;

import com.tgestiona.apiProductoTgestiona.dto.UsuarioDto;
import com.tgestiona.apiProductoTgestiona.entities.Usuario;
import com.tgestiona.apiProductoTgestiona.service.UsuarioService;
import com.tgestiona.apiProductoTgestiona.util.UsuarioDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioDtoConverter usuarioDtoConverter;


    @GetMapping(value = "tgestiona/usuario/{id}")
    public ResponseEntity<UsuarioDto> findUserById(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUserById(id);
        return new ResponseEntity<>(usuarioDtoConverter.convertUsuarioToDto(usuario), HttpStatus.OK);
    }

    @GetMapping(value = "tgestiona/usuarios")
    public ResponseEntity<List<UsuarioDto>> findUserAll() {
        List<Usuario> usuarios = usuarioService.findAllUsers();
        return new ResponseEntity<>(usuarioDtoConverter.convertEntityToDtos(usuarios), HttpStatus.OK);
    }


    @PostMapping(value = "tgestiona/usuario")
    public ResponseEntity<UsuarioDto> createUser(@RequestBody UsuarioDto usuarioDto) {
        Usuario newUser = usuarioDtoConverter.convertUsuarioToEntity(usuarioDto);
        newUser = usuarioService.saveUser(newUser);
        return new ResponseEntity<>(usuarioDtoConverter.convertUsuarioToDto(newUser), HttpStatus.CREATED);
    }

    @PutMapping(value = "tgestiona/usuario/{id}")
    public ResponseEntity<UsuarioDto> updateUser(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto) {
        Usuario userUpdate = usuarioService.findUserById(id);

        Usuario updatedUser = usuarioDtoConverter.map(usuarioDtoConverter.convertUsuarioToEntity(usuarioDto), userUpdate);
        updatedUser = usuarioService.saveUser(updatedUser);
        return new ResponseEntity<>(usuarioDtoConverter.convertUsuarioToDto(updatedUser), HttpStatus.OK);
    }

    @DeleteMapping(value = "tgestiona/usuario/{id}")
    public ResponseEntity<UsuarioDto> deleteUser(@PathVariable("id") Long id) {
        Usuario user = usuarioService.findUserById(id);
        usuarioService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

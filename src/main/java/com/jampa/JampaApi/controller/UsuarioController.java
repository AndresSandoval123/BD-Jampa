package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.model.Usuario;
import com.jampa.JampaApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/todos")
  public List<Usuario> getAllUsuarios(){
    return usuarioService.getAllUsuarios();
  }

  @PostMapping("/agregar")
  public Usuario addUsuario(@RequestBody Usuario usuario){
    return usuarioService.addUsuario(usuario);
  }

  @DeleteMapping("/{id}")
  public void eliminarUsuario(@PathVariable Long id){
    usuarioService.eliminarUsuario(id);
  }

  // De prueba
  //@DeleteMapping("/{id}")

}

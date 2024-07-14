package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.model.Usuario;
import com.jampa.JampaApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
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

  // agregar nuevo usuario
  @PostMapping("/add")
  public Usuario createUsuario(@RequestBody Usuario usuario) {
    return usuarioService.createUsuario(usuario);
  }

  @DeleteMapping("/{id}")
  public void eliminarUsuario(@PathVariable Long id){
    usuarioService.eliminarUsuario(id);
  }

  // Actualizar un usuario
  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
    Usuario usuario = usuarioService.getUsuarioById(id);
    if (usuario != null) {
      return ResponseEntity.ok(usuario);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/con-pedidos")
  public List<Usuario> obtenerUsuariosConPedidos() {
    return usuarioService.obtenerUsuariosConPedidos();
  }

}

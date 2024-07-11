package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Usuario;
import com.jampa.JampaApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

  @Autowired //Inyectamos la dependencia del repositorio
  private UsuarioRepository usuarioRepository; //Con esta anotación creamos una instancia de usuario repositorio o inyectamos una dependencia.

  //Método ver todos los usuarios de la lista
  public List<Usuario> getAllUsuarios(){
    return usuarioRepository.findAll();
  }

  //Método agregar usuario
  public Usuario addUsuario( Usuario usuario){
    return usuarioRepository.save(usuario);
   }
   // agregar nuevos usuarios
  public Usuario createUsuario(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  // buscar un usuario por su id
  public Usuario getUsuarioById(Long id) {
    return usuarioRepository.findById(id).orElse(null);
  }

  //Método eliminar usuario
  public void eliminarUsuario(Long id){
    usuarioRepository.deleteById(id);
  }

  // Actualizar un usuario
  public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
    Usuario usuario = usuarioRepository.findById(id).orElse(null);
    if (usuario != null) {
      usuario.setNombre_usuario(usuarioDetails.getNombre_usuario());
      usuario.setApellido_usuario(usuarioDetails.getApellido_usuario());
      usuario.setCorreo_usuario(usuarioDetails.getCorreo_usuario());
      usuario.setContrasena_usuario(usuarioDetails.getContrasena_usuario());
      return usuarioRepository.save(usuario);
    }
    return null;
  }

  public void deleteUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

  // usuarios que tienen pedidos
  public List<Usuario> obtenerUsuariosConPedidos() {
    return usuarioRepository.findUsuariosConPedidos();
  }



}

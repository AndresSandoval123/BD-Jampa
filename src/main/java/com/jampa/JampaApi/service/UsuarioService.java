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

  //Método eliminar usuario
  public void eliminarUsuario(Long id){
    usuarioRepository.deleteById(id);
  }



}

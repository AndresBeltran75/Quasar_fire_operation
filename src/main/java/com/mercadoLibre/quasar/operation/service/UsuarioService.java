package com.mercadoLibre.quasar.operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.repository.UsuarioRepository;

@Component
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(int user, String pass) {
        return usuarioRepository.findByUsuarioIdAndClave(user, pass);
    }
    
    public Usuario getUsuarioId(int user) {
        return usuarioRepository.findByUsuarioId(user);
    }

    public boolean delete(Usuario usuarioId) {
    	if(getUsuarioId(usuarioId.getUsuarioId()) != null) {
    		usuarioRepository.delete(usuarioId);
    		return true;
    	}else {
    		return false;
    	}
    }
    
}

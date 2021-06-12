package com.mercadoLibre.quasar.operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadoLibre.quasar.operation.entity.Usuarios;
import com.mercadoLibre.quasar.operation.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public Usuarios save(Usuarios usuario) {
		return usuarioRepository.save(usuario);
	}

    public Usuarios getUsuario(int user, String pass) {
        return usuarioRepository.findByUsuarioIdAndClave(user, pass);
    }
    
    public Usuarios getUsuarioId(int user) {
        return usuarioRepository.findByUsuarioId(user);
    }

    public boolean delete(Usuarios usuarioId) {
    	if(getUsuarioId(usuarioId.getUsuarioId()) != null) {
    		usuarioRepository.delete(usuarioId);
    		return true;
    	}else {
    		return false;
    	}
    }
    
}

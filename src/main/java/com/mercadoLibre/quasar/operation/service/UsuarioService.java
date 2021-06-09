package com.mercadoLibre.quasar.operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadoLibre.quasar.operation.dto.UsuarioTO;
import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.mapper.UsuarioMapper;
import com.mercadoLibre.quasar.operation.repository.UsuarioRepository;

@Component
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public UsuarioTO save(Usuario usuario) {
		Usuario registro = usuarioRepository.save(usuario);
		return usuarioMapper.usuarioToUsuarioDto(registro);
	}

    public UsuarioTO getUsuario(int user, String pass) {
        Usuario registro = usuarioRepository.findByUsuarioIdAndClave(user, pass);
    	return usuarioMapper.usuarioToUsuarioDto(registro);
    }
    
    public UsuarioTO getUsuarioId(int user) {
        Usuario registro = usuarioRepository.findByUsuarioId(user);
    	return usuarioMapper.usuarioToUsuarioDto(registro);
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

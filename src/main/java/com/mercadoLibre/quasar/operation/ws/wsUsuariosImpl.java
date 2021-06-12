package com.mercadoLibre.quasar.operation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadoLibre.quasar.operation.entity.Usuarios;
import com.mercadoLibre.quasar.operation.mapper.UsuarioMapper;
import com.mercadoLibre.quasar.operation.repository.IUsuarioRepository;
import com.mercadoLibre.quasar.operation.to.UsuarioTO;

@RestController
public class wsUsuariosImpl implements IwsUsuarios{
	
	@Autowired
	private IUsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;

	@Override
	public ResponseEntity<UsuarioTO> obtenerUsuario(@RequestParam Integer usuarioId) {
		return new ResponseEntity<UsuarioTO>(mapper.usuarioToUsuarioDto(repository.findByUsuarioId(usuarioId)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuarioTO> crearUsuario(Usuarios user) {
		return new ResponseEntity<UsuarioTO>(mapper.usuarioToUsuarioDto(repository.save(user)), HttpStatus.OK);
	}

}
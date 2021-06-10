package com.mercadoLibre.quasar.operation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadoLibre.quasar.operation.interfac.IwsUsuarios;
import com.mercadoLibre.quasar.operation.mapper.UsuarioMapper;
import com.mercadoLibre.quasar.operation.service.UsuarioService;
import com.mercadoLibre.quasar.operation.to.UsuarioTO;

@RestController
public class wsUsuarios implements IwsUsuarios{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioMapper mapper;

	@Override
	public ResponseEntity<UsuarioTO> obtenerUsuario(@RequestParam Integer usuarioId) {
		return new ResponseEntity<UsuarioTO>(mapper.usuarioToUsuarioDto(usuarioService.getUsuarioId(usuarioId)), HttpStatus.OK);
	}

}

package com.mercadoLibre.quasar.operation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.interfac.IwsUsuarios;
import com.mercadoLibre.quasar.operation.service.UsuarioService;

@RestController
public class wsUsuarios implements IwsUsuarios{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public ResponseEntity<Usuario> obtenerUsuario(@RequestParam Integer usuarioId) {
		return new ResponseEntity<Usuario>(usuarioService.getUsuarioId(usuarioId), HttpStatus.OK);
	}

}

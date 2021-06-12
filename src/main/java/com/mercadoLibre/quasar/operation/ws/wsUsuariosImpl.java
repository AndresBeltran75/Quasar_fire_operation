package com.mercadoLibre.quasar.operation.ws;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadoLibre.quasar.operation.entity.Usuarios;
import com.mercadoLibre.quasar.operation.mapper.UsuarioMapper;
import com.mercadoLibre.quasar.operation.repository.IUsuarioRepository;
import com.mercadoLibre.quasar.operation.to.UsuarioTO;
import com.mercadoLibre.quasar.operation.utilidades.Constantes;

@RestController
public class wsUsuariosImpl implements IwsUsuarios{
	
	@Autowired
	IUsuarioRepository repository;
	
	@Autowired
	UsuarioMapper mapper;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public ResponseEntity<UsuarioTO> obtenerUsuario(@RequestParam Integer usuarioId) {
		return new ResponseEntity<UsuarioTO>(mapper.usuarioToUsuarioDto(repository.findByUsuarioId(usuarioId)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuarioTO> crearUsuario(Usuarios user) {
		Usuarios usuario = new Usuarios();
		usuario.setClave(encoder.encode(user.getClave()));
		usuario.setEstado(Constantes.ESTADO_ACTIVO);
		usuario.setFechaCreacion(new Date());
		usuario.setPrimerApellido(user.getPrimerApellido());
		usuario.setSegundoApellido(user.getSegundoApellido());
		usuario.setPrimerNombre(user.getPrimerNombre());
		usuario.setSegundoNombre(user.getSegundoNombre());
		usuario.setUsuarioCreacion(user.getUsuarioCreacion());
		usuario.setFechaModificacion(new Date());
		usuario.setUsuarioModificacion(usuario.getUsuarioModificacion());
		Usuarios salida = repository.save(usuario);
		return new ResponseEntity<UsuarioTO>(mapper.usuarioToUsuarioDto(repository.save(salida)), HttpStatus.OK);
	}

}
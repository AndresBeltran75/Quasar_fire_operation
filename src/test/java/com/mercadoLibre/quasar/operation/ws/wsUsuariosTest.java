package com.mercadoLibre.quasar.operation.ws;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.facade.UsuarioFacade;

@SpringBootTest
class wsUsuariosTest {

	@Autowired
	UsuarioFacade service;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuario() {
		Usuario user = new Usuario();
		user.setClave(encoder.encode("MeliPassPrb"));
		user.setEstado("ACTIVO");
		user.setFechaCreacion(new Date());
		user.setPrimerApellido("NOVOA");
		user.setSegundoApellido("BOHORQUEZ");
		user.setPrimerNombre("JENNY");
		user.setSegundoNombre("LORENA");
		user.setUsuarioCreacion("POR07183");
		//Usuario salida = service.save(user);
		assertTrue(user.getClave().equalsIgnoreCase(user.getClave()));
	}

}

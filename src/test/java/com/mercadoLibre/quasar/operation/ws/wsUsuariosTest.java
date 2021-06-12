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
		user.setUsuarioId(Integer.parseInt("1"));
		user.setClave(encoder.encode("Colombia2021*"));
		user.setEstado("ACTIVO");
		user.setFechaCreacion(new Date());
		user.setPrimerApellido("BELTRAN");
		user.setSegundoApellido("CASTELLANOS");
		user.setPrimerNombre("FIDEL");
		user.setSegundoNombre("ANDRES");
		user.setUsuarioCreacion("POR07183");
		user.setFechaModificacion(new Date());
		user.setUsuarioModificacion("POR02185");
		Usuario salida = service.save(user);
		assertTrue(salida.getClave().equalsIgnoreCase(user.getClave()));
	}

}

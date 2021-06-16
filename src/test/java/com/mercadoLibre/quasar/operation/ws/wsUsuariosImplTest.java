package com.mercadoLibre.quasar.operation.ws;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mercadoLibre.quasar.operation.entity.Usuarios;
import com.mercadoLibre.quasar.operation.repository.IUsuarioRepository;
import com.mercadoLibre.quasar.operation.to.AuthenticationRequest;
import com.mercadoLibre.quasar.operation.to.AuthenticationResponse;

@SpringBootTest
class wsUsuariosImplTest {

	@Autowired
	IUsuarioRepository service;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	IwsAuthentication auth;
	
	@Test
	public void crearUsuario() {
		Usuarios user = new Usuarios();
		user.setUsuarioId(Integer.parseInt("1"));
		user.setNombreUsuario("SAS00556");
		user.setClave(encoder.encode("Colombia2021*"));
		user.setEstado("ACTIVO");
		user.setFechaCreacion(new Date());
		user.setPrimerApellido("BELTRAN");
		user.setSegundoApellido("CASTELLANOS");
		user.setPrimerNombre("FIDEL");
		user.setSegundoNombre("ANDRES");
		user.setUsuarioCreacion("POR07183");
		user.setFechaModificacion(null);
		user.setUsuarioModificacion(null);
		Usuarios salida = service.save(user);
		assertTrue(salida.getClave().equalsIgnoreCase(user.getClave()));
	}
	
	@Test
	public void generarToken() {
		AuthenticationRequest req = new AuthenticationRequest();
		req.setUsername("SAS00556");
		req.setPassword("Colombia2021*");
		ResponseEntity<AuthenticationResponse> res = auth.createToken(req);
		assertNotNull(res.getBody().getToken());
	}

}

package com.mercadoLibre.quasar.operation.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mercadoLibre.quasar.operation.to.UsuarioTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/usuarios")
@Api(value = "Web service get information user")
public interface IwsUsuarios {

	@GetMapping("/consulta")
	@ApiOperation(value = "get information user")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public ResponseEntity<UsuarioTO> obtenerUsuario(Integer usuarioId);
	
}

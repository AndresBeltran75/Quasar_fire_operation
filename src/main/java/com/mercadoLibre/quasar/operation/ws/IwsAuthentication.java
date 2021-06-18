package com.mercadoLibre.quasar.operation.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercadoLibre.quasar.operation.to.AuthenticationRequest;
import com.mercadoLibre.quasar.operation.to.AuthenticationResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@Api(description = "Web service authentication users")
public interface IwsAuthentication {

    @PostMapping("/authenticate")
	@ApiOperation(value = "Get token for user")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request);
	
}

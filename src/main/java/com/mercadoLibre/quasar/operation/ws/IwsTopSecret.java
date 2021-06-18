package com.mercadoLibre.quasar.operation.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercadoLibre.quasar.operation.to.ResponseTO;
import com.mercadoLibre.quasar.operation.to.requestTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@CrossOrigin(origins = "*")
@RequestMapping("topsecret")
@Api(description = "Web service top secret")
public interface IwsTopSecret {

	@GetMapping("/status")
	@ApiOperation(value = "Get status service to determine if it is active")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public String status();
	
	@PostMapping("/")
	@ApiOperation(value = "Get top secret service response for a specific vessel")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public ResponseTO mensaje(@RequestBody requestTO request);
	
}

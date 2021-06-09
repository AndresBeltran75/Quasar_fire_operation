package com.mercadoLibre.quasar.operation.interfac;

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

@RequestMapping("topsecret")
@Api(value = "Web service top secret")
public interface IwsTopSecret {

	@GetMapping("/status")
	@ApiOperation(value = "Get status service")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public String status();
	
	@PostMapping("/")
	@ApiOperation(value = "Get responde top secret service")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public ResponseTO mensaje(@RequestBody requestTO request);
	
}

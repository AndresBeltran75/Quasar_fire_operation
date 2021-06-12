package com.mercadoLibre.quasar.operation.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercadoLibre.quasar.operation.to.ResponseSplitTO;
import com.mercadoLibre.quasar.operation.to.ResponseTO;
import com.mercadoLibre.quasar.operation.to.quasarTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "Web service top secret split")
@RequestMapping("topsecret_split")
public interface IwsTopSecretSplit {

	@GetMapping("/status")
	@ApiOperation(value = "Get status service to determine if it is active")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public String status();
	
	@GetMapping("/")
	@ApiOperation(value = "Get top secret split service service response")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public ResponseTO obtenerMensajePosicion();
	
	@PostMapping("/")
	@ApiOperation(value = "Get responde top secret split service")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public ResponseTO datosPorSaltelite(@RequestBody quasarTO request);
	
	@PostMapping("/{satellite_name}")
	@ApiOperation(value = "Get top secret split service response for a specific vessel")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Not Found")
	})
	public ResponseTO satelliteName(@PathVariable("satellite_name") String name,
								    @RequestBody ResponseSplitTO responseSplitTO);
	
}

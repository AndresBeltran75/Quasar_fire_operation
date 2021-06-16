package com.mercadoLibre.quasar.operation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadoLibre.quasar.operation.to.CircunferenciaTO;
import com.mercadoLibre.quasar.operation.to.PositionTO;
import com.mercadoLibre.quasar.operation.to.PuntoTO;
import com.mercadoLibre.quasar.operation.to.ResponseTO;
import com.mercadoLibre.quasar.operation.to.requestTO;
import com.mercadoLibre.quasar.operation.utilidades.CalculoCircunferencia;
import com.mercadoLibre.quasar.operation.utilidades.ObtenerMensaje;

@RestController
public class wsTopSecretImpl implements IwsTopSecret{
	
	@Autowired
	CalculoCircunferencia calculoCircunferencia;
	
	@Autowired
	ObtenerMensaje obtenerMensaje;
	
	@Override
	public String status() {
		return "OK";
	}
	
	@Override
	public ResponseTO mensaje(requestTO request) {
		
		String mensaje = null;
		ResponseTO response = new ResponseTO();
		PositionTO position = new PositionTO();
		
        PuntoTO kenobi = new PuntoTO(-500, -200);
        PuntoTO skywalker = new PuntoTO(100, -100);
        PuntoTO sato = new PuntoTO(500, 100);
        
        CircunferenciaTO circunferecia = calculoCircunferencia.calcularCentro(kenobi, skywalker, sato);
        
        position.setX(circunferecia.getCentro().getPunto().getX());
        position.setY(circunferecia.getCentro().getPunto().getY());

        mensaje = obtenerMensaje.GetMessage(request.getSatellites());        	
		
		response.setPosition(position);
		response.setMessage(mensaje);
		
		return response;
		
	}
	
}

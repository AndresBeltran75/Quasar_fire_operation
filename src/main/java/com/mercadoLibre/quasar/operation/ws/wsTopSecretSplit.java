package com.mercadoLibre.quasar.operation.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mercadoLibre.quasar.operation.interfac.IwsTopSecretSplit;
import com.mercadoLibre.quasar.operation.to.CircunferenciaTO;
import com.mercadoLibre.quasar.operation.to.PositionTO;
import com.mercadoLibre.quasar.operation.to.PuntoTO;
import com.mercadoLibre.quasar.operation.to.ResponseSplitTO;
import com.mercadoLibre.quasar.operation.to.ResponseTO;
import com.mercadoLibre.quasar.operation.to.quasarTO;
import com.mercadoLibre.quasar.operation.utilidades.CalculoCircunferencia;
import com.mercadoLibre.quasar.operation.utilidades.Constantes;
import com.mercadoLibre.quasar.operation.utilidades.ObtenerMensaje;

@RestController
public class wsTopSecretSplit implements IwsTopSecretSplit{

	@Autowired
	CalculoCircunferencia calculoCircunferencia;
	
	@Autowired
	ObtenerMensaje obtenerMensaje;
	
    PuntoTO kenobi = new PuntoTO(-500, -200);
    PuntoTO skywalker = new PuntoTO(100, -100);
    PuntoTO sato = new PuntoTO(500, 100);
    
	@Override
	public String status() {
		return "OK";
	}
	
	@Override
	public ResponseTO obtenerMensajePosicion() {
		String mensaje = null;
		ResponseTO response = new ResponseTO();
		PositionTO position = new PositionTO();
		
		CircunferenciaTO circunferecia = calculoCircunferencia.calcularCentro(kenobi, skywalker, sato);
        
        position.setX(circunferecia.getCentro().getPunto().getX());
        position.setY(circunferecia.getCentro().getPunto().getY());
		
        mensaje = obtenerMensaje.GetMessage(null);
		
		response.setPosition(position);
		response.setMessage(mensaje);
		
		return response;
	}
	
	@Override
	public ResponseTO datosPorSaltelite(@RequestBody quasarTO request){
		
		List<quasarTO> listQuasarTo = new ArrayList<quasarTO>();
		listQuasarTo.add(request);
		ResponseTO salida = new ResponseTO();
		PositionTO positionTO = new PositionTO();
		String mensaje = obtenerMensaje.GetMessage(listQuasarTo);
		
		if( request.getName().equalsIgnoreCase(Constantes.SATELITE_KENOBI) ) {
			positionTO.setX(kenobi.getPunto().getX());
			positionTO.setY(kenobi.getPunto().getY());
			salida.setPosition(positionTO);
			salida.setMessage(mensaje);
		}else if( request.getName().equalsIgnoreCase(Constantes.SATELITE_SKYWALKER) ) {
			positionTO.setX(skywalker.getPunto().getX());
			positionTO.setY(skywalker.getPunto().getY());
			salida.setPosition(positionTO);
			salida.setMessage(mensaje);
		}else if( request.getName().equalsIgnoreCase(Constantes.SATELITE_SATO) ){
			positionTO.setX(sato.getPunto().getX());
			positionTO.setY(sato.getPunto().getY());
			salida.setPosition(positionTO);
			salida.setMessage(mensaje);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, null);
		}
		
		return salida;
	}
	
	@Override
	public ResponseTO satelliteName(@PathVariable("satellite_name") String name,
								    @RequestBody ResponseSplitTO responseSplitTO) {

		List<quasarTO> listQuasarTo = new ArrayList<quasarTO>();
		ResponseTO salida = new ResponseTO();
		PositionTO positionTO = new PositionTO();
		
		if( name != null && !name.isEmpty() ) {
			quasarTO quasarTO = new quasarTO();
			quasarTO.setDistance(responseSplitTO.getDistance());
			quasarTO.setMessage(responseSplitTO.getMessage());
			quasarTO.setName(name);
			listQuasarTo.add(quasarTO);
			
			String mensaje = obtenerMensaje.GetMessage(listQuasarTo);
			
			if( name.equalsIgnoreCase(Constantes.SATELITE_KENOBI) ) {
				positionTO.setX(kenobi.getPunto().getX());
				positionTO.setY(kenobi.getPunto().getY());
				salida.setPosition(positionTO);
				salida.setMessage(mensaje);
			}else if( name.equalsIgnoreCase(Constantes.SATELITE_SKYWALKER) ) {
				positionTO.setX(skywalker.getPunto().getX());
				positionTO.setY(skywalker.getPunto().getY());
				salida.setPosition(positionTO);
				salida.setMessage(mensaje);
			}else if( name.equalsIgnoreCase(Constantes.SATELITE_SATO) ){
				positionTO.setX(sato.getPunto().getX());
				positionTO.setY(sato.getPunto().getY());
				salida.setPosition(positionTO);
				salida.setMessage(mensaje);
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, null);
			}
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, null);
		}
		
		return salida;
		
	}

}

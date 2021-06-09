package com.mercadoLibre.quasar.operation.utilidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mercadoLibre.quasar.operation.to.quasarTO;

@Repository
public class ObtenerMensaje {
	
	public String GetMessage(List<quasarTO> listQuasarTO) {
		
		Map<Integer, String> valoresMensaje = new HashMap<Integer, String>();
		
		String mensaje = "";
		int contador = 0;
		int vueltas = 0;
		
		if( listQuasarTO != null && !listQuasarTO.isEmpty() ) {
			for (quasarTO quasarTO : listQuasarTO) {
				contador = 0;
				for (String cadena : quasarTO.getMessage()) {
					if( contador != 0 ) {
						if( cadena != valoresMensaje.get(contador) ) {
							if( cadena != null && !cadena.isEmpty() ) {
								valoresMensaje.put(contador, cadena);							
							}
						}
						contador++;
					}else{
						if( vueltas != 0 ) {
							if( cadena != valoresMensaje.get(contador) ) {
								if( cadena != null && !cadena.isEmpty() ) {
									valoresMensaje.put(contador, cadena);							
								}
							}
							contador++;
						}else {
							valoresMensaje.put(contador, cadena);
							contador++;	
						}
					}
				}
				vueltas++;
			}
			
			for (Map.Entry<Integer,String> entry : valoresMensaje.entrySet()) {
				mensaje = mensaje.concat(" ").concat(entry.getValue()).trim();
			}
		}else {
			mensaje = "No se encontro información suficiente para determinar el mensaje";
		}
		
		return mensaje; 
	}

}

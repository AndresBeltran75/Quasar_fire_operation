package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos consolidados de la respuesta")
public class ResponseTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Objeto con datos de la posicion de una nave")
	private PositionTO position;
	@ApiModelProperty(value = "Mensaje calculado para una nave")
	private String message;
	
	public PositionTO getPosition() {
		return position;
	}
	public void setPosition(PositionTO position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

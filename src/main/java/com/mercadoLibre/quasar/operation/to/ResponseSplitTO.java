package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos de la respuesta para una nave especifica")
public class ResponseSplitTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Distancia de una nave")
	private Double distance;
	@ApiModelProperty(value = "Mensaje de una nave")
	private String[] message;
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String[] getMessage() {
		return message;
	}
	public void setMessage(String[] message) {
		this.message = message;
	}

}

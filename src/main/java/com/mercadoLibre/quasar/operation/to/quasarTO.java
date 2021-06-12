package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos de la respuesta con respecto a las naves")
public class quasarTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Nombre de la nave")
	private String name;
	@ApiModelProperty(value = "Distancia de la nave")
	private Double distance;
	@ApiModelProperty(value = "Mensaje de la nave")
	private String[] message;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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

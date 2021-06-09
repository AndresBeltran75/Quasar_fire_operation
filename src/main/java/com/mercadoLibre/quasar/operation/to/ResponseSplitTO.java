package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

public class ResponseSplitTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double distance;
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

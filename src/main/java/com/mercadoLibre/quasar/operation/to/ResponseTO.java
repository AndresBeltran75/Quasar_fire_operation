package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

public class ResponseTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PositionTO position;
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

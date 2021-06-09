package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

public class PositionTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double x;
	private Double y;
	
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}

}

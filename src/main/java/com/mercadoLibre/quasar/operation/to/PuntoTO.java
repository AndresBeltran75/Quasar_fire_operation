package com.mercadoLibre.quasar.operation.to;

import java.awt.geom.Point2D;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos de la posición en 2D")
public class PuntoTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Posición de la nave en 2D")
	private Point2D punto;

    public PuntoTO() {
        punto = new Point2D.Double(0, 0);
    }

    public PuntoTO(int x, int y) {
        punto = new Point2D.Double(x, y);
    }

    public Point2D getPunto() {
        return punto;
    }

    public void setPunto(Point2D punto) {
        this.punto = punto;
    }

}

package com.mercadoLibre.quasar.operation.to;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class PuntoTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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

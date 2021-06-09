package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;

public class CircunferenciaTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PuntoTO centro;
    private double radio;
    
    public CircunferenciaTO() {
    }

    public CircunferenciaTO(PuntoTO centro, int radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public PuntoTO getCentro() {
        return centro;
    }

    public void setCentro(PuntoTO centro) {
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

}

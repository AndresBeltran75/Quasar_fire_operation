package com.mercadoLibre.quasar.operation.utilidades;

import org.springframework.stereotype.Repository;

import com.mercadoLibre.quasar.operation.to.CircunferenciaTO;
import com.mercadoLibre.quasar.operation.to.PuntoTO;

@Repository
public class CalculoCircunferencia {
	
	public CircunferenciaTO calcularCentro(PuntoTO x1, PuntoTO x2, PuntoTO x3) {
        CircunferenciaTO circunferencia = new CircunferenciaTO();
        double a, b, c, d, e, f, h, k, r;
        a = x1.getPunto().getX();
        b = x1.getPunto().getY();
        c = x2.getPunto().getX();
        d = x2.getPunto().getY();
        e = x3.getPunto().getX();
        f = x3.getPunto().getY();
        h = (0.5) * ((Math.pow(a, 2) + Math.pow(b, 2)) * (f - d) + (Math.pow(c, 2) + Math.pow(d, 2)) * (b - f) + (Math.pow(e, 2) + Math.pow(f, 2)) * (d - b)) / (a * (f - d) + c * (b - f) + e * (d - b));
        k = (0.5) * ((Math.pow(a, 2) + Math.pow(b, 2)) * (e - c) + (Math.pow(c, 2) + Math.pow(d, 2)) * (a - e) + (Math.pow(e, 2) + Math.pow(f, 2)) * (c - a)) / (b * (e - c) + d * (a - e) + f * (c - a));
        r = Math.sqrt(Math.pow((h - a), 2) + Math.pow((k - b), 2));
        circunferencia.setRadio(r);
        circunferencia.setCentro(new PuntoTO((int) h, (int) k));
        return circunferencia;
    }

}

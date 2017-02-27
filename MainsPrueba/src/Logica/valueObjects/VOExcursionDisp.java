package Logica.valueObjects;

import java.io.Serializable;

import Logica.Hora;

public class VOExcursionDisp extends VOExcursion implements Serializable{
	private int cant_disponibles;

	public VOExcursionDisp(String codigo, String destino, Hora hr_partida,
			Hora hr_regreso, float precioBase, int cant_disponibles) {
		super(codigo, destino, hr_partida, hr_regreso, precioBase);
		this.cant_disponibles = cant_disponibles;
	}

	public int getCant_disponibles() {
		return cant_disponibles;
	}
	
	
}

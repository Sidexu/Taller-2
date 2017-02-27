package Logica.valueObjects;
import java.io.Serializable;

import Logica.Hora;

public class VOExcursion implements Serializable {
	private String codigo;
	private String destino;
	private Hora hr_partida;
	private Hora hr_regreso;
	private float precioBase;
	
	public VOExcursion(String codigo, String destino, Hora hr_partida,
			Hora hr_regreso, float precioBase) {
		this.codigo = codigo;
		this.destino = destino;
		this.hr_partida = hr_partida;
		this.hr_regreso = hr_regreso;
		this.precioBase = precioBase;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDestino() {
		return destino;
	}

	public Hora getHr_partida() {
		return hr_partida;
	}

	public Hora getHr_regreso() {
		return hr_regreso;
	}

	public float getPrecioBase() {
		return precioBase;
	}
	
	
}

package Logica;
import java.io.Serializable;

import Logica.Hora;
import Logica.Boletos;
import Logica.Bus;

public class Excursion implements Serializable{
	private String codigo;
	private String destino;
	private Hora hr_partida;
	private Hora hr_regreso;
	private float precio_base;
	private Bus bus;
	private Boletos boletos;
	
	public Excursion(){
		
	}

	public Excursion(String codigo, String destino, Hora hr_partida,
			Hora hr_regreso, float precio_base, Bus bus, Boletos boletos) {
		super();
		this.codigo = codigo;
		this.destino = destino;
		this.hr_partida = hr_partida;
		this.hr_regreso = hr_regreso;
		this.precio_base = precio_base;
		this.bus = bus;
		this.boletos = boletos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Hora getHr_partida() {
		return hr_partida;
	}

	public void setHr_partida(Hora hr_partida) {
		this.hr_partida = hr_partida;
	}

	public Hora getHr_regreso() {
		return hr_regreso;
	}

	public void setHr_regreso(Hora hr_regreso) {
		this.hr_regreso = hr_regreso;
	}

	public float getPrecio_base() {
		return precio_base;
	}

	public void setPrecio_base(float precio_base) {
		this.precio_base = precio_base;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Boletos getBoletos() {
		return boletos;
	}

	public void setBoletos(Boletos boletos) {
		this.boletos = boletos;
	}
	
	
	

}


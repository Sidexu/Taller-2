package Logica;
import Logica.Excursiones;
import java.io.Serializable;

public class Bus implements Serializable {
	private String matricula;
	private String marca;
	private int capacidad;
	private Excursiones exc;
	
	public Bus(String matricula, String marca, int capacidad, Excursiones exc) {
		
		this.matricula = matricula;
		this.marca = marca;
		this.capacidad = capacidad;
		this.exc = exc;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Excursiones getExc() {
		return exc;
	}

	public void setExc(Excursiones exc) {
		this.exc = exc;
	}
	

	
}

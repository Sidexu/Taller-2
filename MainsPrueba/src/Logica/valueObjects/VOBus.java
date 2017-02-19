package Logica.valueObjects;

public class VOBus {
	private String matricula;
	private String marca;
	private int capacidad;
	
	public VOBus(String matricula, String marca, int capacidad) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.capacidad = capacidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public int getCapacidad() {
		return capacidad;
	}
	
}

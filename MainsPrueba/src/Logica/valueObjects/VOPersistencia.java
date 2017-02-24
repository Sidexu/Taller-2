package Logica.valueObjects;

import java.io.Serializable;

import Logica.Buses;
import Logica.Excursiones;

public class VOPersistencia implements Serializable{
	private Buses buses;
	private Excursiones excursiones;
	
	public VOPersistencia(Buses buses, Excursiones excursiones) {
		this.buses = buses;
		this.excursiones = excursiones;
	}

	public Buses getBuses() {
		return buses;
	}

	public Excursiones getExcursiones() {
		return excursiones;
	}
	
}

package Logica;

import java.io.Serializable;

public class Hora implements Serializable {
	private int hora;
	private int min;
	
	public Hora(){
		hora=0;
		min=0;
	}
	
	public Hora(int hora, int min) {
		super();
		this.hora = hora;
		this.min = min;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	//retorna true si la hora que tengo es menor a la que me pasan
	public boolean esMenorIgual(Hora h1){
		boolean esMenor=false;
		int min1=(h1.getHora()*60)+h1.getMin();
		int miHora=(this.hora*60)+this.min;
		if(miHora<=min1){
			esMenor=true;
		}
			
		return esMenor;
	}
	
}

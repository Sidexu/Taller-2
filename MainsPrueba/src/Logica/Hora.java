package Logica;

public class Hora {
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
	
	
}

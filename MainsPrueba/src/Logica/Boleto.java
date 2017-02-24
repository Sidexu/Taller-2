package Logica;

import java.io.Serializable;

public class Boleto implements Serializable{
	private int nroboleto;
	private int edad_pas;
	private String lugar_procedencia;
	private long cel_pas;
	
	public Boleto() {
		
	}
	
	public Boleto(int nroboleto, int edad_pas, String lugar_procedencia,
			long cel_pas) {
		this.nroboleto = nroboleto;
		this.edad_pas = edad_pas;
		this.lugar_procedencia = lugar_procedencia;
		this.cel_pas = cel_pas;
	}

	public int getNroboleto() {
		return nroboleto;
	}
	public void setNroboleto(int nroboleto) {
		this.nroboleto = nroboleto;
	}
	public int getEdad_pas() {
		return edad_pas;
	}
	public void setEdad_pas(int edad_pas) {
		this.edad_pas = edad_pas;
	}
	public String getLugar_procedencia() {
		return lugar_procedencia;
	}
	public void setLugar_procedencia(String lugar_procedencia) {
		this.lugar_procedencia = lugar_procedencia;
	}
	public long getCel_pas() {
		return cel_pas;
	}
	public void setCel_pas(long cel_pas) {
		this.cel_pas = cel_pas;
	}
	
	public String tipoBoleto (){
		return "comun";
	}
}

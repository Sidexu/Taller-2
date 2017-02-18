package Logica;

public class Boleto {
	private int nroboleto;
	private int edad_pad;
	private String lugar_procedencia;
	private long cel_pas;
	
	public Boleto(int nroboleto, int edad_pad, String lugar_procedencia,
			long cel_pas) {
		this.nroboleto = nroboleto;
		this.edad_pad = edad_pad;
		this.lugar_procedencia = lugar_procedencia;
		this.cel_pas = cel_pas;
	}
	public int getNroboleto() {
		return nroboleto;
	}
	public void setNroboleto(int nroboleto) {
		this.nroboleto = nroboleto;
	}
	public int getEdad_pad() {
		return edad_pad;
	}
	public void setEdad_pad(int edad_pad) {
		this.edad_pad = edad_pad;
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
}

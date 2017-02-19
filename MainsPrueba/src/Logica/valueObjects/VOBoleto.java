package Logica.valueObjects;

public class VOBoleto {
	private int edad_pas;
	private String lugar_procedencia;
	private long cel_pas;
	
	public VOBoleto(int edad_pas, String lugar_procedencia, long cel_pas) {
		this.edad_pas = edad_pas;
		this.lugar_procedencia = lugar_procedencia;
		this.cel_pas = cel_pas;
	}

	public int getEdad_pas() {
		return edad_pas;
	}

	public String getLugar_procedencia() {
		return lugar_procedencia;
	}

	public long getCel_pas() {
		return cel_pas;
	}

	
	
}

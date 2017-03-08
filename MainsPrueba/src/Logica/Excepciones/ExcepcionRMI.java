package Logica.Excepciones;

public class ExcepcionRMI extends Exception {
	private String msg;

	public ExcepcionRMI(String msg) {
		this.msg = msg;
	}

	public String darMensaje() {
		return msg;
	}
}
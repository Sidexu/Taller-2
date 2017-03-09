package Logica.Excepciones;

public class ExcepcionVentana extends Exception {
	private String msg;

	public ExcepcionVentana(String msg) {
		this.msg = msg;
	}

	public String darMensaje() {
		return msg;
	}
}
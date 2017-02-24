package Logica.Excepciones;

public class ExcepcionPersistencia extends Exception {
	private String msg;

	public ExcepcionPersistencia(String msg) {
		this.msg = msg;
	}

	public String darMensaje() {
		return msg;
	}
	
	
}

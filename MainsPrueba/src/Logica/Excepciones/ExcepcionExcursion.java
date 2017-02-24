package Logica.Excepciones;

public class ExcepcionExcursion extends Exception {
	private String msg;
	
	public ExcepcionExcursion (String mensaje){ 
		this.msg = mensaje; 
	}
	public String darMensaje(){
		return msg; 
	}
}

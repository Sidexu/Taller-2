package Logica;
//import Logica.Boletos;

public class Excursion {
	private String codigo;
	private String destino;
	// private time hr_partida;
	// private time hr_regreso;
	private float precio_base;
	// private Bus Bus;
	// private Boletos Boletos;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public float getPrecio_base() {
		return precio_base;
	}
	public void setPrecio_base(float precio_base) {
		this.precio_base = precio_base;
	}
}


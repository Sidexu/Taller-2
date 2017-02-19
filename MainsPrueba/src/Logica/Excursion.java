package Logica;
import Logica.Boletos;
import Logica.Bus;

public class Excursion {
	private String codigo;
	private String destino;
	// private time hr_partida;
	// private time hr_regreso;
	private float precio_base;
	private Bus Bus;
	private Boletos Boletos;
	
	public Excursion(String codigo, String destino, float precio_base,
			Bus bus, Boletos boletos) {
		super();
		this.codigo = codigo;
		this.destino = destino;
		this.precio_base = precio_base;
		Bus = bus;
		Boletos = boletos;
	}
	
	public Excursion() {

	}

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
	public Bus getBus() {
		return Bus;
	}
	public void setBus(Bus bus) {
		Bus = bus;
	}
	public Boletos getBoletos() {
		return Boletos;
	}
	public void setBoletos(Boletos boletos) {
		Boletos = boletos;
	}

}


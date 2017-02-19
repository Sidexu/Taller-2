package Logica.valueObjects;

public class VOBoletoEspecial extends VOBoleto {
	private int nro_boleto;
	private float descuento;
	
	public VOBoletoEspecial(int edad_pas, String lugar_procedencia,
			long cel_pas, int nro_boleto, float descuento) {
		super(edad_pas, lugar_procedencia, cel_pas);
		this.nro_boleto = nro_boleto;
		this.descuento = descuento;
	}

	public int getNro_boleto() {
		return nro_boleto;
	}

	public float getDescuento() {
		return descuento;
	}

	
}

package Logica.valueObjects;

public class VOBoletoEspecial extends VOBoleto {
	private float descuento;
	
	public VOBoletoEspecial(int nro_boleto,int edad_pas, String lugar_procedencia,
			long cel_pas, float descuento) {
		super(nro_boleto,edad_pas, lugar_procedencia, cel_pas);
		this.descuento = descuento;
	}


	public float getDescuento() {
		return descuento;
	}

	
}

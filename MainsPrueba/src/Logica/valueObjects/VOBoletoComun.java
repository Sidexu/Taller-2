package Logica.valueObjects;

public class VOBoletoComun extends VOBoleto{
	private int nro_boleto;

	public VOBoletoComun(int edad_pas, String lugar_procedencia, long cel_pas,
			int nro_boleto) {
		super(edad_pas, lugar_procedencia, cel_pas);
		this.nro_boleto = nro_boleto;
	}

	public int getNro_boleto() {
		return nro_boleto;
	}
	
	
}

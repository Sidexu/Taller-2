package Logica;

public class Especial extends Boleto {
	private float descuento;

	public Especial() {
		
	}

	public Especial(int nroboleto, int edad_pas, String lugar_procedencia,
			long cel_pas, float descuento) {
		super(nroboleto, edad_pas, lugar_procedencia, cel_pas);
		this.descuento = descuento;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	public String tipoBoleto (){
		return "especial";
	}
}

package Logica.valueObjects;

import java.io.Serializable;

public class VOBoletoTipo implements Serializable {
		private int nro_boleto;
		private int edad_pas;
		private String lugar_procedencia;
		private long cel_pas;
		private float descuento;
		
		public VOBoletoTipo(int nro_boleto,int edad_pas, String lugar_procedencia, long cel_pas, float descuento) {
			this.nro_boleto = nro_boleto;
			this.edad_pas = edad_pas;
			this.lugar_procedencia = lugar_procedencia;
			this.cel_pas = cel_pas;
			this.descuento = descuento;
		}
		
		public int getNro_boleto() {
			return nro_boleto;
		}

		public int getEdad_pas() {
			return edad_pas;
		}

		public String getLugar_procedencia() {
			return lugar_procedencia;
		}

		public long getCel_pas() {
			return cel_pas;
		}
		
		public float getDescuento() {
			return descuento;
		}
}

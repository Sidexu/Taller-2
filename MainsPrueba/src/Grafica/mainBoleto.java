package Grafica;
import Logica.Boleto;

public class mainBoleto {

	public static void main(String[] args) {
		Boleto b = new Boleto(1,12,"Montevideo",99950265);
		System.out.println("Numero Boleto: "+ b.getNroboleto());
		System.out.println("Edad Pasajero: "+ b.getEdad_pas());
		System.out.println("Lugar de Procedencia: "+ b.getLugar_procedencia());
		System.out.println("Celular Pasajero: "+ b.getCel_pas());
        
		Boleto b1 = new Boleto();
		b1.setNroboleto(2);
		b1.setEdad_pas(20);
		b1.setLugar_procedencia("Turquia");
		b1.setCel_pas(99754253);
		System.out.println("Numero Boleto: "+ b1.getNroboleto());
		System.out.println("Edad Pasajero: "+ b1.getEdad_pas());
		System.out.println("Lugar de Procedencia: "+ b1.getLugar_procedencia());
		System.out.println("Celular Pasajero: "+ b1.getCel_pas());
	}

}

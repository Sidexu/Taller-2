package Grafica;
import java.util.LinkedList;
//import java.util.Iterator;

import Logica.Boleto;
import Logica.Boletos;

public class mainBoletos {

	public static void main(String[] args) {
		Boleto b1 = new Boleto(1,12,"Montevideo",99950265);
		Boleto b2 = new Boleto(2,15,"Artigas",54321);
		Boleto b3 = new Boleto(3,7,"Canelones",112233);
		Boleto b4 = new Boleto(4,2,"Montevideo",123456);
			
		Boleto lx[];
		Boletos bol = new Boletos();
		
		bol.insert(b1);
		bol.insert(b2);
		bol.insert(b3);
		bol.insert(b4);
		lx = bol.listadoDeBoletos();
		
		for(int i=0; i<lx.length;i++ ){
			System.out.println("Boleto: "+ lx[i].getNroboleto());
			System.out.println(" Edad="+lx[i].getEdad_pas());
			System.out.println(" Cel="+ lx[i].getCel_pas());
			System.out.println(" L proc="+ lx[i].getLugar_procedencia() + " fin bol");
			System.out.println(" ");
		}
		
		System.out.println("paso el primer lx");
		
		
	}

}

package Grafica;

import java.util.ArrayList;
import java.util.Iterator;

import Logica.Boleto;
import Logica.Boletos;
import Logica.Especial;

public class mainBoletos {

	public static void main(String[] args) {
		Boleto b1 = new Boleto(1,12,"Montevideo",99950265);
		Boleto b2 = new Boleto(2,15,"Artigas",54321);
		Boleto b3 = new Boleto(3,7,"Canelones",112233);
		Boleto b4 = new Boleto(4,2,"Montevideo",123456);
		Boleto e1 = new Especial(5,2,"San Jose",252525,10);
		Boleto e2 = new Especial(6,2,"Durazno",33333,3);
		Boleto e3 = new Especial(7,2,"Rocha",5454254,25);
		Boleto e4 = new Especial(8,2,"San Jose",66666,66);
		
		// Defino arreglos del tipo boleto
		ArrayList<Boleto> lx,lx_tipo, lx_tipo2;
		
		
		// Creo secuencia de boletos
		Boletos bol = new Boletos();

		// Inserto los elementos
		bol.insert(b1); bol.insert(b2); 
		bol.insert(b3); bol.insert(b4);
		bol.insert(e1); bol.insert(e2);
		bol.insert(e3); bol.insert(e4);
		
		// Seteo 3 arreglos para mostrar los boletos
		lx = bol.listadoDeBoletos();
		lx_tipo = bol.listadoBoletoXTipo("comun");
		lx_tipo2 = bol.listadoBoletoXTipo("especial");
		
		System.out.println(" ");
		System.out.println("Muestro todos los boletos:");
		System.out.println(" ");
		
		for(int i=0;i<lx.size();i++){
			System.out.print("Boleto: "+ lx.get(i).getNroboleto());
			System.out.print(" Edad="+lx.get(i).getEdad_pas());
			System.out.print(" Cel="+ lx.get(i).getCel_pas());
			System.out.print(" L proc="+ lx.get(i).getLugar_procedencia());
			if(lx.get(i) instanceof Especial){
				System.out.print(" Descuento="+ ((Especial) lx.get(i)).getDescuento());
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("Muestro los boletos Comunes:");
		System.out.println(" ");
		
		for(int i=0; i<lx_tipo.size();i++ ){
			System.out.print("Boleto: "+ lx_tipo.get(i).getNroboleto());
			System.out.print(" Edad="+lx_tipo.get(i).getEdad_pas());
			System.out.print(" Cel="+ lx_tipo.get(i).getCel_pas());
			System.out.print(" L proc="+ lx_tipo.get(i).getLugar_procedencia());
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("Muestro los boletos Especiales:");
		System.out.println(" ");
		
		for(int i=0; i<lx_tipo2.size();i++ ){
				System.out.print("Boleto: "+ lx_tipo2.get(i).getNroboleto());
				System.out.print(" Edad="+lx_tipo2.get(i).getEdad_pas());
				System.out.print(" Cel="+ lx_tipo2.get(i).getCel_pas());
				System.out.print(" L proc="+ lx_tipo2.get(i).getLugar_procedencia());
				if(lx_tipo2.get(i) instanceof Especial){
					System.out.print(" Descuento="+ ((Especial) lx_tipo2.get(i)).getDescuento());
				}
				System.out.println(" ");			
		}
		
		
	}

}

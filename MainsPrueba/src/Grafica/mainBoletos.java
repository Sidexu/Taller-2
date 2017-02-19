package Grafica;

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
		Boleto [] lx, lx_tipo, lx_tipo2;
		
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
		
		for(int i=0; i<lx.length;i++ ){
			System.out.print("Boleto: "+ lx[i].getNroboleto());
			System.out.print(" Edad="+lx[i].getEdad_pas());
			System.out.print(" Cel="+ lx[i].getCel_pas());
			System.out.print(" L proc="+ lx[i].getLugar_procedencia());
			if(lx[i].tipoBoleto() == "especial"){
				System.out.print(" Descuento="+ ((Especial) lx[i]).getDescuento());
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("Muestro los boletos Comunes:");
		System.out.println(" ");
		
		for(int i=0; i<lx_tipo.length;i++ ){
			System.out.print("Boleto: "+ lx_tipo[i].getNroboleto());
			System.out.print(" Edad="+lx_tipo[i].getEdad_pas());
			System.out.print(" Cel="+ lx_tipo[i].getCel_pas());
			System.out.print(" L proc="+ lx_tipo[i].getLugar_procedencia());
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("Muestro los boletos Especiales:");
		System.out.println(" ");
		
		for(int i=0; i<lx_tipo2.length;i++ ){
			System.out.print("Boleto: "+ lx_tipo2[i].getNroboleto());
			System.out.print(" Edad="+lx_tipo2[i].getEdad_pas());
			System.out.print(" Cel="+ lx_tipo2[i].getCel_pas());
			System.out.print(" L proc="+ lx_tipo2[i].getLugar_procedencia());
			System.out.print(" Descuento="+ ((Especial) lx_tipo2[i]).getDescuento());
			System.out.println(" ");
		}
		
		
	}

}

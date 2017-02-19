package Grafica;
import Logica.Boleto;
import Logica.Boletos;
import Logica.Bus;
import Logica.Especial;
import Logica.Excursion;

public class mainExcursion {

	public static void main(String[] args) {
		// CARGA DE BOLETOS
		Boleto b1 = new Boleto(1,12,"Montevideo",99950265);Boleto b2 = new Boleto(2,15,"Artigas",54321);
		Boleto b3 = new Boleto(3,7,"Canelones",112233);Boleto b4 = new Boleto(4,2,"Montevideo",123456);
		Boleto e1 = new Especial(5,2,"San Jose",252525,10);Boleto e2 = new Especial(6,2,"Durazno",33333,3);
		Boleto e3 = new Especial(7,2,"Rocha",5454254,25);Boleto e4 = new Especial(8,2,"San Jose",66666,66);

		// Creo secuencia de boletos
		Boletos BOLETOS1 = new Boletos(); Boletos BOLETOS2 = new Boletos();
		
		// Inserto los elementos
		BOLETOS2.insert(b1); BOLETOS1.insert(e1);
		BOLETOS1.insert(b2); BOLETOS1.insert(e2);
		BOLETOS1.insert(b3); BOLETOS2.insert(e3);
		BOLETOS2.insert(b4); BOLETOS1.insert(e4);
		
		// Defino arreglos del tipo boleto
		Boleto [] lx, lx2;	

		//PARTE NUEVA
		Bus BUS1 = new Bus("CEH 125", "Torino", 30); Bus BUS2 = new Bus();
		BUS2.setCapacidad(33);BUS2.setMarca("MARCOPOLO");BUS2.setMatricula("CEH 223");
	
		Excursion ex1 = new Excursion("EX1","MVD", 125, BUS1, BOLETOS1); 
		Excursion ex2 = new Excursion(); ex2.setBoletos(BOLETOS2);ex2.setBus(BUS2);ex2.setCodigo("EX2");
		ex2.setDestino("CAN");ex2.setPrecio_base(150);

		
		// Seteo 2 arreglos para mostrar los boletos
		lx = ex1.getBoletos().listadoDeBoletos(); lx2 = ex2.getBoletos().listadoDeBoletos();
		
		System.out.println("MODULO EXCURSION");
		
		System.out.println(" ");
		System.out.println("Muestro datos EX1:");
		System.out.println(" ");
		
		System.out.print(" Codigo="+ex1.getCodigo());
		System.out.print(" Destino="+ex1.getDestino());
		System.out.println(" Precio base="+ex1.getPrecio_base());
		System.out.print(" Bus matricula="+ex1.getBus().getMatricula());
		System.out.print(" Bus capacidad="+ex1.getBus().getCapacidad());
		System.out.print(" Bus Marca="+ex1.getBus().getMarca());

		System.out.println(" ");
		System.out.println("Muestro todos los boletos del bus "+ex1.getBus().getMatricula());
		System.out.println(" ");
		
		for(int i=0; i<lx.length;i++ ){
			System.out.print(" Boleto: "+ lx[i].getNroboleto());
			System.out.print(" Edad="+lx[i].getEdad_pas());
			System.out.print(" Cel="+ lx[i].getCel_pas());
			System.out.print(" L proc="+ lx[i].getLugar_procedencia());
			if(lx[i].tipoBoleto() == "especial"){
				System.out.print(" Descuento="+ ((Especial) lx[i]).getDescuento());
			}
			System.out.println(" ");
		}
		
		///////////////////////////////
		
		
		System.out.println(" ");
		System.out.println("Muestro datos EX2:");
		System.out.println(" ");
		
		System.out.print(" Codigo="+ex2.getCodigo());
		System.out.print(" Destino="+ex2.getDestino());
		System.out.println(" Precio base="+ex2.getPrecio_base());
		System.out.print(" Bus matricula="+ex2.getBus().getMatricula());
		System.out.print(" Bus capacidad="+ex2.getBus().getCapacidad());
		System.out.print(" Bus Marca="+ex2.getBus().getMarca());

		System.out.println(" ");
		System.out.println("Muestro todos los boletos del bus "+ex2.getBus().getMatricula());
		System.out.println(" ");
		
		for(int i=0; i<lx2.length;i++ ){
			System.out.print("Boleto: "+ lx2[i].getNroboleto());
			System.out.print(" Edad="+lx2[i].getEdad_pas());
			System.out.print(" Cel="+ lx2[i].getCel_pas());
			System.out.print(" L proc="+ lx2[i].getLugar_procedencia());
			if(lx2[i].tipoBoleto() == "especial"){
				System.out.print(" Descuento="+ ((Especial) lx2[i]).getDescuento());
			}
			System.out.println(" ");
		}
		
		
	}

}
package Grafica;

import java.util.ArrayList;
import java.util.Iterator;

import Logica.Boleto;
import Logica.Boletos;
import Logica.Bus;
import Logica.Especial;
import Logica.Excursion;
import Logica.Excursiones;
import Logica.Hora;

public class mainExcursiones {

	public static void main(String[] args) {
		Hora h_partida1= new Hora(10,00);
		Hora h_partida= new Hora();
		Hora h_regreso1= new Hora(12,00);
		Hora h_regreso= new Hora();
		// CARGA DE BOLETOS
		Boleto b1 = new Boleto(1,12,"Montevideo",99950265);Boleto b2 = new Boleto(2,15,"Artigas",54321);
		Boleto b3 = new Boleto(3,7,"Canelones",112233);Boleto b4 = new Boleto(4,2,"Montevideo",123456);
		Boleto e1 = new Especial(5,2,"San Jose",252525,10);Boleto e2 = new Especial(6,2,"Durazno",33333,3);
		Boleto e3 = new Especial(7,2,"Rocha",5454254,25);Boleto e4 = new Especial(8,2,"San Jose",66666,66);

		// Creo secuencia de boletos
		Boletos BOLETOS1 = new Boletos(); Boletos BOLETOS2 = new Boletos();
		
		//creo un diccionario de excursiones
		Excursiones dicExc= new Excursiones();
		
		// Inserto los elementos
		BOLETOS2.insert(b1); BOLETOS1.insert(e1);
		BOLETOS1.insert(b2); BOLETOS1.insert(e2);
		BOLETOS1.insert(b3); BOLETOS2.insert(e3);
		BOLETOS2.insert(b4); BOLETOS1.insert(e4);
		
		// Defino arreglos del tipo boleto
		ArrayList<Boleto> lx, lx2;	

		//PARTE NUEVA
		Bus BUS1 = new Bus("CEH 125", "Torino", 30); Bus BUS2 = new Bus();
		BUS2.setCapacidad(33);BUS2.setMarca("MARCOPOLO");BUS2.setMatricula("CEH 223");
	
	
		
		Excursion ex1 = new Excursion("EX1","MVD",h_partida1,h_regreso1,125, BUS1, BOLETOS1); 
		h_partida.setHora(13);
		h_partida.setMin(0);
		h_regreso.setHora(17);
		h_regreso.setMin(0);
		
		Excursion ex2 = new Excursion(); ex2.setBoletos(BOLETOS2);ex2.setBus(BUS2);ex2.setCodigo("EX2");
		ex2.setDestino("CAN");ex2.setPrecio_base(150);ex2.setHr_partida(h_partida);ex2.setHr_regreso(h_regreso);

		//inserto las dos excursiones en el diccionario de excursiones
		dicExc.insertExcursion(ex1);dicExc.insertExcursion(ex2);
		ArrayList<Excursion> arr;
		arr=dicExc.listarExcursiones();
		
		// Seteo 2 arreglos para mostrar los boletos
		
		
		for(int i=0;i<arr.size();i++){
			Excursion e=arr.get(i);
			System.out.print(" Codigo="+e.getCodigo());
			System.out.print(" Destino="+e.getDestino());
			System.out.print(" Hora partida="+e.getHr_partida().getHora()+":"+e.getHr_partida().getMin());
			System.out.print(" Hora regreso="+e.getHr_regreso().getHora()+":"+e.getHr_regreso().getMin());
			System.out.println(" Precio base="+e.getPrecio_base());
			System.out.print(" Bus matricula="+e.getBus().getMatricula());
			System.out.print(" Bus capacidad="+e.getBus().getCapacidad());
			System.out.print(" Bus Marca="+e.getBus().getMarca());

			System.out.println(" ");
			System.out.println("Muestro todos los boletos del bus "+e.getBus().getMatricula());
			System.out.println(" ");
			lx = e.getBoletos().listadoDeBoletos();
			for(int j=0;j<lx.size();j++){
				System.out.print("Boleto: "+ lx.get(j).getNroboleto());
				System.out.print(" Edad="+lx.get(j).getEdad_pas());
				System.out.print(" Cel="+ lx.get(j).getCel_pas());
				System.out.print(" L proc="+ lx.get(j).getLugar_procedencia());
				if(lx.get(j) instanceof Especial){
					System.out.print(" Descuento="+ ((Especial) lx.get(j)).getDescuento());
				}
				System.out.println(" ");
			}
			System.out.println("Termine excursion "+i);
		}
			
		
	}

}

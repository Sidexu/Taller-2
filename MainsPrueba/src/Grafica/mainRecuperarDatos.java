package Grafica;
import java.util.ArrayList;

import Logica.*;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOBusCant;
import Logica.valueObjects.VOExcursionDisp;
import Logica.valueObjects.VOPersistencia;
import Persistencia.Respaldo;
public class mainRecuperarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buses buses=new Buses();
		Excursiones excursiones=new Excursiones();
		Respaldo r = new Respaldo();
		VOPersistencia voPers = new VOPersistencia(buses,excursiones);
		try {
			voPers=r.recuperar("respaldo.dat");
			buses=voPers.getBuses();
			excursiones=voPers.getExcursiones();
			
		} catch (ExcepcionPersistencia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.darMensaje());
		}
		Fachada fach = new Fachada(buses,excursiones);
		
		System.out.println("\nREQUERIMIENTO 2: listado general de buses");
		VOBusCant arrVOBusCant[] ;
		arrVOBusCant=fach.listadoGralBuses();
		for(int i=0;i<arrVOBusCant.length;i++){
			VOBusCant voBusCant=arrVOBusCant[i];
			System.out.println("\tMatricula: "+voBusCant.getMatricula()+" Marca: "+voBusCant.getMarca()+" Cap: "+voBusCant.getCapacidad()+" Cant excursiones: "+voBusCant.getCat_ex());
		}
		
		
System.out.println("\nREQUERIMIENTO 3: listado de excursiones por bus");
		
		System.out.println("\tListado BUS1 MAT: AAA 123");
		try{
			VOExcursionDisp arrVOExDis[];
			arrVOExDis=fach.listadoExcursionesXBus("AAA 123");
			for(int i=0;i<arrVOExDis.length;i++){
				VOExcursionDisp vo=arrVOExDis[i];
				System.out.println("\tExcursion COD: "+vo.getCodigo()+", Destino: "+vo.getDestino()+", Hora Partida: "+vo.getHr_partida().getHora()+":"+vo.getHr_partida().getMin()+", Hora regreso: "+vo.getHr_regreso().getHora()+":"+vo.getHr_regreso().getMin()+", Precio base: "+vo.getPrecioBase()+", Cant asientos disp: "+vo.getCant_disponibles());
			}
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje()+"\n");
		}
		
		System.out.println("\tListado BUS3 MAT: CCC 345");
		try{
			VOExcursionDisp arrVOExDis[];
			arrVOExDis=fach.listadoExcursionesXBus("CCC 345");
			for(int i=0;i<arrVOExDis.length;i++){
				VOExcursionDisp vo=arrVOExDis[i];
				System.out.println("\tExcursion COD: "+vo.getCodigo()+", Destino: "+vo.getDestino()+", Hora Partida: "+vo.getHr_partida().getHora()+":"+vo.getHr_partida().getMin()+", Hora regreso: "+vo.getHr_regreso().getHora()+":"+vo.getHr_regreso().getMin()+", Precio base: "+vo.getPrecioBase()+", Cant asientos disp: "+vo.getCant_disponibles());
			}
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje()+"\n");
		}
		
		
		

		
	}

}

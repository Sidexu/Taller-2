package Logica;
import java.util.ArrayList;

import Logica.valueObjects.*;

public class Fachada {
	private Buses buses;
	private Excursiones excursiones;
	
	public void registroNuevoBus(VOBus vo){
		if(buses.memberBus(vo.getMatricula())){
			//error: bus ya existe
		}else{
			if(vo.getCapacidad()<0){
				//error: la capacidad no puede ser menor o igual a cero
			}else{
				Excursiones ex=new Excursiones();
				Bus v = new Bus(vo.getMatricula(),vo.getMarca(),vo.getCapacidad(),ex);
				buses.insertBus(v);
			}
		}
	}
	public VOBusCant [] listadoGralBuses(){
		ArrayList<Bus> arr= new ArrayList<Bus>();
		arr= buses.listadoBuses();
		VOBusCant arrVO[]= new VOBusCant[arr.size()];
		
		for(int i=0;i<arr.size();i++){
			Bus b=arr.get(i);
			VOBusCant vobuscant= new VOBusCant(b.getMatricula(),b.getMarca(),b.getCapacidad(),b.getExc().tamExcursiones());
			arrVO[i]= vobuscant;
		}
		return arrVO;
	}
	/*public VOExcursionDisp [] listadoExcursionesXBus(String mat){
		
		//HAY Q HACER EL MANEJO DE EXCEPCIONES
		if(!buses.memberBus(mat)){
			//error: la matricula no existe
		}else{
			Bus b=buses.findBus(mat);
			ArrayList<Excursion> arr= new ArrayList<Excursion>();
			arr= b.getExc().listarExcursiones();
			VOExcursionDisp arrVO []= new VOExcursionDisp[arr.size()];
			
			for(int i=0;i<arr.size();i++){
				Excursion ex=arr.get(i);
				int cant_disponibles=b.getCapacidad()-ex.getBoletos().tamBoletos();
				VOExcursionDisp vodisp= new VOExcursionDisp(ex.getCodigo(),ex.getDestino(),ex.getHr_partida(),ex.getHr_regreso(),ex.getPrecio_base(),cant_disponibles);
				arrVO[i]= vodisp;
			}
			return arrVO;
		}
	}*/
	
}

package Logica;
import Logica.Bus;
import Logica.Excepciones.ExcepcionBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Buses implements Serializable {
	private TreeMap<String,Bus> TM;
	
	public Buses(){
		TM = new TreeMap<String,Bus>();
	}
	public Bus findBus (String clave){
		return TM.get(clave);
	}
	public boolean memberBus (String clave){
		return TM.containsKey(clave);
	}
	public void insertBus(Bus b){
		TM.put(b.getMatricula(), b);
	}
	public void deleteBus(Bus b){
		TM.remove(b);
	}
	public ArrayList<Bus> listadoBuses(){
		ArrayList<Bus> arr= new ArrayList<Bus>();
		Iterator<Bus> iter= TM.values().iterator();
		while(iter.hasNext()){
			Bus b=iter.next();
			arr.add(new Bus(b.getMatricula(),b.getMarca(),b.getCapacidad(),b.getExc()));
		}
		return arr;
	}
	public Bus obtenerBusDisp(Hora partida, Hora regreso, int venta_boleto, String mat) throws ExcepcionBus{
		Iterator<Bus> iterBus= TM.values().iterator();
		
		Bus bFin=null;
		boolean encontre=false;
		boolean capacidad=false;
		while(iterBus.hasNext() && !encontre){
			Bus b=iterBus.next();
			if((b.getCapacidad()-venta_boleto)>=0 && !(b.getMatricula().contentEquals(mat))){
				capacidad=true;
				Excursiones exc=b.getExc();
				ArrayList<Excursion> arr= new ArrayList<Excursion>();
				arr=exc.listarExcursiones();
				int i=0;
				int cont=0;
				while(i<arr.size()){
					//se tiene que cumplir que (hp<partida && hr<partida) || (hp>regreso && hr>regreso)
					if( (arr.get(i).getHr_partida().esMenorIgual(partida) && arr.get(i).getHr_regreso().esMenorIgual(partida)) 
							|| (regreso.esMenorIgual(arr.get(i).getHr_partida()) && regreso.esMenorIgual(arr.get(i).getHr_regreso()))){
						cont++; 
					}else{
						i=arr.size(); //si encontre una excursion que esta en el rango horario de la que quiero agregar, termino el recorrido
					}
					i++;
				}
				//si i=0, entonces el bus no tiene ninguna excursion y se la puedo asignar
				// si cont == arr.size, entonces todas las excursiones estan fuera del rango horario de la excursion que quiero agregar
				if(i==0 || cont==arr.size()){ 
					encontre=true;
					bFin=b;
				}
			}
		}
		if(!encontre ){
			String msg="";
			if(mat == "" || capacidad){ //obtener bus disponible entre dos horas
				msg="Atención! No hay bus disponible en ese rango horario.";
			}else{ //obtener bus para reasignar
				msg="Atención! No hay bus disponible en ese rango horario ni con la capacidad necesaria.";
			}
			throw new ExcepcionBus(msg);
		}else{
			return bFin;
		}
	}
}

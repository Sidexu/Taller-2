package Logica;
import Logica.Bus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Buses {
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
	public Bus obtenerBusDisp(Hora partida, Hora regreso, int cap, String mat){
		Iterator<Bus> iterBus= TM.values().iterator();
		int i;
		Bus bFin=null;//VER EXEPTION
		boolean encontre=false;
		while(iterBus.hasNext() && !encontre){
			Bus b=iterBus.next();
			if(b.getCapacidad()>cap && !(b.getMatricula().contentEquals(mat))){
				Excursiones exc=b.getExc();
				ArrayList<Excursion> arr= new ArrayList<Excursion>();
				arr=exc.listarExcursiones();
				i=0;
				while(i<arr.size() && !encontre){
					if(partida.esMenorIgual(arr.get(i).getHr_partida()) && arr.get(i).getHr_regreso().esMenorIgual(regreso)){
						encontre=true;
						bFin=b;
					}
				}
			}
		}
		
		//hacer exception si !encontre
		
		return bFin;
	}
}

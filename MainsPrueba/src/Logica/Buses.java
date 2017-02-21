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
			arr.add(new Bus(b.getMatricula(),b.getMarca(),b.getCapacidad()));
		}
		return arr;
	}

}

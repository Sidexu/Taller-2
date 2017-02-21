package Logica;
import Logica.Excursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Excursiones{
	private  TreeMap<String,Excursion> arbol;
	
	public Excursiones(){
		arbol = new TreeMap<String,Excursion>();
	}
	public Excursion findExcursion(String clave){
		return arbol.get(clave);
	}
	public boolean memberExcursion(String clave){
		return arbol.containsKey(clave);
	}
	public void insertExcursion(Excursion e){
		arbol.put(e.getCodigo(), e);
	}
	public void deleteExcursion(Excursion e){
		arbol.remove(e);
	}
	public ArrayList<Excursion> listarExcursiones(){
		ArrayList<Excursion> arr= new ArrayList<Excursion>();
		Iterator<Excursion> iter= arbol.values().iterator();
		while(iter.hasNext()){
			Excursion e=iter.next();
			arr.add(new Excursion(e.getCodigo(),e.getDestino(),e.getHr_partida(),e.getHr_regreso(),e.getPrecio_base(),e.getBus(),e.getBoletos()));
		}
		return arr;
	}
	public ArrayList<Excursion> listarExcursionesPorDestino(String destino){
		ArrayList<Excursion> arr= new ArrayList<Excursion>();
		Iterator<Excursion> iter= arbol.values().iterator();
		while(iter.hasNext()){
			Excursion e=iter.next();
			if(e.getDestino() == destino){
				arr.add(new Excursion(e.getCodigo(),e.getDestino(),e.getHr_partida(),e.getHr_regreso(),e.getPrecio_base(),e.getBus(),e.getBoletos()));
			}
		}
		return arr;
	}
	public ArrayList<Excursion> listarExcursionesPorPrecio(float precioMenor, float precioMayor){
		ArrayList<Excursion> arr= new ArrayList<Excursion>();
		Iterator<Excursion> iter= arbol.values().iterator();
		while(iter.hasNext()){
			Excursion e=iter.next();
			if(e.getPrecio_base() >= precioMenor && e.getPrecio_base() <= precioMayor){
				arr.add(new Excursion(e.getCodigo(),e.getDestino(),e.getHr_partida(),e.getHr_regreso(),e.getPrecio_base(),e.getBus(),e.getBoletos()));
			}
		}
		return arr;
	}
	public void respaldoExcursion(){
		
	}
	public int tamExcursiones(){
		return arbol.size();
	}
}

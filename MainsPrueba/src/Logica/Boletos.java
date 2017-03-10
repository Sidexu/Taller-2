package Logica;
import Logica.Boleto;
import Logica.Especial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;


public class Boletos implements Serializable{
	private LinkedList<Boleto> LL;
	
	public Boletos(){
		LL = new LinkedList<Boleto>();
	}
	
	public void Delete (Boleto b){
		LL.remove(b);
	}
	
	public void insert (Boleto b){
		LL.addLast(b);
	}
	
	public ArrayList<Boleto>  listadoDeBoletos (){
		ArrayList<Boleto> arr= new ArrayList<Boleto>();
		Iterator<Boleto> iter= LL.iterator();
		while(iter.hasNext()){
			Boleto b=iter.next();
			if(b instanceof Especial){
				arr.add(new Especial(b.getNroboleto(),b.getEdad_pas(),b.getLugar_procedencia(),b.getCel_pas(),((Especial) b).getDescuento()));
			}else{
				arr.add(new Boleto(b.getNroboleto(),b.getEdad_pas(),b.getLugar_procedencia(),b.getCel_pas()));
			}
		}
		return arr;
	}
	
	
	public ArrayList<Boleto> listadoBoletoXTipo (String tipo){
		ArrayList<Boleto> arr= new ArrayList<Boleto>();
		Iterator<Boleto> iter= LL.iterator();
		while(iter.hasNext()){
			Boleto b=iter.next();
			if (tipo.equals("especial")){
				if(b instanceof Especial){
					arr.add(new Especial(b.getNroboleto(),b.getEdad_pas(),b.getLugar_procedencia(),b.getCel_pas(),((Especial) b).getDescuento()));
				}
			}else if(b.tipoBoleto().equals("comun")){ 

				arr.add(new Boleto(b.getNroboleto(),b.getEdad_pas(),b.getLugar_procedencia(),b.getCel_pas()));
			}	
		}
		return arr;
	}
	public int tamBoletos(){
		return LL.size();
	}


}

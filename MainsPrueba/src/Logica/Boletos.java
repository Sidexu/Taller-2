package Logica;
import Logica.Boleto;

import java.util.LinkedList;
//import java.util.Iterator;

public class Boletos extends LinkedList<Boleto> {
	
	public Boletos(){

	}
	
	public void Delete (Boleto b){
		this.remove(b);
	}
	
	public void insert (Boleto b){
		this.addLast(b);
	}
	
	public Boleto[]  listadoDeBoletos (){
		return this.toArray(new Boleto[]{});
	}
	
	public void respaldoBoletos(){
		
	}
	
	public Boleto [] listadoBoletoXTipo (String tipo){
		//Copio el listado en uno auxiliar
		LinkedList listado_copia = (LinkedList<Boleto>) this.clone();
		// Declaro un array de boleto
		Boleto[] arregloBoletos;
		// Reservo memoria para todo el listado
		arregloBoletos = new Boleto[this.size()];

		int contador=0;
		//Recorro cada elemento y consulto si es un boleto de tipo "tipo"
		
		// Recorro con for común
		Boleto b;
		for ( int i=0; i< this.size(); i++){
			b = (Boleto) listado_copia.poll();
			if(b.tipoBoleto() == tipo){
				// Guardo el boleto en el nuevo arreglo que voy a devolver
				arregloBoletos[contador] = b;
				contador ++;
			}
			//Apunto a null para que garbagecollector se lo lleve (?
			b = null;
		}
		
		// Recorro con foreach !!!!!NO ANDA!!!!!
		/*for (Boleto elem: arregloBoletos){
			System.out.println("Boleto ini	: "+ elem.getNroboleto());
			if(elem.tipoBoleto() == tipo){
				// Guardo el boleto en el nuevo arreglo que voy a devolver
				System.out.println("Boleto Entre: "+ elem.getNroboleto());
				arregloBoletos[contador] = (Boleto) listado_copia.poll();
				contador ++;
			}
		}*/
		return arregloBoletos;
	}


}

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
	
	public void listadoBoletoXTipo (String tipo){
		
	}


}

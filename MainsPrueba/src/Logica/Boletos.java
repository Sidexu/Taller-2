package Logica;
import Logica.Boleto;

import java.util.LinkedList;
import java.util.ListIterator;

public class Boletos extends LinkedList<Boleto> {
	
	public Boletos(){
		
	}
	
	public void Delete (Boleto b){
		this.remove(b);
	}
	
	public void insert (Boleto b){
		this.addLast(b);
	}
	
	public ListIterator<Boleto> listadoDeBoletos (){
		return this.listIterator();
		
	}
	
	public void respaldoBoletos(){
		
	}
	
	public ListIterator<Boleto> listadoBoletoXTipo (String tipo){
		ListIterator<Boleto> l = this.listIterator();		
		LinkedList<Boleto> lst2 = new LinkedList<Boleto>(); // CREAMOS UNA LISTA VACIA PARA ASOCIARLA A UN LIST ITERATOR
		ListIterator<Boleto> lxtipo = lst2.listIterator(); // PARA CREAR UN LIST ITERATOR, DEBEMOS HACERLO SOBRE UNA LINKED LIST
		
		while(l.hasNext()){
			if(l.next().tipoBoleto() == tipo){
				lxtipo.add(l.next());
			}
			l.remove();
		}
		return lxtipo;
	}
	

}

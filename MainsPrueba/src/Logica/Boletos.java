package Logica;
import Logica.Boleto;
import Logica.Especial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Boletos extends LinkedList<Boleto> {
	protected LinkedList<Boleto> LL;
	
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
	
	public void respaldoBoletos(){
		
	}
	
	public ArrayList<Boleto> listadoBoletoXTipo (String tipo){
		ArrayList<Boleto> arr= new ArrayList<Boleto>();
		Iterator<Boleto> iter= LL.iterator();
		while(iter.hasNext()){
			Boleto b=iter.next();
			if (tipo == "especial"){
				if(b instanceof Especial){
					arr.add(new Especial(b.getNroboleto(),b.getEdad_pas(),b.getLugar_procedencia(),b.getCel_pas(),((Especial) b).getDescuento()));
				}
			}else if(b.tipoBoleto() == "comun"){

				arr.add(new Boleto(b.getNroboleto(),b.getEdad_pas(),b.getLugar_procedencia(),b.getCel_pas()));
			}	
		}
		return arr;
		
		/*
		//Copio el listado en uno auxiliar
		LinkedList<Boleto> listado_copia = (LinkedList<Boleto>) this.clone();
		// Declaro un array de boletos para almacenar los boletos temporalmente
		Boleto[] arregloBoletos;
		// Declaro un array de boletos, para copiar los boletos almacenados temporalmente en uno con tamaño justo
		Boleto[] arregloBoletosDevuelve;
		// Reservo memoria para todo el listado contemplando como maximo el tamaño de la lista
		arregloBoletos = new Boleto[this.size()];
		Boleto b;
		int contador=0;
		//Recorro cada elemento y consulto si es un boleto de tipo "tipo"
		
		// Recorro con for común para saber cuanta cantidad del tipo deseado
		for ( int i=0; i< this.size(); i++){
			b = (Boleto) listado_copia.poll();
			if(b.tipoBoleto() == tipo){
				// Guardo el boleto en el nuevo arreglo que voy a copiar
				arregloBoletos[contador] = b;
				contador ++;
			}
			//Apunto a null para que garbagecollector se lo lleve (?
			b = null;
		}
		
		// Defino un arreglo con el tamaño justo
		arregloBoletosDevuelve = new Boleto[contador];
		// Recorro el arreglo temporal para guardar esos elementos en el arreglo final
		for ( int i=0; i < contador; i++){
			// Guardo el boleto en el nuevo arreglo que voy a devolver
			arregloBoletosDevuelve[i] = arregloBoletos[i];
		}
		
		return arregloBoletosDevuelve;
		*/
		
		
		
	}


}

package Logica;
import Logica.Boleto;
import java.util.LinkedList;


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
		
		
		// Recorro con foreach !!!!!NO ANDA!!!!! falta cambio tamaño
		/*for (Boleto elem: arregloBoletos){
			System.out.println("Boleto ini	: "+ elem.getNroboleto());
			if(elem.tipoBoleto() == tipo){
				// Guardo el boleto en el nuevo arreglo que voy a devolver
				System.out.println("Boleto Entre: "+ elem.getNroboleto());
				arregloBoletos[contador] = (Boleto) listado_copia.poll();
				contador ++;
			}
		}*/
		
		
	}


}

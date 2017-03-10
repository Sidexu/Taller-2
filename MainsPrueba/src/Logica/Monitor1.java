package Logica;

public class Monitor1 {
	private int lectores;
	private  boolean alguien_escribe;
	
	public void Monitor1(){
		lectores = 0;
		alguien_escribe = false;
	}
	
	public synchronized void comenzarLectura(){
		while(alguien_escribe){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// no hago nada
			}
		}
		lectores++;
	}
	
	public synchronized void lecturaTerminada(){
		lectores--;
		this.notifyAll();	
	}
	
	public synchronized void comenzarEscritura(){
		while(lectores > 0 || alguien_escribe){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// no hago nada
			}
		}
		alguien_escribe=true;
		
	}
	
	public synchronized void escrituraTerminada(){
		alguien_escribe=false;
		this.notifyAll();
	}
}

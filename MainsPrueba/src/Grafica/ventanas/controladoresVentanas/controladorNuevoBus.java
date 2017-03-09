package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBus;

public class controladorNuevoBus {
	private ventanaPrueba ven;

	public controladorNuevoBus(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void nuevoBus(String Matricula,String Marca,String Capacidad) throws RemoteException, ExcepcionBus,ExcepcionPersistencia,ExcepcionRMI, ExcepcionVentana{


		boolean error=false;
		String MSG = "";
		String MAT = Matricula.trim();
		if(MAT.equals(new String(""))){
			error=true;
			MSG = "Error la matricula no puede ser vacía";
		}else{
			String MARCA = Marca.trim();
			if(MARCA.equals(new String(""))){
				error=true;
				MSG = "Error la marca no puede ser vacía";
			}
		}	
		if(error == false){
			try{
				int cap = Integer.parseInt(Capacidad);
				if(cap >100 || cap < 0){
					throw new ExcepcionVentana("Error, la capacidad no puede superar los 100 asientos ni ser negativa");
				} 
				VOBus voB = new VOBus(Matricula,Marca,Integer.parseInt(Capacidad));
				try {
					managerIFachada.getInstancia().getIFachada().registroNuevoBus(voB);
					} catch (ExcepcionPersistencia e) {
						throw new ExcepcionPersistencia(e.darMensaje());
					} catch (ExcepcionRMI e) {
						throw new ExcepcionRMI(e.darMensaje());
					}catch (ExcepcionBus e){
						throw new ExcepcionBus(e.darMensaje());
					}
				
			}catch(NumberFormatException e){
					throw new ExcepcionVentana("Error, la capacidad debe de ser numerica");
			}
		}else{
			throw new ExcepcionVentana(MSG);
		}
		
	}
}

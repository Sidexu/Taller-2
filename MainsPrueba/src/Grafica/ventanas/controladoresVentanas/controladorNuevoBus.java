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
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBus;

public class controladorNuevoBus {
	private ventanaPrueba ven;

	public controladorNuevoBus(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void nuevoBus(String Matricula,String Marca,String Capacidad) throws RemoteException, ExcepcionBus,ExcepcionPersistencia,ExcepcionRMI{


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
	

	}
}

package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBusCant;



public class controladorListadoGralBuses {
	private ventanaPrueba ven;

	public controladorListadoGralBuses(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOBusCant [] listadoGralBuses() throws RemoteException, ExcepcionRMI,ExcepcionPersistencia
	{
		
			try {
				return managerIFachada.getInstancia().getIFachada().listadoGralBuses();
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}
			
	}
}

package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursionDisp;

public class controladorListadoExcursionDisp {
	private ventanaPrueba ven;

	public controladorListadoExcursionDisp(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp [] listadoExcursionesXBus(String mat) throws RemoteException,  ExcepcionExcursion, ExcepcionPersistencia,ExcepcionRMI{
		
			try {
				return managerIFachada.getInstancia().getIFachada().listadoExcursionesXBus(mat);
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}catch(ExcepcionExcursion e){
				throw new ExcepcionExcursion(e.darMensaje());
			}
		
	}
}

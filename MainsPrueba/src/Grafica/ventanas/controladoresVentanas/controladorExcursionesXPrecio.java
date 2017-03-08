package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXPrecio {
	private ventanaPrueba ven;

	public controladorExcursionesXPrecio(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp[] excursionesXPrecio(String precio1, String precio2) throws RemoteException,NumberFormatException,ExcepcionPersistencia,ExcepcionRMI {
		
			
			try {
				return managerIFachada.getInstancia().getIFachada().excursionesXPrecio(Float.parseFloat(precio1), Float.parseFloat(precio2));
			} catch (NumberFormatException e) {
				throw new NumberFormatException(e.getMessage());
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}
	
	}
}

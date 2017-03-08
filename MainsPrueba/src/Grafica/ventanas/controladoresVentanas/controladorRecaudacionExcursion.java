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

public class controladorRecaudacionExcursion {
	private ventanaPrueba ven;

	public controladorRecaudacionExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static float recaudacionExcursion(String codEx) throws RemoteException,ExcepcionExcursion,ExcepcionPersistencia,ExcepcionRMI{
		
			try {
				return managerIFachada.getInstancia().getIFachada().recaudacionExcursion(codEx);
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}catch(ExcepcionExcursion e){
				throw new ExcepcionExcursion(e.darMensaje());
			}
		
	}
}

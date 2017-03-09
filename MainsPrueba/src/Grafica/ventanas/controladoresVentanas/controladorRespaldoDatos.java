package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;

public class controladorRespaldoDatos {
	private ventanaPrueba ven;

	public controladorRespaldoDatos(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void respaldoDatos() throws ExcepcionPersistencia,ExcepcionRMI {
		try {
			managerIFachada.getInstancia().getIFachada().respaldoDatos();
		} catch (RemoteException e) {
			throw new ExcepcionRMI("Error en la conexión.");
		} catch (ExcepcionPersistencia e) {
			throw new ExcepcionPersistencia(e.darMensaje());
		} catch (ExcepcionRMI e) {
			throw new ExcepcionRMI(e.darMensaje());
		}
	}
}

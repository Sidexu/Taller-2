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


public class controladorReasignarExcursion {

	private ventanaPrueba ven;

	public controladorReasignarExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void reasignarExcursion(String Codigo) throws RemoteException, ExcepcionExcursion, ExcepcionBus,ExcepcionPersistencia,ExcepcionRMI
	{
		
			try {
				managerIFachada.getInstancia().getIFachada().reasignacionExcursion(Codigo);
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}catch(ExcepcionExcursion e){
				throw new ExcepcionExcursion(e.darMensaje());
			}catch(ExcepcionBus e){
				throw new ExcepcionBus(e.darMensaje());
			}
		
	}
}

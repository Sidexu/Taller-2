package Grafica.ventanas.Controladores;

import java.rmi.RemoteException;

import Grafica.ventanas.ManagerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;


public class controladorReasignarExcursion {
	private ventanaPrueba ven;
	 /* tengo como atributo remoto a la fachada y como atributo local a mi ventana */ 
	
	public controladorReasignarExcursion (ventanaPrueba vent)
	 {
	 /* aqu� me guardo la referencia a mi ventana y adem�s hago el lookup
	 para acceder remotamente a la fachada */
		this.ven = vent;
		
	}
	
	public static void reasignarExcursion(String Codigo) throws RemoteException, ExcepcionExcursion, ExcepcionBus
	{
		try {
			ManagerIFachada.getinstancia().getIFachada().reasignacionExcursion(Codigo);
		} catch (ExcepcionExcursion e) {
			throw new ExcepcionExcursion(e.darMensaje());
		} catch (ExcepcionBus e) {
			throw new ExcepcionBus(e.darMensaje());
		}
	}		
}

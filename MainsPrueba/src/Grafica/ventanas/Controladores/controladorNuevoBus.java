package Grafica.ventanas.Controladores;

import java.rmi.RemoteException;

import Grafica.ventanas.ManagerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.valueObjects.VOBus;

public class controladorNuevoBus {
	private ventanaPrueba ven;
	 /* tengo como atributo remoto a la fachada y como atributo local a mi ventana */ 
	
	public controladorNuevoBus (ventanaPrueba vent)
	 {
	 /* aquí me guardo la referencia a mi ventana y además hago el lookup
	 para acceder remotamente a la fachada */
		this.ven = vent;
		
	}
	
	public static void nuevoBus (String matricula, String marca, String capacidad) throws ExcepcionBus
	{
		 int cap = Integer.parseInt(capacidad);
		 VOBus vo = new VOBus(matricula, marca, cap);
		 try {
			ManagerIFachada.getinstancia().getIFachada().registroNuevoBus(vo);
		} catch (RemoteException e) {

		}

	}
}

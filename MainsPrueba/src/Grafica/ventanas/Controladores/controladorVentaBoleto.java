package Grafica.ventanas.Controladores;

import java.rmi.RemoteException;

import Grafica.ventanas.ManagerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.valueObjects.VOBoletoTipo;


public class controladorVentaBoleto {
	private ventanaPrueba ven;
	 /* tengo como atributo remoto a la fachada y como atributo local a mi ventana */ 
	
	public controladorVentaBoleto (ventanaPrueba vent)
	 {
	 /* aquí me guardo la referencia a mi ventana y además hago el lookup
	 para acceder remotamente a la fachada */
		this.ven = vent;
		
	}
	
	public static void ventaBoleto(String codigo, String edad, String procedencia, String cel, String descuento) throws RemoteException, ExcepcionExcursion, ExcepcionBus
	{
		
		int ed = Integer.parseInt(edad);
		long cl = Long.parseLong(cel);
		float desc = Float.parseFloat(descuento);
		VOBoletoTipo vo = new VOBoletoTipo(0, ed, procedencia, cl, desc);	
		try {
			ManagerIFachada.getinstancia().getIFachada().ventaBoleto(codigo, vo);
		} catch (RemoteException e) {
			throw new  RemoteException(e.getMessage());
		} catch (ExcepcionExcursion e) {
			throw new  ExcepcionExcursion(e.darMensaje());
		} catch (ExcepcionBus e) {
			throw new  ExcepcionBus(e.darMensaje());
		}
	}
}

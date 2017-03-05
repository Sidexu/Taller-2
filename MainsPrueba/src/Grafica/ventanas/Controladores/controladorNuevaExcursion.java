package Grafica.ventanas.Controladores;

import java.rmi.RemoteException;

import Grafica.ventanas.ManagerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.valueObjects.VOExcursion;

public class controladorNuevaExcursion {
	private ventanaPrueba ven;
	 /* tengo como atributo remoto a la fachada y como atributo local a mi ventana */ 
	
	public controladorNuevaExcursion (ventanaPrueba vent)
	 {
	 /* aquí me guardo la referencia a mi ventana y además hago el lookup
	 para acceder remotamente a la fachada */
		this.ven = vent;
		
	}
	
	public static void nuevaExcursion (String Codigo, String Destino, String HrPartida, String HrPartidaMin, String HrRegreso, String HrRegresoMin, String Precio) throws ExcepcionExcursion, ExcepcionBus, RemoteException
	{
		 float prec = Float.parseFloat(Precio);
		 Hora HrP= new Hora(Integer.parseInt(HrPartidaMin), Integer.parseInt(HrPartidaMin));
		 Hora HrR= new Hora(Integer.parseInt(HrRegreso), Integer.parseInt(HrRegresoMin));
		 VOExcursion vo = new VOExcursion(Codigo, Destino, HrP, HrR, prec);
			try {
				ManagerIFachada.getinstancia().getIFachada().registroExcursion(vo);
			} catch (RemoteException e) {
				throw new RemoteException(e.getMessage());
			} catch (ExcepcionBus e) {
				throw new ExcepcionBus(e.darMensaje());
			} catch (ExcepcionExcursion e){
				throw new ExcepcionExcursion(e.darMensaje());
			}
	}
}

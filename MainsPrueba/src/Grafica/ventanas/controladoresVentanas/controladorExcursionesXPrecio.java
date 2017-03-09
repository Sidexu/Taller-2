package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXPrecio {
	private ventanaPrueba ven;

	public controladorExcursionesXPrecio(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp[] excursionesXPrecio(String precio1, String precio2) throws RemoteException,ExcepcionPersistencia,ExcepcionRMI, ExcepcionVentana {
		

			try{
				Float.parseFloat(precio1);
				return managerIFachada.getInstancia().getIFachada().excursionesXPrecio(Float.parseFloat(precio1), Float.parseFloat(precio2));
			}catch (NumberFormatException e){
				throw new ExcepcionVentana("Error, precio debe de ser numérico");
			} catch (NullPointerException e){
				throw new ExcepcionVentana("Error, precio no puede estar vacío");
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}
	
	}
}

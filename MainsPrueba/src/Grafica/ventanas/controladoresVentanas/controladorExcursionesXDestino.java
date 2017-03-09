package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXDestino {
	private ventanaPrueba ven;

	public controladorExcursionesXDestino(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp[] excursionesXDestino(String destino) throws RemoteException,ExcepcionPersistencia,ExcepcionRMI, ExcepcionVentana {
		
		boolean error = false;
		String MSG = "";
		String DES = destino.trim();
		if(DES.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}
		if(!error){
			try {
				return managerIFachada.getInstancia().getIFachada().excursionesXDestino(destino);
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}
		}else{
			throw new ExcepcionVentana(MSG);
		}
	}
}

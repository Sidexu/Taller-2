package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOExcursionDisp;

public class controladorListadoExcursionDisp {
	private ventanaPrueba ven;

	public controladorListadoExcursionDisp(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp [] listadoExcursionesXBus(String mat) throws  ExcepcionExcursion, ExcepcionPersistencia,ExcepcionRMI, ExcepcionVentana{
		
		boolean error = false;
		String MSG = "";
		String MAT = mat.trim();
		if(MAT.equals(new String(""))){
			error=true;
			MSG = "Error la matricula no puede ser vacía";
		}
		if(!error){
			try {
				return managerIFachada.getInstancia().getIFachada().listadoExcursionesXBus(mat);
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}catch(ExcepcionExcursion e){
				throw new ExcepcionExcursion(e.darMensaje());
			}catch (RemoteException e){
				throw new ExcepcionRMI("Error en la conexión.");
			}
		}else{
			throw new ExcepcionVentana(MSG);
		}
	}
}

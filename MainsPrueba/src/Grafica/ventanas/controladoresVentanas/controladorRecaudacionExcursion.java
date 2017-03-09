package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;

public class controladorRecaudacionExcursion {
	private ventanaPrueba ven;

	public controladorRecaudacionExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static float recaudacionExcursion(String codEx) throws ExcepcionExcursion,ExcepcionPersistencia,ExcepcionRMI,ExcepcionVentana{
		
		boolean error = false;
		String MSG = "";
		String COD = codEx.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}
		if(!error){
			try {
				return managerIFachada.getInstancia().getIFachada().recaudacionExcursion(codEx);
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

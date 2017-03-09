package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;


public class controladorReasignarExcursion {

	private ventanaPrueba ven;

	public controladorReasignarExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void reasignarExcursion(String Codigo) throws  ExcepcionExcursion, ExcepcionBus,ExcepcionPersistencia,ExcepcionRMI, ExcepcionVentana
	{
		
		boolean error = false;
		String MSG = "";
		String COD = Codigo.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}
		if(!error){
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
			}catch (RemoteException e){
				throw new ExcepcionRMI("Error en la conexión.");
			}
		}else{
			throw new ExcepcionVentana(MSG);
		}

		
	}
}

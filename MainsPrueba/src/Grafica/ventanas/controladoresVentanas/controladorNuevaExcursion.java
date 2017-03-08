package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursion;

public class controladorNuevaExcursion {
	private ventanaPrueba ven;

	public controladorNuevaExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void nuevaExcursion(String Codigo,String Destino,String HrPartida,String HrPartidaMin,String HrRegreso,String HrRegresoMin,String Precio) throws RemoteException, ExcepcionExcursion, ExcepcionBus,ExcepcionRMI,ExcepcionPersistencia 
	{
		
		Hora HrP = new Hora(Integer.parseInt(HrPartida),Integer.parseInt(HrPartidaMin));
		Hora HrR = new Hora(Integer.parseInt(HrRegreso),Integer.parseInt(HrRegresoMin));

		VOExcursion voE = new VOExcursion(Codigo,Destino,HrP,HrR,Float.parseFloat(Precio));
		
			try {
				managerIFachada.getInstancia().getIFachada().registroExcursion(voE);
			} catch (ExcepcionPersistencia e) {
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			}catch(ExcepcionBus e){
				throw new ExcepcionBus(e.darMensaje());
			}catch(ExcepcionExcursion e){
				throw new ExcepcionExcursion(e.darMensaje());
			}
	
	}

}

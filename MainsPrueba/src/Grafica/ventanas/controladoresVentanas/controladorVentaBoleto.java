package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBoletoTipo;

public class controladorVentaBoleto {
	private ventanaPrueba ven;

	public controladorVentaBoleto(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void ventaBoleto(String codigo,String edad,String procedencia,String cel,String descuento) throws RemoteException,ExcepcionPersistencia,ExcepcionRMI,  ExcepcionExcursion, ExcepcionBus 
	{


		VOBoletoTipo voBol= new VOBoletoTipo(0,Integer.parseInt(edad),procedencia,Long.parseLong(cel),Float.parseFloat(descuento));
		
			try {
				managerIFachada.getInstancia().getIFachada().ventaBoleto(codigo, voBol);
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

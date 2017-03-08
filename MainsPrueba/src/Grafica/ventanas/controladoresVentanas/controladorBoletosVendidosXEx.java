package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBoletoTipo;

public class controladorBoletosVendidosXEx {
	private ventanaPrueba ven;

	public controladorBoletosVendidosXEx(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) throws ExcepcionExcursion, ExcepcionPersistencia, ExcepcionRMI, RemoteException{
		
		try {
			return managerIFachada.getInstancia().getIFachada().boletosVendidosXEx(codigo, tipoBoleto);
		} catch (ExcepcionPersistencia e){
			throw new ExcepcionPersistencia(e.darMensaje());
		} catch (ExcepcionRMI e) {
			throw new ExcepcionRMI(e.darMensaje());
		} catch (ExcepcionExcursion e) {
			throw new ExcepcionExcursion(e.darMensaje());
		}
	}
}

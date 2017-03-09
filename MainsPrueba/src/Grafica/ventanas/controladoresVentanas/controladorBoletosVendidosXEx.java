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
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOBoletoTipo;

public class controladorBoletosVendidosXEx {
	private ventanaPrueba ven;

	public controladorBoletosVendidosXEx(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) throws ExcepcionExcursion, ExcepcionVentana,ExcepcionPersistencia, ExcepcionRMI{
		
		boolean error = false;
		String MSG = "";
		String COD = codigo.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}
		if(!error){
			try {
				return managerIFachada.getInstancia().getIFachada().boletosVendidosXEx(codigo, tipoBoleto);
			} catch (ExcepcionPersistencia e){
				throw new ExcepcionPersistencia(e.darMensaje());
			} catch (ExcepcionRMI e) {
				throw new ExcepcionRMI(e.darMensaje());
			} catch (ExcepcionExcursion e) {
				throw new ExcepcionExcursion(e.darMensaje());
			}catch (RemoteException e){
				throw new ExcepcionRMI("Error en la conexión.");
			}
		}else{
			throw new ExcepcionVentana(MSG);
		}
	}
}

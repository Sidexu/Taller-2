package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXPrecio {
	private ventanaPrueba ven;

	public controladorExcursionesXPrecio(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp[] excursionesXPrecio(String precio1, String precio2) throws RemoteException,FileNotFoundException, IOException, NotBoundException{
		try {
			
			return managerIFachada.getInstancia().getIFachada().excursionesXPrecio(Float.parseFloat(precio1), Float.parseFloat(precio2));
		} catch (RemoteException e) {
			throw new RemoteException(e.getMessage());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (NotBoundException e) {
			throw new NotBoundException(e.getMessage());
		}
	}
}

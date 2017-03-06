package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXDestino {
	private ventanaPrueba ven;

	public controladorExcursionesXDestino(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOExcursionDisp[] excursionesXDestino(String destino) throws RemoteException, FileNotFoundException, IOException, NotBoundException{
		try {
			return managerIFachada.getInstancia().getIFachada().excursionesXDestino(destino);
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

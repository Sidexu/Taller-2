package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.valueObjects.VOBusCant;



public class controladorListadoGralBuses {
	private ventanaPrueba ven;

	public controladorListadoGralBuses(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOBusCant [] listadoGralBuses() throws RemoteException, FileNotFoundException, IOException, NotBoundException
	{
		try {
			return managerIFachada.getInstancia().getIFachada().listadoGralBuses();
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

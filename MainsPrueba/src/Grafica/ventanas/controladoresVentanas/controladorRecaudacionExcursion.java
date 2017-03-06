package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionExcursion;

public class controladorRecaudacionExcursion {
	private ventanaPrueba ven;

	public controladorRecaudacionExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static float recaudacionExcursion(String codEx) throws RemoteException,FileNotFoundException,ExcepcionExcursion,IOException,NotBoundException{
		try {
			return managerIFachada.getInstancia().getIFachada().recaudacionExcursion(codEx);
		} catch (RemoteException e) {
			throw new RemoteException(e.getMessage());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} catch (ExcepcionExcursion e) {
			throw new ExcepcionExcursion(e.darMensaje());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (NotBoundException e) {
			throw new NotBoundException(e.getMessage());
		}
	}
}

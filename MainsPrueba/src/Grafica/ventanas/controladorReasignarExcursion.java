package Grafica.ventanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;


public class controladorReasignarExcursion {

	private ventanaPrueba ven;

	public controladorReasignarExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void reasignarExcursion(String Codigo) throws RemoteException, FileNotFoundException, ExcepcionExcursion, ExcepcionBus, IOException, NotBoundException
	{
		try {
			managerIFachada.getInstancia().getCapaLogica().reasignacionExcursion(Codigo);
		} catch (RemoteException e) {
			throw new RemoteException(e.getMessage());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} catch (ExcepcionExcursion e) {
			throw new ExcepcionExcursion(e.darMensaje());
		} catch (ExcepcionBus e) {
			throw new ExcepcionBus(e.darMensaje());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (NotBoundException e) {
			throw new NotBoundException(e.getMessage());
		}
	}
}

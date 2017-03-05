package Grafica.ventanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionBus;
import Logica.valueObjects.VOBus;

public class controladorNuevoBus {
	private ventanaPrueba ven;

	 public controladorNuevoBus (ventanaPrueba ven)
	 {
		 this.ven=ven;
	}

	public static void nuevoBus (String Matricula, String Marca, String Capacidad) throws RemoteException, FileNotFoundException, ExcepcionBus, IOException, NotBoundException
	{
		int cap = Integer.parseInt(Capacidad);
		VOBus voB = new VOBus(Matricula, Marca, cap);
		try {
			managerIFachada.getInstancia().getIFachada().registroNuevoBus(voB);
		} catch (RemoteException e) {
			throw new RemoteException(e.getMessage());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} catch (ExcepcionBus e) {
			throw new ExcepcionBus(e.darMensaje());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (NotBoundException e) {
			throw new NotBoundException(e.getMessage());
		}
	} 

}

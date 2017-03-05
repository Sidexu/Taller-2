package Grafica.ventanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBus;

public class controladorNuevoBus {
	private ventanaPrueba ven;

	public controladorNuevoBus(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void nuevoBus(String Matricula,String Marca,String Capacidad) throws RemoteException, FileNotFoundException, ExcepcionBus, IOException, NotBoundException{


		VOBus voB = new VOBus(Matricula,Marca,Integer.parseInt(Capacidad));
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

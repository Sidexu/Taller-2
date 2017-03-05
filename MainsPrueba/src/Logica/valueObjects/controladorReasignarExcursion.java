package Logica.valueObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;

public class controladorReasignarExcursion {
	private ventanaPrueba ven;

	 public controladorReasignarExcursion (ventanaPrueba ven)
	 {
		 this.ven=ven;
	}

	public static void reasignarExcursion (String Codigo) throws NotBoundException, IOException {
		
			try {
				managerIFachada.getInstancia().getIFachada().reasignacionExcursion(Codigo);
			} catch (RemoteException e) {
				throw new RemoteException(e.getMessage());
			} catch (FileNotFoundException e) {
				throw new FileNotFoundException(e.getMessage());
			} catch (ExcepcionExcursion e) {
				throw new NotBoundException(e.darMensaje());
			} catch (ExcepcionBus e) {
				throw new NotBoundException(e.darMensaje());
			} catch (IOException e) {
				throw new IOException(e.getMessage());
			} catch (NotBoundException e) {
				throw new NotBoundException(e.getMessage());
			}

	} 
}

package Grafica.ventanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.valueObjects.VOExcursion;

public class controladorNuevaExcursion {
	private ventanaPrueba ven;

	public controladorNuevaExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void nuevaExcursion(String Codigo,String Destino,String HrPartida,String HrPartidaMin,String HrRegreso,String HrRegresoMin,String Precio) throws RemoteException, FileNotFoundException, ExcepcionExcursion, ExcepcionBus, IOException, NotBoundException
	{
		
		Hora HrP = new Hora(Integer.parseInt(HrPartida),Integer.parseInt(HrPartidaMin));
		Hora HrR = new Hora(Integer.parseInt(HrRegreso),Integer.parseInt(HrRegresoMin));

		VOExcursion voE = new VOExcursion(Codigo,Destino,HrP,HrR,Float.parseFloat(Precio));
		try {
			managerIFachada.getInstancia().getCapaLogica().registroExcursion(voE);
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

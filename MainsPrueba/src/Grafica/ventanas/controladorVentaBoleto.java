package Grafica.ventanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.valueObjects.VOBoletoTipo;

public class controladorVentaBoleto {
	private ventanaPrueba ven;

	public controladorVentaBoleto(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void ventaBoleto(String codigo,String edad,String procedencia,String cel,String descuento) throws RemoteException, FileNotFoundException, ExcepcionExcursion, ExcepcionBus, IOException, NotBoundException
	{

		VOBoletoTipo voBol= new VOBoletoTipo(0,Integer.parseInt(edad),procedencia,Long.parseLong(cel),Float.parseFloat(descuento));
		try {
			managerIFachada.getInstancia().getCapaLogica().ventaBoleto(codigo, voBol);
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

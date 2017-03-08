package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.valueObjects.VOBoletoTipo;

public class controladorBoletosVendidosXEx {
	private ventanaPrueba ven;

	public controladorBoletosVendidosXEx(ventanaPrueba ven)
	{
		this.ven = ven;
	}
	
	public static VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) throws RemoteException,FileNotFoundException,ExcepcionExcursion,IOException,NotBoundException{
		System.out.println("tipo boleto: "+tipoBoleto);
		try {
			return managerIFachada.getInstancia().getIFachada().boletosVendidosXEx(codigo, tipoBoleto);
			
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

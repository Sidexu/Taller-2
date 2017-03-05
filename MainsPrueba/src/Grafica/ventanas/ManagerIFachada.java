package Grafica.ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import defaultP.IFachada;

public class ManagerIFachada {
	private static ManagerIFachada instancia;
	private IFachada fach;
	
	private ManagerIFachada (){
		try{
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/obj";
			fach = (IFachada) Naming.lookup(ruta);
		}
		catch (FileNotFoundException e)
		{

		}
		catch (IOException e)
		{

		} 
		catch (NotBoundException e) 
		{
		
		}
	}
	
	public static ManagerIFachada getinstancia(){
		if (instancia == null){
			instancia = new ManagerIFachada();
		}
		
		return instancia;
	}
	
	public IFachada getIFachada(){
		return fach;
	}
}

package Grafica.ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import defaultP.IFachada;


public class managerIFachada {
	private static managerIFachada instancia;
	private IFachada fach;
	
	private managerIFachada() throws FileNotFoundException, IOException, NotBoundException
	{
		Properties p = new Properties();
		String nomArch = "config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/obj";
		fach = (IFachada) Naming.lookup(ruta);
	}
	
	public static managerIFachada getInstancia() throws FileNotFoundException, IOException, NotBoundException
	{
		if(instancia == null)
		{
			instancia = new managerIFachada();
		}
		return instancia;
	}
	
	public IFachada getIFachada()
	{
		return fach;
	}
}

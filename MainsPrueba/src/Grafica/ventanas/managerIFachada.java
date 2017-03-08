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
		try 
		{
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/obj";
			fach = (IFachada) Naming.lookup(ruta);
		}catch (FileNotFoundException e)
		{
			throw new FileNotFoundException(e.getMessage());
		}
		catch (IOException e)
		{
			throw new IOException(e.getMessage());
		} 
		catch (NotBoundException e) 
		{
			throw new NotBoundException(e.getMessage());
		}
	}
	
	public static managerIFachada getInstancia() throws FileNotFoundException, IOException, NotBoundException
	{
		try{
			if(instancia == null)
			{
				instancia = new managerIFachada();
			}
		}catch (FileNotFoundException e)
		{
			throw new FileNotFoundException(e.getMessage());
		}
		catch (IOException e)
		{
			throw new IOException(e.getMessage());
		} 
		catch (NotBoundException e) 
		{
			throw new NotBoundException(e.getMessage());
		}
		
		
		return instancia;
	}
	
	public IFachada getIFachada()
	{
		return fach;
	}
}

package defaultP;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import Logica.Excepciones.ExcepcionBus;
import Logica.valueObjects.VOBus;

public class mainServidor {
	public static void main(String[] args)
	{
		try
		{
			Properties p = new Properties();
			Fachada fach = Fachada.getInstance();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
			LocateRegistry.createRegistry(port);
			String ruta = "//" + ip + ":" + puerto + "/obj";
			Naming.rebind(ruta, fach);
			
			VOBus voBUS1 = new VOBus("AAA 123","Mercedes",1);
			VOBus voBUS2 = new VOBus("BBB 234","Yutong",0);
			VOBus voBUS3 = new VOBus("CCC 345","VW",3);
			
			System.out.println("REQUERIMIENTO 1: ingresar nuevo Bus");
			try{
				System.out.println("\tSe ingresa bus MAT:AAA 123, MARCA:Mercedes, CAP:30.");
				fach.registroNuevoBus(voBUS1);
				System.out.println("\tRegristro ingresado con éxito.");
			}catch(ExcepcionBus e){
				System.out.println("\t"+e.darMensaje()+"");
			}

		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

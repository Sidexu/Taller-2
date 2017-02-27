package defaultP;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import Logica.Buses;
import Logica.Excursiones;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOPersistencia;
import Persistencia.Respaldo;

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
			
			/*
			Buses buses=new Buses();
			Excursiones excursiones=new Excursiones();
			Respaldo r = new Respaldo();
			VOPersistencia voPers = new VOPersistencia(buses,excursiones);
			try {
				voPers=r.recuperar("respaldo.dat");
				buses=voPers.getBuses();
				excursiones=voPers.getExcursiones();
				
			} catch (ExcepcionPersistencia e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.darMensaje());
			}
			fach.setBuses(buses);
			fach.setExcursiones(excursiones);*/

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

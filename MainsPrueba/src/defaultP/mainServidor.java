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
			Fachada fach=null;
			try {
				fach = Fachada.getInstance();

			} catch (ExcepcionPersistencia e) {
				try {
					fach = Fachada.getInstance();
				} catch (ExcepcionPersistencia e1) {
					System.out.println(e.getMessage());
				}
			}
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
			LocateRegistry.createRegistry(port);
			String ruta = "//" + ip + ":" + puerto + "/obj";
			Naming.rebind(ruta, fach);
			System.out.println("Se inició servidor correctamente");
			
		}
		catch (RemoteException e)
		{
		
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e)
		{
		
		}
	}
}

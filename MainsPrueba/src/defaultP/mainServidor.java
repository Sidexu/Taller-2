package defaultP;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import javax.swing.JOptionPane;
import Logica.Excepciones.ExcepcionPersistencia;

public class mainServidor {
	public static void main(String[] args)
	{
		try
		{
			Fachada fach=null;
			try {
				fach = Fachada.getInstance();
				JOptionPane.showMessageDialog(null, "Datos recuperados correctamente", "Duck Boat Server", 1);
			} catch (ExcepcionPersistencia e) {
				try {
					fach = Fachada.getInstance();
					JOptionPane.showMessageDialog(null, e.darMensaje(), "Duck Boat Server", 2);
				} catch (ExcepcionPersistencia e1) {
					JOptionPane.showMessageDialog(null, e1.darMensaje(), "Duck Boat Server", 2);
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

			JOptionPane.showMessageDialog(null, "Se inició servidor correctamente", "Duck Boat Server", 1);
			
		}catch(RemoteException e){
			JOptionPane.showMessageDialog(null, "Error de comunicación", "Duck Boat Server", 0);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Error de archivo", "Duck Boat Server", 0);
		}
		
	}
}

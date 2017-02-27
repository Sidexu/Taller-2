package Grafica;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import Logica.Excepciones.ExcepcionBus;
import Logica.valueObjects.VOBusCant;


public class mainCliente {
	public static void main(String[] args)
	{
		try 
		{
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/obj";
			IFachada fach = (IFachada) Naming.lookup(ruta);
			
			System.out.println("\nREQUERIMIENTO 2: listado general de buses");
			VOBusCant arrVOBusCant[] ;
			arrVOBusCant=fach.listadoGralBuses();
			for(int i=0;i<arrVOBusCant.length;i++){
				VOBusCant voBusCant=arrVOBusCant[i];
				System.out.println("\tMatricula: "+voBusCant.getMatricula()+" Marca: "+voBusCant.getMarca()+" Cap: "+voBusCant.getCapacidad()+" Cant excursiones: "+voBusCant.getCat_ex());
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (NotBoundException e) 
		{
			e.printStackTrace();
		}
	}
}

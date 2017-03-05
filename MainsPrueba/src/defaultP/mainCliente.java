package defaultP;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOBusCant;
import Logica.valueObjects.VOExcursion;
import Logica.valueObjects.VOExcursionDisp;


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
			
			System.out.println("\nREQUERIMIENTO 3: listado de excursiones por bus");
			
			System.out.println("\tListado BUS1 MAT: AAA 123");
			try{
				VOExcursionDisp arrVOExDis[];
				arrVOExDis=fach.listadoExcursionesXBus("AAA 123");
				for(int i=0;i<arrVOExDis.length;i++){
					VOExcursionDisp vo=arrVOExDis[i];
					System.out.println("\tExcursion COD: "+vo.getCodigo()+", Destino: "+vo.getDestino()+", Hora Partida: "+vo.getHr_partida().getHora()+":"+vo.getHr_partida().getMin()+", Hora regreso: "+vo.getHr_regreso().getHora()+":"+vo.getHr_regreso().getMin()+", Precio base: "+vo.getPrecioBase()+", Cant asientos disp: "+vo.getCant_disponibles());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}
			
			
			
			
			
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
}

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
			
			try{
				System.out.println("\tSe ingresa bus MAT:AAA 123, MARCA:Mercedes, CAP:30.");
				fach.registroNuevoBus(voBUS1);
				System.out.println("\tRegristro ingresado con éxito.");
			}catch(ExcepcionBus e){
				System.out.println("\t"+e.darMensaje()+"");
			}
			
			try{
				System.out.println("\tSe ingresa bus MAT:BBB 234, Yutong, CAP:0.");
				fach.registroNuevoBus(voBUS2);
				System.out.println("\tRegristro ingresado con éxito.");
			}catch(ExcepcionBus e){
				System.out.println("\t"+e.darMensaje()+"");
			}
			
			try{
				System.out.println("\tSe ingresa bus MAT:CCC 345, VW, CAP:20.");
				fach.registroNuevoBus(voBUS3);
				System.out.println("\tRegristro ingresado con éxito.");
			}catch(ExcepcionBus e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}
			
			
			
			
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
			
			System.out.println("\tListado BUS3 MAT: CCC 345");
			try{
				VOExcursionDisp arrVOExDis[];
				arrVOExDis=fach.listadoExcursionesXBus("CCC 345");
				for(int i=0;i<arrVOExDis.length;i++){
					VOExcursionDisp vo=arrVOExDis[i];
					System.out.println("\tExcursion COD: "+vo.getCodigo()+", Destino: "+vo.getDestino()+", Hora Partida: "+vo.getHr_partida().getHora()+":"+vo.getHr_partida().getMin()+", Hora regreso: "+vo.getHr_regreso().getHora()+":"+vo.getHr_regreso().getMin()+", Precio base: "+vo.getPrecioBase()+", Cant asientos disp: "+vo.getCant_disponibles());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}
			
			System.out.println("\nREQUERIMIENTO 5: reasignar una excursión");
			System.out.println("\tSe reasignará la excursion4 'ROC 4' ");
			try{
				fach.reasignacionExcursion("ROC 4");
				System.out.println("\tReasignación realizada con éxito");
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}catch(ExcepcionBus e){
				System.out.println("\t"+e.darMensaje()+"\n");
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
			
			System.out.println("\tListado BUS3 MAT: CCC 345");
			try{
				VOExcursionDisp arrVOExDis[];
				arrVOExDis=fach.listadoExcursionesXBus("CCC 345");
				for(int i=0;i<arrVOExDis.length;i++){
					VOExcursionDisp vo=arrVOExDis[i];
					System.out.println("\tExcursion COD: "+vo.getCodigo()+", Destino: "+vo.getDestino()+", Hora Partida: "+vo.getHr_partida().getHora()+":"+vo.getHr_partida().getMin()+", Hora regreso: "+vo.getHr_regreso().getHora()+":"+vo.getHr_regreso().getMin()+", Precio base: "+vo.getPrecioBase()+", Cant asientos disp: "+vo.getCant_disponibles());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}
			
			
			
			
			System.out.println("\nREQUERIMIENTO 3: listado de excursiones por bus");
			
			System.out.println("\tListado BUS1 MAT: AAA 123");
			try{
				VOExcursionDisp arrVOExDis[];
				arrVOExDis=fach.listadoExcursionesXBus("AAA 123");
				for(int i=0;i<arrVOExDis.length;i++){
					VOExcursionDisp vo3=arrVOExDis[i];
					System.out.println("\tExcursion COD: "+vo3.getCodigo()+", Destino: "+vo3.getDestino()+", Hora Partida: "+vo3.getHr_partida().getHora()+":"+vo3.getHr_partida().getMin()+", Hora regreso: "+vo3.getHr_regreso().getHora()+":"+vo3.getHr_regreso().getMin()+", Precio base: "+vo3.getPrecioBase()+", Cant asientos disp: "+vo3.getCant_disponibles());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje());
			}
			
			System.out.println("\tListado BUS3 MAT: CCC 345");
			try{
				VOExcursionDisp arrVOExDis[];
				arrVOExDis=fach.listadoExcursionesXBus("CCC 345");
				for(int i=0;i<arrVOExDis.length;i++){
					VOExcursionDisp vo4=arrVOExDis[i];
					System.out.println("\tExcursion COD: "+vo4.getCodigo()+", Destino: "+vo4.getDestino()+", Hora Partida: "+vo4.getHr_partida().getHora()+":"+vo4.getHr_partida().getMin()+", Hora regreso: "+vo4.getHr_regreso().getHora()+":"+vo4.getHr_regreso().getMin()+", Precio base: "+vo4.getPrecioBase()+", Cant asientos disp: "+vo4.getCant_disponibles());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}
			
			System.out.println("\nREQUERIMIENTO 5: reasignar una excursión ");
			System.out.println("\tSe reasignará la excursion1 'ROC 1' ");
			try{
				fach.reasignacionExcursion("ROC 1");
				System.out.println("\tReasignación realizada con éxito");
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}catch(ExcepcionBus e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}

			
			System.out.println("\nREQUERIMIENTO 8: recaudacion de una excursion");
			System.out.println("\tRecaudacion de la excursion NOEXISTE");
			try{
				float recaudacion=fach.recaudacionExcursion("NOEXISTE");
				System.out.println("\tLa recaudacion fue: "+recaudacion);
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje());
			}
			
			System.out.println("\tRecaudacion de la excursion ROC 4");
			try{
				float recaudacion=fach.recaudacionExcursion("ROC 4");
				System.out.println("\tLa recaudacion fue: "+recaudacion);
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje()+"\n");
			}
			
			System.out.println("\nREQUERIMIENTO 9: listado de boletos vendidos para una excursion");
			System.out.println("\t Codigo excursion 'NOEXISTE' tipo boleto comun");
			try{
				VOBoletoTipo arr[];
				arr=fach.boletosVendidosXEx("NOEXISTE","comun");
				for(int i=0;i<arr.length;i++){
					System.out.println("\tNroBoleto:"+arr[i].getNro_boleto()+", EdadPas:"+arr[i].getEdad_pas()+", LugarProc:"+arr[i].getLugar_procedencia()+", CelPas:"+arr[i].getCel_pas()+", Descuento:"+arr[i].getDescuento());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje());
			}
			
			System.out.println("\t Codigo excursion 'ROC 4' tipo boleto comun");
			try{
				VOBoletoTipo arr[];
				arr=fach.boletosVendidosXEx("ROC 4","comun");
				for(int i=0;i<arr.length;i++){
					System.out.println("/tNroBoleto:"+arr[i].getNro_boleto()+", EdadPas:"+arr[i].getEdad_pas()+", LugarProc:"+arr[i].getLugar_procedencia()+", CelPas:"+arr[i].getCel_pas()+", Descuento:"+arr[i].getDescuento());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje());
			}
			
			System.out.println("\t Codigo excursion 'ROC 4' tipo boleto especial");
			try{
				VOBoletoTipo arr[];
				arr=fach.boletosVendidosXEx("ROC 4","especial");
				for(int i=0;i<arr.length;i++){
					System.out.println("\tNroBoleto:"+arr[i].getNro_boleto()+", EdadPas:"+arr[i].getEdad_pas()+", LugarProc:"+arr[i].getLugar_procedencia()+", CelPas:"+arr[i].getCel_pas()+", Descuento:"+arr[i].getDescuento());
				}
			}catch(ExcepcionExcursion e){
				System.out.println("\t"+e.darMensaje());
			}
			
			System.out.println("\nREQUERIMIENTO 10: listado excursiones por destino");
			System.out.println("\t Destino Atlantida");
			
				VOExcursionDisp arr[];
				arr=fach.excursionesXDestino("Atlantida");
				if(arr.length==0){
					System.out.println("\tNo hay excursiones para ese destino");
				}else{
					for(int i=0;i<arr.length;i++){
						System.out.println("\tCodigo:"+arr[i].getCodigo()+", Destino:"+arr[i].getDestino()+", HoraPartida: "+arr[i].getHr_partida().getHora()+":"+arr[i].getHr_partida().getMin()+", HoraRegreso: "+arr[i].getHr_regreso().getHora()+":"+arr[i].getHr_regreso().getMin()+ ", PrecioBase:"+arr[i].getPrecioBase());
					}
				}
				
				System.out.println("\t Destino Antoniopolis");
				
				VOExcursionDisp arr2[];
					arr2=fach.excursionesXDestino("Antoniopolis");
					if(arr2.length==0){
						System.out.println("\tNo hay excursiones para ese destino");
					}else{
						for(int i=0;i<arr2.length;i++){
							System.out.println("\tCodigo:"+arr2[i].getCodigo()+", Destino:"+arr2[i].getDestino()+", HoraPartida: "+arr2[i].getHr_partida().getHora()+":"+arr2[i].getHr_partida().getMin()+", HoraRegreso: "+arr2[i].getHr_regreso().getHora()+":"+arr2[i].getHr_regreso().getMin()+ ", PrecioBase:"+arr2[i].getPrecioBase());
						}
					}
			
					
			System.out.println("\nREQUERIMIENTO 11: listado excursiones por rango de precio");
			System.out.println("Rango de precio de 1500 a 2000");
			
				VOExcursionDisp arr3[];
				arr3=fach.excursionesXPrecio(1500,2000);
				if(arr3.length==0){
					System.out.println("\tNo hay excursiones para ese rango de precios");
				}else{
					for(int i=0;i<arr3.length;i++){
						System.out.println("\tCodigo:"+arr3[i].getCodigo()+", Destino:"+arr3[i].getDestino()+", HoraPartida: "+arr3[i].getHr_partida().getHora()+":"+arr3[i].getHr_partida().getMin()+", HoraRegreso: "+arr3[i].getHr_regreso().getHora()+":"+arr3[i].getHr_regreso().getMin()+ ", PrecioBase:"+arr3[i].getPrecioBase());
					}
				}
				
			System.out.println("Rango de precio de 400 a 1000");
				
				VOExcursionDisp arr4[];
					arr4=fach.excursionesXPrecio(400,1000);
					if(arr4.length==0){
						System.out.println("\tNo hay excursiones para ese rango de precios");
					}else{
						for(int i=0;i<arr4.length;i++){
							System.out.println("\tCodigo:"+arr4[i].getCodigo()+", Destino:"+arr4[i].getDestino()+", HoraPartida: "+arr4[i].getHr_partida().getHora()+":"+arr4[i].getHr_partida().getMin()+", HoraRegreso: "+arr4[i].getHr_regreso().getHora()+":"+arr4[i].getHr_regreso().getMin()+ ", PrecioBase:"+arr4[i].getPrecioBase());
						}
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

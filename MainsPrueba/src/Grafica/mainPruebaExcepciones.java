package Grafica;

import java.rmi.RemoteException;

import defaultP.Fachada;
import Logica.Boleto;
import Logica.Bus;
import Logica.Buses;
import Logica.Excursion;
import Logica.Excursiones;
import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOBusCant;
import Logica.valueObjects.VOExcursion;
import Logica.valueObjects.VOExcursionDisp;

public class mainPruebaExcepciones {

	public static void main(String[] args)  throws RemoteException{
		
		VOBus voBUS1 = new VOBus("AAA 123","Mercedes",1);
		VOBus voBUS2 = new VOBus("BBB 234","Yutong",0);
		VOBus voBUS3 = new VOBus("CCC 345","VW",3);

		
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
		
		System.out.println("REQUERIMIENTO 1: ingresar nuevo Bus");
		try{
			System.out.println("\tSe ingresa bus MAT:AAA 123, MARCA:Mercedes, CAP:30.");
			fach.registroNuevoBus(voBUS1);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje()+"");
		}
		
		try{
			System.out.println("\tSe ingresa bus MAT:AAA 123, MARCA:Mercedes, CAP:30.");
			fach.registroNuevoBus(voBUS1);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje()+"");
		}
		
		try{
			System.out.println("\tSe ingresa bus MAT:BBB 234, Yutong, CAP:0.");
			fach.registroNuevoBus(voBUS2);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje()+"");
		}
		
		try{
			System.out.println("\tSe ingresa bus MAT:CCC 345, VW, CAP:20.");
			fach.registroNuevoBus(voBUS3);
			System.out.println("\tRegristro ingresado con �xito.");
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
		
		System.out.println("\nREQUERIMIENTO 4: registro de una excursi�n");
		Hora hpartida= new Hora(8,00);
		Hora hregreso= new Hora(12,00);
		VOExcursion voEx1 = new VOExcursion("ROC 1", "Ciudad Rocha",hpartida,hregreso,800);
		Hora hpartida1= new Hora(9,00);
		Hora hregreso1= new Hora(15,00);
		VOExcursion voEx2 = new VOExcursion("ROC 2", "La Paloma",hpartida1,hregreso1,1200);
		Hora hpartida3= new Hora(10,00);
		Hora hregreso3= new Hora(11,00);
		VOExcursion voEx3 = new VOExcursion("ROC 3", "La Pedrera",hpartida3,hregreso3,1400);
		Hora hpartida2= new Hora(15,00);
		Hora hregreso2= new Hora(18,00);
		VOExcursion voEx4 = new VOExcursion("ROC 4", "Antoniopolis",hpartida2,hregreso2,500);
		try{
			System.out.println("\tIngreso Excursion1 COD: ROC 1, Destino:Ciudad Rocha, Hpartida: 8:00, Hregreso: 12:00, PrecioBase: 800");
			fach.registroExcursion(voEx1);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion2 COD: ROC 2, Destino:La Paloma, Hpartida: 9:00, Hregreso: 15:00, PrecioBase: 1200");
			fach.registroExcursion(voEx2);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion2 COD: ROC 2, Destino:La Paloma, Hpartida: 9:00, Hregreso: 15:00, PrecioBase: 1200");
			fach.registroExcursion(voEx2);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion3 COD: ROC 3, Destino:La Pedrera, Hpartida: 10:00, Hregreso: 11:00, PrecioBase: 1400");
			fach.registroExcursion(voEx3);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion4 COD: ROC 4, Destino:Antonipolis, Hpartida: 15:00, Hregreso: 18:00, PrecioBase: 500");
			fach.registroExcursion(voEx4);
			System.out.println("\tRegristro ingresado con �xito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
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
		
		System.out.println("\nREQUERIMIENTO 5: reasignar una excursi�n");
		System.out.println("\tSe reasignar� la excursion4 'ROC 4' ");
		try{
			fach.reasignacionExcursion("ROC 4");
			System.out.println("\tReasignaci�n realizada con �xito");
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
		
		
		System.out.println("\nREQUERIMIENTO 5: reasignar una excursi�n (NO SE PUEDE REASIGNAR)");
		System.out.println("\tSe reasignar� la excursion1 'ROC 1' ");
		try{
			fach.reasignacionExcursion("ROC 1");
			System.out.println("\tReasignaci�n realizada con �xito");
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
			System.out.println("\t"+e.darMensaje());
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
		
		
		System.out.println("\nREQUERIMIENTO 7: Venta de boleto");
		System.out.println("\tCodigo de Excursion: NOEXISTE, datos del pasajero: NRO_BOLETO: 1, EDAD:12, PROCEDENCIA: CANELONES, CEL: 598996655, DESCUENTO:0");
		String edad="12", cel="9999999", desc="0";
		
		VOBoletoTipo vo=new VOBoletoTipo(0,Integer.parseInt(edad),"Canelones",Long.parseLong(cel),Float.parseFloat(desc));
		try{
			fach.ventaBoleto("NOEXISTE", vo);
			System.out.println("Boleto ingresado con exito.");
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje());
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje());
		}
		
		System.out.println("\tCodigo de Excursion: ROC 1, datos del pasajero: NRO_BOLETO: 1, EDAD:12, PROCEDENCIA: CANELONES, CEL: 598996655, DESCUENTO:0");
		try{
			fach.ventaBoleto("ROC 1", vo);
			System.out.println("\tBoleto ingresado con exito.");
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje());
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje());
		}
		
		System.out.println("\tCodigo de Excursion: ROC 1, datos del pasajero: NRO_BOLETO: 2, EDAD:28, PROCEDENCIA: PAYSANDU, CEL: 598200022, DESCUENTO:300");
		VOBoletoTipo vo2=new VOBoletoTipo(0,28,"Paysandu",598200022,300);
		try{
			fach.ventaBoleto("ROC 1", vo2);
			System.out.println("Boleto ingresado con exito.");
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje());
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje());
		}
		System.out.println("\tCodigo de Excursion: ROC 4,  datos del pasajero: NRO_BOLETO: 1, EDAD:12, PROCEDENCIA: CANELONES, CEL: 598996655, DESCUENTO:0");
		try{
			fach.ventaBoleto("ROC 4", vo);
			System.out.println("\tBoleto ingresado con exito.");
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje());
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje());
		}
		
		System.out.println("\tCodigo de Excursion: ROC 4, datos del pasajero: NRO_BOLETO: 2, EDAD:28, PROCEDENCIA: PAYSANDU, CEL: 598200022, DESCUENTO:300");
		try{
			fach.ventaBoleto("ROC 4", vo2);
			System.out.println("\tBoleto ingresado con exito.");
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje());
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje());
		}
		
		System.out.println("\tCodigo de Excursion: ROC 4, datos del pasajero: NRO_BOLETO: 2, EDAD:12, PROCEDENCIA: SAN JOSE, CEL: 598445522, DESCUENTO:200");
		VOBoletoTipo vo8=new VOBoletoTipo(0,12,"San Jose",598445522,200);
		try{
			fach.ventaBoleto("ROC 4", vo8);
			System.out.println("\tBoleto ingresado con exito.");
		}catch(ExcepcionExcursion e){
			System.out.println("\t"+e.darMensaje());
		}catch(ExcepcionBus e){
			System.out.println("\t"+e.darMensaje());
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
		
		System.out.println("\nREQUERIMIENTO 5: reasignar una excursi�n ");
		System.out.println("\tSe reasignar� la excursion1 'ROC 1' ");
		try{
			fach.reasignacionExcursion("ROC 1");
			System.out.println("\tReasignaci�n realizada con �xito");
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
				System.out.println("\tNroBoleto:"+arr[i].getNro_boleto()+", EdadPas:"+arr[i].getEdad_pas()+", LugarProc:"+arr[i].getLugar_procedencia()+", CelPas:"+arr[i].getCel_pas()+", Descuento:"+arr[i].getDescuento());
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
	
		System.out.println("\nREQUERIMIENTO 6: respaldo de datos");
		try{
			fach.respaldoDatos();
			System.out.println("Se respaldo correctamente!");
		}catch(ExcepcionPersistencia e){
			System.out.println("\t"+e.darMensaje()+"\n");
		}
		
		
		
	}
}

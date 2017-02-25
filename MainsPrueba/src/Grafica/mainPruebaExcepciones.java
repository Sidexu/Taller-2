package Grafica;

import Logica.Boleto;
import Logica.Bus;
import Logica.Buses;
import Logica.Excursion;
import Logica.Excursiones;
import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOBusCant;
import Logica.valueObjects.VOExcursion;
import Logica.valueObjects.VOExcursionDisp;
import Logica.Fachada;

public class mainPruebaExcepciones {

	public static void main(String[] args) {
		
		VOBus voBUS1 = new VOBus("AAA 123","Mercedes",30);
		VOBus voBUS2 = new VOBus("BBB 234","Yutong",0);
		VOBus voBUS3 = new VOBus("CCC 345","VW",20);
		Buses buses = new Buses();
		Excursiones excursiones = new Excursiones();
		//Fachada fach = new Fachada(buses,excursiones);
		
		
		Fachada fach= Fachada.getInstance(buses,excursiones);
		
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
		
		System.out.println("\nREQUERIMIENTO 4: registro de una excursión");
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
			System.out.println("\tRegristro ingresado con éxito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		///PRUEBA
		Boleto b = new Boleto(1,12,"montevideo",44322222);
		//prueba
		Excursion prueba=excursiones.findExcursion("ROC 1");
		prueba.getBoletos().insert(b);
		
		
		
		try{
			System.out.println("\tIngreso Excursion2 COD: ROC 2, Destino:La Paloma, Hpartida: 9:00, Hregreso: 15:00, PrecioBase: 1200");
			fach.registroExcursion(voEx2);
			System.out.println("\tRegristro ingresado con éxito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion2 COD: ROC 2, Destino:La Paloma, Hpartida: 9:00, Hregreso: 15:00, PrecioBase: 1200");
			fach.registroExcursion(voEx2);
			System.out.println("\tRegristro ingresado con éxito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion3 COD: ROC 3, Destino:La Pedrera, Hpartida: 10:00, Hregreso: 11:00, PrecioBase: 500");
			fach.registroExcursion(voEx3);
			System.out.println("\tRegristro ingresado con éxito.");
		}catch(ExcepcionExcursion e1){
			System.out.println("\t"+e1.darMensaje());
		}catch(ExcepcionBus e2){
			System.out.println("\t"+e2.darMensaje());
		}
		
		try{
			System.out.println("\tIngreso Excursion4 COD: ROC 4, Destino:Antonipolis, Hpartida: 15:00, Hregreso: 18:00, PrecioBase: 1400");
			fach.registroExcursion(voEx4);
			System.out.println("\tRegristro ingresado con éxito.");
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
		
		
		System.out.println("\nREQUERIMIENTO 5: reasignar una excursión (NO SE PUEDE REASIGNAR)");
		System.out.println("\tSe reasignará la excursion1 'ROC 1' ");
		try{
			fach.reasignacionExcursion("ROC 1");
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
		
		
		
		
		System.out.println("\nREQUERIMIENTO 6: respaldo de datos");
		try{
			fach.respaldoDatos();
			System.out.println("Se respaldo correctamente!");
		}catch(ExcepcionPersistencia e){
			System.out.println("\t"+e.darMensaje()+"\n");
		}
		
		
		
	}
}

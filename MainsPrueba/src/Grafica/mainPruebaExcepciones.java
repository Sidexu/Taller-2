package Grafica;

import Logica.Buses;
import Logica.ExcepcionBus;
import Logica.ExcepcionExcursion;
import Logica.Excursiones;
import Logica.Hora;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOExcursion;
import Logica.Fachada;

public class mainPruebaExcepciones {

	public static void main(String[] args) {
		
		Buses B = new Buses();
		Excursiones E = new Excursiones();
		Fachada fach = new Fachada(B,E);
		
		VOBus VB = new VOBus("dsadsa","dsadsa",12);
		try {
			fach.registroNuevoBus(VB);
		} catch (ExcepcionBus e) {
			System.out.println(e.darMensaje());
		}
		VOBus VB1 = new VOBus("dsadsa","dsadsa",12);
		try {
			fach.registroNuevoBus(VB1);
		} catch (ExcepcionBus e) {
			System.out.println(e.darMensaje());
		}
		VOBus VB2 = new VOBus("pedro","dsadsa",12);
		try {
			fach.registroNuevoBus(VB2);
		} catch (ExcepcionBus e) {
			System.out.println(e.darMensaje());
		}
		try {
			fach.listadoExcursionesXBus("trewrew");
		} catch (ExcepcionExcursion e) {
			System.out.println(e.darMensaje());
		}
		
		Hora h1 = new Hora(11,45);
		Hora h2 = new Hora(18,30);
		VOExcursion exc = new VOExcursion("hola","pepe",h1,h2,10);
		try {
			fach.registroExcursion(exc);
		} catch (ExcepcionExcursion e) {
			System.out.println(e.darMensaje());
		} catch (ExcepcionBus e) {
			System.out.println(e.darMensaje());
		}
			
		Hora h3 = new Hora(12,00);
		Hora h4 = new Hora(17,30);
		VOExcursion exc2 = new VOExcursion("hola2","pepe",h3,h4,10);
		try {
			fach.registroExcursion(exc2);
		} catch (ExcepcionExcursion e) {
			System.out.println(e.darMensaje());
		} catch (ExcepcionBus e) {
			System.out.println(e.darMensaje());
		}
		try {
			fach.reasignacionExcursion("hola");
		} catch (ExcepcionExcursion e) {
			System.out.println(e.darMensaje());
		} catch (ExcepcionBus e) {
			System.out.println(e.darMensaje());
		}
	}
}

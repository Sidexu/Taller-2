package Grafica.ventanas.controladoresVentanas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOExcursion;

public class controladorNuevaExcursion {
	private ventanaPrueba ven;

	public controladorNuevaExcursion(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void nuevaExcursion(String Codigo,String Destino,String HrPartida,String HrPartidaMin,String HrRegreso,String HrRegresoMin,String Precio) throws  ExcepcionExcursion, ExcepcionBus,ExcepcionRMI,ExcepcionPersistencia, ExcepcionVentana 
	{
			boolean error = false;
			
			String MSG = "";
			String COD = Codigo.trim();
			if(COD.equals(new String(""))){
				error=true;
				MSG = "Error el código no puede ser vacío";
			}else{
				String DES = Destino.trim();
				if(DES.equals(new String(""))){
					error=true;
					MSG = "Error el destino no puede ser vacío";
				}
			}	
				
			try{
				int hrp = Integer.parseInt(HrPartida);
				if(hrp >24 || hrp < 0){
					throw new ExcepcionVentana("Error, la hora debe estar comprendida entre 00 y 24");
				}
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, la hora debe de ser numerica");
			}
			
			try{
				int hrpm = Integer.parseInt(HrPartidaMin);
				if(hrpm >59 || hrpm < 0){
					throw new ExcepcionVentana("Error, los minutos deben estar comprendids entre 00 y 59");
				}
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, los minutos deben de ser numericos");
			}
			
			try{
				int hrr = Integer.parseInt(HrRegreso);
				if(hrr >24 || hrr < 0){
					throw new ExcepcionVentana("Error, la hora debe estar comprendida entre 00 y 24");
				}
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, la hora debe de ser numerica");
			}
			
			try{
				int hrrm = Integer.parseInt(HrRegresoMin);
				if(hrrm >59 || hrrm < 0){
					throw new ExcepcionVentana("Error, los minutos deben estar comprendids entre 00 y 59");
				}
					
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, los minutos deben de ser numericos");
			}
			
			if(!error){
				try{
					Float.parseFloat(Precio);
						Hora HrP = new Hora(Integer.parseInt(HrPartida),Integer.parseInt(HrPartidaMin));
						Hora HrR = new Hora(Integer.parseInt(HrRegreso),Integer.parseInt(HrRegresoMin));

						VOExcursion voE = new VOExcursion(Codigo,Destino,HrP,HrR,Float.parseFloat(Precio));
						try{
							managerIFachada.getInstancia().getIFachada().registroExcursion(voE);
						} catch (ExcepcionPersistencia e) {
							throw new ExcepcionPersistencia(e.darMensaje());
						} catch (ExcepcionRMI e) {
							throw new ExcepcionRMI(e.darMensaje());
						}catch (ExcepcionBus e){
							throw new ExcepcionBus(e.darMensaje());
						}catch (ExcepcionExcursion e){
							throw new ExcepcionExcursion(e.darMensaje());
						}catch (RemoteException e){
							throw new ExcepcionRMI("Error en la conexión.");
						}
					}catch (NumberFormatException e){
						throw new ExcepcionVentana("Error, precio debe de ser numérico");
					}catch (NullPointerException e){
						throw new ExcepcionVentana("Error, precio no puede estar vacío");
					}
			}else{
				throw new ExcepcionVentana(MSG);
			}
	}

}

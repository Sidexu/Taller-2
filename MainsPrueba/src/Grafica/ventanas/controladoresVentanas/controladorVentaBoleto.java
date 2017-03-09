package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import Grafica.ventanas.managerIFachada;
import Grafica.ventanas.ventanaPrueba;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.Excepciones.ExcepcionVentana;
import Logica.valueObjects.VOBoletoTipo;

public class controladorVentaBoleto {
	private ventanaPrueba ven;

	public controladorVentaBoleto(ventanaPrueba ven)
	{
		this.ven = ven;
		
	}
	
	public static void ventaBoleto(String codigo,String edad,String procedencia,String cel,String descuento) throws ExcepcionVentana,ExcepcionPersistencia,ExcepcionRMI,  ExcepcionExcursion, ExcepcionBus 
	{
		boolean error = false;
		
		String MSG = "";
		String COD = codigo.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}else{
			String PROC = procedencia.trim();
			if(PROC.equals(new String(""))){
				error=true;
				MSG = "Error la procedencia no puede ser vacía";
			}
		}
		
		if(!error){
			try{
				float DESC= Float.parseFloat(descuento);
				if(DESC < 0){
					throw new ExcepcionVentana("Error, el descuento no puede ser negativo");
				}
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, el descuento debe ser numerico");
			}
			try{
				int EDAD= Integer.parseInt(edad);
				if(EDAD < 0 || EDAD>150){
					throw new ExcepcionVentana("Error, la edad no puede ser negativa o mayor a 150 años");
				}
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, la edad debe ser numerica");
			}
			
			try{
				long CEL= Long.parseLong(cel);
				if(CEL < 0){
					throw new ExcepcionVentana("Error, el celular no puede ser negativo");
				}
			}catch(NumberFormatException e){
				throw new ExcepcionVentana("Error, el celular debe ser numerico");
			}
			
			
			VOBoletoTipo voBol= new VOBoletoTipo(0,Integer.parseInt(edad),procedencia,Long.parseLong(cel),Float.parseFloat(descuento));
		
				try {
					managerIFachada.getInstancia().getIFachada().ventaBoleto(codigo, voBol);
				} catch (ExcepcionPersistencia e) {
					throw new ExcepcionPersistencia(e.darMensaje());
				} catch (ExcepcionRMI e) {
					throw new ExcepcionRMI(e.darMensaje());
				}catch(ExcepcionBus e){
					throw new ExcepcionBus(e.darMensaje());
				}catch(ExcepcionExcursion e){
					throw new ExcepcionExcursion(e.darMensaje());
				}catch (RemoteException e){
					throw new ExcepcionRMI("Error en la conexión.");
				}
		}else{
			throw new ExcepcionVentana(MSG);
		}

	}
}

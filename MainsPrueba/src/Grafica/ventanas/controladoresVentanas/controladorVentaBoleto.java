package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBoletoTipo;

public class controladorVentaBoleto {
	
	public static void ventaBoleto(String codigo,String edad,String procedencia,String cel,String descuento) 
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
					JOptionPane.showMessageDialog(null,"Error, el descuento no puede ser negativo", "Duck Boat Window", 0);	
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Error, el descuento debe ser numerico", "Duck Boat Window", 0);	
			}
			try{
				int EDAD= Integer.parseInt(edad);
				if(EDAD < 0 || EDAD>150){
					JOptionPane.showMessageDialog(null,"Error, la edad no puede ser negativa o mayor a 150 años", "Duck Boat Window", 0);
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Error, la edad debe ser numerica", "Duck Boat Window", 0);
			}
			
			try{
				long CEL= Long.parseLong(cel);
				if(CEL < 0 || CEL >999999999){
					JOptionPane.showMessageDialog(null,"Error, el celular no puede ser negativo o tener mas de 9 dígitos", "Duck Boat Window", 0);
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Error, el celular debe ser numerico", "Duck Boat Window", 0);
			}
			
			
			VOBoletoTipo voBol= new VOBoletoTipo(0,Integer.parseInt(edad),procedencia,Long.parseLong(cel),Float.parseFloat(descuento));
		
				try {
					managerIFachada.getInstancia().getIFachada().ventaBoleto(codigo, voBol);
					JOptionPane.showMessageDialog(null,"Se ingresó el boleto correctamente!", "Duck Boat Window", 1);
				} catch (ExcepcionPersistencia e) {
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				} catch (ExcepcionRMI e) {
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				}catch(ExcepcionBus e){
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				}catch(ExcepcionExcursion e){
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				}catch (RemoteException e){
					JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
				}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}

	}
}

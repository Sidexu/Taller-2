package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXPrecio {

	public static VOExcursionDisp[] excursionesXPrecio(String precio1, String precio2) {
		VOExcursionDisp[] arr=null;
		boolean error=false;
		
		try{
			long RANG1= Long.parseLong(precio1);
			if(RANG1 < 0){
				error=true;
				JOptionPane.showMessageDialog(null,"Error, el rango 1 no puede ser negativo", "Duck Boat Window", 0);
			}
		}catch(NumberFormatException e){
			error=true;
			JOptionPane.showMessageDialog(null,"Error, el rango 1 debe ser numerico o superó el tamaño máximo admitido", "Duck Boat Window", 0);
		}
		if(!error){
			try{
				long RANG2= Long.parseLong(precio2);
				if(RANG2 < 0){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, el rango 2 no puede ser negativo", "Duck Boat Window", 0);
				}
			}catch(NumberFormatException e){
				error=true;
				JOptionPane.showMessageDialog(null,"Error, el rango 2 debe ser numerico o superó el tamaño máximo admitido", "Duck Boat Window", 0);
			}
		}
		
		if(!error){
			try{
				Float.parseFloat(precio1);
				arr= managerIFachada.getInstancia().getIFachada().excursionesXPrecio(Float.parseFloat(precio1), Float.parseFloat(precio2));
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Error, precio debe de ser numérico", "Duck Boat Window", 0);
			} catch (NullPointerException e){
				JOptionPane.showMessageDialog(null,"Error, precio no puede estar vacío", "Duck Boat Window", 0);
			} catch (ExcepcionPersistencia e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
			}
		}
		return arr;
	}
}

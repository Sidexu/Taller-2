package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;

public class controladorRecaudacionExcursion {

	public static void recaudacionExcursion(String codEx) {
		float recaudacion=0;
		boolean error = false;
		String MSG = "";
		String COD = codEx.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}
		if(!error){
			try {
				recaudacion= managerIFachada.getInstancia().getIFachada().recaudacionExcursion(codEx);
				JOptionPane.showMessageDialog(null, "La recaudación para la excursión "+codEx+" es: "+recaudacion, "Duck Boat Window", 1);
			} catch (ExcepcionPersistencia e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
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

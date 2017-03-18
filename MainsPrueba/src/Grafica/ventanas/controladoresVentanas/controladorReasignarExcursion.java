package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;



public class controladorReasignarExcursion {

	
	public static void reasignarExcursion(String Codigo) 
	{
		
		boolean error = false;
		String MSG = "";
		String COD = Codigo.trim();
		if(COD.equals("")){
			error=true;
			MSG = "Error el código no puede ser vacío";
		}
		if(!error){
			try {
				String matBusReasig="";
				matBusReasig=managerIFachada.getInstancia().getIFachada().reasignacionExcursion(Codigo);
				JOptionPane.showMessageDialog(null,"Excursión se reasignó correctamente al bus con matricula: "+matBusReasig, "Duck Boat Window", 1);
			} catch (ExcepcionPersistencia e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch(ExcepcionExcursion e){
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch(ExcepcionBus e){
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch (RemoteException e){
				JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
			}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}

		
	}
}

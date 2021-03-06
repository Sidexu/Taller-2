package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBusCant;



public class controladorListadoGralBuses {
	
	public static VOBusCant [] listadoGralBuses() 
	{
		VOBusCant [] arr=null;
			try {
				arr= managerIFachada.getInstancia().getIFachada().listadoGralBuses();
				if(arr == null){
					JOptionPane.showMessageDialog(null,"No hay datos para listar", "Duck Boat Window", 2);
				}
			} catch (ExcepcionPersistencia e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch (RemoteException e){
				JOptionPane.showMessageDialog(null, "Error en la conexi�n", "Duck Boat Window", 0);
			}
			return arr;
	}
}

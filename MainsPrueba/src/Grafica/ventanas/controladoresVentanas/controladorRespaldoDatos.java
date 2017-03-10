package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;

public class controladorRespaldoDatos {
	
	public static void respaldoDatos() {
		try {
			managerIFachada.getInstancia().getIFachada().respaldoDatos();
			JOptionPane.showMessageDialog(null,"Se respaldaron los datos correctamente!", "Duck Boat Window", 1);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
		} catch (ExcepcionPersistencia e) {
			JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
		} catch (ExcepcionRMI e) {
			JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
		}
	}
}

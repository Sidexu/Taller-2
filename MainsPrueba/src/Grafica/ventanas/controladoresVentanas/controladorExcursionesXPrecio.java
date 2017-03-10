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
			return arr;
	}
}

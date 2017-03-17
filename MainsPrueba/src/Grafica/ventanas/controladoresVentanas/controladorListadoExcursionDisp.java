package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursionDisp;

public class controladorListadoExcursionDisp {

	public static VOExcursionDisp [] listadoExcursionesXBus(String mat){
		VOExcursionDisp [] arr=null;
		boolean error = false;
		String MSG = "";
		String MAT = mat.trim();
		if(MAT.equals(new String(""))){
			error=true;
			MSG = "Error la matricula no puede ser vacía";
		}
		if(!error){
			try {
				arr= managerIFachada.getInstancia().getIFachada().listadoExcursionesXBus(mat);
				if(arr.length == 0){
					JOptionPane.showMessageDialog(null,"No hay datos para listar", "Duck Boat Window", 2);
				}
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
		return arr;
	}
}

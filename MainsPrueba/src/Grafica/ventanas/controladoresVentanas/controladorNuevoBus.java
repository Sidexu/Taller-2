package Grafica.ventanas.controladoresVentanas;


import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBus;

public class controladorNuevoBus {

	
	public static void nuevoBus(String Matricula,String Marca,String Capacidad) {


		boolean error=false;
		String MSG = "";
		String MAT = Matricula.trim();
		if(MAT.equals(new String(""))){
			error=true;
			MSG = "Error la matricula no puede ser vacía";
		}else{
			String MARCA = Marca.trim();
			if(MARCA.equals(new String(""))){
				error=true;
				MSG = "Error la marca no puede ser vacía";
			}
		}	
		if(error == false){
			try{
				VOBus voB = new VOBus(Matricula,Marca,Integer.parseInt(Capacidad));
				try {
					managerIFachada.getInstancia().getIFachada().registroNuevoBus(voB);
					JOptionPane.showMessageDialog(null, "Bus ingresado correctamente", "Duck Boat Window", 1);
					} catch (ExcepcionPersistencia e) {
						JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
					} catch (ExcepcionRMI e) {
						JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
					}catch (ExcepcionBus e){
						JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
					}catch (RemoteException e){
						JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
					}
				
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Error, la capacidad debe de ser numerica y no superar los 100 asientos", "Duck Boat Window", 0);
			}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}
		
	}
}

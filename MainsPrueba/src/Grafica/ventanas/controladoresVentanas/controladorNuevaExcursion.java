package Grafica.ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import Grafica.ventanas.managerIFachada;
import Logica.Hora;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursion;

public class controladorNuevaExcursion {
	
	public static void nuevaExcursion(String Codigo,String Destino,String HrPartida,String HrPartidaMin,String HrRegreso,String HrRegresoMin,String Precio)
	{
			boolean error = false;
			
		
			String COD = Codigo.trim();
			if(COD.equals(new String(""))){
				error=true;
				JOptionPane.showMessageDialog(null,"Error el código no puede ser vacío", "Duck Boat Window", 0);
			}else{
				String DES = Destino.trim();
				if(DES.equals(new String(""))){
					error=true;
					JOptionPane.showMessageDialog(null,"Error el destino no puede ser vacío", "Duck Boat Window", 0);
				}
			}	
			
			if(!error){
				try{
					int hrp = Integer.parseInt(HrPartida);
					if(hrp >24 || hrp < 0){
						error=true;
						JOptionPane.showMessageDialog(null,"Error, la hora de partida debe estar comprendida entre 00 y 24", "Duck Boat Window", 0);
					}
				}catch(NumberFormatException e){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, la hora de partida debe de ser numerica", "Duck Boat Window", 0);
				}
			}
			
			if(!error){
				try{
					int hrpm = Integer.parseInt(HrPartidaMin);
					if(hrpm >59 || hrpm < 0){
						error=true;
						JOptionPane.showMessageDialog(null,"Error, los minutos de partida deben estar comprendids entre 00 y 59", "Duck Boat Window", 0);
					}
				}catch(NumberFormatException e){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, los minutos de partida deben de ser numericos", "Duck Boat Window", 0);
				}
			}
			
			if(!error){
				try{
					int hrr = Integer.parseInt(HrRegreso);
					if(hrr >24 || hrr < 0){
						error=true;
						JOptionPane.showMessageDialog(null,"Error, la hora de regreso debe estar comprendida entre 00 y 24", "Duck Boat Window", 0);
					}
				}catch(NumberFormatException e){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, la hora de regreso debe de ser numerica", "Duck Boat Window", 0);
				}
			}
			
			if(!error){
				try{
					int hrrm = Integer.parseInt(HrRegresoMin);
					if(hrrm >59 || hrrm < 0){
						error=true;
						JOptionPane.showMessageDialog(null,"Error, los minutos de regreso deben estar comprendids entre 00 y 59", "Duck Boat Window", 0);
					}	
				}catch(NumberFormatException e){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, los minutos de regreso deben de ser numericos", "Duck Boat Window", 0);
				}
			}
			
			if(!error){
				try{
					Float.parseFloat(Precio);
						Hora HrP = new Hora(Integer.parseInt(HrPartida),Integer.parseInt(HrPartidaMin));
						Hora HrR = new Hora(Integer.parseInt(HrRegreso),Integer.parseInt(HrRegresoMin));

						VOExcursion voE = new VOExcursion(Codigo,Destino,HrP,HrR,Float.parseFloat(Precio));
						
						try{
							managerIFachada.getInstancia().getIFachada().registroExcursion(voE);
							JOptionPane.showMessageDialog(null,"Excursión ingresada correctamente", "Duck Boat Window", 1);
						} catch (ExcepcionPersistencia e) {
							JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
						} catch (ExcepcionRMI e) {
							JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
						}catch (ExcepcionBus e){
							JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
						}catch (ExcepcionExcursion e){
							JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
						}catch (RemoteException e){
							JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
						}
					}catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Error, precio debe de ser numérico", "Duck Boat Window", 0);
					}catch (NullPointerException e){
						JOptionPane.showMessageDialog(null, "Error, precio no puede estar vacío", "Duck Boat Window", 0);
					}
			}
	}

}

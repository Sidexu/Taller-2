package Logica;
import java.util.ArrayList;

import Logica.valueObjects.*;

public class Fachada {
	private Buses buses;
	private Excursiones excursiones;
	
	//Requerimiento 1
	public void registroNuevoBus(VOBus vo){
		if(buses.memberBus(vo.getMatricula())){
			//error: bus ya existe
		}else{
			if(vo.getCapacidad()<0){
				//error: la capacidad no puede ser menor o igual a cero
			}else{
				Excursiones ex=new Excursiones();
				Bus v = new Bus(vo.getMatricula(),vo.getMarca(),vo.getCapacidad(),ex);
				buses.insertBus(v);
			}
		}
	}
	//Requerimiento 2
	public VOBusCant [] listadoGralBuses(){
		ArrayList<Bus> arr= new ArrayList<Bus>();
		arr= buses.listadoBuses();
		VOBusCant arrVO[]= new VOBusCant[arr.size()];
		
		for(int i=0;i<arr.size();i++){
			Bus b=arr.get(i);
			VOBusCant vobuscant= new VOBusCant(b.getMatricula(),b.getMarca(),b.getCapacidad(),b.getExc().tamExcursiones());
			arrVO[i]= vobuscant;
		}
		return arrVO;
	}
	//Requerimiento 3
	/*public VOExcursionDisp [] listadoExcursionesXBus(String mat){
		
		//HAY Q HACER EL MANEJO DE EXCEPCIONES
		if(!buses.memberBus(mat)){
			//error: la matricula no existe
		}else{
			Bus b=buses.findBus(mat);
			ArrayList<Excursion> arr= new ArrayList<Excursion>();
			arr= b.getExc().listarExcursiones();
			VOExcursionDisp arrVO []= new VOExcursionDisp[arr.size()];
			
			for(int i=0;i<arr.size();i++){
				Excursion ex=arr.get(i);
				int cant_disponibles=b.getCapacidad()-ex.getBoletos().tamBoletos();
				VOExcursionDisp vodisp= new VOExcursionDisp(ex.getCodigo(),ex.getDestino(),ex.getHr_partida(),ex.getHr_regreso(),ex.getPrecio_base(),cant_disponibles);
				arrVO[i]= vodisp;
			}
			return arrVO;
		}
	}*/
	//Requerimiento 4
	public void registroExcursion(VOExcursion vo){
		if(excursiones.memberExcursion(vo.getCodigo())){
			//error: la excursion ya existe
		}else{
			//VER EXCEPTION
			Bus b=buses.obtenerBusDisp(vo.getHr_partida(),vo.getHr_regreso(),0,"");
			Boletos bol=new Boletos();
			Excursion ex= new Excursion(vo.getCodigo(),vo.getDestino(),vo.getHr_partida(),vo.getHr_regreso(),vo.getPrecioBase(),b,bol); 
			excursiones.insertExcursion(ex);
			b.getExc().insertExcursion(ex);
		}
	}
	//Requerimiento 5
	public void reasignacionExcursion(String codigo){
		if(!excursiones.memberExcursion(codigo)){
			//error: la excursion no existe
		}else{
			Excursion ex=excursiones.findExcursion(codigo);
			String matriculaVieja=ex.getBus().getMatricula();
			//VER EXCEPTION
			Bus b=buses.obtenerBusDisp(ex.getHr_partida(),ex.getHr_regreso(),ex.getBoletos().tamBoletos(), matriculaVieja);
			//si obtengo un bus (sino exception)
			b.getExc().insertExcursion(ex);
			Bus bViejo=buses.findBus(matriculaVieja);
			bViejo.getExc().deleteExcursion(ex);
			ex.setBus(b);
		}
	}
	//Requerimiento 6
	public void respaldoDatos(){
		
	}
	//Requerimiento 7
	public void ventaBoleto(String codEx,VOBoleto vo, float desc){
		if(!excursiones.memberExcursion(codEx)){
			//error: la excursion no existe
		}else{
			Excursion ex=excursiones.findExcursion(codEx);
			int cant_disp=ex.getBus().getCapacidad()-ex.getBoletos().tamBoletos();
			if(cant_disp == 0){
				//error: no quedan asientos disponibles
			}else{
				if(desc == 0){//boleto comun
					Boleto b = new Boleto(vo.getNro_boleto(),vo.getEdad_pas(),vo.getLugar_procedencia(),vo.getCel_pas());
					ex.getBoletos().insert(b);
				}else{ //boleto especial
					Boleto b = new Especial(vo.getNro_boleto(),vo.getEdad_pas(),vo.getLugar_procedencia(),vo.getCel_pas(),desc); 
					ex.getBoletos().insert(b);
				}				
			}
		}
	}
	//Requerimiento 8
	public float recaudacionExcursion(String codEx){
		float montoTotal=0;
		if(!excursiones.memberExcursion(codEx)){
			//error: la excursion no existe
		}else{
			Excursion ex=excursiones.findExcursion(codEx);
			ArrayList<Boleto> arr= new ArrayList<Boleto>();
			arr=ex.getBoletos().listadoDeBoletos();
			
			for(int i=0;i<arr.size();i++){
				if(arr.get(i).tipoBoleto() == "comun"){
					if(arr.get(i).getEdad_pas() <= 12){
						montoTotal=(float) (montoTotal+(ex.getPrecio_base()*0.8));
					}else{
						montoTotal=(float) (montoTotal+ex.getPrecio_base());
					}
				}else{
					if(arr.get(i) instanceof Especial){
						if(arr.get(i).getEdad_pas() <= 12){
							montoTotal=(float) (montoTotal+(ex.getPrecio_base()*0.8)-((Especial) arr.get(i)).getDescuento());
						}else{
							montoTotal=(float) (montoTotal+ex.getPrecio_base()-((Especial) arr.get(i)).getDescuento());
						}
					}
				}
			}
		}
		return montoTotal;
	}
}

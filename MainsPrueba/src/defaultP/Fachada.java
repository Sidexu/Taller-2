package defaultP;
import java.util.ArrayList;

import Logica.Boleto;
import Logica.Boletos;
import Logica.Bus;
import Logica.Buses;
import Logica.Especial;
import Logica.Excursion;
import Logica.Excursiones;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.*;
import Persistencia.Respaldo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Fachada extends UnicastRemoteObject implements IFachada{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6371657270370176547L;
	private Buses buses;
	private Excursiones excursiones;
	private static Fachada instancia;

	//Singleton
    public static Fachada getInstance() throws RemoteException {
        if (instancia == null){
        	try {
				instancia = new Fachada();
			} catch (RemoteException e1) {
				throw new RemoteException(e1.getMessage());
			}
        }
        return instancia;
    }
	
	private Fachada() throws RemoteException {
		this.buses = new Buses();
		this.excursiones = new Excursiones();
	}
	
	public void setBuses(Buses b){
		this.buses=b;
	}
	
	public void setExcursiones(Excursiones e){
		this.excursiones=e;
	}
	
	//Requerimiento 1
	public void registroNuevoBus(VOBus vo) throws ExcepcionBus, RemoteException{
		if(buses.memberBus(vo.getMatricula())){
			String msg="Error! El Bus ya existe en el sistema.";
			throw new ExcepcionBus(msg);
		}else{
			if(vo.getCapacidad()<=0){
				String msg="Error! La capacidad del Bus no puede ser menor o igual a cero.";
				throw new ExcepcionBus(msg);
			}else{
				Excursiones ex=new Excursiones();
				Bus v = new Bus(vo.getMatricula(),vo.getMarca(),vo.getCapacidad(),ex);
				buses.insertBus(v);
			}
		}
	}
	//Requerimiento 2
	public VOBusCant [] listadoGralBuses() throws RemoteException{
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
	public VOExcursionDisp [] listadoExcursionesXBus(String mat) throws ExcepcionExcursion, RemoteException {
		if(!buses.memberBus(mat)){
			String msg="Error! La matricula ingresada no pertenece a un Bus.";
			throw new ExcepcionExcursion(msg);
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
	}
	//Requerimiento 4
	public void registroExcursion(VOExcursion vo) throws ExcepcionExcursion, ExcepcionBus, RemoteException {
		if(excursiones.memberExcursion(vo.getCodigo())){
			String msg= "Error! La excursion ingresada ya existe.";
			throw new ExcepcionExcursion(msg);
		}else{
			try{
			Bus b=buses.obtenerBusDisp(vo.getHr_partida(),vo.getHr_regreso(),0,"");
			Boletos bol=new Boletos();
			Excursion ex= new Excursion(vo.getCodigo(),vo.getDestino(),vo.getHr_partida(),vo.getHr_regreso(),vo.getPrecioBase(),b,bol); 
			excursiones.insertExcursion(ex);
			b.getExc().insertExcursion(ex);
			}catch(ExcepcionBus e){
				throw new ExcepcionBus(e.darMensaje());
			}
		}
	}
	//Requerimiento 5
	public void reasignacionExcursion(String codigo) throws ExcepcionExcursion, ExcepcionBus, RemoteException{
		if(!excursiones.memberExcursion(codigo)){
			String msg = "Error! El código ingresado no pertenece a ninguna Excursión.";
			throw new ExcepcionExcursion(msg);
		}else{
			try{
				Excursion ex=excursiones.findExcursion(codigo);
				String matriculaVieja=ex.getBus().getMatricula();
				Bus b=buses.obtenerBusDisp(ex.getHr_partida(),ex.getHr_regreso(),ex.getBoletos().tamBoletos(), matriculaVieja);
				b.getExc().insertExcursion(ex);
				Bus bViejo=buses.findBus(matriculaVieja);
				bViejo.getExc().deleteExcursion(ex);
				ex.setBus(b);
			}catch(ExcepcionBus e){
				throw new ExcepcionBus(e.darMensaje());
			}
		}
	}
	//Requerimiento 6
	public void respaldoDatos() throws ExcepcionPersistencia, RemoteException{
		VOPersistencia vo = new VOPersistencia(buses, excursiones);
		Respaldo r = new Respaldo();
		try {
			r.respaldar("respaldo.dat", vo);
		} catch (ExcepcionPersistencia e) {
			throw new ExcepcionPersistencia(e.darMensaje());
		}
	}
	//Requerimiento 7
	public void ventaBoleto(String codEx,VOBoletoTipo vo) throws ExcepcionExcursion, ExcepcionBus, RemoteException{
		if(!excursiones.memberExcursion(codEx)){
			String msg = "La excursion no existe";
			throw new ExcepcionExcursion(msg);
		}else{
			Excursion ex=excursiones.findExcursion(codEx);
			int cant_disp=ex.getBus().getCapacidad()-ex.getBoletos().tamBoletos();
			if(cant_disp == 0){
				String msg2 = "No quedan asientos disponibles";
				throw new ExcepcionBus(msg2);
			}else{
				if(vo.getDescuento() == 0){//boleto comun
					Boleto b = new Boleto(vo.getNro_boleto(),vo.getEdad_pas(),vo.getLugar_procedencia(),vo.getCel_pas());
					ex.getBoletos().insert(b);
				}else{ //boleto especial
					Boleto b = new Especial(vo.getNro_boleto(),vo.getEdad_pas(),vo.getLugar_procedencia(),vo.getCel_pas(),vo.getDescuento()); 
					ex.getBoletos().insert(b);
				}				
			}
		}
	}
	//Requerimiento 8
	public float recaudacionExcursion(String codEx) throws ExcepcionExcursion, RemoteException{
		float montoTotal=0;
		if(!excursiones.memberExcursion(codEx)){
			String msg = "No existe la excursion";
			throw new ExcepcionExcursion(msg);
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

	//REQUERIMIENTO 9
	public VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) throws ExcepcionExcursion, RemoteException{
		ArrayList<Boleto> arr = new ArrayList<Boleto>();
		VOBoletoTipo arrVO[]; 
		if(!excursiones.memberExcursion(codigo)){
			String msg = "No existe la excursion";
			throw new ExcepcionExcursion(msg);
		}else{
			Excursion exc = excursiones.findExcursion(codigo);
			arr= exc.getBoletos().listadoBoletoXTipo(tipoBoleto);
			arrVO = new VOBoletoTipo[arr.size()];
			for(int i=0; i<arr.size(); i++){
					Boleto b = arr.get(i);
					if(tipoBoleto=="especial"){
						if(b instanceof Especial){
							arrVO[i]= new VOBoletoTipo(arr.get(i).getNroboleto(), arr.get(i).getEdad_pas(), arr.get(i).getLugar_procedencia(), arr.get(i).getCel_pas(),((Especial)arr.get(i)).getDescuento());
						}
					}else{
						arrVO[i]= new VOBoletoTipo(arr.get(i).getNroboleto(), arr.get(i).getEdad_pas(), arr.get(i).getLugar_procedencia(), arr.get(i).getCel_pas(), 0);
					}
			}
		}
		return arrVO;
	}
	
	//REQUERIMIENTO 10
	public VOExcursionDisp[] excursionesXDestino(String destino) throws RemoteException{
		ArrayList<Excursion> arrExc = new ArrayList<Excursion>();
		arrExc = excursiones.listarExcursionesPorDestino(destino);
		VOExcursionDisp arrVO[] = new VOExcursionDisp[arrExc.size()];
		for(int i=0; i<arrExc.size(); i++){
			int cantidadDisponible = arrExc.get(i).getBus().getCapacidad() - arrExc.get(i).getBoletos().tamBoletos();
			arrVO[i] = new VOExcursionDisp(arrExc.get(i).getCodigo(), arrExc.get(i).getDestino(), arrExc.get(i).getHr_partida(), arrExc.get(i).getHr_regreso(), arrExc.get(i).getPrecio_base(), cantidadDisponible);
		}
		return arrVO;
	}
	
	//REQUERIMIENTO 11
	public VOExcursionDisp[] excursionesXPrecio(float precio1, float precio2) throws RemoteException{
		ArrayList<Excursion> arrExc = new ArrayList<Excursion>();
		arrExc = excursiones.listarExcursionesPorPrecio(precio1, precio2);
		VOExcursionDisp arrVO[] = new VOExcursionDisp[arrExc.size()];
		for(int i=0; i<arrExc.size(); i++){
			int cantidadDisponible = arrExc.get(i).getBus().getCapacidad() - arrExc.get(i).getBoletos().tamBoletos();
			arrVO[i] = new VOExcursionDisp(arrExc.get(i).getCodigo(), arrExc.get(i).getDestino(), arrExc.get(i).getHr_partida(), arrExc.get(i).getHr_regreso(), arrExc.get(i).getPrecio_base(), cantidadDisponible);
		}
		return arrVO;
	}
	
	
}

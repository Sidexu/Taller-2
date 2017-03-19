package defaultP;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Logica.Boleto;
import Logica.Boletos;
import Logica.Bus;
import Logica.Buses;
import Logica.Especial;
import Logica.Excursion;
import Logica.Excursiones;
import Logica.Monitor1;
import Logica.Excepciones.ExcepcionBus;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOBusCant;
import Logica.valueObjects.VOExcursion;
import Logica.valueObjects.VOExcursionDisp;
import Logica.valueObjects.VOPersistencia;
import Persistencia.Respaldo;

public class Fachada extends UnicastRemoteObject implements IFachada{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6371657270370176547L;
	private Buses buses;
	private Excursiones excursiones;
	private static Fachada instancia;
	private Monitor1 m; //VA STATIC?

	//Singleton
    public static Fachada getInstance() throws RemoteException, ExcepcionPersistencia {
        if (instancia == null){
			instancia = new Fachada();
        }
        return instancia;
    }
    
	
	private Fachada() throws RemoteException, ExcepcionPersistencia {
		this.buses = new Buses();
		this.excursiones = new Excursiones();
		this.m = new Monitor1();

		Respaldo r = new Respaldo();
		VOPersistencia voPers = new VOPersistencia(buses,excursiones);
		try {
			voPers=r.recuperar("respaldo.dat");
			buses=voPers.getBuses();
			excursiones=voPers.getExcursiones();
		} catch (ExcepcionPersistencia e) {
			this.respaldoDatos();
			throw new ExcepcionPersistencia("Se genera archivo vacío");
		}
	}
	
	
	//Requerimiento 1
	public void registroNuevoBus(VOBus vo) throws ExcepcionBus, RemoteException{
		m.comenzarEscritura();
		if(buses.memberBus(vo.getMatricula())){
			String msg="Error! El Bus ya existe en el sistema.";
			m.escrituraTerminada();
			throw new ExcepcionBus(msg);
		}else{
			if(vo.getCapacidad()<=0 || vo.getCapacidad()>100 ){
				String msg="Error! La capacidad del Bus no puede ser menor o igual a cero, ni mayor a 100.";
				m.escrituraTerminada();
				throw new ExcepcionBus(msg);
			}else{
				Excursiones ex=new Excursiones();
				Bus v = new Bus(vo.getMatricula(),vo.getMarca(),vo.getCapacidad(),ex);
				buses.insertBus(v);
				m.escrituraTerminada();
			}
		}
	}
	//Requerimiento 2
	public VOBusCant [] listadoGralBuses() throws RemoteException{
		ArrayList<Bus> arr= new ArrayList<Bus>();
		m.comenzarLectura();
		arr= buses.listadoBuses();
		VOBusCant arrVO[]= new VOBusCant[arr.size()];
		
		for(int i=0;i<arr.size();i++){
			Bus b=arr.get(i);
			VOBusCant vobuscant= new VOBusCant(b.getMatricula(),b.getMarca(),b.getCapacidad(),b.getExc().tamExcursiones());
			arrVO[i]= vobuscant;
		}
		m.lecturaTerminada();
		return arrVO;
	}
	//Requerimiento 3
	public VOExcursionDisp [] listadoExcursionesXBus(String mat) throws ExcepcionExcursion, RemoteException {
		m.comenzarLectura();
		if(!buses.memberBus(mat)){
			String msg="Error! La matricula ingresada no pertenece a un Bus.";
			m.lecturaTerminada();
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
			m.lecturaTerminada();
			return arrVO;
		}
	}
	//Requerimiento 4
	public void registroExcursion(VOExcursion vo) throws ExcepcionExcursion, ExcepcionBus, RemoteException {
		m.comenzarEscritura();
		if(excursiones.memberExcursion(vo.getCodigo())){
			String msg= "Error! La excursion ingresada ya existe.";
			m.escrituraTerminada();
			throw new ExcepcionExcursion(msg);
		}else{
			if(vo.getHr_regreso().esMenorIgual(vo.getHr_partida())){
				String msg= "Error! La hora de regreso no puede ser menor a la hora de partida.";
				m.escrituraTerminada();
				throw new ExcepcionExcursion(msg);
			}else{
				try{
					Boletos bol=new Boletos();
					Bus b=buses.obtenerBusDisp(vo.getHr_partida(),vo.getHr_regreso(),0,"");	
					Excursion ex= new Excursion(vo.getCodigo(),vo.getDestino(),vo.getHr_partida(),vo.getHr_regreso(),vo.getPrecioBase(),b,bol); 
					excursiones.insertExcursion(ex);
					b.getExc().insertExcursion(ex);
					m.escrituraTerminada();
				}catch(ExcepcionBus e){
					m.escrituraTerminada();
					throw new ExcepcionBus(e.darMensaje());
				}
			}
		}
	}
	//Requerimiento 5
	public String reasignacionExcursion(String codigo) throws ExcepcionExcursion, ExcepcionBus, RemoteException{
		String matBusReasignado="";
		m.comenzarEscritura();
		if(!excursiones.memberExcursion(codigo)){
			String msg = "Error! El código ingresado no pertenece a ninguna Excursión.";
			m.escrituraTerminada();
			throw new ExcepcionExcursion(msg);
		}else{
			try{
				Excursion ex=excursiones.findExcursion(codigo);
				String matriculaVieja=ex.getBus().getMatricula();
				Bus b=buses.obtenerBusDisp(ex.getHr_partida(),ex.getHr_regreso(),ex.getBoletos().tamBoletos(), matriculaVieja);
				Bus bViejo=buses.findBus(matriculaVieja);
				bViejo.getExc().deleteExcursion(ex);
				ex.setBus(b);
				b.getExc().insertExcursion(ex);
				int capacidadRestante=b.getCapacidad()-ex.getBoletos().tamBoletos();
				matBusReasignado=b.getMatricula()+" con asientos restantes disponibles: "+capacidadRestante;
				m.escrituraTerminada();
			}catch(ExcepcionBus e){
				m.escrituraTerminada();
				throw new ExcepcionBus(e.darMensaje());
			}
		}
		return matBusReasignado;
	}
	//Requerimiento 6
	public void respaldoDatos() throws ExcepcionPersistencia, RemoteException{
		m.comenzarEscritura();
		VOPersistencia vo = new VOPersistencia(buses, excursiones);
		Respaldo r = new Respaldo();
		try {
			r.respaldar("respaldo.dat", vo);
			m.escrituraTerminada();
		} catch (ExcepcionPersistencia e) {
			m.escrituraTerminada();
			throw new ExcepcionPersistencia(e.darMensaje());
		}
	}
	//Requerimiento 7
	public String ventaBoleto(String codEx,VOBoletoTipo vo) throws ExcepcionExcursion, ExcepcionBus, RemoteException{
		String asientosDisp="";
		m.comenzarEscritura();
		if(!excursiones.memberExcursion(codEx)){
			String msg = "La excursion no existe";
			m.escrituraTerminada();
			throw new ExcepcionExcursion(msg);
		}else{
			Excursion ex=excursiones.findExcursion(codEx);
			int cant_disp=ex.getBus().getCapacidad()-ex.getBoletos().tamBoletos();
			if(cant_disp == 0){
				String msg2 = "No quedan asientos disponibles";
				m.escrituraTerminada();
				throw new ExcepcionBus(msg2);
			}else{
				if(ex.getPrecio_base()<vo.getDescuento()){
					String msg3="El descuento no puede ser mayor al precio base de la Excursion ($"+ex.getPrecio_base()+")";
					m.escrituraTerminada();
					throw new ExcepcionExcursion(msg3);
				}else{
					int total=cant_disp-1;
					asientosDisp=" Cantidad de asientos disponibles: "+total;
					if(vo.getDescuento() == 0){//boleto comun
						Boleto b = new Boleto(excursiones.findExcursion(codEx).getBoletos().tamBoletos()+1,vo.getEdad_pas(),vo.getLugar_procedencia(),vo.getCel_pas());
						ex.getBoletos().insert(b);
						m.escrituraTerminada();
					}else{ //boleto especial
						Boleto b = new Especial(excursiones.findExcursion(codEx).getBoletos().tamBoletos()+1,vo.getEdad_pas(),vo.getLugar_procedencia(),vo.getCel_pas(),vo.getDescuento()); 
						ex.getBoletos().insert(b);
						m.escrituraTerminada();
					}		
				}		
			}
		}
		return asientosDisp;
	}
	//Requerimiento 8
	public float recaudacionExcursion(String codEx) throws ExcepcionExcursion, RemoteException{
		float montoTotal=0;
		m.comenzarLectura();
		if(!excursiones.memberExcursion(codEx)){
			String msg = "No existe la excursion";
			m.lecturaTerminada();
			throw new ExcepcionExcursion(msg);
		}else{
			Excursion ex=excursiones.findExcursion(codEx);
			ArrayList<Boleto> arr= new ArrayList<Boleto>();
			arr=ex.getBoletos().listadoDeBoletos();
			
			for(int i=0;i<arr.size();i++){
				if(arr.get(i).tipoBoleto().equals("comun")){
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
			m.lecturaTerminada();
		}
		return montoTotal;
	}

	//REQUERIMIENTO 9
		public VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) throws ExcepcionExcursion, RemoteException{
			m.comenzarLectura();
			ArrayList<Boleto> arr = new ArrayList<Boleto>();
			VOBoletoTipo arrVO[]; 
			if(!excursiones.memberExcursion(codigo)){
				String msg = "No existe la excursion";
				m.lecturaTerminada();
				throw new ExcepcionExcursion(msg);
			}else{
				Excursion exc = excursiones.findExcursion(codigo);
				arr= exc.getBoletos().listadoBoletoXTipo(tipoBoleto);
				arrVO = new VOBoletoTipo[arr.size()];
				for(int i=0; i<arr.size(); i++){
						if(arr.get(i).tipoBoleto().equals(tipoBoleto) && tipoBoleto.equals("especial") ){
							Especial e = (Especial) arr.get(i);
								arrVO[i]= new VOBoletoTipo(e.getNroboleto(),e.getEdad_pas(),e.getLugar_procedencia(), e.getCel_pas(),e.getDescuento());
						}else{
							arrVO[i]= new VOBoletoTipo(arr.get(i).getNroboleto(), arr.get(i).getEdad_pas(), arr.get(i).getLugar_procedencia(), arr.get(i).getCel_pas(), 0);
						}
				}
				m.lecturaTerminada();
			}
			return arrVO;
		}
		
	
	//REQUERIMIENTO 10
	public VOExcursionDisp[] excursionesXDestino(String destino) throws RemoteException{
		m.comenzarLectura();
		ArrayList<Excursion> arrExc = new ArrayList<Excursion>();
		arrExc = excursiones.listarExcursionesPorDestino(destino);
		VOExcursionDisp arrVO[] = new VOExcursionDisp[arrExc.size()];
		for(int i=0; i<arrExc.size(); i++){
			int cantidadDisponible = arrExc.get(i).getBus().getCapacidad() - arrExc.get(i).getBoletos().tamBoletos();
			arrVO[i] = new VOExcursionDisp(arrExc.get(i).getCodigo(), arrExc.get(i).getDestino(), arrExc.get(i).getHr_partida(), arrExc.get(i).getHr_regreso(), arrExc.get(i).getPrecio_base(), cantidadDisponible);
		}
		m.lecturaTerminada();
		return arrVO;
	}
	
	//REQUERIMIENTO 11
	public VOExcursionDisp[] excursionesXPrecio(float precio1, float precio2) throws RemoteException{
		m.comenzarLectura();
		ArrayList<Excursion> arrExc = new ArrayList<Excursion>();
		arrExc = excursiones.listarExcursionesPorPrecio(precio1, precio2);
		VOExcursionDisp arrVO[] = new VOExcursionDisp[arrExc.size()];
		for(int i=0; i<arrExc.size(); i++){
			int cantidadDisponible = arrExc.get(i).getBus().getCapacidad() - arrExc.get(i).getBoletos().tamBoletos();
			arrVO[i] = new VOExcursionDisp(arrExc.get(i).getCodigo(), arrExc.get(i).getDestino(), arrExc.get(i).getHr_partida(), arrExc.get(i).getHr_regreso(), arrExc.get(i).getPrecio_base(), cantidadDisponible);
		}
		m.lecturaTerminada();
		return arrVO;
	}
	
	
}

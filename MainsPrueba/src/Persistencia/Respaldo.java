package Persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Logica.Excepciones.ExcepcionPersistencia;
import Logica.valueObjects.VOPersistencia;

public class Respaldo {
	public void respaldar (String nomArch, VOPersistencia vo) throws ExcepcionPersistencia{
		try{
			//abro el archivo y creo un flujo de comunicacion hacia el
			FileOutputStream f = new FileOutputStream(nomArch);
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			//escribo el arreglo de buses en el archivo a traves del flujo
			o.writeObject(vo);
			o.close();
			f.close();
		}catch(IOException e){
			throw new ExcepcionPersistencia("Error al respaldar");
		}
	}
	public  VOPersistencia recuperar (String nomArch) throws ExcepcionPersistencia{
		try{ 
			// Abro el archivo y creo un flujo de comunicación hacia él
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);

			// Leo el arreglo de vehículos desde el archivo a través del flujo
			VOPersistencia VOPersistencia = (VOPersistencia) o.readObject();
			o.close();
			f.close();
			return VOPersistencia;
		}catch (IOException | ClassNotFoundException  e){ 
			throw new ExcepcionPersistencia("Error al recuperar");
		}
	}
}

package xml.clasessax;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Creo mi propia clase que hereda de HashMap y sobrescribo el método toString para modificar
 * lo que yo quiero de la salida por pantalla.
 * Elimino el formato que por defecto utiliza HashMap que no me gusta.
 * @author Diego Santamaría
 *
 */
public class MiHashMap extends HashMap<String, Libro> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiHashMap () {
		// TODO Auto-generated constructor stub
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		
		// Lo que hago es sobreescribir el método toString de la clase HasMap para que visualice
			// como yo quiera. 
		String str_dev = "";
		
		// utilizo el Iterator para recorrer el hashmap y poner mi formato que es simplemente un salto 
		// de línea
		Iterator it_librop = values().iterator();
		while(it_librop.hasNext()){
			str_dev+=it_librop.next()+"\n";
		}
			
			return str_dev;
		
		
		
	}

	
	
	
}

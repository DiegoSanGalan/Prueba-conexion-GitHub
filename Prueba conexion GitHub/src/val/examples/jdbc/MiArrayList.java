package val.examples.jdbc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para hacer mi version de toString() de ArrayList
 * @author Diego Santamaria
 *
 */
public class MiArrayList extends ArrayList<Empleados>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4850328615888126143L;
	
	public MiArrayList ()
	{
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
		Iterator<Empleados> it_empleados = super.iterator() ;
				while(it_empleados.hasNext()){
					str_dev+=it_empleados.next()+"\n";
				}
					
					return str_dev;
					
				
		
		
		//return  super.toString() ;
	}

}

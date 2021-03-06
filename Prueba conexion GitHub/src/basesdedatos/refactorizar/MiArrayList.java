package basesdedatos.refactorizar;

import java.util.ArrayList;
import java.util.Iterator;

public class MiArrayList extends ArrayList<EmpleadoDTO>{

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
		
		// Lo que hago es sobreescribir el m�todo toString de la clase HasMap para que visualice
					// como yo quiera. 
		String str_dev = "";
				
		// utilizo el Iterator para recorrer el hashmap y poner mi formato que es simplemente un salto 
		// de l�nea
		Iterator<EmpleadoDTO> it_empleados = super.iterator() ;
				while(it_empleados.hasNext()){
					str_dev+=it_empleados.next()+"\n";
				}
					
					return str_dev;
					
				
		
		
		//return  super.toString() ;
	}

}

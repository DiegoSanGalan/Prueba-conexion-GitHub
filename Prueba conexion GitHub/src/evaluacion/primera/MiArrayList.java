package evaluacion.primera;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para hacer mi version de toString() de ArrayList
 * @author Diego Santamaria
 *
 */
public class MiArrayList extends ArrayList<RegionDTO>{

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
		
		String str_dev = "";
				
		
		Iterator<RegionDTO> it_regiones = super.iterator() ;
				while(it_regiones.hasNext()){
					str_dev += it_regiones.next()+"\n";
				}
					
		return str_dev;
	}

}

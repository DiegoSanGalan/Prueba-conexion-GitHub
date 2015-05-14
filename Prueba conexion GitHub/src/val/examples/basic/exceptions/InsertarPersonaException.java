package val.examples.basic.exceptions;

import val.examples.basic.ListaPersonas;

public class InsertarPersonaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2039058661347095352L;
	public static final String mensaje = "Numero de personas excecido. Máximo " + ListaPersonas.CAPACIDAD + " personas";
	

}

package excepcionespropias;



/**
 * Clase para la excepci�n que genera el sobrepasar el l�mite de elementos
 * del array de String
 * @author Diego Santamar�a Gal�n
 *
 */
@SuppressWarnings("serial")
public class InsertarPersonaException extends Exception {
	
	public InsertarPersonaException (String mensajeError)
	{
		super (mensajeError);
	}
	
}

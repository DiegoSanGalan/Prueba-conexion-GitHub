package excepcionespropias;



/**
 * Clase para la excepción que genera el sobrepasar el límite de elementos
 * del array de String
 * @author Diego Santamaría Galán
 *
 */
@SuppressWarnings("serial")
public class InsertarPersonaException extends Exception {
	
	public InsertarPersonaException (String mensajeError)
	{
		super (mensajeError);
	}
	
}

package excepcionespropias;



/**
 * Clase para la excepci�n que genera al sobrepasar el l�mite de elementos
 * del array de objetos
 * @author Diego Santamar�a Gal�n
 *
 */
@SuppressWarnings("serial")
public class InsertarPersonaException extends Exception {
	
	
	/**
	 * Constructor de la clase para crear el objeto de la clase InsertarPersonaException
	 * @param mensajeError Tipo String con el mensaje que queramos mostrar
	 */
	public InsertarPersonaException (String mensajeError)
	{
		super (mensajeError); // llama a la clase padre Exception y le env�a el mensaje que queremos mostrar.
	}
	
}

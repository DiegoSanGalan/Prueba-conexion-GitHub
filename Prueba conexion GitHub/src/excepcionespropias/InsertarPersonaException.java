package excepcionespropias;



/**
 * Clase para la excepción que genera al sobrepasar el límite de elementos
 * del array de objetos
 * @author Diego Santamaría Galán
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
		super (mensajeError); // llama a la clase padre Exception y le envía el mensaje que queremos mostrar.
	}
	
}

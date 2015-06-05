package evaluacion.primera;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Utilizaremos �sta interface para hacer cualquier clase que hagamos DAO
 * @author Diego Santamar�a
 *
 */
public interface InterfaceDAO <Generico>{

	// Voy a utilizar generic para poder hacerlo funcionar con cualquier base de datos
	/**
	 * M�todo para crear un registro nuevo en la Base de Datos
	 * @param c Tipo Generico
	 * @return booleano indicando true si se cre� correctamente
	 */
	public boolean crear(Generico c);
	
	// utilizo tipo Object para que nos sirva con cualquiera
	/**
	 * M�todo para eliminar un registro de la Base de Datos
	 * @param claveId Tipo Generico
	 * @return booleano indicando true si borr� correctamente
	 * @throws SQLException 
	 */
	public boolean borrar(Object claveId);
	
	/**
	 * M�todo para actualizar en la base de datos
	 * @param c Tipo Object
	 * @return booleano indicando true si se actualiz� correctamente
	 */
	public boolean actualizar(Generico c);
	
	
	/**
	 * M�todo para leer por ID
	 * @param claveId tipo Object
	 * @return tipo Generico
	 */
	public Generico leer(Object claveId);
	
	
	/**
	 * M�todo para recuperar todos los registros de la Base de Datos
	 * @return ArrayList
	 */
	public ArrayList<Generico> leerTodos();
	
	
	
}

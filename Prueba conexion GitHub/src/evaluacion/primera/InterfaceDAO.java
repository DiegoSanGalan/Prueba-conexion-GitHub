package evaluacion.primera;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Utilizaremos ésta interface para hacer cualquier clase que hagamos DAO
 * @author Diego Santamaría
 *
 */
public interface InterfaceDAO <Generico>{

	// Voy a utilizar generic para poder hacerlo funcionar con cualquier base de datos
	/**
	 * Método para crear un registro nuevo en la Base de Datos
	 * @param c Tipo Generico
	 * @return booleano indicando true si se creó correctamente
	 */
	public boolean crear(Generico c);
	
	// utilizo tipo Object para que nos sirva con cualquiera
	/**
	 * Método para eliminar un registro de la Base de Datos
	 * @param claveId Tipo Generico
	 * @return booleano indicando true si borró correctamente
	 * @throws SQLException 
	 */
	public boolean borrar(Object claveId);
	
	/**
	 * Método para actualizar en la base de datos
	 * @param c Tipo Object
	 * @return booleano indicando true si se actualizó correctamente
	 */
	public boolean actualizar(Generico c);
	
	
	/**
	 * Método para leer por ID
	 * @param claveId tipo Object
	 * @return tipo Generico
	 */
	public Generico leer(Object claveId);
	
	
	/**
	 * Método para recuperar todos los registros de la Base de Datos
	 * @return ArrayList
	 */
	public ArrayList<Generico> leerTodos();
	
	
	
}

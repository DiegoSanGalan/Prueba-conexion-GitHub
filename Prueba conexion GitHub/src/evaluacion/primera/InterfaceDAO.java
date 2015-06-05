package evaluacion.primera;

import java.util.ArrayList;

/**
 * Utilizaremos ésta interface para hacer cualquier clase que hagamos DAO
 * @author Diego Santamaría
 *
 */
public interface InterfaceDAO <Generico>{

	// Voy a utilizar generic para poder hacerlo funcionar con cualquier base de datos
	public boolean crear(Generico c);
	
	// utilizo tipo Object para que nos sirva con cualquiera
	public boolean borrar(Object claveId);
	public boolean actualizar(Generico c);
	
	public Generico leer(Object claveId);
	public ArrayList<Generico> leerTodos();
	
	
	
}

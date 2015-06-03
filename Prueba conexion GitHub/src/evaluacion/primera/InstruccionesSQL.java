package evaluacion.primera;


/**
 * Clase Instrucciones SQL para añadir las instrucciones que vayamos a usar en la BD
 * @author Diego Santamaría
 *
 */
public class InstruccionesSQL {

	static public final String RECUPERAR_POR_ID = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
	static public final String RECUPERAR_TODOS = "SELECT * FROM REGIONS";
	static public final String INSERTAR_NUEVO_REGISTRO = "INSERT"; // MIRAR COMO HACER EL INSERT
	
	
}

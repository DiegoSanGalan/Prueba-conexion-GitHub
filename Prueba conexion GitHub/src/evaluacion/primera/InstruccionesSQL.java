package evaluacion.primera;


/**
 * Clase Instrucciones SQL para añadir las instrucciones que vayamos a usar en la BD
 * @author Diego Santamaría
 *
 */
public class InstruccionesSQL {

	static public final String SQL_RECUPERAR_POR_ID = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
	static public final String SQL_RECUPERAR_TODOS = "SELECT * FROM REGIONS";
	static public final String SQL_INSERTAR_NUEVO_REGISTRO = "INSERT INTO REGIONS (REGION_NAME) VALUES (?)"; // MIRAR COMO HACER EL INSERT
	static public final String SQL_ACTUALIZAR = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
	static public final String SQL_BORRAR = "DELETE FROM REGIONS WHERE REGION_ID =?";
	
	// ************ INSTRUCCION SQL PARA INSERTAR REGISTROS EN LA BD **********************
	/*INSERT INTO <nombre_tabla> 
	[(<campo1>[,<campo2>,...])]
	values 
	(<valor1>,<valor2>,...);
	*/
}

package evaluacion.primera;

import java.sql.Connection;

/**
 * Clase RegionDAO para Acceso a datos de la BD
 * @author Diego Santamaría
 *
 */
public class RegionDAO {
	
	ConexionDB con  = null;
	

	/**
	 * Constructor de la clase
	 */
	public RegionDAO ()
	{
		
	}
	
	// Obtener conexion a la base de datos
	public void conectar ()
	{
		con = ConexionDB.obtenerConexion();
	}
	
	/**
	 * Recibe el identificador y ejecuta la consulta buscando
	 * @param id Tipo int con el id a buscar
	 */
	public void ejecutarSQL (int id)
	{
		prstmt = conn.prepareStatement(InstruccionesSQL.RECUPERAR_POR_ID);
		rset = prstmt.executeQuery();
		
		
		return rset;
	}
	
	
	/**
	 * Recibe un objeto RegionDTO lo inserta .Ejecuta SQL 
	 * @param regionDTO del Tipo RegionDTO
	 */
	public void ejecutarSQL (RegionDTO regionDTO)
	{
		prstmt = conn.prepareStatement(InstruccionesSQL.INSERTAR_NUEVO_REGISTRO);
		rset = prstmt.executeQuery();
	}
	
	/**
	 * Si llamo sin parametros recupero todos
	 */
	public void ejecutarSQL ()
	{
		prstmt = conn.prepareStatement(InstruccionesSQL.RECUPERAR_TODOS);
		rset = prstmt.executeQuery();
	}
	// Ejecutar la instruccionSQL dependiendo del parámetro recibido
	
	
	// 
}

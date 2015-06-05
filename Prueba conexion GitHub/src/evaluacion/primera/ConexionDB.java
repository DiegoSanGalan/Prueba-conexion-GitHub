package evaluacion.primera;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Savepoint;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

//import basesdedatos.refactorizar.InstruccionesSQL;


/**
 * Clase ConexionDB para crear las conexiones a la base de datos
 * @author Diego Santamaría
 *
 */
public class ConexionDB  {
	
	private static ConexionDB conn = new ConexionDB();
	
	// ***********************************************
	// ****** PARAMETROS DE LA CONEXION **************
	// ***********************************************
		private final String TEXT_DRIVER = "oracle.jdbc.driver.OracleDriver";
		private final String TEXT_CONECTAR_BASE_DATOS = "jdbc:oracle:thin:@localhost:1521:xe";
		private final String TEXT_USUARIO = "HR";
		private final String TEXT_PASS = "DIESAN666";
	// ***********************************************
	//********* PARÁMETROS DE LA CONEXION *************	
	//*************************************************	
		private static Connection c = null;
		
		
	
	/**
	 * Constructor privado Metodo Singleton
	 * 
	 */
	private ConexionDB () 
	{
		// Constructor de la Clase Vacio y Privado
	}
	
	/**
	 * Método Público para obtener la conexión
	 * @return Tipo Connection
	 * @throws SQLException 
	 */
	public static Connection obtenerConexion () throws SQLException
	{
		return conn.conectarBD();
	}
	
	/**
	 * Método para realizar las operaciones de conexion a la Base de Datos
	 * @return Tipo Connection
	 * @throws SQLException 
	 */
	private Connection conectarBD() throws SQLException {
		
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		try {
			Class.forName(TEXT_DRIVER);//ejecuta el bloque static de la clase. Que contiene
							//DriverManager.registerDriver (System.out.println(listaEmpleados.toString())
			c =  DriverManager.getConnection (TEXT_CONECTAR_BASE_DATOS, TEXT_USUARIO, TEXT_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (c!=null)
		{
		
			c.setAutoCommit(false);
		
		}
		
		return c;
	}

	/**
	 * Método para liberar la conexion
	 */
	public  static void liberarRecursos()
	{
		if (c != null) 	{ try {  c.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}

}

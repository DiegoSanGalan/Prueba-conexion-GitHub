package evaluacion.primera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import basesdedatos.refactorizar.InstruccionesSQL;


/**
 * Clase ConexionDB para crear las conexiones a la base de datos
 * @author Diego Santamaría
 *
 */
public class ConexionDB {
	
	private static ConexionDB conn = new ConexionDB();
	
	// PARAMETROS DE LA CONEXION
		private final String TEXT_DRIVER = "oracle.jdbc.driver.OracleDriver";
		private final String TEXT_CONECTAR_BASE_DATOS = "jdbc:oracle:thin:@localhost:1521:xe";
		private final String TEXT_USUARIO = "HR";
		private final String TEXT_PASS = "DIESAN666";
		
		static ResultSet rset = null;
		static Statement stmt = null;
		static PreparedStatement prstmt = null;
	
	/**
	 * Constructor privado Metodo Singleton
	 * @throws SQLException 
	 */
	private ConexionDB () 
	{
		//InstruccionesSQL instruccion = new InstruccionesSQL ();
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		try {
			Class.forName(TEXT_DRIVER);//ejecuta el bloque static de la clase. Que contiene
							//DriverManager.registerDriver (System.out.println(listaEmpleados.toString())
		
			conn = (ConexionDB) DriverManager.getConnection (TEXT_CONECTAR_BASE_DATOS, TEXT_USUARIO, TEXT_PASS);
	        stmt = ((Connection) conn).createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ConexionDB obtenerConexion ()
	{
		return conn;
	}
	
	
	public static void liberarRecursos()
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { ((Connection) conn).close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}

}

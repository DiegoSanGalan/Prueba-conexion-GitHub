package evaluacion.primera;

import java.sql.Connection;
import java.sql.DriverManager;

import basesdedatos.refactorizar.InstruccionesSQL;


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
	
	/**
	 * Constructor privado Metodo Singleton
	 */
	private ConexionDB ()
	{
		InstruccionesSQL instruccion = new InstruccionesSQL ();
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		try {
			Class.forName(TEXT_DRIVER);//ejecuta el bloque static de la clase. Que contiene
							//DriverManager.registerDriver (System.out.println(listaEmpleados.toString())
		
		conn = DriverManager.getConnection (TEXT_CONECTAR_BASE_DATOS, TEXT_USUARIO, TEXT_PASS);
	        stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ConexionDB obtenerConexion ()
	{
		return conn;
	}

}

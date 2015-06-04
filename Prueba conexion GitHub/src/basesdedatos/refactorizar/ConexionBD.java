package basesdedatos.refactorizar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import val.examples.threads.Taquilla;

public class ConexionBD {

	// PARAMETROS DE LA CONEXION
	private final String TEXT_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String TEXT_CONECTAR_BASE_DATOS = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String TEXT_USUARIO = "HR";
	private final String TEXT_PASS = "DIESAN666";
	
	//creamos un atributo que es la creacion del único objeto de la clase
	// desde aqui si podemos crear un objeto con el constructor private porque estamos en
	// la misma clase  PATRON SINGLETON
	private static ConexionBD miConexion = new ConexionBD();
	
	
	Connection conn = null;
	ResultSet rset = null;
	Statement stmt = null;
	PreparedStatement prstmt = null;
	
	/**
	 * Constructor privado para que solo haya una sola instancia u objeto de la clase SINGLETON
	 */
	private ConexionBD()
	{
		
	}
	
	public static ConexionBD getConexionBD()
	{
		return miConexion;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ResultSet obtenerConexion() throws Exception
	{
			
			//InstruccionesSQL instruccion = new InstruccionesSQL ();
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			try {
				Class.forName(TEXT_DRIVER);//ejecuta el bloque static de la clase. Que contiene
								//DriverManager.registerDriver (System.out.println(listaEmpleados.toString())
			
			//DriverManager.registerDriver (System.out.println(listaEmpleados.toString());;// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			conn = DriverManager.getConnection (TEXT_CONECTAR_BASE_DATOS, TEXT_USUARIO, TEXT_PASS);
  	        stmt = conn.createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prstmt = conn.prepareStatement(InstruccionesSQL.CONSULTA_EMPLEADO1);
			rset = prstmt.executeQuery();
			
			
			return rset;
	}
	
	public void liberarRecursos()
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
}

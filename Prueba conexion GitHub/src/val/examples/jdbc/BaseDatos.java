package val.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
	
	
	public static void main(String[] args) throws Exception {
		
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		Empleados empleado = null;
		List <Empleados> listaEmpleados = new ArrayList <Empleados>();
		final int SALARIO_A_FILTRAR = 3000; 
		
		
		try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "DIESAN666");
  	        stmt = conn.createStatement();
			//rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
			/*while (rset.next())
				{
			         System.out.println (rset.getString(1));  
				}  */
		
			// HACER UN ARRAYLIST DE EMPLEADOS CON LOS EMPLEADOS QUE COBREN MAS DE 3000 
			
			//elegir salario a filtrar en la base de datos
			// hacer consulta
			rset = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY > 3000");
			
			while (rset.next())
			{
				int idEmpleado = rset.getInt(1);
				String name= rset.getString(2);
				String apell= rset.getString(3);
				String mail= rset.getString(4);
				String phone= rset.getString(5);
				String alta= rset.getString(6);
				String jobId= rset.getString(7);
				int salario= rset.getInt(8);
				int comision= rset.getInt(9);
				int managerId= rset.getInt(10);
				int departamentoId= rset.getInt(11);
				
				
				// crear objeto Empleados
				empleado = new Empleados (idEmpleado, name, apell, mail, phone, alta, jobId, salario, comision, managerId,departamentoId);
				listaEmpleados.add(empleado);
			}
			
			System.out.println(empleado.getFIRST_NAME());
			System.out.println(listaEmpleados);
			
			// añadir Empleados al ArrayList de empleados
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//MUY IMPORTANTE LIBERAR RECURSOS DE LA BASE DE DATOS. SIEMPRE EN ORDEN
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statement, Connection
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   

	}

}


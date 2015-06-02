package val.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseDatos {
	
	
	public static void main(String[] args) throws Exception {
		
		Savepoint sp = null;
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		PreparedStatement prstmt = null;
		Empleados empleado = null;
		//MiArrayList listaEmpleados = null;
		List <Empleados> listaEmpleados = new MiArrayList();
		//final int SALARIO_A_FILTRAR = 3000; 
		int filtroSalario =0;
		String campoOrdenar = "";
		Scanner sc = new Scanner (System.in);
		
		
		try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "DIESAN666");
			
			// para poner el autocomit de la base de datos para trabajar con copia y poder gestionar los fallos de conexion
			conn.setAutoCommit(false); 
  	        sp = conn.setSavepoint();
			
			
			stmt = conn.createStatement();
			//rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
			/*while (rset.next())
				{
			         System.out.println (rset.getString(1));  
				}  */
		
			// HACER UN ARRAYLIST DE EMPLEADOS CON LOS EMPLEADOS QUE COBREN MAS DE 3000 
			
			//elegir salario a filtrar en la base de datos
			// hacer consulta
  	        
  	        System.out.println("INTRODUCE EL VALOR DEL SALARIO MÍNIMO A MOSTRAR");
  	        filtroSalario = sc.nextInt();
  	        System.out.println("INTRODUCE EL CAMPO DE ORDEN: ");
  	        campoOrdenar = sc.next();
  	        
			prstmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE SALARY > ? ORDER BY ?");
			prstmt.setInt(1, filtroSalario);
			prstmt.setString(2, campoOrdenar);
			rset = prstmt.executeQuery();
			
			conn.commit();
			
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
			
			
			
			System.out.println(listaEmpleados.toString());
			
			// añadir Empleados al ArrayList de empleados
			
			
		}
		catch(Exception e)
		{
			conn.rollback(sp);
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


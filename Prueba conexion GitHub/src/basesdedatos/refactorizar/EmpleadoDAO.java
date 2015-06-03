package basesdedatos.refactorizar;

import java.sql.ResultSet;
import java.util.List;

import val.examples.jdbc.Empleados;

/**
 * Clase EmpleadoDAO 
 * Para crear el Objeto de la base de datos que gestiona los métodos con la base de datos
 *
 * @author Diego Santamaría
 *
 */
public class EmpleadoDAO {
	 ResultSet rset = null;
	public EmpleadoDAO ()
	{
		
	}

	
	/**
	 * Método recuperar. Recupera de la base de datos todos sus datos y los mete en un
	 * ArrayList
	 * @return MiArrayList con todos los empleados de la Base de datos que cumplen las
	 * condiciones pedidas por la clase InstruccionesSQL
	 * @throws Exception
	 */
	public static MiArrayList recuperar () throws Exception
	{
		ResultSet rset = null;
		EmpleadoDTO empleadoDTO = null;
		List <EmpleadoDTO> listaE = new MiArrayList();
		ConexionBD miconexion = ConexionBD.getConexionBD();
		rset = miconexion.obtenerConexion();
		
		
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
			empleadoDTO = new EmpleadoDTO (idEmpleado, name, apell, mail, phone, alta, jobId, salario, comision, managerId,departamentoId);
			listaE.add(empleadoDTO);
		}
		
		ejecutarInstruccionSQL();
		crearEmpleadoDTO();
		crearListaEmpleado();
		
		
		
		
		
		return (MiArrayList)listaE;
		
	}

	private static void crearListaEmpleado() {
		// TODO Auto-generated method stub
		
	}

	private static void ejecutarInstruccionSQL() {
		// TODO Auto-generated method stub
		
		//prstmt = conn.prepareStatement(InstruccionesSQL.CONSULTA_EMPLEADO1);
	}

	private static void crearEmpleadoDTO() {
		// TODO Auto-generated method stub
		
	}
	
	
}

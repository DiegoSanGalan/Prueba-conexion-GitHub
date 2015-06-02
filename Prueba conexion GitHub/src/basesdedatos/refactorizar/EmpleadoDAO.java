package basesdedatos.refactorizar;

import java.util.List;

/**
 * Clase EmpleadoDAO 
 * Para crear el Objeto de la base de datos que gestiona los métodos con la base de datos
 * @author Diego Santamaría
 *
 */
public class EmpleadoDAO {
	
	public EmpleadoDAO ()
	{
		
	}

	public static MiArrayList recuperar () throws Exception
	{
		List listaE = new MiArrayList();
		ConexionBD miconexion = ConexionBD.getConexionBD();
		miconexion.obtenerConexion();
		ejecutarInstruccionSQL();
		crearEmpleadoDTO();
		crearListaEmpleado();
		
		
		
		
		
		return null;
		
	}

	private static void crearListaEmpleado() {
		// TODO Auto-generated method stub
		
	}

	private static void ejecutarInstruccionSQL() {
		// TODO Auto-generated method stub
		
		prstmt = conn.prepareStatement(InstruccionesSQL.CONSULTA_EMPLEADO1);
	}

	private static void crearEmpleadoDTO() {
		// TODO Auto-generated method stub
		
	}
	
	
}

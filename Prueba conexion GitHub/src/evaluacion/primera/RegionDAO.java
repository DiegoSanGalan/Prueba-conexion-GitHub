package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase RegionDAO para Acceso a datos de la BD
 * @author Diego Santamaría
 *
 */
public class RegionDAO {
	
	ConexionDB con  = null;
	PreparedStatement prst = null;	
	ResultSet rset = null;
	ArrayList <RegionDTO> listaDev = new MiArrayList ();
	RegionDTO objetoRegDTO = null;

	/**
	 * Constructor de la clase
	 */
	public RegionDAO ()
	{
		
	}
	
	
	/**
	 * Método para devolver un registro en forma de ArrayList buscado por id
	 * @param idBuscar
	 * @return MiArrayList
	 * @throws SQLException
	 */
	public MiArrayList recuperarDatos (int idBuscar) throws SQLException
	{
		//String saberDato = "";
		//saberDato = opcion.toString();
		//System.out.println(saberDato);
		
		conectar();
		rset = ejecutarSQL(idBuscar);
		desconectar();
		
		listaDev = crearLista (rset);
		
		return (MiArrayList) listaDev;
	}
	
	/**
	 * Método para devolver un ArrayList con todos los registros de la Base de Datos
	 * @return MiArrayList
	 * @throws SQLException
	 */
	public MiArrayList recuperarDatos () throws SQLException
	{
		conectar();
		rset = ejecutarSQL();
		desconectar();
		
		listaDev = crearLista (rset);
		
		return (MiArrayList) listaDev;
	}
	
	/**
	 * Método para crear un ArrayList de Objetos leidos de la BD y lo devuelve
	 * @param rset2 Tipo ResultSet
	 * @return ArrayList 
	 * @throws SQLException
	 */
	private ArrayList<RegionDTO> crearLista(ResultSet rset2) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList <RegionDTO> listaVar = new MiArrayList();
		while (rset2.next())
		{
			int idReg = rset.getInt(1);
			String RegName= rset.getString(2);
			
			objetoRegDTO = new RegionDTO(idReg, RegName);
			listaDev.add(objetoRegDTO);
		}
		
		
		return listaDev;
	}


	// **************************************************************
	// ************** Conectar a la base de datos *******************
	// **************************************************************
	
	/**
	 * Método para crear la conexion a la base de datos
	 * 
	 */
	private void conectar ()
	{
		con = ConexionDB.obtenerConexion();
	}
	
	/**
	 * Método para liberar los recursos de conexión a la BD
	 */
	private void desconectar ()
	{
		ConexionDB.liberarRecursos();
	}
	
	
	
	
	
	
	
	// ***********************************************************************************************************
	// **INICIO TRES MÉTODOS *************************************************************************************
	// ***************** Ejecutar la instruccionSQL dependiendo del parámetro recibido ***************************
	// ***********************************************************************************************************
	/**
	 * Recibe el identificador y ejecuta la consulta buscando por id
	 * @param id Tipo int con el id a buscar
	 * @throws SQLException 
	 * @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	 */
	public ResultSet ejecutarSQL (int id) throws SQLException
	{
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.RECUPERAR_POR_ID);
		prst.setInt(1, id); // seteamos la interrogacion de la consulta y la cambiamos por el id recibido por parámetro
		rset = prst.executeQuery();
		return rset;
	}
	
	
	/**
	 * Recibe un objeto RegionDTO lo inserta .Ejecuta SQL insertando registro recibido 
	 * @param regionDTO del Tipo RegionDTO
	 * @throws SQLException 
	 * @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	 */
	public ResultSet ejecutarSQL (RegionDTO regionDTO) throws SQLException
	{
		String regNombre = "";
		regNombre = regionDTO.getREGION_NAME(); // obtenemos el campo nombre que necesitamos para agregar al registro de la BD
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.INSERTAR_NUEVO_REGISTRO);
		prst.setString(1, regNombre); // seteamos la interrogacion de la consulta y la cambiamos por el id recibido por parámetro
		rset = prst.executeQuery();
		return rset;
	}
	
	
	/**
	 * Si llamo sin parametros recupero todos los registros
	 * @throws SQLException 
	 * @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	 */
	public ResultSet ejecutarSQL () throws SQLException
	{
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.RECUPERAR_TODOS);
		rset = prst.executeQuery();
		return rset;
	}
	
	// ***********************************************************************************************************
	// *FINAL DE *********** Ejecutar la instruccionSQL dependiendo del parámetro recibido ***********************
	// ***********************************************************************************************************
	
	
	
} // FIN CLASE RegionDAO

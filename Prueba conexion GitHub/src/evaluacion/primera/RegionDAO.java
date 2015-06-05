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
public class RegionDAO implements InterfaceDAO<RegionDTO> {
	
	private ConexionDB con  = null;
	private PreparedStatement prst = null;	
	private ResultSet rset = null;
	private ArrayList <RegionDTO> listaDev = new MiArrayList ();
	private RegionDTO objetoRegDTO = null;

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
		con = (ConexionDB) ConexionDB.obtenerConexion();
	}
	
	/**
	 * Método para liberar los recursos de conexión a la BD
	 */
	private void desconectar ()
	{
		ConexionDB.liberarRecursos();
	}
	
	@Override
	public boolean crear(RegionDTO c) {
		boolean creado = false;
		PreparedStatement ps = null;
		try {
			ps = con.obtenerConexion().prepareStatement(InstruccionesSQL.SQL_INSERTAR_NUEVO_REGISTRO);
			ps.setString(1, c.getREGION_NAME());
			if (ps.executeUpdate()>0)
			{
				creado = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			desconectar();
		}
		return creado;
	}


	@Override
	public boolean borrar(Object claveId) {
		boolean borrado = false;
		PreparedStatement ps = null;
		
		try {
			ps = con.obtenerConexion().prepareStatement(InstruccionesSQL.SQL_BORRAR);
			ps.setString(1, claveId.toString());
			if (ps.executeUpdate()>0)
			{
				borrado = true;
			}
		} catch (SQLException e) {
			borrado = false;
			e.printStackTrace();
		}
		finally
		{
			desconectar();
		}
		return borrado;
	}


	@Override
	public boolean actualizar(RegionDTO c) {
		boolean actualizado = false;
		PreparedStatement ps = null;
		
		try {
			ps = con.obtenerConexion().prepareStatement(InstruccionesSQL.SQL_ACTUALIZAR);
			ps.setString(1, c.getREGION_NAME());
			ps.setInt(2, c.getREGION_ID());
			if (ps.executeUpdate() > 0)
			{
				actualizado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			desconectar();
		}
		
		return actualizado;
	}


	@Override
	public RegionDTO leer(Object claveId) {
		RegionDTO regDTO = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			ps = con.obtenerConexion().prepareStatement(InstruccionesSQL.SQL_RECUPERAR_POR_ID);
			ps.setString(1, claveId.toString());
			res = ps.executeQuery();
		
		// creo el objeto RegionDTO
			while (res.next())
			{
				regDTO = new RegionDTO (res.getInt(1), res.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			desconectar();
		}
		
		
		return regDTO;
	}


	@Override
	public ArrayList<RegionDTO> leerTodos() {
		RegionDTO regDTO = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		ArrayList<RegionDTO> listaRegDTO = new MiArrayList();
		try {
			ps = con.obtenerConexion().prepareStatement(InstruccionesSQL.SQL_RECUPERAR_TODOS);
			res = ps.executeQuery();
			
			// lleno el ArrayList con los datos del ResultSet
			while (res.next())
			{
				listaRegDTO.add (new RegionDTO (res.getInt(1), res.getString(2)));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally
		{
			desconectar();
			//ps.close();		
		}
		return listaRegDTO;
	}

	
	
	
	
	
	// ******************************** OTRA MANERA QUE SE ME OCURRIÓ ********************************************
	// ***********************************************************************************************************
	// **INICIO TRES MÉTODOS *************************************************************************************
	// ***************** Ejecutar la instruccionSQL dependiendo del parámetro recibido ***************************
	// ***********************************************************************************************************
	
	/*
	  Recibe el identificador y ejecuta la consulta buscando por id
	 @param id Tipo int con el id a buscar
	 @throws SQLException 
	 @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	 
	public ResultSet ejecutarSQL (int id) throws SQLException
	{
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.SQL_RECUPERAR_POR_ID);
		prst.setInt(1, id); // seteamos la interrogacion de la consulta y la cambiamos por el id recibido por parámetro
		rset = prst.executeQuery();
		return rset;
	}
	
	
	
	 * Recibe un objeto RegionDTO lo inserta .Ejecuta SQL insertando registro recibido 
	 * @param regionDTO del Tipo RegionDTO
	 * @throws SQLException 
	 * @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	
	public ResultSet ejecutarSQL (RegionDTO regionDTO) throws SQLException
	{
		String regNombre = "";
		regNombre = regionDTO.getREGION_NAME(); // obtenemos el campo nombre que necesitamos para agregar al registro de la BD
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.SQL_INSERTAR_NUEVO_REGISTRO);
		prst.setString(1, regNombre); // seteamos la interrogacion de la consulta y la cambiamos por el id recibido por parámetro
		rset = prst.executeQuery();
		return rset;
	}
	
	
	
	 * Si llamo sin parametros recupero todos los registros
	 * @throws SQLException 
	 * @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	
	public ResultSet ejecutarSQL () throws SQLException
	{
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.SQL_RECUPERAR_TODOS);
		rset = prst.executeQuery();
		return rset;
	}

	*/
	// ***********************************************************************************************************
	// *FINAL DE *********** Ejecutar la instruccionSQL dependiendo del parámetro recibido ***********************
	// ***********************************************************************************************************
	
	
	
	

	
	
	
	
} // FIN CLASE RegionDAO

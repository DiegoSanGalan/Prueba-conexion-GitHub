package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

/**
 * Clase RegionDAO para Acceso a datos de la BD
 * @author Diego Santamar�a
 *
 */
public class RegionDAO implements InterfaceDAO<RegionDTO> {
	
	private static Connection con  = null;
	//private PreparedStatement prst = null;	
	//private ResultSet rset = null;
	private ArrayList <RegionDTO> listaDev = new MiArrayList ();
	//private RegionDTO objetoRegDTO = null;

	/**
	 * Constructor de la Clase RegionDAO
	 * Aqu� activo la conexion al crear el objeto
	 * Constructor de la clase
	 */
	public RegionDAO ()
	{
		
	}
	

	// **************************************************************
	// ************** Conectar a la base de datos *******************
	// **************************************************************
	
	
	private void conectar ()
	{
		if (con == null)
		{
		try {
			con =  ConexionDB.obtenerConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else {
			System.out.println("conexi�n ya existe");
		}
	}
	
	/**
	 * M�todo para liberar los recursos de conexi�n a la BD
	 */
	private void desconectar ()
	{
		ConexionDB.liberarRecursos();
	}
	
	
	/**
	 * M�todo para crear un registro nuevo en la Base de Datos
	 * @param c Tipo RegionDTO
	 * @return booleano indicando true si se cre� correctamente
	 */
	@Override
	public boolean crear(RegionDTO c) {
		boolean creado = false;
		PreparedStatement ps = null;
		conectar();
		try {
			ps = con.prepareStatement(InstruccionesSQL.SQL_INSERTAR_NUEVO_REGISTRO);
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

	/**
	 * M�todo para eliminar un registro de la Base de Datos
	 * @param claveId Tipo Object
	 * @return booleano indicando true si borr� correctamente
	 */
	@Override
	public boolean borrar(Object claveId) {
		boolean borrado = false;
		PreparedStatement ps = null;
		conectar();
		//Savepoint seguro =null; // para gestionar el punto de salvado Base de Datos
		
		try {
			ps = con.prepareStatement(InstruccionesSQL.SQL_BORRAR);
			ps.setString(1, claveId.toString());
			if (ps.executeUpdate()>0)
			{
				borrado = true;
			}
			con.commit();
		} catch (SQLException e) {
			borrado = false;
			try {
				con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			desconectar();
		}
		return borrado;
	}

	/**
	 * M�todo para actualizar en la base de datos
	 * @param c Tipo RegionDTO
	 * @return booleano indicando true si se actualiz� correctamente
	 */
	@Override
	public boolean actualizar(RegionDTO c) {
		boolean actualizado = false;
		PreparedStatement ps = null;
		conectar();
		//Savepoint seguro =null; // para gestionar el punto de salvado Base de Datos
		
		
		
		try {
			ps = con.prepareStatement(InstruccionesSQL.SQL_ACTUALIZAR);
			ps.setString(1, c.getREGION_NAME());
			ps.setInt(2, c.getREGION_ID());
			if (ps.executeUpdate() > 0)
			{
				actualizado = true;
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			desconectar();
		}
		
		return actualizado;
	}

	/**
	 * M�todo para leer por ID
	 * @param claveId tipo Object
	 * @return tipo RegionDTO
	 */
	@Override
	public RegionDTO leer(Object claveId) {
		RegionDTO regDTO = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		conectar();
		
		try {
			ps = con.prepareStatement(InstruccionesSQL.SQL_RECUPERAR_POR_ID);
			ps.setString(1, claveId.toString());
			res = ps.executeQuery();
		
		// creo el objeto RegionDTO
			while (res.next())
			{
				regDTO = new RegionDTO (res.getInt(1), res.getString(2));
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally 
		{
			desconectar();
		}
		return regDTO;
	}

	/**
	 * M�todo para recuperar todos los registros de la Base de Datos
	 * @return ArrayList
	 */
	@Override
	public ArrayList<RegionDTO> leerTodos() {
		PreparedStatement ps = null;
		ResultSet res = null;
		ArrayList<RegionDTO> listaRegDTO = new MiArrayList();
		conectar();
		try {
			ps = con.prepareStatement(InstruccionesSQL.SQL_RECUPERAR_TODOS);
			res = ps.executeQuery();
			
			// lleno el ArrayList con los datos del ResultSet
			while (res.next())
			{
				listaRegDTO.add (new RegionDTO (res.getInt(1), res.getString(2)));
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback(); // en caso de fallo SQL vuelve al inicio de la conexion
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			desconectar();
			//ps.close();		
		}
		return listaRegDTO;
	}

	
	
	
	
	
	// ******************************** OTRA MANERA QUE SE ME OCURRI� ********************************************
	// ***********************************************************************************************************
	// **INICIO TRES M�TODOS *************************************************************************************
	// ***************** Ejecutar la instruccionSQL dependiendo del par�metro recibido ***************************
	// ***********************************************************************************************************
	
	/*
	  Recibe el identificador y ejecuta la consulta buscando por id
	 @param id Tipo int con el id a buscar
	 @throws SQLException 
	 @return Devuelve un objeto tipo ResultSet que contiene los datos solicitados
	 
	public ResultSet ejecutarSQL (int id) throws SQLException
	{
		prst = ((Connection) con).prepareStatement(InstruccionesSQL.SQL_RECUPERAR_POR_ID);
		prst.setInt(1, id); // seteamos la interrogacion de la consulta y la cambiamos por el id recibido por par�metro
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
		prst.setString(1, regNombre); // seteamos la interrogacion de la consulta y la cambiamos por el id recibido por par�metro
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
	// *FINAL DE *********** Ejecutar la instruccionSQL dependiendo del par�metro recibido ***********************
	// ***********************************************************************************************************
	
	///**
//	 * M�todo para devolver un registro en forma de ArrayList buscado por id
//	 * @param idBuscar
//	 * @return MiArrayList
//	 * @throws SQLException
//	 */
	//public MiArrayList recuperarDatos (int idBuscar) throws SQLException
	//{
		//String saberDato = "";
		//saberDato = opcion.toString();
		//System.out.println(saberDato);
		
	//	conectar();
	//	rset = ejecutarSQL(idBuscar);
	//	desconectar();
		
	//	listaDev = crearLista (rset);
		
	//	return (MiArrayList) listaDev;
	//}
	
	///**
	// * M�todo para devolver un ArrayList con todos los registros de la Base de Datos
	// * @return MiArrayList
	// * @throws SQLException
	// */
	//public MiArrayList recuperarDatos () throws SQLException
	//{
//		conectar();
	//	rset = ejecutarSQL();
	//	desconectar();
		
	//	listaDev = crearLista (rset);
		
	//	return (MiArrayList) listaDev;
	//}
	
	///**
	// * M�todo para crear un ArrayList de Objetos leidos de la BD y lo devuelve
	// * @param rset2 Tipo ResultSet
	// * @return ArrayList 
	// * @throws SQLException
	// */
	//private ArrayList<RegionDTO> crearLista(ResultSet rset2) throws SQLException {
		// TODO Auto-generated method stub
		//ArrayList <RegionDTO> listaVar = new MiArrayList();
		//while (rset2.next())
	//	{
	//		int idReg = rset.getInt(1);
	//		String RegName= rset.getString(2);
			
	//		objetoRegDTO = new RegionDTO(idReg, RegName);
	//		listaDev.add(objetoRegDTO);
	//	}
		
		
	//	return listaDev;
	//}
	
	

	
	
	
	
} // FIN CLASE RegionDAO

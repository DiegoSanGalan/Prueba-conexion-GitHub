package evaluacion.primera;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProbarDtoRegionMain {
	
	public static ArrayList<RegionDTO> listadoTotal = new MiArrayList();
	public static RegionDAO regionDAO = null;

	/**
	 * Clase creada para probar el funcionamiento de las clases DAO y DTO
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ResultSet rst = null; // variable para almacenar el valor devuelto de la consulta
		int idReg = 0; // variable para indicar numero de registro a buscar
		
		listadoTotal = recuperarRegionId (idReg);
		
		System.out.println(listadoTotal.toString());
		
	}

	/**
	 * 
	 * @param idReg Tipo int que indica el numero id a buscar
	 * @return Objeto tipo ResultSet con el contenido solicitado
	 * @throws SQLException 
	 */
	private static MiArrayList recuperarRegionId(int idReg) throws SQLException {
		//ResultSet resultadoConsulta = null; 
		regionDAO = new RegionDAO();
		
		listadoTotal = regionDAO.recuperarDatos (idReg);
		
		return (MiArrayList) listadoTotal;
	}

}

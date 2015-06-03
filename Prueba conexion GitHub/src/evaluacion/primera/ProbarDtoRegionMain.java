package evaluacion.primera;

import java.sql.ResultSet;

public class ProbarDtoRegionMain {

	/**
	 * Clase creada para probar el funcionamiento de las clases DAO y DTO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ResultSet rst = null; // variable para almacenar el valor devuelto de la consulta
		int idReg = 0; // variable para indicar numero de registro a buscar
		
		rst = recuperarRegionId (idReg);
		
	}

	/**
	 * 
	 * @param idReg Tipo int que indica el numero id a buscar
	 * @return Objeto tipo ResultSet con el contenido solicitado
	 */
	private static ResultSet recuperarRegionId(int idReg) {
		ResultSet resultadoConsulta = null; 
		
		resultadoConsulta = RegionDAO.recuperarDatos (idReg);
		
		return resultadoConsulta;
	}

}

package basesdedatos.refactorizar;

import java.util.List;

//import val.examples.jdbc.Empleados;
//import val.examples.jdbc.MiArrayList;

/**
 * Clase MainEmpleados para crear un arrayList de Empleados
 *  y mostrarlo por pantalla.
 *  Para ello accederemos a la base de datos a traves de la clase EmpleadoDAO (Data Access Object)
 * @author Diego Santamaría
 *
 */
public class MainEmpleados {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		
		List<EmpleadoDTO> listaEmpleados = new MiArrayList();
		
		listaEmpleados = EmpleadoDAO.recuperar();
		
		System.out.println(listaEmpleados.toString());
		
	}

}

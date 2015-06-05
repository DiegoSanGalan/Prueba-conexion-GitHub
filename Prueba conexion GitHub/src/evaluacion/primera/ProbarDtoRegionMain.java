package evaluacion.primera;

//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class ProbarDtoRegionMain {
	
	public static ArrayList<RegionDTO> listadoTotal = new MiArrayList();
	public static RegionDAO regionDAO = null;
	public static RegionDTO regionDTO =null;
	public static int opcionMenu = 0;
	public static Scanner sc = new Scanner (System.in);

	/**
	 * Clase creada para probar el funcionamiento de las clases DAO y DTO
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		menuOpciones ();
		
	}

	/**
	 * M�todo MenuOpciones de pruebas
	 */
	private static void menuOpciones() {
		do 
		{
			mostrarMenu();
			opcionMenu = sc.nextInt();
		
		switch (opcionMenu)
		{
		case 0: // OPCION 0 SALIR 
			System.out.println("Salir. Adios");
			break;
		case 1: // OPCION 1 INSERTAR REGION
			System.out.println("OPCION 1 INSERTAR REGI�N");
			regionDAO = new RegionDAO();
			int contID = 5;
			regionDTO = new RegionDTO (contID,"GITANIA");
			if (regionDAO.crear(regionDTO) == true)
				{
				System.out.println("*****************************************");
				System.out.println("*****************************************");
				System.out.println("Insertado Correcto");
				System.out.println("*****************************************");
				System.out.println("*****************************************");
				}
			
			break;
		case 2: // OPCION 2 BORRAR REGION
			System.out.println("OPCION 2 BORRAR REGI�N");
			regionDAO = new RegionDAO();
			Integer idReg = 1;
			if (regionDAO.borrar(idReg)== true)
			{
				System.out.println("*****************************************");
				System.out.println("*****************************************");
				System.out.println("Borrado registro correcto");
				System.out.println("*****************************************");
				System.out.println("*****************************************");
			}
			break;
		case 3:  // OPCION 3 CONSULTA POR ID_REGION 
			System.out.println("OPCION 3 CONSULTA POR ID_REGION");
			regionDAO = new RegionDAO();
			Integer idReg2 = 1;
			regionDTO = regionDAO.leer(idReg2);
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			System.out.println(regionDTO.getREGION_NAME());
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			break;
		case 4:  // OPCION 4 LISTAR TODOS LOS REGISTROS 
			System.out.println("OPCION 4 RECUPERAR TODOS LOS REGISTROS");
			regionDAO = new RegionDAO();
			listadoTotal = regionDAO.leerTodos();
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			System.out.println(listadoTotal.toString());
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			break;
		default: System.out.println("OPCION NO V�LIDA");
		    break;
				}
		
		}while (opcionMenu!=0);
		sc.close();
	}

	/**
	 * M�todo privado para mostrar el men� de opciones Tester.
	 */
	private static void mostrarMenu() {
		
		System.out.println("Elegir Opci�n 0 Salir");
		System.out.println("Elegir Opci�n 1 Insertar");
		System.out.println("Elegir Opci�n 2 Borrar");
		System.out.println("Elegir Opci�n 3 Consultar por ID_Region)");
		System.out.println("Elegir Opci�n 4 Recuperar Todos los Registros");
		
	}

	
	

}
//****************************************************************************
	//******************* VERSION ANTERIOR ELIMINADA *****************************
	//****************************************************************************
	///**
	 //* 
	// * @param idReg Tipo int que indica el numero id a buscar
	// * @return Objeto tipo ResultSet con el contenido solicitado
	// * @throws SQLException 
	// */
	//private static MiArrayList recuperarRegionId(int idReg) throws SQLException {
		//ResultSet resultadoConsulta = null; 
	//	regionDAO = new RegionDAO();
		
		//listadoTotal = regionDAO.recuperarDatos (idReg);
		
		//return (MiArrayList) listadoTotal;
	//}
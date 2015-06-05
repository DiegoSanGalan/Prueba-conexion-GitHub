package evaluacion.primera;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRegionDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void testRegionDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrear() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrar() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeer() {
	//	assertTrue("Al buscar por id = 2 tiene que retornar Registro", regDTO = new RegionDTO());
		
	}

	@Test
	public void testLeerTodos() {
		
		ArrayList<RegionDTO> lista = new MiArrayList();
		
		RegionDAO regDAO = new RegionDAO ();
		System.out.println("INICIO TEST LEER TODOS");
		lista = regDAO.leerTodos();
		for (RegionDTO reg : lista)
		{
			System.out.println(reg.getREGION_NAME());
		}
		//assertTrue("El objeto recibido no es null", );
		
		
	}

}

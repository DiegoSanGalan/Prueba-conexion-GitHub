package val.examples.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * Clase creada con Junit para testear la clase Operaciones.java
 * @author Diego Santamaría
 *
 */
public class TestOperaciones {
	
	static Operaciones tester = null; // inicializamos un objeto tipo Operaciones
	
	
	@BeforeClass
	/** 
	 * Clase creada para iniciar la clase
	 * Ponemos la anotación @BeforeClass para indicar que empieze por aqui.
	 * OBLIGATORIO QUE SEA PUBLIC STATIC
	 */
	public static void iniciaClase ()
	{
		tester = new Operaciones(); // nos creamos un nuevo objeto Operaciones para utilizarlo en los test
	}

	@Test
	/**
	 * Para Testear el método suma de la clase Operaciones
	 */
	public void testSuma() {
		
		// utilizamos assertEquals para que compruebe el método suma de nuestra
		//	clase Operaciones. Utilizando el objeto creado tipo Operaciones (tester)
		assertEquals("5 mas 3 = 8", 8, tester.suma(5, 3));
		
		
	}

	@Test
	/**
	 * Test para el método multiplicación
	 */
	public void testMultiplicacion() {
		
		
		assertEquals("5 por 3 = 15", 15, tester.multiplicacion(5, 3));
		
	}

	@Test
	/**
	 * Test para el método division
	 */
	public void testDivision() {
		
		assertEquals("10 entre 2 = 5", 5, tester.division(10, 2));
		
	}

	@Test
	/**
	 * Test para el método resta
	 */
	public void testResta() {
		
		assertEquals("5 menos 3 = 2", 2, tester.resta (5, 3));
		
		
	}
	
	@AfterClass
	/**
	 * Aqui se pondría lo que tenemos que hacer al final del test
	 * OBLIGATORIO QUE SEA PUBLIC STATIC
	 */
	public static void finClase()
	{
		// cerramos el objeto que hemos utilizado en @ BeforeClass
		tester = null; 
	}

}

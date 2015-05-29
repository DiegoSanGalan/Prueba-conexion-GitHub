package val.examples.basic;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.core.IsEqual;

import val.examples.basic.exceptions.InsertarPersonaException;

public class TestListaPersonas {
	
	static ListaPersonas listaP = new ListaPersonas(); // creo un objeto listapersonas vacio
	static Persona p = new Persona ("Diego", 40);
	static Persona p2 = new Persona ("Pedro", 18);
	
	@BeforeClass
	public static void iniciarTestListaPersonas () 
	{
		//listaP = new ListaPersonas();
		
		try {
			listaP.insertarPersona(p);
		} catch (InsertarPersonaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			listaP.insertarPersona(p2);
		} catch (InsertarPersonaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Persona p = new Persona("Diego",40);
		//Persona p2 = new Persona ("Andres",36);
		//listaP.insertarPersona(p);
	}
	
	/*
	/**
	 * Pasa cada prueba que hace test por aqui.
	
	@Before
	static void reniciarVariables()
	{
	listaP = new ListaPersonas();
	//p = null;
	//p2 = null;
	
	}
	*/
	
	
	@Test
	public void testListaPersonas() {
		
		ListaPersonas lp = new ListaPersonas();
		Persona [] array = lp.getListaPersonas();
		for (Persona p : array)
		{
			
			Assert.assertThat(p, IsEqual.equalTo(null));
		}
		
		// pruebo que la lista no esté a null
		//System.out.println(listaP.getListaPersonas());
		//assertNull("Lista Personas no se ha creado valor = null" , listaP.getListaPersonas());
		
	}
	

	@Test
	public void testBuscarPersonaString() {
		
		
		//listaP.mostrar();
		assertTrue("Persona no encontrada ", p.equals(listaP.buscarPersona("Diego")));
		//assertTrue("No son iguales las personas ",p==listaP.buscarPersona("Diego"));
		
	}

	@Test
	public void testBuscarPersonaInt() {
		//listaP = new ListaPersonas();
		//Persona p = null;
		//p = new Persona("Diego",40);
		//Persona p2 = new Persona ("Andres",36);
		
		assertTrue("Persona encontrada ", p.equals(listaP.buscarPersona(40)));
		
		
		
		
	}

	@Test
	public void testInsertarPersona() {
		
		
		assertNull("El objeto persona no se ha añadido a lista personas ", listaP);
		
		
	}

	@Test
	public void testEliminarPersona()  {
		
		assertTrue("no se ha podido eliminar ", listaP.eliminarPersona(p));
		
	}

	@Test
	public void testEstaLlena() {
		
		assertTrue("La lista está llena y no deberia ", listaP.estaLlena());
		
	}

}

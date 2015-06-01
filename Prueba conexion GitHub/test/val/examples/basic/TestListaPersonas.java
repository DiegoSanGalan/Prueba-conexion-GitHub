package val.examples.basic;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
//import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.core.IsEqual;

import val.examples.basic.exceptions.InsertarPersonaException;

public class TestListaPersonas {
	
	ListaPersonas listaP = null; // creo un objeto listapersonas vacio
	Persona p = null;
	Persona p2 = null;
	
	@Before
	public void iniciarTestListaPersonas () 
	{
		
		
		this.listaP = new ListaPersonas();
		this.p = new Persona ("Diego", 40);
		this.p2 = new Persona ("Pedro", 18);
		
		
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
	}
	
	
	
	@Test
	public void testListaPersonas() {
		
		//ListaPersonas lp = new ListaPersonas();
		/*Persona [] array = listaP.getListaPersonas();
		for (Persona p : array)
		{
			
			Assert.assertThat(p, IsEqual.equalTo(null));
		}
		
		// pruebo que la lista no esté a null
		//System.out.println(listaP.getListaPersonas());
		//assertNull("Lista Personas no se ha creado valor = null" , listaP.getListaPersonas());
		*/
		
		assertNull ("Lista vacia" , listaP.getListaPersonas());
	}
	

	@Test
	public void testBuscarPersonaString() {
		
		assertTrue("Persona no encontrada ", p.equals(listaP.buscarPersona("Diego")));
		
	}

	@Test
	public void testBuscarPersonaInt() {
		
		assertTrue("Persona no encontrada ", p.equals(listaP.buscarPersona(40)));
		
		//assertThat (p, IsEqual.equalTo(listaP.buscarPersona("Diego")));
		
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

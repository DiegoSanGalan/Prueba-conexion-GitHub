package val.examples.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import val.examples.basic.exceptions.InsertarPersonaException;

public class ListaPersonas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6142497509449107427L;

	public static final int CAPACIDAD = 10;
	
	private Persona[] array_personas;
	
	private int contPersonas = 0;
	
	/**
	 * Es muy posible que haga falta añadir algún campo más
	 */
	
	public ListaPersonas()
	{
		//TODO HAY QUE HACER UN CONSTRUCTOR
		//RECUERDA QUE EL CONSTRUCTOR SIRVE PARA
			//RESERVAR MEMORIA
			//INICIALIZAR EL ESTADO DEL OBJETO Y SUS ATRIBUTOS
		
		//creamos un array de persona Vacio.
		//cuando añadan personas o alumnos se iran añadiendo a ésta lista mientras no
		//supere su CAPACIDAD
		this.array_personas = new Persona[CAPACIDAD];
		
	}
	
	public Persona[] getListaPersonas ()
	{
		//TODO HAY QUE DEVOLVER EL ARRAY DE PERSONAS QUE CONFORMAN LA LISTA
		Persona listaPersona[] = null;
		int contadorArray = 0;
		//this.contPersonas
		if (this.contPersonas >0)
		{
			listaPersona = new Persona [this.contPersonas];
			while (contadorArray<this.contPersonas) 
			{
				listaPersona[contadorArray]= this.array_personas[contadorArray];
				contadorArray++;
			}
		}
	
			
		{
			
		}
		
		return listaPersona;
	}
	
	
	/**
	 * Buscar persona por nombre
	 * @param nombre tipo String
	 * @return Objeto Tipo Persona
	 */
	public Persona buscarPersona (String nombre)
	{
		//TODO BUSCAR PERSONA POR NOMBRE Y DEVOLVERLA
		//SI NO ESTÁ, DEVOLVER NULO
		boolean encontrado = false;
		//int contadorBuscarPersona = 0;
		Persona personaBuscada = null;
		
		//while ((this.array_personas!=null) && (this.contPersonas!=0))
		for (int i = 0; i<this.contPersonas; i++)
		{
			if (nombre.equals(this.array_personas[i].getNombre()))
			{
				personaBuscada = this.array_personas[i];
				encontrado = true;
			}
			else
			{
				
			}
			
		}
		if (!encontrado)
		{
			personaBuscada = null;
		}
		
		return personaBuscada;
	}
	
	
	/**
	 * Método buscarPersona por edad. 
	 * @param edad tipo int
	 * @return Objeto Persona
	 */
	public Persona buscarPersona (int edad)
	{
		//TODO BUSCAR PERSONA POR EDAD Y DEVOLVERLA
		//SI NO ESTÁ, DEVOLVER NULO
		boolean encontrado = false;
		int contadorBuscarPersona = 0;
		Persona personaBuscada = null;
		
		while (array_personas != null)
		{
			if (edad == array_personas[contadorBuscarPersona].getEdad())
			{
				personaBuscada=array_personas[contadorBuscarPersona];
				encontrado = true;
			}
			contadorBuscarPersona++;
		}
		
		if (!encontrado)
		{
			personaBuscada = null;
		}
		
		return personaBuscada;
	}
	
	/**
	 * Grabar el array de objetos ListaPersonas en el fichero Personas.dat
	 * @return booleano false si falla la grabacion
	 */
	public boolean serializar ()
	{
		//Hacer uso del fichero de propiedades serializa.properties, 
		//para obtener de él el valor de la clave destino, 
		//que representa el nombre del fichero de salida
		String nombreArchivoGrabado = "Personas.dat"; //archivo grabacion
		FileOutputStream fos = null;
		ObjectOutputStream objOutGrabar = null;
		boolean grabadoOk = true;
		try {
			fos = new FileOutputStream (nombreArchivoGrabado);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			grabadoOk = false;
		}
		try {
			objOutGrabar = new ObjectOutputStream (fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			grabadoOk = false;
			e.printStackTrace();
		}
		
		try {
			objOutGrabar.writeObject(this.array_personas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			grabadoOk = false;
			e.printStackTrace();
		}
		
		finally { 
			try {
				objOutGrabar.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		
		return grabadoOk;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean deserializar()
	{
		return false;
	}
	
	public void insertarPersona (Persona p) throws InsertarPersonaException
	{
		
		this.contPersonas++;
		if (this.contPersonas > CAPACIDAD)
		{
			InsertarPersonaException errorArrayPersona = new InsertarPersonaException();
			throw (errorArrayPersona);
		}
	}
	
	public int numeroPersonas()
	{
		int numPer = 0;
		numPer = this.contPersonas;
		return numPer;
	}
	
	public boolean estaLlena()
	{
		boolean llena = false;
		if (this.contPersonas == CAPACIDAD)
		{
			llena = true;
		}
		return llena;
	}
	
	public void mostrar()
	{
		//TODO MOSTRAR LA LISTA DE PERSONAS
		// pista: ayudarse del método toString de persona
		this.toString();
	}

}

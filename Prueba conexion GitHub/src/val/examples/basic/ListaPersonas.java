package val.examples.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

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
		int posicion = 0;
		
		if (numeroPersonas()>0)
		{
			while (!encontrado && posicion < numeroPersonas())
				//for (int i = 0; i<this.contPersonas; i++)
			{
				if (this.array_personas[posicion].getNombre().equals((nombre)))
				{
				personaBuscada = this.array_personas[posicion];
				encontrado = true;
				}
				posicion++;
			}
				
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
		
		while ((array_personas != null) && (contadorBuscarPersona >= this.contPersonas))
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
		//String nombreArchivoGrabado = "Personas.dat"; //archivo grabacion
		FileInputStream fis = null;
		
		FileOutputStream fos = null;
		
		ObjectOutputStream objOutGrabar = null;
		boolean grabadoOk = true;
		//Properties propiedades = null;
		try {
			fis = new FileInputStream ("serializa.properties");
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Properties propiedades = new Properties();
		try {
			propiedades.load(fis);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			fos = new FileOutputStream (propiedades.getProperty("destino"));
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
		
		finally { try {
			fis.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		boolean leido = true;
		//File archivoLeer = null;
		FileInputStream fis = null;
		FileInputStream fisPropiedades = null;
		ObjectInputStream ois = null;
		try {
			fisPropiedades = new FileInputStream ("serializa.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties propiedades = new Properties ();
		try {
			fisPropiedades = new FileInputStream ("serializa.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			propiedades.load(fisPropiedades);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fis = new FileInputStream(propiedades.getProperty("destino"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al leer el fichero propiedades");
			e.printStackTrace();
		}
		
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al crear el objeto inputStream");
		}
		
		try {
			this.array_personas = (Persona[]) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			leido = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			leido = false;
			e.printStackTrace();
		}
		
		finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.getListaPersonas();
		
		return leido;
	}
	
	public void insertarPersona (Persona p) throws InsertarPersonaException
	{
		
		//no se puede insertar una persona si es igual
		if (!estaLlena()){//si tengo espacio para insertar	
			if(numeroPersonas()!=0){
				if(buscarPersona(p.getNombre())== null) {
					//System.out.println("num de per "+numeroPersonas() );
					array_personas[numeroPersonas()]=p;
				
				}else{
					System.out.println("Ya existe esa persona");
					//log.debug("Ya existe esa persona");
				}
			}else{
				array_personas[numeroPersonas()] = p;
			}
		}else{
			System.out.println("Capacidad limite alcanzada!!!");
			//log.error("Numero de personas excecido. Máximo");
			throw new InsertarPersonaException();
}
		
		
		
		
		
		
		
		
		/*if (buscarPersona(p.getNombre())!= null) //si la persona existe
		{
			this.contPersonas++;
			if (this.contPersonas > CAPACIDAD)
			{
			InsertarPersonaException errorArrayPersona = new InsertarPersonaException();
			throw (errorArrayPersona);
			}	
		} else {
			System.out.println("NO SE PERMITE PERSONAS REPETIDAS");
		}	
			*/
			
			
		
		
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public boolean eliminarPersona (Persona p)
	{
		boolean eliminada = false;
		for (int i = 0; i < this.contPersonas; i++)
		{
			if (p.equals(array_personas[i]))
			{
				//eliminar objeto de la lista
				//vamos a desplazar la última posición a la posicion eliminada
				
				array_personas[i] = array_personas[this.contPersonas];
				eliminada = true;
				this.contPersonas--;
			}
			
		}
				
		return eliminada;
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
		for (int i = 0; i<this.array_personas.length; i++)
		{
			
			System.out.println(this.array_personas[i]);
		}
		
	}

	/**
	 * Recibimos dos Listas de Personas y las combinamos para obtener 1
	 * @param lista1
	 * @param lista2
	 */
	public void combinarListaPersonas (ListaPersonas lista1, ListaPersonas lista2)
	{
		
	}
}

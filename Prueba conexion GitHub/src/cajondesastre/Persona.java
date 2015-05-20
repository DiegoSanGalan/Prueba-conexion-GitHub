package cajondesastre;
import java.io.Serializable;

public class Persona implements Serializable, Comparable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3607507043771074842L;
	private int edad;
	private String nombre;
	//private int numeroDePersonasTotal;
	
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
		
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.edad;
	}


	@Override
	/**
	 * Para comparar si un objeto es mayor que otro
	 * si devuelve 0: Si los objetos son iguales
	 * si devuelve -1: Si el objeto pasado por argumento es mayor 
	 * si devuelve 1: Si el objeto pasado por argumento es menor que el que llama
	 * @param arg0 Tipo Persona
	 * @return
	 */
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		int comparador = 0;
		Persona p = null;
		p = (Persona) arg0;
	
		System.out.println(this.getEdad()== p.getEdad()); 

		if (this.getEdad()== p.getEdad()) 
		{
			
			comparador = 0;
		}
		else {
			if (this.getEdad()>p.getEdad())
			{
				
				comparador = 1;
			}else {
				
				comparador = -1;
			}
		}
		
		
		return comparador;
	}
	
	

	
}

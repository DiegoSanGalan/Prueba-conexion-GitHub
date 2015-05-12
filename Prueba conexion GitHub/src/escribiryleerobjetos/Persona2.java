package escribiryleerobjetos;

import java.io.Serializable;

	/**
	 * @author Diego Santamaría
	 * CLASE PERSONA2 DONDE ALMACENAMOS Y CREAMOS LOS DATOS Y FUNCIONES DE LA PERSONA
	 */
	@SuppressWarnings("serial")
	public class Persona2 implements Serializable{  //Creamos la clase Persona con los atributos:
		static int numeroPersonas=1;	
		static final byte MAYOR_DE_EDAD = 18; // CREAR CONSTANTE
		static boolean compararNombreyEdad = false;
		
		private String nombre;  //Nombre de tipo String (clase) 
		private byte edad;		//edad de tipo byte (tipo primitivo)
		
		
		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public byte getEdad() {
			return edad;
		}


		public void setEdad(byte edad) {
			this.edad = edad;
		}

		

		
	 /**
	 * CONSTRUCTOR de la clase PERSONA2 RECIBE 2 parametros EL NOMBRE Y LA EDAD
	 * @param nombre  TIPO CLASE String
	 * @param edad    TIPO PRIMITIVO byte
	 */
	public Persona2 (String nombre, byte edad)
	{
		this.nombre = nombre; // this indica al objeto que estoy creando al llamar a éste constructor.
		this.edad = edad; //edad;
		System.out.println("El numero de personas creado es: " + numeroPersonas++);
	}
	
	
	/**
	 * FUNCIÓN PARA MOSTRAR LOS DATOS DE LA PERSONA
	 */
	public void mostrarPersona()
	{
		 //System.out.println("TU NOMBRE ES: " + this.nombre);
		 //System.out.println("Y TIENES: " + this.edad + " AÑOS");
		System.out.println("tus datos completos son " + this.toString());
		 
	}

	
	/**
	 * FUNCIÓN PARA PREGUNTAR SI ES MAYOR DE EDAD
	 * @return BOOLEANO TRUE OR FALSE
	 */
	public boolean esMayorDeEdad()
	{
		boolean esmayor=false;
		
		if (this.edad >=MAYOR_DE_EDAD)
			{
				esmayor = true;
			}
		else
			{
				esmayor = false;
			}
		return (esmayor);
	}

	
	/**
	 * AL ESCRIBIR eq y pulsar CTRL + SPACE. se genera el Override de equals.
	 */
	@Override
		public boolean equals(Object arg0) {
		
		 boolean sonIguales = false;
		//int posicion = 0;
		
		System.out.println("PASO POR EL OVERRIDE");
			Persona2 compararPersona = null;
			compararPersona = (Persona2) arg0;  // CASTING PARA CONVERTIR DE UN TIPO A OTRO.
			compararNombreyEdad = ((compararPersona.edad == this.edad) && (compararPersona.nombre.equals(this.nombre)));
					
			if (compararNombreyEdad)
			{
				//System.out.println("VERDAD");
				sonIguales= true;
				
			}
			else
			{
				//System.out.println("FALSO");
				sonIguales = false;
			}
		
			return sonIguales;
			
		}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
		System.out.println("Aqui es el toString de Persona2");
		String datos = null;
		//Persona2 person1 = null;
		
		datos = this.nombre + " " + this.edad;
		//System.out.println(datos);
		
		return datos;
		}
	
	}

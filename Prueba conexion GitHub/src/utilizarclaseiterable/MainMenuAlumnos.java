package utilizarclaseiterable;

import java.util.Scanner;

import val.examples.basic.exceptions.InsertarPersonaException;
import val.examples.basic.exceptions.NotaException;


public class MainMenuAlumnos {

	/** Menú para añadir personas y visualizar
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = null;
		int opcionMenu = 0;
		ListaPersonas lp = null;
		Persona person = null;
		Persona [] lista = null;
		Alumno alum = null;
		Persona per5 = null;
		String name = "";
		Persona per6 = null;
		int ed = 0;

		sc = new Scanner (System.in);
		
		//opcionMenu = sc.nextInt();
		//System.out.println("Elegir Opción 0 Salir");
		//MENU PRUEBAS
		do 
		{
			
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 1 Crear persona (CONSTRUCTOR)");
			System.out.println("Elegir Opción 2 Crear Lista Personas vacia (CONSTRUCTOR)");
			System.out.println("Elegir Opción 3 Crear Alumno (CONSTRUCTOR)");
			System.out.println("Elegir Opción 4 Recuperar array Personas");
			System.out.println("Elegir Opción 5 Buscar Personas (Por Nombre)");
			System.out.println("Elegir Opción 6 Buscar Personas (Por Edad)");
			System.out.println("Elegir Opción 7 Serializar (Grabar)");
			System.out.println("Elegir Opción 8 Deserializar (Leer)");
			System.out.println("Elegir Opción 9 Insertar Persona en Lista");
			System.out.println("Elegir Opción 10 Borrar Persona de lista");
			System.out.println("Elegir Opción 11 Mostrar Todos");
			System.out.println("Elegir Opción 0 Salir");
			
			opcionMenu = sc.nextInt();
					
		
		switch (opcionMenu)
		{
		case 0: // OPCION 0 SALIR 
			System.out.println("Salir. Adios");
			break;
		case 1: // OPCION 1 CREAR PERSONA
			System.out.println("OPCION 1 CREAR PERSONA");
			
			crearPersona(person);
			break;
		case 2: // OPCION 2 CREAR LISTA PERSONAS VACIA
			System.out.println("OPCION 2 CREAR LISTA PERSONAS VACÍA");
			 lp = new ListaPersonas(); //crea una lista con un array de personas. La estructura
			break;
		case 3:  // OPCION 3 CREAR ALUMNO 
			System.out.println("OPCION 3 CREAR ALUMNO");
			
			crearAlumno (alum);
			break;
		case 4:  // OPCION 4 RECUPERAR ARRAY LISTA PERSONAS
			System.out.println("OPCION 4 RECUPERAR ARRAY PERSONAS");
			
			lista = new Persona [ListaPersonas.CAPACIDAD];
			lista = lp.getListaPersonas();
			break;
		case 5: // OPCION 5 BUSCAR POR NOMBRE Y MOSTRAR PERSONA
			System.out.println("OPCION 5 BUSCAR POR NOMBRE Y MOSTRAR");
			
			System.out.println("Introduce nombre a buscar: ");
			name = sc.next();
			per5 = lp.buscarPersona(name); 
			System.out.println("La persona buscada es: " + per5);
			
			break;
		case 6: // OPCION 6 BUSCAR POR EDAD Y MOSTRAR PERSONA
			System.out.println("OPCION 6 BUSCAR POR EDAD Y MOSTRAR");
			
			System.out.println("Introduce la edad a buscar: ");
			ed = sc.nextInt();
			per6 = lp.buscarPersona(ed);
			System.out.println("La persona buscada es: " + per6);
			break;
		case 7: // OPCION 7 SERIALIZAR (GRABAR EN UN FICHERO LA LISTA
			System.out.println("OPCIÓN 7 SERIALIZAR. (GRABAR)");
			if (lp.serializar())
			{
				System.out.println("Serialización correcta");
			} else
			{
				System.out.println("Error en serialización");
			}
			break;
		case 8: // OPCIÓN 8 DESERIALIZAR (LEER DE UN FICHERO LA LISTA)
			System.out.println("OPCIÓN 8 DESERIALIZAR (LEER)");
			if (lp.deserializar())
			{
				System.out.println("deserializacion correcta");
			}
			else {
				System.out.println("Error al deserializar (Leer)");
			}
			break;
		case 9: // OPCIÓN 9 INSERTAR PERSONA EN LA LISTA
			System.out.println("OPCIÓN 9 INSERTAR PERSONA EN LA LISTA");
			try {
				lp.insertarPersona(person);
			} catch (InsertarPersonaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 10: // OPCIÓN 10 BORRAR PERSONA DE LA LISTA
			System.out.println("OPCIÓN 10 BORRAR PERSONA DE LA LISTA");
			System.out.println("Indicar nombre de la persona a borrar: ");
			name=sc.next();
			person = lp.buscarPersona(name);
			if (lp.eliminarPersona(person))
			{
				System.out.println("Borrado correcto: " + person);
			}
			else 
			{
				System.out.println("no se ha podido borrar: " + person);
			}
			
			break;
			
		case 11: // OPCIÓN 11 MOSTRAR LISTA PERSONAS
			System.out.println("OPCIÓN 11 MOSTRAR LA LISTA COMPLETA");
			lp.mostrar();
			break;
		}
		} while (opcionMenu!=0);
	}
	
	
	private static void crearAlumno(Alumno alum) {
		// TODO Auto-generated method stub
		
		int edad = 0;
		int nota = 0;
		String nombre ="";
		Scanner sc1 = new Scanner(System.in);
		//System.out.println("Cuantas personas vamos a introducir: ");
		//numPer = sc1.nextInt();
		
		//for (int i = 0; i<numPer; i++)
		//{
		System.out.println("Introduce el nombre: ");
		nombre = sc1.next();
		System.out.println("Introduce la edad: ");
		edad = sc1.nextInt();
		System.out.println("Introduce la nota del alumno: ");
		nota = sc1.nextInt();
		try {
			alum = new Alumno(nombre, edad, nota);
		} catch (NotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw e;
			} catch (NotaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		sc1.close();
	}


	/**
	 * Crear una persona introducida por teclado.
	 * @param per Objeto Tipo Persona
	 */
	private static void crearPersona(Persona per) {
		// TODO Auto-generated method stub
		//int numPer = 0;
		int edad = 0;
		String nombre ="";
		Scanner sc1 = new Scanner(System.in);
		//System.out.println("Cuantas personas vamos a introducir: ");
		//numPer = sc1.nextInt();
		
		//for (int i = 0; i<numPer; i++)
		//{
		System.out.println("Introduce el nombre: ");
		nombre = sc1.next();
		System.out.println("Introduce la edad: ");
		edad = sc1.nextInt();
		per = new Persona(nombre, edad);
		//}
		
		
	}
}

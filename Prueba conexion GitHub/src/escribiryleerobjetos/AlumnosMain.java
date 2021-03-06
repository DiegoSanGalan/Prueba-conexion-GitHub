package escribiryleerobjetos;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Clase principal AlumnosMain. Desde aqui crearemos objetos, los grabaremos y los leeremos
 * 	utilizando arrays de objetos
 * @author Diego Santamar�a Gal�n
 *
 */
@SuppressWarnings("serial")
public class AlumnosMain implements Serializable {

	/**PROGRAMA PRINCIPAL ALUMNOS
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tama�o = 0;
		int aux = 0; // para almacenar el contenido del array al recorrerlo el valor 
		//int[] arrayAlumnos;
		int [] arrayEnteros = {10, 15, 20, 37, 66, 69};
		//String [][] arrayGente = null;
		String nombreArchivo = "alumnos.dat";
		//Alumnos b = null;
		// variables para leer y grabar objetos en ficheros
		// utilizando arrays de objetos.
		int numeroDeAlumnos = 0; // Para almacenar el n� de objetos Alumno que crearemos
		Alumnos [] arrayAlumnos = null;
		Alumnos [] arrayAlumnosLeidos = null;
		// FIN DECLARACION VARIABLES EXTRA PARA ARRAY DE OBJETOS
		boolean grabado = false;
		
		tama�o=arrayEnteros.length;
		System.out.println(arrayEnteros[0]);
		
		for (int i = 0; i < tama�o; i++)
		{
			for (int j = 0; j < tama�o; j++)
			{
				
			}
			aux = arrayEnteros[i];
			System.out.println(aux);
		}
		
		Scanner sc = null;
		//Alumnos a = null;
		String nombre = null; 
		//Persona2 p = null;
		int edad = 0;
		int nota = 0;
		System.out.println("Cuantos alumnos quieres");
		sc = new Scanner (System.in);
		numeroDeAlumnos = sc.nextInt();
		arrayAlumnos = new Alumnos [numeroDeAlumnos]; // inicializo el array de objetos Alumnos
		int contador = 0;
		while (contador < numeroDeAlumnos)
		{
			System.out.println("Introduce el nombre: ");
			nombre = sc.next();
			System.out.println("Introduce la edad: ");
			sc = new Scanner (System.in);
			edad = sc.nextInt();
			System.out.println("Introduce la nota del alumno: ");
			sc = new Scanner(System.in);
			nota = sc.nextInt();
			arrayAlumnos [contador] = new Alumnos (nombre, (byte)edad, nota); 
			
			contador ++;
			
		}
		
		System.out.println("MOSTRAR ARRAY CREADO DESPUES DE INTRODUCIRLOS");
		mostrarArrayAlumnos(arrayAlumnos);
		
		
				// creo un objeto de Alumnos y lo meto en el arrayAlumnos
		
		
		//VER TODOS LOS DATOS DESDE EL MAIN
		//System.out.println("Tu nombre es: " + a.getNombre() + " Tu edad: " + a.getEdad() +
		//		" Tu nota: "  + a.getNota() + "  " + a.getNotaAlumnoEnumerado());
		
		//Grabar un Array de objeto Alumnos en un archivo.
		
		System.out.println("VAMOS A GRABAR UN ARCHIVO CON: " + numeroDeAlumnos + " OBJETOS");
		
		//for (int i = 0; i < numeroDeAlumnos-1; i++) // para grabar el array de objetos
		//{
		grabado	= Alumnos.grabarObjeto(nombreArchivo, arrayAlumnos);
			if (grabado)
			{
				System.out.println("GRABADO CORRECTO");
				}
			else {
				System.out.println("Error de grabacion");
				}
		//}
		
		System.out.println("MOSTRAREMOS LOS ALUMNOS GRABADOS");
		mostrarArrayAlumnos (arrayAlumnos);
		
		
		
		System.out.println("VAMOS A LEER EL ARRAY DE OBJETOS DESDE UN ARCHIVO");
		
		arrayAlumnosLeidos = (Alumnos[]) Alumnos.leerObjeto(nombreArchivo);
		
		mostrarArrayAlumnos (arrayAlumnosLeidos);
		
		//System.out.println("Tu nombre LEIDO es: " + b.getNombre() + " Tu edad LEIDO: " + b.getEdad() +
		//		" Tu nota LEIDO: "  + b.getNota() + "  " + b.getNotaAlumnoEnumerado());
		
		
		
		//if (a.leerObjeto (nombreArchivo, a))
		//{
			
		//}
		
		//leerDatosObjeto ();
		
		//p = new Alumnos ("Juan", (byte)23, 10);
		//a = new Persona2 ("Juan", (byte)24) NO SE PUEDE 
		
		//p.toString();  // en tiempo de ejecucion mira de que tipo es  p= new Alumnos (....) y llama 
					// al m�todo 
		sc.close();
		
	}

	/**
	 * Funci�n que muestra todos los datos de un array de alumnos recibido
	 * @param alumnos Array de objetos de la clase Alumnos
	 */
	public static void mostrarArrayAlumnos (Alumnos []alumnos)
	{
		for (int i = 0; i<alumnos.length; i++)
		{
			System.out.println("Nombre: " + "Alumno (" + i + ") "+ alumnos[i].getNombre());
			System.out.println("Edad : "+ "Alumno (" + i + ") " +alumnos[i].getEdad());
			System.out.println("Nota : "+ "Alumno (" + i + ") " +alumnos[i].getNota());
			System.out.println("Calificaci�n : "+ "Alumno (" + i + ") " + alumnos[i].getNotaAlumnoEnumerado());
		}
	}
	

}

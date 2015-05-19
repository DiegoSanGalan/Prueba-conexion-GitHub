package cajondesastre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import val.examples.basic.exceptions.NotaException;

public class MapasMain {

	/** Pruebas de uso de colecciones
	 * @param args
	 * @throws NotaException 
	 */
	public static void main(String[] args) throws NotaException {
		// TODO Auto-generated method stub
		Integer numeroOrden = 0; // HACER COLECCION MAPA LINKEDHASHMAP CON ORDEN DE INSERCION
		
		// Creo objetos Persona
		Persona p = new Persona ("Juan", 18);
		Persona p1 = new Persona ("Paco", 20);
		Persona p2 = new Persona ("Andres", 33);
		Persona p3 = new Persona ("Paco", 88);
		
		// Creo objetos Alumno
		Alumno a1 = new Alumno ("Diego", 25, 3);
		Alumno a2 = new Alumno ("Pedro", 25, 5);
		Alumno a3 = new Alumno ("Gema", 25, 10);
		Alumno a4 = new Alumno ("Enrique", 25, 7);
		
		
		// poniendolo así. Utilizando la clase List que implementa las clases
		// ArrayList y LinkedList puedo fácilmente cambiar el tipo de colección
		// sin modificar mas el código solo tenemos que cambiar el tipo
		// Como implementan la clase List tienen todos
		// Ésto es porque cojemos la clase padre INTERFACE que tiene todos los métodos de
		// las clases hijas y esa es la que utilizamos.
		// EL USO DE SUPERTIPOS NOS DA LUGAR A LO:
		// LLAMADO INYECCIÓN DE DEPENDENCIAS. AL TENER UN TIPO GENÉRICO EN TIEMPO DE EJECUCION
		// PUEDO SUSTITUIR EL TIPO DE CLASE SIN QUE AFECTE AL FUNCIONAMIENTO.
		
		List <Persona> l = new ArrayList <Persona> ();
		l.add(p);
		l.add(p1);
		l.add(p2);
		l.add(p3);
		//el cambio en el código para utilizar un LinkedList seria:
		//List <Persona> l1 = new LinkedList <Persona> ();

		/**
		 * USO DE HASHMAP
		 */
		// declarar un mapa tipo HashMap utilizamos SUPERTIPO MAP al crearlo.
		Map <String, Persona> miMapaPersonas = new HashMap <String, Persona>();
		
		//Iterator <Iterator>contadorLista = new Iterator (l.iterator<Iterator>());
		// añado un objeto al mapa indicando la clave
		// .put (Clave, Valor);
		miMapaPersonas.put(p.getNombre(), p);
		// añado otro objeto al mapa
		miMapaPersonas.put(p1.getNombre(), p1);
		// añado otro objeto al mapa
		miMapaPersonas.put (p2.getNombre(), p2);
		
		// muestro el contenido del mapa
		System.out.println(miMapaPersonas);
		
		// añado otro objeto con la clave repetida
		//   al estar repetida la clave sustituye el objeto nuevo por el antiguo.
		miMapaPersonas.put(p3.getNombre(), p3);
		System.out.println(miMapaPersonas);
		System.out.println(miMapaPersonas.get(p3.getNombre()));// me devuelve el objeto
		//miMapaPersonas.clear(); // vacia el contenido del mapa
		System.out.println(miMapaPersonas);
		//miMapaPersonas.entrySet(<Integer, Persona>);
		System.out.println(miMapaPersonas.containsValue(p3)); //devuelve true si existe.
		System.out.println("ELIMINAR OBJETO");
		miMapaPersonas.remove(p2.getNombre());
		System.out.println(miMapaPersonas);
		
		/**
		 * USO DE TREEMAP
		 */
		// Crear un TreeMap de alumnos, usando como clave la nota de cada alumno
		// Utilizo el TipoNota porque no me admite Nota que es tipo int primitivo
		Map <Integer, Alumno> miMapaAlumnos2 = new TreeMap <Integer, Alumno> (); 
		Map <TipoNota, Alumno> miMapaAlumnos = new TreeMap <TipoNota, Alumno> (); 
		miMapaAlumnos.put(a1.getNombre_nota(), a1);
		miMapaAlumnos2.put(a1.getNota(), a1);
		
		miMapaAlumnos.put(a2.getNombre_nota(), a2);
		miMapaAlumnos2.put(a2.getNota(), a2);
	
		miMapaAlumnos.put(a3.getNombre_nota(), a3);
		miMapaAlumnos2.put(a3.getNota(), a3);
		
		System.out.println("MOSTRAR TREE MAP ORDENADO POR NOMBRE DE LA NOTA (TipoNota)");
		System.out.println(miMapaAlumnos);
		
		System.out.println("MOSTRAR TREE MAP POR NOTA ORDENADO");
		System.out.println(miMapaAlumnos2);
		
		miMapaAlumnos.put(a4.getNombre_nota(), a4);
		miMapaAlumnos2.put(a3.getNota(), a3);
		System.out.println("MOSTRAR TREE MAP POR NOTA ORDENADO AÑADIENDO UNO INTERMEDIO");
		System.out.println(miMapaAlumnos);
		
		
		/**
		 * USO DE LINKEDHASHMAP
		 */
		// LinkedHashMap respeta el orden de inserción
		// Creamos un mapa tipo LinkedHashMap almacenando el orden de insercion y utilizando
		// un contador tipo Integer como clave para acceder. Que nos hemos declarado porque
		// el uso de map solo funciona con Objetos
		Map <Integer, Persona> miLinkedHashMap = new LinkedHashMap<Integer, Persona>();
		numeroOrden++;
		miLinkedHashMap.put(numeroOrden, p1);
		numeroOrden++;
		miLinkedHashMap.put(numeroOrden, p2);
		numeroOrden++;
		miLinkedHashMap.put(numeroOrden, p3);
		System.out.println("MOSTRAMOS TODO");
		System.out.println(miLinkedHashMap);
		
	}

}

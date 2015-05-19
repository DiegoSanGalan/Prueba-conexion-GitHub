package cajondesastre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapasMain {

	/** Pruebas de uso de colecciones
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona p = new Persona ("Juan", 18);
		Persona p1 = new Persona ("Paco", 20);
		Persona p2 = new Persona ("Andres", 33);
		Persona p3 = new Persona ("Paco", 88);
		//String nombre = p.getNombre();
		
		//Persona j = new Alumno ("Paco", 20 , 8);
		
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

		
		// declarar un mapa
		Map <String, Persona> miMapaPersonas = new HashMap <String, Persona>();
		
		//Iterator <Iterator>contadorLista = new Iterator (l.iterator<Iterator>());
		// añado un objeto al mapa
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
		
	}

}

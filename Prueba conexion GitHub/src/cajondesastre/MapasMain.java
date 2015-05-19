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
		
		// poniendolo as�. Utilizando la clase List que implementa las clases
		// ArrayList y LinkedList puedo f�cilmente cambiar el tipo de colecci�n
		// sin modificar mas el c�digo solo tenemos que cambiar el tipo
		// Como implementan la clase List tienen todos
		// �sto es porque cojemos la clase padre INTERFACE que tiene todos los m�todos de
		// las clases hijas y esa es la que utilizamos.
		// EL USO DE SUPERTIPOS NOS DA LUGAR A LO:
		// LLAMADO INYECCI�N DE DEPENDENCIAS. AL TENER UN TIPO GEN�RICO EN TIEMPO DE EJECUCION
		// PUEDO SUSTITUIR EL TIPO DE CLASE SIN QUE AFECTE AL FUNCIONAMIENTO.
		
		List <Persona> l = new ArrayList <Persona> ();
		l.add(p);
		l.add(p1);
		l.add(p2);
		l.add(p3);
		//el cambio en el c�digo para utilizar un LinkedList seria:
		//List <Persona> l1 = new LinkedList <Persona> ();

		
		// declarar un mapa
		Map <String, Persona> miMapaPersonas = new HashMap <String, Persona>();
		
		//Iterator <Iterator>contadorLista = new Iterator (l.iterator<Iterator>());
		// a�ado un objeto al mapa
		miMapaPersonas.put(p.getNombre(), p);
		// a�ado otro objeto al mapa
		miMapaPersonas.put(p1.getNombre(), p1);
		// a�ado otro objeto al mapa
		miMapaPersonas.put (p2.getNombre(), p2);
		
		// muestro el contenido del mapa
		System.out.println(miMapaPersonas);
		
		// a�ado otro objeto con la clave repetida
		//   al estar repetida la clave sustituye el objeto nuevo por el antiguo.
		miMapaPersonas.put(p3.getNombre(), p3);
		System.out.println(miMapaPersonas);
		
	}

}

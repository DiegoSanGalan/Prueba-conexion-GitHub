package arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

import val.examples.basic.Persona;

public class MainArrayList 	 {

	/** Prueba con ArrayList añadiendo y borrando objetos en el array list
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 5;
		
		ArrayList<Persona> miArrayList = new ArrayList<Persona>();
		String nom = "Pedro";
		int edad = 18;
		Persona p = new Persona (nom, edad);
		Persona p2 = new Persona ("Antonio", 22);
		Persona p3 = new Persona ("Diego", 40);
		for (int i = 0; i<total; i++)
		{
			miArrayList.add(p);
		}
		miArrayList.add (p2);
		miArrayList.add (p3);
		
		for (Persona pn : miArrayList)
		{
			//System.out.println(pn);
		}
		miArrayList.remove(p);
		
		for (Persona pn : miArrayList)
		{
			//System.out.println(pn);
		}
		miArrayList.remove(p2);
		
		for (Persona pn : miArrayList)
		{
			//System.out.println(pn);
		}
		
		// Nos creamos un objeto Iterator utilizando el método iterator de la clase ArrayList
		// para luego con éste objeto poder recorrer la lista.
		Iterator <Persona> iteradorPersona = miArrayList.iterator();
		while (iteradorPersona.hasNext())
		{
			p2 = iteradorPersona.next();
		System.out.println(p2);
		}
		
		
	}	
	}

package arraylist;

import java.util.ArrayList;

import val.examples.basic.Persona;

public class MainArrayList {

	/**
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
			System.out.println(pn);
		}
		miArrayList.remove(p);
		
		for (Persona pn : miArrayList)
		{
			System.out.println(pn);
		}
		miArrayList.remove(p2);
		
		for (Persona pn : miArrayList)
		{
			System.out.println(pn);
		}
		
		
		
		
		
	}

}

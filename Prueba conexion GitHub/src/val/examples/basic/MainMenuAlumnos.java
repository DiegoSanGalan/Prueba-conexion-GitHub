package val.examples.basic;

import java.util.Scanner;

import val.examples.basic.exceptions.InsertarPersonaException;

public class MainMenuAlumnos {

	/** Menú para añadir personas y visualizar
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = null;
		int opcionMenu = 0;
		sc = new Scanner (System.in);
		
		opcionMenu = sc.nextInt();
		System.out.println("Elegir Opción 0 Salir");
		//MENU PRUEBAS
		while (opcionMenu!=0)
		{
			
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
			System.out.println("Elegir Opción 0 Salir");
				// insertar personas objeto
		// cuando llegue a 10 las pasamos a ListaPersonas[]
		ListaPersonas lp = null;
		Persona person = null;
		lp = new ListaPersonas(); //crea una lista con un array de personas. La estructura
		person = new Persona("Pedro", 18);
		try {
			lp.insertarPersona(person);
		} catch (InsertarPersonaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		}
	
		
		

	}

}

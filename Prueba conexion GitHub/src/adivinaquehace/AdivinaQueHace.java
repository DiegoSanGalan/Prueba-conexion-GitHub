package adivinaquehace;

import java.util.Scanner;


/**
 * 
 * 
 * @author Val
 *
 *El c�digo de esta clase, es un poco misterioso. Alg�n programador Clase "C", no ha usado
 *nombres descriptivos y ahora, nos toca pegarnos y descubrir qu� narices hace este c�digo, 
 *para poder usarlo en nuestro proyecto.
 *
 *
 *Se pide:
 *
 *1) Adivinar la funcionalidad del m�todo adivinaQueHace.
 *		DICE SI LA CADENA INTRODUCIDA ES UN PALINDROMO ES DECIR SI SE LEE IGUAL AL REVES QUE AL DERECHO
 *2) Una vez descubierto, aplicar un nombre apropiado al m�todo y a la clase
 *		esPalabraPalindroma (String cad)
 *3) Idear un m�todo equivalente, pero distinto. Es decir, crear un m�todo 
 *	que haga lo mismo que adivinaQueHace, pero de otra manera.
 *		CREADA NUEVA FUNCION LLAMADA esPalindroma
 *4) EXTRA: S�lo si resolviste los puntos anteriores, implementa una versi�n recursiva
 *
 */
public class AdivinaQueHace {
	
	
	/**
	 * Versi�n ideada por Diego Santamar�a para detectar si una palabra introducida por teclado
	 * es pal�ndroma o no
	 * @param cadena  tipo String
	 * @return booleano que dice si es pal�ndroma o no
	 */
	private static boolean esPalindroma (String cadena)
	
	{
		boolean verdad= false;
		String cadenaInvertida ="";
		
			//ahora recorro la cadena y creo una cadena invertida
			for (int i = cadena.length()-1; i>=0; i--)
			{
				cadenaInvertida = cadenaInvertida + cadena.charAt(i);
			}
			System.out.println(" la palabra invertida es: " + cadenaInvertida);
			
			//y comparo las dos cadenas
			//if (cadena.toString().matches(cadenaInvertida)) // comparo las dos cadenas con .mathes
			if (cadena.equals(cadenaInvertida))// comparo las dos cadenas usando .equals
			{
				verdad = true;
			}
			// si son iguales devuelvo verdad a true
		
		return verdad;
	}
	
	
	
	/**
	 * Funci�n original creada por Valeriano que dice si una palabra es pal�ndroma
	 * @param cad  de tipo String
	 * @return booleano dicienso si es pal�ndroma
	 */
	private static boolean esPalabraPalindroma (String cad)
	{
		boolean bd = true;
		
		int i = 0;
		int j = cad.length()-1;
		
		while ((i<=j)&&(bd))
		{
			bd = cad.charAt(i)==cad.charAt(j);
			i++;
			j--;
		}
		
		
		return bd;
	}
	
	public static void main(String[] args) {
		Scanner sc = null;
		String palabraRara = "";
		sc = new Scanner(System.in);
		
		if (esPalabraPalindroma("carrac"))
		{
			System.out.println("VERDADERO");
		} else 
		{
			System.out.println("FALSO");
		}
		
		System.out.println("Introduce una palabra: ");
		palabraRara = sc.next();
		
		if (esPalindroma(palabraRara))
		{
			System.out.println("palabra mal llamada Capic�a");
			
		}else
		{
			System.out.println("La palabra introducida NO ES Capic�a");
		}
		
		sc.close();
	}

}
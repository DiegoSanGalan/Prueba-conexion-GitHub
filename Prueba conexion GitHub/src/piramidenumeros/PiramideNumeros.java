package piramidenumeros;

/**
 * Piramide de numeros perfecta
 * @author Diego Santamaría Galán
 *
 */
public class PiramideNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nummaxpiramide = 17;
		int bordepiramide = 1;
		int tamañoEspacios = 0;
		String cadNum = "";
		String espacio = "  ";
		
		//para poner los espacios necesarios para hacer la piramide
		for (int i = 1; i<= nummaxpiramide; i++ )
		{
			espacio = espacio + " ";
			tamañoEspacios++;
		}
		
		//para ir generando los números de la piramide
		for (int i=0; i<=nummaxpiramide;i=i+2)
		{
			for (int j=1; j <= bordepiramide; j++)
			{
				cadNum = cadNum + " " + j;
			}
			System.out.println(espacio + cadNum); // imprimo cada línea de la pirámide
			espacio = ""; // inicializo la variable de los espacios
			
			// recalculo los espacios
			for (int k = tamañoEspacios; k>0; k--)
			{
				espacio = espacio + " ";
			}
			
			tamañoEspacios=tamañoEspacios-2; // en cada línea rectifico el tamaño de los espacios en blanco
			bordepiramide = bordepiramide+2; // en cada línea rectifico el número que quiero en el borde derecho
			cadNum = ""; // inicializo la variable que contiene los espacios.
		}
		
		
	}

}
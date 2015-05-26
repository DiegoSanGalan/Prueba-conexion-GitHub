package piramidenumeros;

/**
 * Piramide de numeros perfecta
 * @author Diego Santamar�a Gal�n
 *
 */
public class PiramideNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nummaxpiramide = 17;
		int bordepiramide = 1;
		int tama�oEspacios = 0;
		String cadNum = "";
		String espacio = "  ";
		
		//para poner los espacios necesarios para hacer la piramide
		for (int i = 1; i<= nummaxpiramide; i++ )
		{
			espacio = espacio + " ";
			tama�oEspacios++;
		}
		
		//para ir generando los n�meros de la piramide
		for (int i=0; i<=nummaxpiramide;i=i+2)
		{
			for (int j=1; j <= bordepiramide; j++)
			{
				cadNum = cadNum + " " + j;
			}
			System.out.println(espacio + cadNum); // imprimo cada l�nea de la pir�mide
			espacio = ""; // inicializo la variable de los espacios
			
			// recalculo los espacios
			for (int k = tama�oEspacios; k>0; k--)
			{
				espacio = espacio + " ";
			}
			
			tama�oEspacios=tama�oEspacios-2; // en cada l�nea rectifico el tama�o de los espacios en blanco
			bordepiramide = bordepiramide+2; // en cada l�nea rectifico el n�mero que quiero en el borde derecho
			cadNum = ""; // inicializo la variable que contiene los espacios.
		}
		
		
	}

}
package ficherosbinarios;
// import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
 


public class FicherosBinarios {

	/** Programa para copiar dos ficheros binarios
	 * @param args
	 */
	

	
	/**
	 * Comprueba que el archivo origen existe
	 * @param ruta
	 * @return
	 */
	private static boolean siExiste (String ruta)
	{
		boolean ok = false;
		File archivo = null;
		archivo = new File(ruta);
		if (archivo.exists())
		{
			ok = true;
		}
		// 
		return ok;
	}
	
	/**
	 * Función para copiar un archivo dado a otro igual pero con DIE delante del nombre
	 * 	para diferenciarlo
	 * @param origen tipo String con el path del archivo origen
	 * @param destino tipo String con el path del archivo destino
	 * @return
	 */
	private static boolean copiarArchivoNuevo (String origen, String destino)
	{
		boolean copiaCorrecta = true;
		byte[] archivo = null;
		//byte unoSolo = 0;
		
		File ficheroOrigen = null;			// para objeto tipo file
		FileInputStream fis = null;		// para objeto tipo FileInputStream
		FileOutputStream fos = null;
		File ficheroNuevo = null;
		//BufferedInputStream buffInput = null;  // para objeto tipo BufferedInputStream
		//BufferedOutputStream buffOutput = null; // para objeto tipo BufferedOutputStream
		ficheroNuevo = new File (destino);
		ficheroOrigen = new File (origen);
		//int contador = 0;
		//int totalBytes = fichero.length();
		//System.out.println("TOTAL DE BYTES DEL FICHERO: " + totalBytes);
		archivo = new byte [1024];
		
		// inicializamos el FileOutputStream
		try {
			fos = new FileOutputStream (ficheroNuevo);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// inicializamos el FileInputStream
		try {
			fis = new FileInputStream (ficheroOrigen);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//inicializamos los buffer de lectura y de escritura
		
		//buffInput = new BufferedInputStream(fis);
		//buffOutput = new BufferedOutputStream(fos);
		try {
			while  (fis.read(archivo) > -1)
			{
				try {
					fos.write(archivo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Leemos los datos del archivo byte a byte  y lo pasamos a un array de byte
		
		//System.out.println("contador = " + contador);
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//buffInput.close();
		//buffOutput.close();
		
		
		return copiaCorrecta;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String raiz = "nueva carpeta//";
		Scanner sc = null;
		String archivoOrigen = "";
		String archivoDestino = "";
		int longitudNombre = 0; // para almacenar el tamaño del nombre del fichero
		boolean correcto = false; // para verificar que el nombre archivo es correcto
		boolean copiaCorrecta = false; // para saber si falla la copia de un archivo a otro.
		
		
		
		// 1º introducir nombre de fichero origen... archivo a copiar
		sc = new Scanner(System.in);
		
		do
		{
		
		System.out.println("Introduce el nombre del archivo a copiar con su extensión:");
		archivoOrigen = sc.next();
		
		longitudNombre = archivoOrigen.length();
		
		if (longitudNombre >=5) // el . mas la extension xxx son 4 mas el nombre del archivo minimo 1
				//en la posicón0 añadir las letras DIE para el nombre del origen
		{
			
			correcto = true;
		}
		else
		{
			System.out.println("NOMBRE DE ARCHIVO INCORRECTO");
		}
		
		} while (!correcto);
		
		archivoDestino = raiz + "DIE" + archivoOrigen;
		System.out.println("ARCHIVO DESTINO: " + archivoDestino);
		
		archivoOrigen = raiz + archivoOrigen;
		System.out.println("ARCHIVO ORIGEN: " + archivoOrigen);
		
		//comprobar si existe fisicamente en el disco
		
		if (siExiste (archivoOrigen))
		{
			// 2º leer los datos del archivo origen y pasarlos a un array
			copiaCorrecta = copiarArchivoNuevo (archivoOrigen, archivoDestino);
			if (copiaCorrecta)
			{
				System.out.println("Copia realizada. El nuevo archivo se llama: " + archivoDestino);
			}
		}
		
		
		
		
	
	
	sc.close();
	}

}

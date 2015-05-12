package ficheropropiedades.cuentoidiomas;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
//import java.security.KeyStore.LoadStoreParameter;
import java.util.Enumeration;
import java.util.Properties;

public class MiCuento {
	
	//final static String  RAIZ = "Mispropiedades.properties\\";
	//public static String nuevalinea = System.getProperty("line.separator");

	/**Recibiremos por parámetros el idioma elegido y dependiendo de ésto
	 *  utilizaremos un fichero de propiedades diferente
	 *  it = italiano; es = español; eng = inglés.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String archivo = "";
		//File file = null;
		FileInputStream fis = null;
				
		
		
		
		switch (args [0]){
		case "ES": archivo = "story_es.properties";
					//ponerIdioma (archivo);
					//cargarArchivoPropiedades ();
					//leerCuento();
			break;
		case "IT": archivo = "story_it.properties";
					//ponerIdioma (archivo);
					//cargarArchivoPropiedades ();
					//leerCuento();
			break;
		case "IN": archivo = "story_en.properties";
					//ponerIdioma (archivo);
					//cargarArchivoPropiedades ();
					//leerCuento();
			break;
		default : System.out.println("ERROR EN IDIOMA");
		break;
		}
		
		//archivo = RAIZ + archivo;
		fis = new FileInputStream (new File (archivo));
		cargarArchivoPropiedades (fis);
		
		fis.close();
		
		
	}
	
	
	/*private static void leerCuento() {
		// TODO Auto-generated method stub
		
	}
*/

	/**
	 * leer las propiedades y las escribe en un fichero txt
	 * dependiendo del parametro recibido por consola creara un ar
	 * @throws IOException 
	 */
	public static void cargarArchivoPropiedades (FileInputStream fis2) throws IOException {
		
		
		//Enumeration<Object> valoresProperties = null;
		File micuentotxt = null;
		//FileInputStream fis = null;
		Properties archivoPropiedades = null;
		archivoPropiedades = new Properties ();
		String valor1 = "";
		String valor2 = "";
		String valor3 = "";
		String valor4 = "";
		FileWriter fw = null;
		
		archivoPropiedades.load(fis2);
		
		
		 valor1 = archivoPropiedades.getProperty("start");
		 valor2 = archivoPropiedades.getProperty("body");
		 valor3 = archivoPropiedades.getProperty("end");
		 valor4 = archivoPropiedades.getProperty("outfile");
		 
		
		System.out.println(valor1 + " " + valor2 + " " + valor3);
		
		micuentotxt = new File (valor4);
		micuentotxt.createNewFile();
		fw = new FileWriter (micuentotxt);
		
		fw.write(valor1);
		fw.write(valor2);
		fw.write(valor3);
		
		
		//cerrar fw
		fw.close();
		
		
	
		
		
		
		
	}
	
		
	
	
	
	/**
	 * 
	 */
	/*public static void ponerIdioma (String archivo)
	{
		String nuevoArchivo = null;
		
		File fileLectura = null;
		File fileEscritura = null;
		fileLectura = new File (archivo);
		FileReader frLectura = null;
		BufferedReader bfr = null;
		
		FileWriter fwEscritura = null;
		BufferedWriter bfw = null;
		
		
		try {
			// abrimos el archivo y lo leemos
			frLectura = new FileReader (fileLectura);
			// creamos el buffer de lectura
			bfr = new BufferedReader (frLectura);
			// mientras no sea fin de fichero almacenamos en una variable String
			// los valores que hay en el fichero 
			try {
				while ((nuevoArchivo = bfr.readLine()) != null)
				{
					//con nuevalinea hago un intro entre cada linea de código
					nuevoArchivo = nuevoArchivo + nuevalinea;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("EL STRING QUEDARA ASI: " + nuevoArchivo);
			// cerramos los objetos de lectura
			try {
				frLectura.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bfr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// una vez leidos todos y almacenados en el string nuevoArchivo
			// lo grabamos en el nuevo archivo.
			
			// creamos el nuevo archivo de propiedades si no existe
			
			fileEscritura = new File (MI_ARCHIVO_PROPIEDADES);
			if (fileEscritura.exists())
			{
				System.out.println("El fichero " + MI_ARCHIVO_PROPIEDADES + " existe");
			}
			else {
				System.out.println("El fichero " + MI_ARCHIVO_PROPIEDADES + " NO existe");
				//si no existe lo creo
				try {
					fileEscritura.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//escribo el nuevo fichero con los datos del elegido
			try {
				fwEscritura = new FileWriter (fileEscritura);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bfw = new BufferedWriter (fwEscritura);
			try {
				bfw.write(nuevoArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//cerramos archivo de escritura
			try {
				fwEscritura.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bfw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//cargamos el nuevo archivo como propiedades del programa
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//Load (fileLectura);
			//propiedadesListado = archivoPropiedades.elements();
			//System.out.println(propiedadesListado.nextElement());
			
	}*/

}

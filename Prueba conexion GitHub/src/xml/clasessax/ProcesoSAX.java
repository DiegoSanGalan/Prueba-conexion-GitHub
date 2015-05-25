package xml.clasessax;

import java.io.FileInputStream;
import java.io.IOException;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesoSAX {

	public static void main(String[] args) {  
        
		Libro libro = new Libro();
		LibroXML  miLibroXML = new LibroXML(libro);
	      try {  
	         // Creamos nuestro objeto libro vacío  
	           
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         // Añadimos nuestro manejador al reader pasandole el objeto libro  
	        // LibroXML miLibroXML = miLibroXML;
	         reader.setContentHandler(miLibroXML);           
	         // Procesamos el xml de ejemplo  
	         reader.parse(new InputSource(new FileInputStream("libros.xml")));  
	         //System.out.println(miLibroXML);
	         //System.out.println(libro.toString());           
	      } catch (SAXException e) {  
	         System.out.println(e);
	    	  e.printStackTrace();  
	      } catch (IOException e) {  
	         System.out.println(e);
	    	  e.printStackTrace();  
	      }  
	  
	     
		
	   }  
}

package xml.clasessax;

import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LibroXML extends DefaultHandler{
	 private String valor = "";  
     
	   private Libro libro;  
	   
	   // Creo atributo de clase con el HashMap
	   public Map <String, Libro> mapaLibros = new HashMap <String, Libro> ();
	   
	   public LibroXML(Libro libro){  
	      this.libro=libro;  
	   }  
	     
	   @Override  
	   public void startElement(String uri, String localName, String name,  
	         Attributes attributes) throws SAXException {  
	        
	      // Limpiamos la variable temporal.  
	       valor = null; 
	        
	      // Si la etiqueta es libro leemos el atributo isbn  
	      if(localName.equals("libro")){  
	    	 libro = new Libro (); // inicializo el objeto libro para que cree nueva referencia de objeto
	         String isbn = attributes.getValue("isbn");
	         // Lo guardamos en el objeto libro  
	         libro.setIsbn(isbn);  
	      }  
	   }  
	     
	   @Override  
	   public void characters(char[] ch, int start, int length)  
			   			throws SAXException {  
	      // Guardamos el texto en la variable temporal  
	      valor = new String(ch,start,length);  
	      //System.out.println(valor);
	   }  
	  
	   @Override  
	   public void endElement(String uri, String localName, String name)  
	         throws SAXException {  
	      // Según la etiqueta guardamos el valor leido   
	      // en una propiedad del objeto libro  
		  // System.out.println(name);
		   
		  if (localName.equals("titulo")){  
	         libro.setTitulo(valor);  
	      }else if (localName.equals("autor")){  
	         libro.setAutor(valor);  
	      }else if (localName.equals("anyo")){  
	         libro.setAnyo(valor);  
	      }else if (localName.equals("editorial")){  
	         libro.setEditorial(valor); 
	         
	         // añado libro al HashMap
	         mapaLibros.put(libro.getIsbn(), libro); 
	      }  
	      
	   }

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		// muestro el mapa de libros cuando termina de leer el documento
		System.out.println(mapaLibros);
		super.endDocument();
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	/**
	 * @return the mapaLibros
	 */
	public Map <String, Libro> getMapaLibros() {
		return mapaLibros;
	}

	/**
	 * @param mapaLibros the mapaLibros to set
	 */
	public void setMapaLibros(Map <String, Libro> mapaLibros) {
		this.mapaLibros = mapaLibros;
	}  
	  
	}  
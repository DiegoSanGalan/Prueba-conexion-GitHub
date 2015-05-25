package xml.clasessax;

import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LibroXML extends DefaultHandler{
	 private String valor = "";  
     
	   private Libro libro;  
	   //MiHashMap mapaLibros = null;
	   // Creo atributo de clase con el HashMap
	   public Map <String, Libro> mapaLibros = new MiHashMap();
	   
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
	    	 		// Al hacer ésto creamos un nuevo objeto que aunque tiene el mismo nombre de variable
	    	 		// referencia a una nueva posición de memoria.
	    	 		// el objeto inicial no se pierde porque hemos almacenado la dirección de memoria
	    	 		// en el HashMap
	    	 String isbn = attributes.getValue("isbn");
	         // Lo guardamos en el objeto libro  
	    	   // con el String no es necesario porque el objeto String cada vez que se modifica
	    	 	// el contenido cambia a una nueva referencia de memoria.
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
		   
		  if (localName.equals("titulo")){  
	         libro.setTitulo(valor);  
	      }else if (localName.equals("autor")){  
	         libro.setAutor(valor);  
	      }else if (localName.equals("anyo")){  
	         libro.setAnyo(valor);  
	      }else if (localName.equals("editorial")){  
	         libro.setEditorial(valor); 
	      }  
	         else if (localName.equals("libro")) {
	        	 // En el momento que encuentre una nueva etiqueta libro con el fin </libro>
	        	 // añado libro al HashMap
	        	 mapaLibros.put(libro.getIsbn(), libro);
	        	 
	        	 // Si queremos que al imprimir el listado con los libros no nos muestre los caracteres
	        	 // específicos del HashMap con las separaciónes tenemos que hacer un "truco"
	        	 // es decir cada vez que llenamos un libro con todos los datos mostramos ése libro
	        	 		//System.out.println(libro.toString());
	         }
	          
	        
	      
	   }

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		
		
		// TODO Auto-generated method stub
		// muestro el mapa de libros cuando termina de leer el documento
		// Al imprimir va a usar el toString que tenemos en Libro con el formato de texto que le pongamos
		// pero muestra los caracteres separadores de elementos del HashMap
		
		System.out.println(mapaLibros.toString());
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
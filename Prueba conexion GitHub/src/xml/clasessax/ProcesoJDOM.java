package xml.clasessax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ProcesoJDOM implements Serializable {
	
	
	public static Integer totalLibros = 0; // atributo de la clase que cuenta los libros totales
	/**
	 * 
	 */
	private static final long serialVersionUID = 1321634073570807095L;

	public static void main(String[] args) throws FileNotFoundException,
			JDOMException, IOException {

		//CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		// en documentJDOM cargarmos todo el archivo libros.xml
		// ésta variable representa a todo el documento .xml
		// el builder es SAX porque ésta libreria utiliza el SAX para cargar el archivo
		Document documentJDOM = builder.build(new FileInputStream("libros.xml"));

		//MOSTRAMOS EL DOCUMENTO
		
		// cojemos el elemento Raiz que en éste caso sería <Libros>
		Element raiz = documentJDOM.getRootElement();
		// Recorremos los hijos de la etiqueta raíz
		
		// en una lista metemos todos los hijos que hay dentro de ése nivel de profundidad
		// el nombre de la variable creada es libros
		List<Element> libros = raiz.getChildren();
		
		// Recorremos la lista utilizando un iterator
		for (Element libro : libros) {
			//para cada libro, obtenemos su detalle
			System.out.println(libro.getAttribute("isbn"));
			List<Element> detalles = libro.getChildren();

			for (Element detalle : detalles) {

				System.out.println("Nombre =" + detalle.getName());
				System.out.println("Valor =" + detalle.getValue());

			}

			
		}
		
		// elemento libros que es el raiz
		Element padre = documentJDOM.getRootElement();
	    
		
		// Creamos una nueva etiqueta  
	    Element nuevolibro = new Element("libro");  
	    // Añadimos un atributo al elemento libro  
	    nuevolibro.setAttribute("isbn", "xxxx-yyyy");
	   
	    
	    
	 // para añadir un nuevo elemento (etiqueta) que cuelga de nuevolibro Titulo
	    Element titulo = new Element("titulo");
	    nuevolibro.addContent(titulo); // añadimos el elemento titulo 
	    titulo.addContent("El loco de la colina"); // añadimos el contenido a titulo
	    
	    // para añadir un nuevo elemento (etiqueta) que cuelga de nuevolibro autor
	    Element autor = new Element("autor");
	    nuevolibro.addContent(autor); // añadimos el elemento autor
	    autor.addContent("Perico de los palotes"); // añadimos el contenido del elemento autor
	    
	    Element anyo = new Element("anyo");
	    nuevolibro.addContent(anyo);
	    anyo.addContent("1999");
	    
	    
	    Element editorial = new Element ("editorial");
	    nuevolibro.addContent(editorial);
	    editorial.addContent("Ediciones EDB");
	   // Cuando terminamos de añadir todos los elementos lo añadimos al principal  
	    padre.addContent(nuevolibro);  

	    
	   //SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA
	    
	    // es un formato ya predefinido en la clase. Para que el .xml quede visible
	    Format format = Format.getPrettyFormat();
	    // Creamos el serializador con el formato deseado  
	    XMLOutputter xmloutputter = new XMLOutputter(format);
	    // Serializamos el document parseado  
	    String docStr = xmloutputter.outputString(documentJDOM); 
	    //Volcamos en un fichero
	    FileWriter fw = new FileWriter("lsalida3.xml");
	    fw.write(docStr);
	    fw.close();
	    
	    
	    // Ahora crearemos un procedimiento que carga el libro .xml en memoria, creo un 
	    // arrayList en memoria y le vuelco el contenido del fichero .xml
	    // ordenarlo por título. Volcar el resultado en un fichero .xml nuevo y 
	    // añadiendo un nuevo nodo que indique el total de libros
		//<total>N<total/>
	    //String nombreArchivo = "";
	    List <Libro>listaXML = new ArrayList<Libro> (); 
	    //nombreArchivo = "lsalida3.xml";
	    
	    // 1.- Parseo (parsing) libros.xml
	    SAXBuilder builderLeer = new SAXBuilder();
	    Document documentJDOMLeer = builderLeer.build(new FileInputStream("libros.xml"));
	    
	    // 2.- y hago el arrayList
	    listaXML = cargarArchivoXML (documentJDOMLeer);
	    
	    //System.out.println("LA LISTA CREADA CONTIENE:  " + listaXML);
	    // 3.- Ordenar ArrayList por Titulo
	    listaXML = ordenarListaXML (listaXML);
	    
	    // muestro la lista ordenada por título
	    System.out.println("LISTA ORDENADA POR TITULO");
	    System.out.println(listaXML);
	    
	    
	    // 4.- crear
	    crearNuevoXML(listaXML);
	    
	    
	    
	    añadirEtiquetaTotal();
	    
	    serializarXML();
	    
	   
	    
	}
	
	/**
	 * Cargo el libro recibido en memoria y lo añado a un arrayList de Libros
	 * @param librosJDOM
	 * @return
	 */
	private static List<Libro> cargarArchivoXML(Document librosJDOM) {
		// TODO Auto-generated method stub
		
		// variables para los atributos del objeto libro
		String isbn = "";  
		String titulo = "";  
		String autor = "";  
		String anyo = "";  
		String editorial = "";  
		
		
		List <Libro>listaSalida = new ArrayList<Libro> ();
		
		
		Element raizleer = librosJDOM.getRootElement();
		
		List<Element> listaLibros = raizleer.getChildren();
		System.out.println("MOSTRAMOS EL FOR DE CARGARxml DIE");
		// Recorremos la lista utilizando un iterator
		for (Element libro : listaLibros) { // primer for
			
			// me creo un nuevo objeto Libro
			Libro miObjetoLibro = new Libro();
			
			// capturo el valor de isbn y lo asigno a la variable isbn tipo String
			isbn = libro.getAttributeValue("isbn");
			
			
			//para cada libro, obtenemos su detalle
			// me creo una Lista de Element
			List<Element> detallesleer = libro.getChildren();

			
			// parseo (recorro) el contenido de libro (los hijos)
			for (Element detalle : detallesleer) { // segundo for

				String etiqueta = detalle.getName();
				
				switch (etiqueta){
				
				case "titulo":titulo = detalle.getValue();
					break;
				
				case "autor": autor = detalle.getValue();
					break;
					
				case "anyo" : anyo = detalle.getValue();
					break;
					
				case "editorial" : editorial = detalle.getValue();
					break;
				
				default: System.out.println("ERROR DE ETIQUETA");
				
				} //fin del switch
				

			} // fin del segundo for
			
			
			// creo el objeto Libro	
			miObjetoLibro.setIsbn(isbn);
			miObjetoLibro.setTitulo(titulo);
			miObjetoLibro.setAutor(autor);
			miObjetoLibro.setAnyo(anyo);
			miObjetoLibro.setEditorial(editorial);
			
			// incremento la variable para contar el numero de libros introducidos.
			totalLibros++;
			
			// añado el libro al arrayList de tipo Libro
			listaSalida.add(miObjetoLibro);
			
		} // fin del primer for
		
		return listaSalida;
	}
	private static void serializarXML() {
		// TODO Auto-generated method stub
		
	}

	private static void añadirEtiquetaTotal() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Función para crear el nuevo xml desde el arrayList
	 * 
	 * @param listaXML
	 * @throws IOException
	 * @throws JDOMException
	 */
	private static void crearNuevoXML(List<Libro> listaXML) throws IOException, JDOMException {
		// TODO Auto-generated method stub
		String nombreXMLNuevo = "mislibros.xml";
	   
		//ELEMENTO RAIZ LIBROS
		Element raizmislibros = new Element ("libros");
		
		
		// me creo el documento xml vacío
		Document documentJDOMEscribir = new Document (raizmislibros);
		
		for (Libro l : listaXML)
		{
			// Creamos una nueva etiqueta 
			// ELEMENTO LIBRO
		    Element nuevolibro = new Element("libro");  
		    // agregar el nuevo libro al raiz 
		    raizmislibros.addContent(nuevolibro); 
		    // Añadimos un atributo al elemento libro 
		    nuevolibro.setAttribute("isbn", l.getIsbn());
		   
		   		    
		 // para añadir un nuevo elemento (etiqueta TITULO) que cuelga de nuevolibro LIBRO
		    Element titulo = new Element("titulo");
		    nuevolibro.addContent(titulo); // añadimos el elemento titulo 
		    titulo.addContent(l.getTitulo()); // añadimos el contenido a titulo
		    
		    // para añadir un nuevo elemento (etiqueta AUTOR) que cuelga de nuevolibro LIBRO
		    Element autor = new Element("autor");
		    nuevolibro.addContent(autor); // añadimos el elemento autor
		    autor.addContent(l.getAutor()); // añadimos el contenido del elemento autor
		    
		    Element anyo = new Element("anyo");
		    nuevolibro.addContent(anyo);
		    anyo.addContent(l.getAnyo());
		    
		    
		    Element editorial = new Element ("editorial");
		    nuevolibro.addContent(editorial);
		    editorial.addContent(l.getEditorial());
		   
		    // Cuando terminamos de añadir todos los elementos lo añadimos al principal  
		    
		    
		}
		
		
		raizmislibros.setAttribute("TotalLibros", totalLibros.toString());
		
		//SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA
	    
	    // es un formato ya predefinido en la clase. Para que el .xml quede visible
	    Format format = Format.getPrettyFormat();
	    // Creamos el serializador con el formato deseado  
	    XMLOutputter xmloutputter = new XMLOutputter(format);
	    // Serializamos el document parseado  
	    String docStr = xmloutputter.outputString(documentJDOMEscribir); 
	    //Volcamos en un fichero
	    FileWriter fw = new FileWriter(nombreXMLNuevo);
	    fw.write(docStr);
	    fw.close();
	    
	}

	
	/**
	 * Método para ordenar por Titulo
	 * Nos hemos creado una clase OrdenarPorTitulo para gestionar el orden sobrecargando
	 * el método compare()
	 * @param listaXML
	 * @return la lista ya ordenada
	 */
	private static List<Libro> ordenarListaXML(List<Libro> listaXML) {

		OrdenarPorTitulo ordenar = new OrdenarPorTitulo();
		listaXML.sort(ordenar);
		/*for (Libro l:listaXML)
		{
			
		}
		
		
		*/
		return listaXML;
	}

	

}

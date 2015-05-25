package xml.clasessax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ProcesoJDOM {
	
	public static void main(String[] args) throws FileNotFoundException,
			JDOMException, IOException {

		//CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		// en documentJDOM cargarmos todo el archivo libros.xml
		// �sta variable representa a todo el documento .xml
		// el builder es SAX porque �sta libreria utiliza el SAX para cargar el archivo
		Document documentJDOM = builder.build(new FileInputStream("libros.xml"));

		//MOSTRAMOS EL DOCUMENTO
		
		// cojemos el elemento Raiz que en �ste caso ser�a <Libros>
		Element raiz = documentJDOM.getRootElement();
		// Recorremos los hijos de la etiqueta ra�z
		
		// en una lista metemos todos los hijos que hay dentro de �se nivel de profundidad
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
	    // A�adimos un atributo al elemento libro  
	    nuevolibro.setAttribute("isbn", "xxxx-yyyy");
	   
	    
	    
	 // para a�adir un nuevo elemento (etiqueta) que cuelga de nuevolibro Titulo
	    Element titulo = new Element("titulo");
	    nuevolibro.addContent(titulo); // a�adimos el elemento titulo 
	    titulo.addContent("El loco de la colina"); // a�adimos el contenido a titulo
	    
	    // para a�adir un nuevo elemento (etiqueta) que cuelga de nuevolibro autor
	    Element autor = new Element("autor");
	    nuevolibro.addContent(autor); // a�adimos el elemento autor
	    autor.addContent("Perico de los palotes"); // a�adimos el contenido del elemento autor
	    
	    Element anyo = new Element("anyo");
	    nuevolibro.addContent(anyo);
	    anyo.addContent("1999");
	    
	    
	    Element editorial = new Element ("editorial");
	    nuevolibro.addContent(editorial);
	    editorial.addContent("Ediciones EDB");
	   // Cuando terminamos de a�adir todos los elementos lo a�adimos al principal  
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
	    
	}

}

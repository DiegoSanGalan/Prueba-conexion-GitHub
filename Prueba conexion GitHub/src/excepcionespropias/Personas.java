package excepcionespropias;


public class Personas {
	
	// Atributos de la clase Personas
	String nombre = "";
	int edad = 0;
	
	/**
	 * Constructor de la clase personas
	 * @param nombre Tipo String
	 * @param Edad Tipo ing
	 */
	public Personas (String name, int age)
	{
		this.nombre = name;
		this.edad = age;
	}

	/** Definir una excepci�n propia, llamada InsertarPersonasException y que se lance al sobrepasar 
	 * el n�mero de personas que incrementamos en nuestra Lista.
	 * Nota: debemos previamente a lanzar nuestra excepci�n, recoger la ArrayIndexOutOfBoundsException
	 * 
	 * crearemos un array de 4 e intentaremos meter 5 para generar nuestra propia excepci�n
	 * que recojamos la excepci�n que genera Java outBoundException y al recogerlo mandemos nuestra excepci�n.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personas []listaPersonas = null; // array de tipo String para almacenar la lista de las personas introducidas
		int numeroDePersonas = 2; // variable para almacenar el numero de personas a introducir
		InsertarPersonaException pasado = null; // pasado es mi variable de tipo excepcion personal
		listaPersonas = new Personas [numeroDePersonas];
		for (int i = 0; i<numeroDePersonas; i++)
		{
			//llenar array de objeto personas
			listaPersonas [i] = new Personas ("Pepe" + i, 18 +i);
		}
		
		//generamos el error a�adiendo uno mas con la funcion insertar Persona
		try {
			insertarPersona (listaPersonas, numeroDePersonas); //metodo a�adir personas
		} catch (ArrayIndexOutOfBoundsException e) { // capturo el error ArrayIndexOutOfBoundsException
			e.printStackTrace();
			System.out.println(e.getMessage()); // mensage que muestra el error ArrayIndexOutOfBoundsException
			
			//creo el objeto pasado del tipo InsertarPersonaException 
			// y le env�o el mensaje personalizado que quiero mostrar
			pasado = new InsertarPersonaException ("No puedes meter a Juanito");
			try {
				throw pasado; // llamo a la excepcion personal
			} catch (InsertarPersonaException e1) {
				e1.printStackTrace();
			}
		}finally {
			System.out.println("Aqui pondr�amos las instruciiones que queremos que se ejecuten siempre");
		}
	}
	
	/**
	 * Funcion para generar el error
	 * @param listaPersonas
	 * @param numeroDePersonas
	 * @throws InsertarPersonaException
	 */
	private static void insertarPersona(Personas [] listaPersonas, int numeroDePersonas) throws ArrayIndexOutOfBoundsException
		{
		listaPersonas[numeroDePersonas + 1] = new Personas("Juanito" + numeroDePersonas, 33);
		}
}

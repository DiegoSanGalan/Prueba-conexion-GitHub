package escribiryleerobjetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Alumnos extends Persona2 implements Serializable
{
	private int nota = 0;
	private enum NOTAS {SUSPENSO, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE};
	private NOTAS notaAlumnoEnumerado = null;
	

	/**
	 * CONSTRUCTOR CREADO AUTOMATICO BOTON DCHO. --> SOURCE --> GENERATE CONSTRUCTOR USING FIELDS
	 * EL CONSTRUCTOR SIRVE TAMBIEN PARA INICIALIZAR EL OBJETO
	 * @param nota
	 */
	public Alumnos(String nombre, byte edad, int nota) 
	{
		super(nombre, edad);  // llama al constructor de persona para que cree nombre y edad
		//NOTAS misnotas = null;
		
		
		this.nota = nota;
		this.setNotaAlumnoEnumerado(this.evaluarNota());
		//System.out.println(Alumnos.NOTAS.values());
		
		//System.out.println(this.evaluarNota()); // llamo a la funcion evaluar nota para usar el tipo enumerado
	
	}
	
	/**
	 * GET BOTON DCHO.--> SOURCE --> GENERATE GETTERS AND SETTERS
	 * PARA OBTENER EL VALOR
	 * @return
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * CREA LOS DOS CON BOTON DCHO. --> SOURCE --> GENERATE GETTERS AND SETTERS
	 * PARA ASIGNAR EL VALOR
	 * @param nota
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	
	/**
	 * @return the notaAlumnoEnumerado
	 */
	public NOTAS getNotaAlumnoEnumerado() {
		return notaAlumnoEnumerado;
	}

	/**
	 * @param notaAlumnoEnumerado the notaAlumnoEnumerado to set
	 */
	public void setNotaAlumnoEnumerado(NOTAS notaAlumnoEnumerado) {
		this.notaAlumnoEnumerado = notaAlumnoEnumerado;
	}

	/**
	 * toString () automático
	 */
	@Override
	public String toString() {
		
		System.out.println("va por aqui toString de Alumnos");
		
		return "Alumnos [nota=" + nota + ", nombre=" + getNombre() + ", edad="
				+ getEdad() + "]";
		
		
	}
	
	
	/**
	 * Funcion para grabar un objeto en un archivo dado por parámetro
	 * @param nombre Tipo String con el nombre del archivo
	 * @param datos Objeto recibido por parámetro con el objeto a grabar en el fichero
	 * @return booleano si es correcto.
	 */
	public static boolean grabarObjeto (String nombre, Alumnos[] datos)
	{
		boolean grabadoOk = true;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream (new File (nombre));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream objectGrabar = null;
		
		try {
			objectGrabar = new ObjectOutputStream (fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			objectGrabar.writeObject(datos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			objectGrabar.close();
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
		
		return grabadoOk;
	}

	
	
	/**
	 * Funcion para leer un objeto desde un archivo dado
	 * @param nombre Tipo String
	 * Como es por referencia el objeto modificado no hace falta que devuelva nada la funcion
	 */
	public static Alumnos[] leerObjeto (String nombre)
	{
		Alumnos[]objetoAlumno = null;
		File archivo = null;
		FileInputStream fis = null;
		ObjectInputStream objectLeer = null;
		archivo = new File (nombre);
		//int contador = 0;
		if (archivo.exists())
		{
			System.out.println("El archivo existe: " + nombre);
			objetoAlumno = new Alumnos [7];
			try {
				fis = new FileInputStream (archivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//while (archivo.length()<contador )
			//{
			
			try {
				objectLeer = new ObjectInputStream (fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				objetoAlumno = (Alumnos[]) objectLeer.readObject();
			//	contador++;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			//}
			}
		}
		else
		{
			System.out.println("El archivo NO EXISTE: " + nombre);
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
		objectLeer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return objetoAlumno;
	
	
	}
	
	
	
	
	
	/**
	 * Funcion evaluarNota del tipo enumerado NOTAS
	 * @return tipo NOTAS con el valor evaluado con el switch
	 * 
	 * 
	 */
	public NOTAS evaluarNota()
	{
		NOTAS notaAlumno = null;
		int nota = 0;
		nota = this.nota;
		
		// Para evaluar la nota del alumno y ver los casos del 0 al 10
		switch (nota)
		{
		
		case 0:	case 1: case 2:case 3:case 4: notaAlumno = NOTAS.SUSPENSO; 
									break;
		case 5: notaAlumno = NOTAS.SUFICIENTE;
		break;
		case 6: notaAlumno = NOTAS.BIEN;
		break;
		case 7: 
		case 8: notaAlumno = NOTAS.NOTABLE;
		break;
		case 9:
		case 10: notaAlumno = NOTAS.SOBRESALIENTE;
		break;
			default: System.out.println("nota no valida");
		}
		return notaAlumno;
		
		
		//return notaAlumno;
	}
	
	

}

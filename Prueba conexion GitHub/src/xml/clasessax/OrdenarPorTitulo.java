package xml.clasessax;

import java.util.Comparator;

import cajondesastre.Persona;

public class OrdenarPorTitulo implements Comparator {
	
	
	@Override
	/**
	 * Método de la clase OrdenarPorNombre que utiliza el compare
	 */
	public int compare(Object arg0, Object arg1) {
		int comparador = 0;
		Libro l1 = null;
		Libro l2 = null;
		l1 = (Libro) arg0;
		l2 = (Libro) arg1;
		
		//utilizamos el metodo compareTo de la clase String
		comparador = l1.getTitulo().compareTo(l2.getTitulo());
		
		
		// TODO Auto-generated method stub
		return comparador;
	}

}

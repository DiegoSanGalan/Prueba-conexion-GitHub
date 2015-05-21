package cajondesastre;

import java.util.Iterator;
import java.util.function.Consumer;

public class RecorerPersonas implements Iterator{
	
	
	/**
	 * Constructor clase RecorerPersonas
	 * @param lista
	 */
	public RecorerPersonas (Persona[] lista)
	{
		//lista.iterator();
		for (Persona i: lista)
		{
			System.out.println(" + Nombre: " + i.getNombre() + " Edad: " + i.getEdad());
		}
		
		
	}

	@Override
	public void forEachRemaining(Consumer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

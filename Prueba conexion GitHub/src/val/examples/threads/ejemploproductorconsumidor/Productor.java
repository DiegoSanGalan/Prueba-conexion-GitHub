package val.examples.threads.ejemploproductorconsumidor;


/**
 * su mision es almacenar en la cola
 * @author alumno
 *
 */
public class Productor implements Runnable {
	
	private Cola cola_productor;
	
	public Productor (Cola c)
	{
		cola_productor = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i = 0;
		while (true)
		{
			cola_productor.almacenar(i);
			System.out.println("El productor almacena = " +i);
			i++;
		}
		
	}

}

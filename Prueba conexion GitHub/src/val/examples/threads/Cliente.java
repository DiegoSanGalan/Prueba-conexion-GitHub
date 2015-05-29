package val.examples.threads;

/**
 * En la clase cliente utilizamos synchronized
 * @author Diego Santamaria
 *
 */
public class Cliente implements Runnable {

	private String nombre;
	//public String bloqueado = new String ("hola");
	@Override
	public void run() {
		Taquilla taquilla = Taquilla.getTaquilla();
		//Integer pruebaBloqueo = new Integer (0);
		for (int i = 0; i < 15; i++) {
			
			try {
				Thread.sleep(3000); // para provocar el fallo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// para evitar el error utilizamos synchronized para que solo entre un objeto
			//o cliente a la vez
			synchronized (taquilla) {
				//pruebaBloqueo++;
				//System.out.println(bloqueado);
				if ((taquilla.quedanEntradas()))
				{
					try {
						Thread.sleep(2000); // forzar el fallo espero a que pasen otros
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					taquilla.comprarEntrada(this);
				} else
					{
					System.out.println("No quedan entradas, se siente");
					}
			}//fin sync
			
		}
		
	}
	
	public Cliente (String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}

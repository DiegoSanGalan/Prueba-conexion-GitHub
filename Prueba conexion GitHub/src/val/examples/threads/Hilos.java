package val.examples.threads;

public class Hilos extends Thread {
    public Hilos(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Km " + i + " : " + getName());
            try {
            	//Hacemos que el c�digo se detenga un tiempo aleatorio
            	// es muy mala pr�ctica es mejor no usarlo. Detener la ejecuci�n de un hilo y 
            	//dejar paso a los dem�s.
            	
					sleep((long)(Math.random() * 2500));
				
            	// mejor usar sleep junto con wait
                
            } catch (InterruptedException e) {}
        }
        System.out.println("Llego a la meta! " + getName());
    }
}
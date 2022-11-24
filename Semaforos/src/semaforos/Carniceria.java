package semaforos;

import java.util.concurrent.Semaphore;

public class Carniceria implements Runnable{
	static Semaphore semaforo = new Semaphore(4);
	
	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 10; i++) {
				semaforo.acquire();
				System.out.println("El cliente " + i + " está siendo atendido");
				Thread.sleep((long) (Math.random()*10000));
				System.out.println("El cliente " + i + " ha terminado en la carnicería");	
				semaforo.release();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		Thread hilo = new Thread();
		hilo.start();
		}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.println("El cliente está siendo atendido");
			Thread.sleep((long) (Math.random()*10000));
			System.out.println("El cliente ha terminado en la carnicería");	
			semaforo.release();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
	
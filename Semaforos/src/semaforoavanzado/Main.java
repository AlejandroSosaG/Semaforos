package semaforoavanzado;

import java.util.concurrent.Semaphore;

public class Main {

static Semaphore carniceria = new Semaphore(4);
static Semaphore charcuteria = new Semaphore(2);

	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 10; i++) {
				Thread hilo = new Thread();
				hilo.start();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		}

	public void run() {
		try {
			carniceria.acquire();
			System.out.println("El cliente está siendo atendido");
			Thread.sleep((long) (Math.random()*10000));
			System.out.println("El cliente ha terminado en la carnicería");	
			carniceria.release();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

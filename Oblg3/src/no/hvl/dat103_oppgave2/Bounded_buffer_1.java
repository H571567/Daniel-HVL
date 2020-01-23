package no.hvl.dat103_oppgave2;


public class Bounded_buffer_1 {

	private int antall;
	private String[] Buffer_Size;
	
	public Bounded_buffer_1() {
		
		antall = 0;
		Buffer_Size = new String[50];
	}
}	
	
	// Producer class
		class Producer2 implements Runnable {

			Bounded_buffer_1 p;

			Producer2(Bounded_buffer_1 p) {
				this.p = p;
				new Thread(this, "Producer").start();
			}

			public void run() {
				
				for (int i = 0; i < 5; i++) {
					// producer put items
					
				}
			}
		}	
			
		//Consumer class 
		class Consumer2 implements Runnable {
			Bounded_buffer_1 c;

			Consumer2(Bounded_buffer_1 c) {
				this.c = c;
				new Thread(this, "Consumer").start();
			}

			public void run() {
				
				
				for (int i = 0; i < 5; i++) {
					// consumer get items
					
				}
			}
		}

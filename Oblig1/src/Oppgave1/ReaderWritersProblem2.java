package Oppgave1;

public class ReaderWritersProblem2 {

	public static void main(String[] args) {

		Read2 leser = new Read2();
		Writer2 skriver = new Writer2();

		// Lesere
		Thread t1 = new Thread(leser);
		t1.setName("Dave");
		Thread t2 = new Thread(leser);
		t2.setName("Dalen");
		Thread t3 = new Thread(leser);
		t3.setName("Simon");
		Thread t4 = new Thread(leser);
		t4.setName("Mats");
		Thread t5 = new Thread(leser);
		t5.setName("Kristine");

		// Skrivere
		Thread t6 = new Thread(skriver);
		t6.setName("DJ");
		Thread t7 = new Thread(skriver);
		t7.setName("DD");
		Thread t8 = new Thread(skriver);
		t8.setName("Vilde");
		Thread t9 = new Thread(skriver);
		t9.setName("Link");
		Thread t10 = new Thread(skriver);
		t10.setName("Jess");

		// Start
		t1.start();
		t2.start();
		t6.start();
		t5.start();
		t3.start();
		t9.start();
		t4.start();
		t7.start();
		t8.start();
		t10.start(); //Meget Linært
		
	}

	// Class for writing using Threads
	static class ThreadSkriver extends Thread {

		Writer2 writer;

		ThreadSkriver() {
			writer = null;
		}

		public void run() {
			// Only one thread can write
			// at a time.
			synchronized (writer) {
				writer.run();
			}
		}
	}

	static class Writer2 implements Runnable {

		public void run() {

			System.out.println(Thread.currentThread().getName() + " skriver");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Thread  interrupted.");
			}
			System.out.println("\n" + Thread.currentThread().getName() + " er ferdig å skrive");
		}
	}

	static class Read2 implements Runnable {

		@Override
		public void run() {

			try {
				System.out.println(Thread.currentThread().getName() + " leser");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Thread  interrupted.");
			}
			System.out.println("\n" + Thread.currentThread().getName() + " er ferdig å lese");
		}
	}
}

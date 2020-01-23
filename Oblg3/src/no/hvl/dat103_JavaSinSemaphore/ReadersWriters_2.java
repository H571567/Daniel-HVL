package no.hvl.dat103_JavaSinSemaphore;

import java.util.concurrent.Semaphore;

public class ReadersWriters_2 {

	// Med java sin semaphore
	static Semaphore readLock = new Semaphore(1);
	static Semaphore writeLock = new Semaphore(1);
	static int readCount = 0;
	
	static class Read implements Runnable {
		@Override
		public void run() {
			try {

				// Acquire Section
				readLock.acquire();
				readCount++;
				if (readCount == 1) {
					writeLock.acquire();
				}
				readLock.release();
				
				// Reading Section
				System.out.println(Thread.currentThread().getName()
						+ " leser");
				Thread.sleep(2500);
				System.out.println("Leseren " + Thread.currentThread().getName() 
						+ " er ferdig");
				
				//Releasing section
				readLock.acquire();
				readCount--;
				if (readCount == 0) {
					writeLock.release();
				}
				readLock.release();
				
			} catch (InterruptedException e) {
				System.out.print(e.getMessage());
			}
		}
	}
	
	static class Write implements Runnable {
		
		@Override
		public void run() {
			
			try {
				
				writeLock.acquire();
				System.out.println(Thread.currentThread().getName() 
						+ " skriver");
				Thread.sleep(2500);
				System.out.println(Thread.currentThread().getName() 
						+ " er ferdig med å skrive");
				writeLock.release();
				
			} catch (InterruptedException e) {
				System.out.print(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {

		Read leser = new Read();
		Write skriver = new Write();
		
		//Lesere
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
		
		//Skrivere
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
		
		//Start
		t1.start();
		t2.start();
		t6.start();
		t5.start();
		t3.start();
		t9.start();
		t4.start();
		t7.start();
		t8.start();
		t10.start();
		
	}
}

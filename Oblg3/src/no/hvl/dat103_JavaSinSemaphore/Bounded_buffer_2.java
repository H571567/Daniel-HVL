package no.hvl.dat103_JavaSinSemaphore;

//Java implementation of a producer and consumer 
//that use semaphores to control synchronization. 

import java.util.concurrent.Semaphore;

public class Bounded_buffer_2 {

	// Med java sin Semaphore
	
	int item;
	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	// Main metoden
	public static void main(String args[]) {
		// creating buffer queue
		Bounded_buffer_2 q = new Bounded_buffer_2();

		// starting consumer thread
		new Consumer(q);

		// starting producer thread
		new Producer(q);
	}

	// to get an item from buffer
	void get() {
		
		try {
			// Before consumer can consume an item,
			// it must acquire a permit from semCon
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// consumer consuming an item
		System.out.println("Consumer consumed item : " + item);

		// After consumer consumes the item,
		// it releases semProd to notify producer
		semProd.release();
	}

	// to put an item in buffer
	void put(int item) {
		
		try {
			// Before producer can produce an item,
			// it must acquire a permit from semProd
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// producer producing an item
		this.item = item;

		System.out.println("Producer produced item : " + item);

		// After producer produces the item,
		// it releases semCon to notify consumer
		semCon.release();
	}
}

	// Producer class
	class Producer implements Runnable {

		Bounded_buffer_2 p;

		Producer(Bounded_buffer_2 p) {
			this.p = p;
			new Thread(this, "Producer").start();
		}

		public void run() {
			for (int i = 0; i < 5; i++)
				// producer put items
				p.put(i);
		}
	}

	//Consumer class 
	class Consumer implements Runnable {
		Bounded_buffer_2 c;

		Consumer(Bounded_buffer_2 c) {
			this.c = c;
			new Thread(this, "Consumer").start();
		}

		public void run() {
			for (int i = 0; i < 5; i++)
				// consumer get items
				c.get();
		}
	}

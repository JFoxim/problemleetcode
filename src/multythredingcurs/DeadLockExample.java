package multythredingcurs;

public class DeadLockExample {
	public static final Object lock1 = new Object();
	public static final Object lock2 = new Object();
	
	public static void main(String[] args) {
		Thread10 thread10 = new Thread10();
		Thread20 thread20 = new Thread20();
		thread10.start();
		thread20.start();
	}
}

class Thread10 extends Thread{	
	public void run(){
		System.out.println("Thread10: попытка захватить монитор lock 1");
		synchronized (DeadLockExample.lock1) {
			System.out.println("Thread10: монитор lock 1 хахвачен");
			System.out.println("Thread10: попытка захватить монитор lock 2");
			synchronized (DeadLockExample.lock2) {
				System.out.println("Thread10: мониторы lock 1 и lock 2 хахвачен");
			}			
		}		
	}
}

class Thread20 extends Thread{	
	public void run(){
		System.out.println("Thread20: попытка захватить монитор lock 2");
		synchronized (DeadLockExample.lock2) {
			System.out.println("Thread20: монитор lock 2 хахвачен");
			System.out.println("Thread20: попытка захватить монитор lock 1");
			synchronized (DeadLockExample.lock1) {
				System.out.println("Thread20: мониторы lock 1 и lock 2 хахвачен");
			}			
		}		
	}
}

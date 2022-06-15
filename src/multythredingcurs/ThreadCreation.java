package multythredingcurs;

public class ThreadCreation {

	public static void main(String[] args) {
		MyThread1 myThread1 = new MyThread1();
		Thread mythread2 = new Thread(new Mythread2());

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 22; i > 12; i--) {
					System.out.println(Thread.currentThread().getName() + " " + i);
				}
			}
		}).start();

		new Thread(() -> {
			for (int i = 10; i < 20; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}).start();

		myThread1.start();
		mythread2.start();
	}
}

class Mythread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

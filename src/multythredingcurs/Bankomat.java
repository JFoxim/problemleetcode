package multythredingcurs;

import java.io.InterruptedIOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {

	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
        new Employee("Zaur", lock);
        new Employee("Oleg", lock);
        new Employee("Elena", lock);
        Thread.sleep(5000);
        new Employee("Viktor", lock);
        new Employee("Marina", lock);
	}

}

class Employee extends Thread {
	String name;
	private Lock lock;

	public Employee(String name, Lock lock) {
		this.lock = lock;
		this.name = name;
		this.start();
	}

	public void run() {
		if (lock.tryLock())
		try {
			System.out.println(name + " ждёт...");
			//lock.lock();
			System.out.println(name + " пользуется банкоматом");
			Thread.sleep(2000);
			System.out.println(name + " завершил");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		else {
			System.out.println(name + " не хочет ждать в очереди");
		}
	}
}

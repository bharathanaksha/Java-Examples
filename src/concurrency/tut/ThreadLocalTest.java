package concurrency.tut;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task(), "FIRST THREAD");
		Thread t2 = new Thread(new Task(), "SECOND THREAD");
		t1.start();
		t2.start();
	}

}

class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("Task.run() = " + MyThreadLocal.getLocal());
		Context context = new Context();
		context.print();
	}
}

class Context {
	public void print() {
		System.out.println("Context Data is " + MyThreadLocal.getLocal()
				+ " for thread " + Thread.currentThread().getName());
	}
}

class MyThreadLocal {

	private static ThreadLocal<String> local = new ThreadLocal<String>() {

		private final AtomicInteger atomic = new AtomicInteger(266);

		@Override
		protected String initialValue() {
			return "DEFAULT Val " + atomic.getAndIncrement();
		}
	};

	public static void setLocal(String str) {
		local.set(str);
	}

	public static String getLocal() {
		return local.get();
	}
}

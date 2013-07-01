package concurrency.tut;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class worker implements Runnable {

	ReentrantLock lock;
	private final String name;

	public worker(ReentrantLock lock, String name) {
		this.lock = lock;
		this.name = name;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println("********************Example.worker " + name
				+ " start******");
		print();
		lock.lock();
		System.out.println("LOCK HOLD COUNT = " + lock.getHoldCount());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		lock.unlock();
		System.out.println("***********************Example.worker " + name
				+ " end******");
		System.out.println("LOCK HOLD COUNT = " + lock.getHoldCount());
		print();
		lock.unlock();
		System.out.println("LOCK HOLD COUNT = " + lock.getHoldCount());
	}

	private void print() {
		System.out.println("HA QUEUED THREADS= " + lock.hasQueuedThreads());
		System.out.println("QUEUE LENGTH = " + lock.getQueueLength());
		System.out.println("LOCK HOLD COUNT = " + lock.getHoldCount());
	}
}

class TryLockWorker implements Runnable {

	ReentrantLock lock;
	private final String name;

	public TryLockWorker(ReentrantLock lock, String name) {
		this.lock = lock;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("********************TryLockWorker " + name
				+ " start******");
		
		System.out.println("TRY GETTING THE LOCK TRY 1 = "+lock.tryLock());
		System.out.println("TRY GETTING THE LOCK TRY 2 = "+lock.tryLock());
		System.out.println("LOCK HOLD COUNT = " + lock.getHoldCount());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		lock.unlock();
		System.out.println("***********************TryLockWorker " + name
				+ " end******");
		lock.unlock();
	}
}
/**
 * Example created for Learning ReentrantLock.
 * 
 * @author bharathkumarr
 *
 */
public class ReentrantLockExample {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock(true);

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		try {
			for (int i = 0; i < 3; i++) {
				worker worker = new worker(lock, "Thread " + i);
				executorService.submit(worker);
			}
			executorService.submit(new TryLockWorker(lock, "TRY LOCK WORKER"));
		} catch (Exception e) {
		} finally {
			executorService.shutdown();
		}

		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

	}
}

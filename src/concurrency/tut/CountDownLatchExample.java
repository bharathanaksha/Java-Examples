package concurrency.tut;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example on CountDownLatch.
 * 
 * @author bharathkumarr
 *
 */
class WorkerClass implements Runnable {
	CountDownLatch startLatch, endLatch;

	public WorkerClass(CountDownLatch startLatch, CountDownLatch endLatch) {
		this.startLatch = startLatch;
		this.endLatch = endLatch;
	}

	@Override
	public void run() {
		try {
			startLatch.await();
			System.out.println("WORKERCLASS.RUN() THREAD RUNNING");
			Thread.sleep(3000);
			System.out.println("WORKERCLASS.RUN() THREAD COMPLETED");
		} catch (InterruptedException e) {
		}
		endLatch.countDown();
	}
}

public class CountDownLatchExample {
	public static void main(String[] args) {
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch endLatch = new CountDownLatch(3);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		try {
			for (int i = 0; i < 3; i++) {
				executorService.submit(new WorkerClass(startLatch, endLatch));
			}
			System.out.println("NOW INITATING ALL THE THREADS.");
			// start all the threads
			Thread.sleep(2000);
			startLatch.countDown();
			
			System.out.println("WAIT UNTILL ALL THE THREADS COMPLETE.");
			
			endLatch.await();
			
			System.out.println("TASKS DONE!!!!!!!!");

		} catch (InterruptedException e) {
		} finally {
			executorService.shutdown();
		}

	}
}

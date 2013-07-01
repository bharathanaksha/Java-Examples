package concurrency.tut;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Example on cyclicBarrier.
 * 
 * @author bharathkumarr
 *
 */
class WorkerThread implements Runnable {

	CyclicBarrier barrier;

	boolean reset;

	public WorkerThread(CyclicBarrier barrier, boolean reset) {
		this.barrier = barrier;
		this.reset = reset;
	}

	@Override
	public void run() {
		System.out.println("START THE TASK" + this.toString());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("END THE TASK" + this.toString());

		try {
			System.out.println("BARRIER WAIT BY " + this.toString());
			System.out.println("NUMBER OF PARTIES WAITING FOR THE BARIER "
					+ barrier.getNumberWaiting());
			System.out
					.println("NUMBER OF PARTIES YET REQUIRED TO TRIP THE BARRIER "
							+ barrier.getParties());
			if (this.reset) {
				barrier.reset();
			}
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
			System.out.println("BrokenBarrierException BARRIER IS BROKEN ? "
					+ barrier.isBroken());
		}
	}
}

public class CyclicBarrierExample {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("COMPLETED ALL THE TASKS MERGE IT NOW");
			}
		});
		ExecutorService executorService = Executors.newCachedThreadPool();
		try {
			boolean reset;
			for (int i = 0; i < 3; i++) {
				reset = i == 1 ? true : false;
				executorService.submit(new WorkerThread(barrier, reset));
			}
		} finally {
			executorService.shutdown();
		}

		executorService.awaitTermination(1, TimeUnit.HOURS);
	}

}

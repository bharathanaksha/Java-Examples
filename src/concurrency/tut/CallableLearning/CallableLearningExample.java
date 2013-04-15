package concurrency.tut.CallableLearning;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer> {

	private final int id;

	public MyThread(int id) {
		this.id = id;
	}

	@Override
	public Integer call() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return id;
	}
}

public class CallableLearningExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		try {
			for (int i = 0; i < 5; i++) {
				Future<Integer> future = executorService.submit(new MyThread(i));
				try {
					if (i == 1) {
						future.cancel(true);
					}
					System.out.println("Thread " + i + " Return Value = " + future.get());
				} catch (InterruptedException e) {
				} catch (ExecutionException e) {
				} catch (CancellationException e) {
					System.out
						.println(" The second thread is cancelled using Future so it Came up with CancellationException for future.get() method on the second thread");
				}
			}
		} finally {
			executorService.shutdown();
		}

		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

	}

}

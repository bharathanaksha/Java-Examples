package concurrency.tut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Example created for Learning Executor Service.
 * 
 * @author bharathkumarr
 *
 */
public class ExecutorServiceLearning2 {

	public static void main(String[] args) {
		Callable<Integer> callable = Executors.callable(new Runnable() {
			@Override
			public void run() {
				System.out.println("*******START THE THREAD********");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				System.out.println("*******END THE THREAD********");
			}
		}, new Integer(12));
		ExecutorService executorService = Executors.newCachedThreadPool();

		List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
		for (int i = 0; i < 5; i++) {
			callables.add(callable);
		}
		
		try {
			Future<Integer> future = executorService.submit(callable);

			List<Future<Integer>> invokeAll = executorService
					.invokeAll(callables);

			executorService.shutdown();
			executorService.awaitTermination(1, TimeUnit.DAYS);
			try {
				System.out.println("TRY FETCHING THE RESULT = " + future.get());

				for (int i = 0; i < invokeAll.size(); i++) {
					System.out.println("TRY FETCHING THE RESULT = "
							+ invokeAll.get(i).get());
				}
			} catch (ExecutionException e) {
			}
		} catch (InterruptedException e) {
		} finally {
		}

	}

}

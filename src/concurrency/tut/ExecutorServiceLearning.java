package concurrency.tut;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/**
 * 
 * Example created for Learning Executor Service.
 * 
 * @author bharathkumarr
 *
 */
public class ExecutorServiceLearning {

	public void doTasks(ExecutorService executorService) {

		System.out.println(executorService);
		try {
			for (int i = 0; i < 10; i++) {
				final int j = i;
				executorService.submit(new Runnable() {
					@Override
					public void run() {
						System.out.println("THREAD EXCECUTION START = " + j);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
						}
						System.out.println("THREAD EXCECUTION END = " + j);
					}
				});
			}
		} finally {
			executorService.shutdown();
		}

		System.out
				.println("Main Thread starts waiting the for the termination*******");
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}
		System.out.println("Main Thread ends waiting and terminates*******");
	}

	public void doTasks(ScheduledExecutorService executorService) {

		System.out.println(executorService);
		try {
			for (int i = 0; i < 10; i++) {
				final int j = i;
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						System.out.println("THREAD EXCECUTION START = " + j);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
						}
						System.out.println("THREAD EXCECUTION END = " + j);
					}
				};
				executorService.schedule(runnable, 10000, TimeUnit.MILLISECONDS);
			}
		} finally {
			executorService.shutdown();
		}

		System.out
				.println("Main Thread starts waiting the for the termination*******");
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

		System.out.println("Main Thread ends waiting and terminates*******");
	}

	public static void main(String[] args) {
		ExecutorServiceLearning executorServiceLearning = new ExecutorServiceLearning();
		ExecutorService executorService = null;
		DataInputStream dataInputStream = new DataInputStream(
				new BufferedInputStream(System.in));
		try {
			System.out.println("******Enter the Choice******");
			int readLine = Integer.parseInt(dataInputStream.readLine());
			System.out.println(readLine);
			switch (readLine) {
			case 1:
				System.out.println("******newSingleThreadExecutor******");
				executorService = Executors.newSingleThreadExecutor();
				executorServiceLearning.doTasks(executorService);
				break;
			case 2:
				System.out.println("******newCachedThreadPool******");
				executorService = Executors.newCachedThreadPool();
				executorServiceLearning.doTasks(executorService);
				break;
			case 3:
				System.out.println("******newFixedThreadPool******");
				executorService = Executors.newFixedThreadPool(3);
				executorServiceLearning.doTasks(executorService);
				break;
			case 4:
				System.out
						.println("******newFixedThreadPool With My THREAD FACTORY******");
				executorService = Executors.newFixedThreadPool(3,
						new ThreadFactory() {
							@Override
							public Thread newThread(Runnable r) {
								System.out
										.println("**MY THREAD FACTORY RETURNING THREADS");
								return new Thread(r);
							}
						});
				executorServiceLearning.doTasks(executorService);
				break;

			case 5:
				System.out
						.println("******newSingleThreadScheduledExecutor******");
				executorServiceLearning.doTasks(Executors
						.newSingleThreadScheduledExecutor());
				break;
			default:
				System.out
						.println("******Default newSingleThreadExecutor******");
				executorService = Executors.newSingleThreadExecutor();
				break;
			}

		} catch (IOException e1) {
		}
		System.out.println("DO TASK*****" + executorService);

	}
}

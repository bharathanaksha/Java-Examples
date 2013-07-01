package concurrency.tut;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyState {
	private int count;
	private boolean isUpdated;

	public MyState() {
		isUpdated = false;
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public boolean setUpdated(boolean isUpdated) {
		return this.isUpdated = isUpdated;
	}

	public int getCount() {
		return count;
	}

	public void updateCount() {
		this.count++;
	}
}

class ProducerEX implements Runnable {

	ReentrantLock lock;

	MyState state;

	Condition condition;

	public ProducerEX(ReentrantLock lock, MyState state, Condition condition) {
		this.lock = lock;
		this.state = state;
		this.condition = condition;
	}

	@Override
	public void run() {
		while (state.getCount() < 10) {
			try {
				lock.lock();
				Thread.sleep(1000);
				state.updateCount();
				System.out.println("ProducerEX.run() Updated the STATE = "
						+ state.getCount());
				state.setUpdated(true);

				System.out.println("WAKE UP CONSUMER...");
				condition.signalAll();

				System.out.println("PRODUCER STARTS WAITING...");

				while (state.isUpdated()) {
					condition.await();
				}
				System.out.println("PRODUCER ENDS WAITING...");

			} catch (InterruptedException e) {
			}

			finally {
				lock.unlock();
			}

		}
	}
}

class ConsumerEX implements Runnable {

	ReentrantLock lock;
	MyState state;
	Condition condition;

	public ConsumerEX(ReentrantLock lock, MyState state, Condition condition) {
		this.lock = lock;
		this.state = state;
		this.condition = condition;
	}

	@Override
	public void run() {
		while (state.getCount() < 10) {
			try {
				System.out.println("CONSUMER STARTS WAITING...");
				lock.lock();
				while (!state.isUpdated()) {
					condition.await();
				}
				System.out.println("CONSUMER ENDS WAITING...");

				System.out.println("ConsumerEX.run() got the UPDATED STATE = "
						+ state.getCount());
				state.setUpdated(false);

				System.out.println("WAKE UP PRODUCER...");
				condition.signalAll();

			} catch (InterruptedException e) {

			} finally {
				lock.unlock();
			}

		}
	}

}

/**
 * 
 * Producer Consumer Example Using RentrantLock and Condition.
 * 
 * @author bharathkumarr
 *
 */
public class ProducerConsumerExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		MyState state = new MyState();
		try {
			executorService.submit(new ProducerEX(lock, state, condition));
			executorService.submit(new ConsumerEX(lock, state, condition));
		} catch (Exception e) {
		} finally {
			executorService.shutdown();
		}

		try {
			executorService.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
		}

	}

}

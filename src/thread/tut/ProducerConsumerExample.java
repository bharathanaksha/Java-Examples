package thread.tut;

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
		System.out.println("MyState.getCount() Accessed by Thread "+Thread.currentThread().getName());
		return count;
	}

	public void updateCount() {
		this.count++;
	}
}

class Producer extends Thread {

	private final MyState state;

	public Producer(MyState state2) {
		super("Producer");
		this.state = state2;
	}

	@Override
	public void run() {
		synchronized (state) {
			while (state.getCount() != 20) {
				while (state.isUpdated()) {
					try {
						state.wait();
					} catch (InterruptedException e) {
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				state.updateCount();
				System.out.println("PRODUCER Thread NAME " +getName() +" ID = "+ getId() +" COUNT = "
						+ state.getCount());
				state.setUpdated(true);
				state.notify();
			}
		}
	}
}

class Consumer extends Thread {

	private final MyState state;

	public Consumer(MyState object) {
		super("Consumer");
		this.state = object;
	}

	@Override
	public void run() {
		synchronized (state) {
			while (state.getCount() != 20) {
				while (!state.isUpdated()) {
					try {
						state.wait();
					} catch (InterruptedException e) {
					}
				}
				System.out.println("CONSUMER THREAD " +getName() +" ID = "+ getId() +" GOT THE COUNT UPDATE = "
						+ state.getCount());
				state.setUpdated(false);
				state.notify();
			}
		}
	}
}


/**
 * 
 * Producer Consumer Problem example using wait() and notify() methods .
 * 
 * @author Bharath Kumar R
 *
 */
public class ProducerConsumerExample {
	public static void main(String[] args) {
		MyState state = new MyState();
		Producer producerThread = new Producer(state);
		Consumer consumerThread = new Consumer(state);
		producerThread.start();
		consumerThread.start();
		System.out.println("ThreadExample.main() MAIN STARTS WAITING ");
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
		}
		System.out.println("ThreadExample.main() MAIN ENDS WAITING ");
		
	}
}

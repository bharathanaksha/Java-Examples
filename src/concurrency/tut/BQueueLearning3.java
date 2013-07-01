package concurrency.tut;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * usage of take() and put() method from BlockingQueue
 * @author BHARATH
 */
class Consumer2 implements Runnable {
	BlockingQueue<Integer> blockingQueue;

	public Consumer2(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			
			Integer ret = null;
			try {
				//take() method , if queue is empty waits for element to be added
				ret = blockingQueue.take();
			} catch (InterruptedException e) {
			}
			System.out.println("remove() Size " + blockingQueue.size()
					+ " ele = " + ret);
		}
	}
}

class Producer2 implements Runnable {

	BlockingQueue<Integer> blockingQueue;

	public Producer2(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		while (true) {
			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			Integer createObject = createObject();
			System.out.println("add() Size " + blockingQueue.size()+"ele = "+createObject);
			
			//put() method , if queue is Full waits for free position in the queue to put the element.
			try {
				blockingQueue.put(createObject);
			} catch (InterruptedException e) {
			}
		}
	}

	private Integer createObject() {
		return new Random().nextInt(10000);
	}
}

public class BQueueLearning3 {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(
				10);

		new Thread(new Consumer2(blockingQueue)).start();
		new Thread(new Producer2(blockingQueue)).start();
		new Thread(new Producer2(blockingQueue)).start();
	}

}

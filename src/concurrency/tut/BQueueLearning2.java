package concurrency.tut;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * usage of poll() and offer() method from BlockingQueue
 * @author BHARATH
 */
class Consumer1 implements Runnable {
	BlockingQueue<Integer> blockingQueue;

	public Consumer1(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			//poll() method returns null if queue is empty.
			Integer ret = blockingQueue.poll();
			System.out.println("remove() Size " + blockingQueue.size()
					+ " ele = " + ret);
			if(ret == null){
				System.out.println("<<<<QUEUE EMPTY>>>>");
			}
		}
	}
}

class Producer1 implements Runnable {

	BlockingQueue<Integer> blockingQueue;

	public Producer1(BlockingQueue<Integer> blockingQueue) {
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
			
			//offer() method returns false if queue is Full.
			boolean ret = blockingQueue.offer(createObject);
			if (!ret) {
				System.out.println("<<<<QUEUE FULL>>>>");
			}
		}
	}

	private Integer createObject() {
		return new Random().nextInt(10000);
	}
}

public class BQueueLearning2 {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(
				10);

		new Thread(new Consumer2(blockingQueue)).start();
		new Thread(new Producer1(blockingQueue)).start();
		new Thread(new Producer1(blockingQueue)).start();
	}

}

package concurrency.tut;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * usage of add() and remove() method from BlockingQueue
 * @author BHARATH
 */
class Consumer implements Runnable {
	BlockingQueue<Integer> blockingQueue;

	public Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			try {
				//if queue if empty add() throws NoSuchElementException
				Integer remove = blockingQueue.remove();
				System.out.println("remove() Size " + blockingQueue.size()+" ele = "+remove);
				
			} catch (NoSuchElementException e) {
				System.out.println("<<<<<<QUEUE EMPTY>>>>>");
			}
		}
	}

}

class Producer implements Runnable {

	BlockingQueue<Integer> blockingQueue;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			try {
				//if queue if full add() throws IllegalStateException
				blockingQueue.add(createObject());
			} catch (IllegalStateException e) {
				System.out.println("<<<<<<QUEUE FULL>>>>>");
			}
		}
	}

	private Integer createObject() {
		return new Random().nextInt(10000);
	}
}

public class BQueueLearning1 {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(
				10) {
			@Override
			public boolean add(Integer e) {
				System.out.println("add() " + e.intValue() + " Size = "
						+ size());
				return super.add(e);
			}

			@Override
			public Integer remove() {
				
				return super.remove();
			}
		};

		new Thread(new Consumer(blockingQueue)).start();
		new Thread(new Producer(blockingQueue)).start();
		new Thread(new Producer(blockingQueue)).start();
	}

}

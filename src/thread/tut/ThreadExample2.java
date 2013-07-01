package thread.tut;

class Worker extends Thread{
	
	@Override
	public void run() {
		System.out.println("Worker.run()");
	}
	
	public void instanceMethod() {
		System.out.println("( OUTSIDE SYNCHRONIZED BLOCK ) Worker in instanceMethod hold the lock on this object "+Thread.holdsLock(this));
		System.out.println("( OUTSIDE SYNCHRONIZED BLOCK ) Worker in instanceMethod hold the lock on class object ==> "+Thread.holdsLock(Worker.class));
		synchronized (this) {
			System.out.println("( INSIDE SYNCHRONIZED BLOCK ) Worker in instanceMethod hold the lock on this object "+Thread.holdsLock(this));
			System.out.println("( INSIDE SYNCHRONIZED BLOCK ) Worker in instanceMethod hold the lock on class object ==> "+Thread.holdsLock(Worker.class));
		}
	}
	
	public static void StaticMethod(){
		System.out.println("( OUTSIDE SYNCHRONIZED BLOCK ) Worker in StaticMethod hold the lock on class object ==> "+Thread.holdsLock(Worker.class));
		synchronized (Worker.class) {
			System.out.println("( INSIDE SYNCHRONIZED BLOCK ) Worker in StaticMethod hold the lock on class object ==> "+Thread.holdsLock(Worker.class));
		}
	}
}

public class ThreadExample2 {
	public static void main(String[] args) throws InterruptedException {
		Worker worker =  new Worker();
		Worker.StaticMethod();
		worker.instanceMethod();
		//calling run normally using the thread instance will not run the Thread in the new Stack.
		worker.run();
		//calling start using the thread instance will run the Thread in the new Stack.
		worker.start();
		Thread.sleep(100);
		//once Thread is Completed (in DEAD STATE ) calling start() again on the Thread Throws the java.lang.IllegalThreadStateException.
		worker .start();
	}
}

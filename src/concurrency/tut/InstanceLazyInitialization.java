package concurrency.tut;

/**
 * 
 * 
 * @author Bharath Kumar R
 * 
 *         Double check idiom.
 */
public class InstanceLazyInitialization {

	private volatile Object data;

	public Object getData() {
		Object object = data;
		if (object == null) {
			synchronized (this) {
				object = data;
				if (object == null) {
					data = object = "DONE";
				}
			}
		}
		return object;
	}
	
	public static void main(String[] args) {
		InstanceLazyInitialization initialization = new InstanceLazyInitialization();
		initialization.getData();
		System.out.println("InstanceLazyInitialization.main() = "+initialization.getData().toString());
	}

}

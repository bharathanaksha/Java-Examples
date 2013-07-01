package concurrency.tut;

/**
 * 
 * 
 * @author Bharath Kumar R
 * 
 *         Initialize on demand holder class idiom.
 */
public class StaticLazyInitialization {

	private StaticLazyInitialization() {
		System.out.println("CONSTRUCTOR");
	}

	public static StaticLazyInitialization getInstance() {
		return InstanceProvider.instance;
	}

	static class InstanceProvider {
		public static StaticLazyInitialization instance = getInstance();

		public static StaticLazyInitialization getInstance() {
			System.out.println("StaticLazyInitialization.getInstance() Called");
			if (instance == null) {
				instance = new StaticLazyInitialization();
			}
			return instance;
		}
	}

	public static void main(String[] args) {
		System.out.println("StaticLazyInitialization.main()"
				+ StaticLazyInitialization.getInstance());
	}

}

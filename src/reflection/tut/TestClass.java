package reflection.tut;

public class TestClass implements Comparable {

	public int y;
	public int x;
	private int res;

	public TestClass(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

}

package enumex.tut;

public enum EnumLearning2 {
	JAN (0),
	FEB (2),
	MAR (3);
	
	private int val;
	
	EnumLearning2(int val){
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
	
}

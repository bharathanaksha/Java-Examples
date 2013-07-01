package enumex.tut;

public class EnumLearning2Main {

	public static void main(String[] args) {
		for (EnumLearning2 value : EnumLearning2.values()) {
			System.out.print("NAME = "+ value.name()+" ORDINAL = "+value.ordinal());
			System.out.println(" VALUE = "+ value.getVal());
		}
		
		EnumLearning2 value = EnumLearning2.JAN; 
		 if(value == EnumLearning2.JAN){
			 System.out.println("ITS JANUARY..its COLD");
		 }
		 
		 value = EnumLearning2.MAR;
		 
		 
		 //using the switch for the values of the EnumLearning enum.
		 switch(value){
		 case JAN: 
			 System.out.println("ITS JANUARY..its COLD");
			 break;
		 case FEB: 
			 System.out.println("ITS JANUARY..its HOT");
			 break;
		 case MAR: 
			 System.out.println("ITS JANUARY..its too HOT");
			 break;
			 
			 
		 
		 }
		
	}
	
}

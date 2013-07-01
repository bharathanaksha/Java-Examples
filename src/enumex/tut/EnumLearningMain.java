package enumex.tut;

public class EnumLearningMain {
	
	public static void main(String[] args) {
		
		//printing all the values defined in the EnumLearning enum.
	 for(EnumLearning value:EnumLearning.values()){
		 System.out.println("NAME = "+ value.name()+" ORDINAL = "+value.ordinal());
	 }
	 
	 //if condition for value defined in the EnumLearning enum.
	 EnumLearning value = EnumLearning.JAN; 
	 if(value == EnumLearning.JAN){
		 System.out.println("ITS JANUARY..its COLD");
	 }
	 
	 value = EnumLearning.MAR;
	 
	 
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

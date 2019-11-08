
public class Manager {
	
	private String name;
	private String ID;
	private String Password;
    public static String Questions[]=new String [6];
	

	public String getName() {
		return name;
	}


	public String getID() {
		return ID;
	}


	public String getPassword() {
		return Password;
	}

	public void GetQuestions() { 
		
		
		Questions [0]= "1- employee is good:";
		Questions [1]= "2- employee is kind :";
		Questions [2]= "3- employee is intelgent:";
		Questions [3]= "4- employee is fast :";
		Questions [4]= "5- employee is best:";
		Questions [5]= "6- how many tasks employee did it :";
		
		for(int i = 0; i<6;i++) {
			System.out.println(Questions[i]);
			
		}
		

	}
}

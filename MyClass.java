
public class MyClass {

	public static void main(String[] args) {
		
		SuperVisor s1 = new SuperVisor();
		Manager m1 = new Manager();
		Empolyee E1 = new Empolyee();
		System.out.println("Format Of Manager:");
		m1.GetQuestions();
		System.out.println("---------------------------------------------");
	    s1.Answer();
	    System.out.println("----------------------------------------------");
	    E1.displayRate();
	    
          
	}

}

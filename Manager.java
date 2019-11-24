// is this
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Manager {

	Manager (){

	}


	public void promote () {
		

	}



	public void searchForEmployee() {
		Scanner input = new Scanner (System.in);

	}


	public void showEmployees() {
		Scanner input = new Scanner (System.in);
		System.out.println("please select one:");
		System.out.println(" 1 - Supervisor");
		System.out.println(" 2- Sales man");
		System.out.println(" 3- Worker");
		int select = input.nextInt();
		switch(select) {
		case 1 : 
			//ssssss
			
			break;
		case 2 : 
			//ssss
			
			break;
		case 3 :
			//dada

			break;

		default:
			//sssss
		}

	}

	public void storageAndFinancialManagment() {
		
	}
	
	public void setTarget() throws IOException {
		Scanner input = new Scanner (System.in);
		String FileName = "Target Of SuperVisor";
		FileWriter in = new FileWriter(FileName+".txt");
		BufferedWriter buf = new BufferedWriter(in);
		
		System.out.println("Welcome manager:");
		System.out.println("please Set target:");
		int Target = input.nextInt();
		buf.write("Target Of SuperVisor: "+Target);
		buf.newLine();
		buf.close();
		System.out.println("Ok, you set target = "+Target);
		
		input.close();
	}
	

	public void firingEmployee() {
		
	}
}

import java.util.Scanner;
public class SuperVisor {
	Manager m2 ;
	char check [] = new char [6];
	private String name;
	private String ID;
	private	String Password;
	public int t ;


	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public String getPassword() {
		return Password;

	}
	int T = 0;
	int F = 0;
	public void Answer () {
		Scanner input = new Scanner (System.in);


		for (int i= 0; i<6;i++) {

			System.out.println("questions " + (1+i) + ": "+m2.Questions[i]); 
			check [i] = input.next().charAt(0);
			if (  check [i] == 'T' || check [i] == 't' ) {
				T++;
			} else if (check [i] == 'F' || check [i] == 'f' ) {
				F++;
			}


		}

		if(check [5] == '0') {
			T += 0;
		}
		else if(check [5] == '1') {
			T+=1;
		}
		else if(check [5] == '2') {
			T+=2;
		}
		else if(check [5] == '3') {
			T+=3;

		}

		else if(check [5] =='4') {
			T+=4;
		}
		else if(check [5] == '5') {
			T+=5;
		}     


		System.out.println("Rate of this employee is "+ T + " of 10");
		input.close();
	}
}

package FactorySystem;
import java.util.ArrayList;
import java.util.Scanner;
public class SuperVisor extends Employee {
	private Employee[] workers = new Employee[5];
	private int numOfWorkers;

	public SuperVisor(Employee superVisor) {
		super(

				superVisor.getId(), superVisor.getPassword(),
				superVisor.getName(), superVisor.getSalary(),
				superVisor.getBonus(), superVisor.getMonthlyRate(),
				superVisor.getOverallRate(), superVisor.getHiringDate(),
				superVisor.getPhoneNumber(), superVisor.getEmail(),
				superVisor.getAddress(),
				superVisor.getBankAccount(),superVisor.getBirthDate());

		int numberOfWorkers = 0;
		for (int i = 0; i < 5; i++) {
			if (this.workers[i] != null) {
				numberOfWorkers++;
			} else {
				break;
			}
		}
		this.numOfWorkers = numberOfWorkers;

	}
	public Employee showWorkersInformation(ArrayList<Employee>Workers) {
		Scanner input = new Scanner(System.in);
		int index = 0;
		ArrayList<String> SuperVisors = new ArrayList<String>();
		FileData.getData(SuperVisors,"SuperVisors");
		
		for (int i = 0; i < SuperVisors.size(); i++) {
			if (this.getId().equalsIgnoreCase(SuperVisors.get(i).substring(0,SuperVisors.get(i).indexOf('#')))) {
				index = i;
				break;
			}
		}	
		ArrayList<String> WorkersId = new ArrayList<String>();
		FileData.getData(WorkersId,"WorkersId.txt");
		String[] workersid = WorkersId.get(index).split("#");
		int ind = 0;
		for (int i = 0; i < workersid.length; i++) {
			for (int j = 0; j < Workers.size(); j++) {
				if (workersid[i] == Workers.get(j).getId()) {
					this.workers[ind++] = Workers.get(j);
					break;
				}
			}
		}
		int numOfWorkers = 0;
		for (;;) {
			for (int i = 0; i < 5; i++) {
				if (this.workers[i] != null) {
					System.out.println((i + 1) + "- " + this.workers[i].getName());
					numOfWorkers++;
				} else {
					System.out.println((i + 1) + "- " + "Back");
					break;
				}
			}
			System.out.print("Choose : ");
			String inn = input.next();
			if (inn.equals("1") && Integer.parseInt(inn) <= numOfWorkers) {
				System.out.println("name of this employee is" + workers[0].getName());
				System.out.println("id of this employee is" + workers[0].getId());
				System.out.println("phone number of this employee is" + workers[0].getPhoneNumber());
				System.out.println("email of this employee is" + workers[0].getEmail());
				System.out.println("address of this employee is" + workers[0].getAddress());
				System.out.println("hiring date of this employee is" + workers[0].getHiringDate());
				System.out.println("overall rate of this employee is" + workers[0].getOverallRate());
				System.out.println("----------------------------------------------------");
				return workers[0];
			} else if (inn.equals("2") && Integer.parseInt(inn) <= numOfWorkers) {
				System.out.println("name of this employee is" + workers[1].getName());
				System.out.println("id of this employee is" + workers[1].getId());
				System.out.println("phone number of this employee is" + workers[1].getPhoneNumber());
				System.out.println("email of this employee is" + workers[1].getEmail());
				System.out.println("address of this employee is" + workers[1].getAddress());
				System.out.println("hiring date of this employee is" + workers[1].getHiringDate());
				System.out.println("overall rate of this employee is" + workers[1].getOverallRate());
				System.out.println("----------------------------------------------------");
				return workers[1];
			} else if (inn.equals("3") && Integer.parseInt(inn) <= numOfWorkers) {
				System.out.println("name of this employee is" + workers[2].getName());
				System.out.println("id of this employee is" + workers[2].getId());
				System.out.println("phone number of this employee is" + workers[2].getPhoneNumber());
				System.out.println("email of this employee is" + workers[2].getEmail());
				System.out.println("address of this employee is" + workers[2].getAddress());
				System.out.println("hiring date of this employee is" + workers[2].getHiringDate());
				System.out.println("overall rate of this employee is" + workers[2].getOverallRate());
				System.out.println("----------------------------------------------------");
				return workers[2];
			} else if (inn.equals("4") && Integer.parseInt(inn) <= numOfWorkers) {
				System.out.println("name of this employee is" + workers[3].getName());
				System.out.println("id of this employee is" + workers[3].getId());
				System.out.println("phone number of this employee is" + workers[3].getPhoneNumber());
				System.out.println("email of this employee is" + workers[3].getEmail());
				System.out.println("address of this employee is" + workers[3].getAddress());
				System.out.println("hiring date of this employee is" + workers[3].getHiringDate());
				System.out.println("overall rate of this employee is" + workers[3].getOverallRate());
				System.out.println("----------------------------------------------------");
				return workers[3];
			} else if (inn.equals("5") && Integer.parseInt(inn) <= numOfWorkers) {
				System.out.println("name of this employee is" + workers[4].getName());
				System.out.println("id of this employee is" + workers[4].getId());
				System.out.println("phone number of this employee is" + workers[4].getPhoneNumber());
				System.out.println("email of this employee is" + workers[4].getEmail());
				System.out.println("address of this employee is" + workers[4].getAddress());
				System.out.println("hiring date of this employee is" + workers[4].getHiringDate());
				System.out.println("overall rate of this employee is" + workers[4].getOverallRate());
				System.out.println("----------------------------------------------------");
				return workers[4];
			} else {
				break;
			}
		}
		return null;
	}
	
	public double answerFeedback() {
		Scanner input = new Scanner(System.in);
		double Y = 0;
		String answer;
		String questions[] = new String[7];
		questions[0] = "Does the worker come on time ? : ";
		questions[1] = "Does the worker have passion on work ? : ";
		questions[2] = "Is the worker good at collaborating with teammates ? : ";
		questions[3] = "Does the worker behave well ? : ";
		questions[4] = "Does the worker do his job efficiently ? : ";
		questions[5] = "Does the worker bear the pressure of work ? : ";
		questions[6] = "-->So the number of goods made by him is : ";

		for (int i = 0; i < 6; i++) {
			System.out.print(questions[i]);
			answer = input.next();
			if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("T")) {
				Y++;
			}
		}
		int target = super.showTarget();
		System.out.print(questions[6]);
		for (;;) {
			answer = input.next();

			if (Integer.parseInt(answer) > target) {
				System.out.print("You entered a number greater than the target please try again : ");
			} else {
				Y += ((Double.parseDouble(answer) / target) * 4);
				break;
			}
		}
		return Y;
	}
	
	@Override
	public int showTarget(){
		super.showTarget();
		String TargetLine = FileData.getData("Target.txt") ;
		String[] Line = TargetLine.split("#");
		System.out.println("The total team target is : " + (Integer.parseInt(Line[1]) * numOfWorkers));
		return (Integer.parseInt(Line[1]) * numOfWorkers);
	}
	
	public int setTargetResult() {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter the number of manufactured goods this month");
		String  amount = input.next();
		int target = this.showTarget();
		System.out.println("And your team manufactured " + amount + " goods this month ..");
		double ratio = (Integer.parseInt(amount) * 1.0) / target;
		this.setMonthlyRate(ratio * 10);
		this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
	return Integer.parseInt(amount);
	}
	

}

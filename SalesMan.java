
import java.util.ArrayList;
import java.util.Scanner;

public class SalesMan extends Employee {

	public SalesMan(Employee salesMan) {
		super(salesMan.getId(), salesMan.getPassword(), salesMan.getName(), salesMan.getSalary(), salesMan.getBonus(),
				salesMan.getMonthlyRate(), salesMan.getOverallRate(), salesMan.getHiringDate(),
				salesMan.getPhoneNumber(), salesMan.getEmail(), salesMan.getAddress(), salesMan.getBankAccount(),
				salesMan.getBirthDate());

	}

	public int setTargetResult() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of manufactured goods this month");
		String amount = input.next();
		int target = this.showTarget();
		System.out.println("And your sold " + amount + " goods this month ..");
		double ratio = (Integer.parseInt(amount) * 1.0) / target;
		this.setMonthlyRate(ratio * 10);
		this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
		return Integer.parseInt(amount);
	}

	@Override
	public int showTarget() {
		ArrayList<String> lines = new ArrayList<String>();
		FileData.getData(lines, "Target.txt");
		String line = lines.get(1);
		System.out.println("The Target is to sell \"" + line + "\"goods this month");
		return (Integer.parseInt(line));
	}
}

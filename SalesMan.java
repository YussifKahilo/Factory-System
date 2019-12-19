
///**
//* his class is responsible for the sales man of the factory and all his connection in the system.
//* he can show his target and set the target he has made.
//* @author Mohamed Ahmed EL-Sayed
//* @ID 220180220  
// */
import java.util.Scanner;

public class SalesMan extends Employee {

	/// **
	// * Sales man constructor.
	// *
	// * @param salesMan a reference from the Employee to access its methods and
	// * attributes.
	// */
	public SalesMan(Employee salesMan) {
		super(salesMan.getId(), salesMan.getPassword(), salesMan.getName(), salesMan.getSalary(), salesMan.getBonus(),
				salesMan.getMonthlyRate(), salesMan.getOverallRate(), salesMan.getHiringDate(),
				salesMan.getPhoneNumber(), salesMan.getEmail(), salesMan.getAddress(), salesMan.getBankAccount(),
				salesMan.getBirthDate());
	}

	/// **
	// * sets the target result.
	// *
	// * @param reference of target class.
	// * @return the target.
	// */
	public int setTargetResult(Target target) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of sold goods this month");
		String amount = input.next();
		long satTarget = this.showTarget(target);
		System.out.println("And your sold " + amount + " goods this month ..");
		double ratio = (Integer.parseInt(amount) * 1.0) / satTarget;
		this.setMonthlyRate(ratio * 10);
		this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
		return Integer.parseInt(amount);
	}

	/// **
	// * shows the target to the salesman .
	// */
	@Override
	public long showTarget(Target target) {
		System.out.println("The Target is to sell \"" + target.getTargetOfGoodsToBeSold() + "\"goods this month");
		System.out.println(
				"And the target for each Sales Man is \"" + target.getTargetOfGoodsToBeSoldByEachSalesMan() + "\"");
		return target.getTargetOfGoodsToBeSoldByEachSalesMan();
	}
}

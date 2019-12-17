
import java.util.Scanner;

public class SalesMan extends Employee {
<<<<<<< HEAD
	/**
	 * Sales man constructor.
	 * 
	 * @param salesMan a reference from the Employee to access its methods and
	 *                 attributes.
	 */
	public SalesMan(Employee salesMan) {
		super(salesMan.getId(), salesMan.getPassword(), salesMan.getName(), salesMan.getSalary(), salesMan.getBonus(),
				salesMan.getMonthlyRate(), salesMan.getOverallRate(), salesMan.getHiringDate(),
				salesMan.getPhoneNumber(), salesMan.getEmail(), salesMan.getAddress(), salesMan.getBankAccount(),
				salesMan.getBirthDate());
	}

	/**
	 * sets the target result.
	 * 
	 * @param reference of target class.
	 * @return the target.
	 */
	public int setTargetResult(Target target) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of sold goods this month");
		String amount = input.next();
		int satTarget = this.showTarget(target);
		System.out.println("And your sold " + amount + " goods this month ..");
		double ratio = (Integer.parseInt(amount) * 1.0) / satTarget;
		this.setMonthlyRate(ratio * 10);
		this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
		return Integer.parseInt(amount);
	}

	/**
	 * shows the target to the salesman .
	 */
	@Override
	public int showTarget(Target target) {
		System.out.println("The Target is to sell \"" + target.getTargetOfGoodsToBeSold() + "\"goods this month");
		return target.getTargetOfGoodsToBeSold();
	}
=======

    public SalesMan(Employee salesMan) {
        super(salesMan.getId(), salesMan.getPassword(), salesMan.getName(), salesMan.getSalary(), salesMan.getBonus(),
                salesMan.getMonthlyRate(), salesMan.getOverallRate(), salesMan.getHiringDate(),
                salesMan.getPhoneNumber(), salesMan.getEmail(), salesMan.getAddress(), salesMan.getBankAccount(),
                salesMan.getBirthDate());
    }

    public int setTargetResult(Target target) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of sold goods this month");
        String amount = input.next();
        int satTarget = this.showTarget(target);
        System.out.println("And your sold " + amount + " goods this month ..");
        double ratio = (Integer.parseInt(amount) * 1.0) / satTarget;
        this.setMonthlyRate(ratio * 10);
        this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
        return Integer.parseInt(amount);
    }

    @Override
    public int showTarget(Target target) {
        System.out.println("The Target is to sell \"" + target.getTargetOfGoodsToBeSold() + "\"goods this month");
        return target.getTargetOfGoodsToBeSold();
    }
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd
}

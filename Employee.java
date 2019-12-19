
///**
// * this class arranges the employees functions and their attributes.
//* everyone has email,name,phone number,salary,bonus,birth date and address.
//* @author Eslam Amin Ahmed.
//* @ID 220180018
//*/
import java.util.*;

public class Employee extends Person {
	// attributes of every employee in the factory.
	private BankAccount bankAccount;
	private String email;
	private double salary;
	private String phoneNumber;
	private double bonus;
	private String hiringDate;
	private double monthlyRate;
	private double overallRate;
	private Address address;
	private BirthDate birthdate;

	/// **
	// * employee constructor.
	// *
	// * @param id of an employee.
	// * @param password of account of an employee.
	// * @param name of an employee.
	// * @param salary of an employee.
	// * @param bonus of an employee.
	// * @param monthlyRate of an employee.
	// * @param overallRate of an employee.
	// * @param hiringDate when the employee is hired.
	// * @param phoneNumber of an employee.
	// * @param email of an employee.
	// * @param address of an employee.
	// * @param bankAccount of an employee.
	// * @param birthdate of an employee.
	// */
	public Employee(String id, String password, String name, double salary, double bonus, double monthlyRate,
			double overallRate, String hiringDate, String phoneNumber, String email, Address address,
			BankAccount bankAccount, BirthDate birthdate) {
		super(id, name, password);
		this.bankAccount = bankAccount;
		this.email = email;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.bonus = bonus;
		this.hiringDate = hiringDate;
		this.monthlyRate = monthlyRate;
		this.overallRate = overallRate;
		this.address = address;
		this.birthdate = birthdate;
	}

	/// **
	// *
	// *@return employee's bank account.
	// */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/// **
	// *
	// *@return employee's address.
	// */
	public Address getAddress() {
		return address;
	}

	/// **
	// * set an address to epmloyee's address
	// * @param address to be set.
	// */
	public void setAddress(int apartmentNumber, int floorNumber, int buildingNumber, String streetName, String block,
			String city) {
		this.address = new Address(apartmentNumber, floorNumber, buildingNumber, streetName, block, city);
	}

	/// *
	// * @return employee's email.
	// */
	public String getEmail() {
		return email;
	}

	/// **
	// * set an email to epmloyee's email
	// * @param emial to be set.
	// */
	public void setEmail(String email) {
		this.email = email;
	}

	/// *
	// * @return employee's salary.
	// */
	public double getSalary() {
		return salary;
	}

	/// **
	// * set a salary to epmloyee's salary
	// * @param salary to be set.
	// */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/// *
	// * @return employee's phone number.
	// */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/// **
	// * set a phone number to epmloyee's phone number.
	// * @param phone number to be set.
	// */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/// *
	// * @return employee's bonus.
	// */
	public double getBonus() {
		return bonus;
	}

	/// **
	// * set an bonus to epmloyee's bonus
	// * @param bonus to be set.
	// */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	/// *
	// * @return employee's hiring date.
	// */
	public String getHiringDate() {
		return hiringDate;
	}

	/// *
	// * @return employee's monthly rate.
	// */
	public double getMonthlyRate() {
		return monthlyRate;
	}

	/// **
	// * set a monthly rate to employee's rate
	// * @param monthly rate to be set.
	// */
	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	/// *
	// * @return employee's over all rate.
	// */
	public double getOverallRate() {
		return overallRate;
	}

	/// **
	// * set an over all rate to employee's rate
	// * @param over all rate to be set.
	// */
	public void setOverallRate(double overallRate) {
		this.overallRate = overallRate;
	}

	/// *
	// * @return employee's birth date.
	// */
	public BirthDate getBirthDate() {
		return birthdate;
	}

	/// **
	// * takes an amount from an employee's bank account.
	// *
	// * @param amount to be taken.
	// */
	public void withDraw(double amount) {
		double balance = bankAccount.getBalance();
		if (amount > balance) {
			System.out.println("your balance is less than the amount ");
		} else {
			bankAccount.setBalance(balance - amount);
		}
	}

	/// **
	// * adds an amount to an employee's bank account.
	// *
	// * @param amount to be added.
	// */
	public void deposit(double amount) {
		bankAccount.setBalance(amount + bankAccount.getBalance());
	}

	/// **
	// * edits an employee's name
	// *
	// * @param input a reference from scanner class.
	// */
	public void editName(Scanner input) {
		System.out.println("Enter Your Name : ");
		input.nextLine();
		String newName = input.nextLine();
		setName(newName);
	}

	/// **
	// * edits an employee's password.
	// *
	// * @param input a reference from scanner class.
	// */
	public void editPassword(Scanner input) {
		boolean isPasswordValid = false;
		do {
			UserMenu.passwordConditions();
			System.out.print("Enter a password : ");
			String newPaswword = input.next();
			if (FactorySystem.isPasswordValid(newPaswword)) {
				System.out.println("input the password Again: ");
				String confirmingPassword = input.next();
				if (confirmingPassword.equals(newPaswword)) {
					setPassword(newPaswword);
					isPasswordValid = true;// to break the loop if the password is valid.
				} else {
					System.out.println("The Two Passwords aren't identical");
				}
			} else {
				System.out.println("Invalid Password");
			}

		} while (!isPasswordValid);
	}

	/// **
	// * edits the phone number of an employee.
	// *
	// * @param input a reference from scanner class.
	// */
	public void editPhoneNumber(Scanner input) {
		boolean isInvalid = true;
		System.out.println("Enter Your new Phone number : ");
		do {
			String newPhoneNumber = input.next();
			if (newPhoneNumber.length() == 11 && newPhoneNumber.startsWith("01")) {
				isInvalid = true; // to break the loop if the number is valid.
				setPhoneNumber(newPhoneNumber);

			} else {
				System.out.println("invalid input\nEnter the phone number again :: ");
				isInvalid = false;
			}
		} while (!isInvalid);
	}

	/// **
	// * edits the email of an employee.
	// *
	// * @param input a reference from Scanner Class.
	// */
	public void editEmail(Scanner input) {
		System.out.println("enter Your New Email : ");
		boolean isValidEmail = false;
		do {
			String newEmail = input.next();
			if (newEmail.contains("@") && newEmail.contains(".com")) {
				isValidEmail = true;// to break the loop is the email is valid.
				setEmail(newEmail);
			} else {
				System.out.println("invalid input\nEnter the email again :: ");
			}
		} while (!isValidEmail);
	}

	// **
	// * edits the address where an employee lives.
	// *
	// * @param input a reference from Scanner Class.
	// */
	public void editAddress(Scanner input) {
		System.out.println("Enter Your new Address : ");
		System.out.print("-->Apartment Number : ");
		String apartmentNumber = input.next();
		System.out.print("-->Floor number : ");
		String floorNumber = input.next();
		System.out.print("-->Bulding Number : ");
		String buildingNumber = input.next();
		System.out.print("-->Street name : ");
		input.nextLine();
		String streetName = input.nextLine();
		System.out.print("-->Block name : ");
		String blockName = input.nextLine();
		System.out.print("-->City name : ");
		String cityName = input.nextLine();
		setAddress(Integer.parseInt(apartmentNumber), Integer.parseInt(floorNumber), Integer.parseInt(buildingNumber),
				streetName, blockName, cityName);
	}

	/// **
	// * edits information of an employee.
	// */
	public void editInformations() {
		Scanner input = new Scanner(System.in);
		boolean ifEditAgain = true;
		do {
			UserMenu.editMenu();
			// input the choice of the menu from the employee.
			int chosenEdit = input.nextInt();
			if (chosenEdit == 1) {
				editName(input);
			} else if (chosenEdit == 2) {
				editPassword(input);
			} else if (chosenEdit == 3) {
				editPhoneNumber(input);
			} else if (chosenEdit == 4) {
				editAddress(input);
			} else if (chosenEdit == 5) {
				editEmail(input);
			} else if (chosenEdit == 6) {
				ifEditAgain = false;// to break the loop and back to the last menu.
			} else {
				System.out.println("invalid input.");

			}
			/// *
			// * to check if the "if edit again " is still true.
			// */
			if (ifEditAgain) {
				System.out.println("Do you want to edit another ?\n(Press 'y' if you want) ::");
				char editAgain = input.next().charAt(0);
				if (Character.toLowerCase(editAgain) == 'y') {
					ifEditAgain = true;
				} else {
					ifEditAgain = false;
				}
			}
		} while (ifEditAgain);
	}

	/// **
	// * shows information of an employee.
	// */
	public void showInformations() {
		System.out.println("*--------------------------------------------------------------------------");
		System.out.println("|Name                    : " + this.getName());
		System.out.println("|ID                      : " + this.getId());
		System.out.println("|Bonus                   : " + this.getBonus());
		System.out.println("|Salary                  : " + this.getSalary());
		System.out.println("|Salary after Bonus      : " + (this.getSalary() + (this.getBonus() * this.getSalary())));
		System.out.println("|Overall Rate            : " + this.getOverallRate());
		System.out.println("|Bank account            : " + this.getBankAccount().getAccountNumber());
		System.out.println("|Balance in the account  : " + this.getBankAccount().getBalance());
		System.out.println("|Phone Number            : " + this.getPhoneNumber());
		System.out.println("|E-mail                  : " + this.getEmail());
		System.out.println("|Address                 : " + this.getAddress().Display_Address());
		System.out.println("*--------------------------------------------------------------------------");
	}

	/// **
	// * shows the target.
	// *
	// * @param target that will be showed.
	// * @return the target of each worker.
	// */
	public long showTarget(Target target) {
		System.out.println("The Target this month is : " + target.getTargetOfGoodsToBeManufactured());
		System.out.println("Target for each worker is : " + target.getTargetOfGoodsToBeManufacturedForEachWorker());
		return target.getTargetOfGoodsToBeManufacturedForEachWorker();
	}

	/// **
	// * the way of saving the data to the file.
	// */
	public String toString() {
		return getId() + "#" + getPassword() + "#" + getName() + "#" + salary + "#" + bonus + "#" + monthlyRate + "#"
				+ overallRate + "#" + hiringDate + "#" + phoneNumber + "#" + email + "#" + address.toString() + "#"
				+ bankAccount.getAccountNumber() + "#" + bankAccount.getBalance() + "#" + birthdate.getDay() + "#"
				+ birthdate.getMonth() + "#" + birthdate.getYear();
	}

}

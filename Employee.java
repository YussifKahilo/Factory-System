import java.io.IOException;
import java.util.Scanner;

public class Employee extends Person {

	private BankAccount bankAccount;
	private String email;
	private double salary;
	private String phoneNumber;
	private double bonus;
	private String hiringDate;
	private double monthlyRate;
	private double overallRate;
	private Address address;

	public Employee() {

	}

	public Employee(String id, String password, String name, double salary, double bonus, double monthlyRate,
			double overallRate, String hiringDate, String phoneNumber, String email, int houseNumber, int flateNumber,
			String streetName, String place, String bankAccountNumber, double balance) {
		super(id, name, password);
		this.bankAccount = new BankAccount(bankAccountNumber, balance);
		this.email = email;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.bonus = bonus;
		this.hiringDate = hiringDate;
		this.monthlyRate = monthlyRate;
		this.overallRate = overallRate;
		this.address = new Address(houseNumber, flateNumber, streetName, place);
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(String hiringDate) {
		this.hiringDate = hiringDate;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public double getOverallRate() {
		return overallRate;
	}

	public void setOverallRate(double overallRate) {
		this.overallRate = overallRate;
	}

	public void editInformations() throws IOException {
		User user = new User();
		Scanner input = new Scanner(System.in);
		boolean Continue = true;
		boolean passwordValid=false;
		while (Continue) {
			System.out.println("To Change :\n1- Name\n2- password\n3- phone number");
			String choice = input.next();
			if (choice.equalsIgnoreCase("1")) {
				this.setName(input.next());
				Continue = false;
			} else if (choice.equalsIgnoreCase("2")) {
				while(!passwordValid) {
					System.out.println("(INFO)=> \n :: Your pass word must have at least : ");
					System.out.println("   - Four Charecters \n  - One upercase letter . "
							+ "\n   - One lowercase letter . " + "\n   - One Number or Symbol .");
					System.out.print("Enter a password : ");
					String password = input.next();
					if (user.isPasswordValid(password)) {
						this.setPassword(password);
						passwordValid=true;
					}
					Continue = false;
				}
			} else if (choice.equalsIgnoreCase("3")) {
				this.setPhoneNumber(input.next());
				Continue = false;
			} else {
				System.out.println("invalid input\nchoose Again");
				Continue = true;
			}
		}
		if (this.getId().startsWith("22")) {
			user.updateInformations("Workers");
		} else if (this.getId().startsWith("33")) {
			user.updateInformations("SuperVisors");
		} else if (this.getId().startsWith("44")) {
			user.updateInformations("SalesMan");
		}

		input.close();
	}

	public void withDraw(double amount) {
		double balance = bankAccount.getBalance();
		if (amount > balance) {
			System.out.println("your balance is less than the amount ");
		} else {
			bankAccount.setBalance(balance - amount);
		}
	}

	public void deposit(double amount) {
		bankAccount.setBalance(amount + bankAccount.getBalance());
	}

	public void showInformations() {
		System.out.println("Welcome : " + this.getName().substring(0, this.getName().indexOf(" ")) + "your ID is : "
				+ this.getId() + "your Bonus is : " + this.getBonus() + "your Salary is : " + this.getSalary()
				+ "your Salary after Bonus is : " + (this.getSalary() + this.getBonus()) + "your Overall Rate is : "
				+ this.getOverallRate() + "Your Bank account is : " + this.getBankAccount().getAccountNumber()
				+ "Your Balance in the account is : " + this.getBankAccount().getBalance() + "Your Phone Number is : "
				+ this.getPhoneNumber() + "Your E-mail is : " + this.getEmail());
	}

	public String toString() {
		return "";
	}

}


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

	public Employee(String id, String name, String password, double salary, double overallRate, double monthlyRate,
			String hiringDate, double bonus, Address adress, double balance, String bankAccountNumber) {
		super(id, name, password);
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

	public void editInformations() {

	}

	public void withDraw(double amount) {
		double balance =bankAccount.getBalance();
		if(amount > balance) {
			System.out.println("your balance is less than the amount ");
		}
		else {
			bankAccount.setBalance(balance-amount);
		}
	}

	public void deposit(double amount) {
		bankAccount.setBalance(amount + bankAccount.getBalance());
	}

	public void showInformations() {

	}

	public String toString() {
		return "";
	}

}

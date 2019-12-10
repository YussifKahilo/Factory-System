
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
	private BirthDate birthdate;

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

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(int houseNumber, int flateNumber, int blookNumber, String streetName, String place) {
		this.address = new Address(houseNumber, flateNumber, blookNumber, streetName, place);
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

	public BirthDate getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(int dayOfBirth, int monthOfBirth, int yearOfBirth) {
		this.birthdate = new BirthDate(dayOfBirth, monthOfBirth, yearOfBirth);
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
		System.out.println("*--------------------------------------------------------------------------");
		System.out.println("|Name                    : " + this.getName());
		System.out.println("|ID                      : " + this.getId());
		System.out.println("|Bonus                   : " + (this.getBonus() / 100) + "%");
		System.out.println("|Salary                  : " + this.getSalary());
		System.out.println("|Salary after Bonus      : " + (this.getSalary() + (this.getBonus() * this.getSalary())));
		System.out.println("|Overall Rate            : " + this.getOverallRate());
		System.out.println("|Bank account            : " + this.getBankAccount().getAccountNumber());
		System.out.println("|Balance in the account  : " + this.getBankAccount().getBalance());
		System.out.println("|Phone Number            : " + this.getPhoneNumber());
		System.out.println("|E-mail                  : " + this.getEmail());
		System.out.println("|Address                 : " + this.getAddress().toString());
		System.out.println("*--------------------------------------------------------------------------");
	}

	public int showTarget() {
		String line = FileData.getData("Target.txt");
		String[] str = line.split("#");
		System.out.println("The Target this month is : " + str[0]);
		System.out.println("Target for each worker is : " + str[1]);
		return Integer.parseInt(str[1]);
	}

	public String toString() {
		return getId() + "#" + getPassword() + "#" + getName() + "#" + salary + "#" + bonus + "#" + monthlyRate + "#"
				+ overallRate + "#" + hiringDate + "#" + phoneNumber + "#" + email + "#" + address.getHouseNumber()
				+ "#" + address.getFloorNumber() + "#" + address.getBlockNumber() + "#" + address.getStreetName() + "#"
				+ address.getRegion() + "#" + bankAccount.getAccountNumber() + "#" + bankAccount.getBalance();
	}
}

package FactorySystem;

import java.io.BufferedReader;
import java.io.FileReader;
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

    public void setAddress(int houseNumber, int flateNumber,
            String streetName, String place) {
        this.address.setHouseNumber(houseNumber);
        this.address.setFlateNumber(flateNumber);
        this.address.setStreetName(streetName);
        this.address.setPlace(place);
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
        while (true) {
            System.out.println("To Change :\n 1- Name\n 2- password\n 3- phone number\n 4- E-Mail\n 5- Address");
            System.out.print("::");
            String choice = input.next();
            if (choice.equalsIgnoreCase("1")) {
                System.out.print("Enter Your Name : ");
                this.setName(input.nextLine());
                break;
            } else if (choice.equalsIgnoreCase("2")) {
                while (true) {
                    System.out.println("(INFO)=> \n :: Your pass word must have at least : ");
                    System.out.println("   - Four Charecters \n  - One upercase letter . "
                            + "\n   - One lowercase letter . " + "\n   - One Number or Symbol .");
                    System.out.print("Enter a password : ");
                    String password = input.next();
                    if (user.isPasswordValid(password)) {
                        while (true) {
                            System.out.print("Confirm your password : ");
                            String password2 = input.next();
                            if (password.equals(password2)) {
                                break;
                            } else {
                                System.out.println("The two password are not identical ..");
                            }
                        }
                        this.setPassword(password);
                        break;
                    }
                    break;
                }
            } else if (choice.equalsIgnoreCase("3")) {
                System.out.print("Enter Yout phone number :");
                this.setPhoneNumber(input.next());
                break;
            } else if (choice.equalsIgnoreCase("4")) {
                System.out.print("Enter your E-Mail :");
                this.setEmail(input.next());
                break;
            } else if (choice.equalsIgnoreCase("5")) {
                System.out.print("Enter your house number : ");
                int houseNumber = input.nextInt();
                System.out.print("Enter your flat number : ");
                int flatNumber = input.nextInt();
                System.out.print("Enter your street name : ");
                String streetName = input.next();
                System.out.print("Enter your place name : ");
                String placeName = input.next();
                this.setAddress(houseNumber, flatNumber, streetName, placeName);
                break;
            } else {
                System.out.println("invalid input\nchoose Again");
                break;
            }
        }
        if (this.getId().startsWith("22")) {
            user.updateInformations("Workers",this);
        } else if (this.getId().startsWith("33")) {
            user.updateInformations("SuperVisors",this);
        } else if (this.getId().startsWith("44")) {
            user.updateInformations("SalesMan",this);
        }
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

    public int showTarget() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("Target.txt"));
        String line = reader.readLine();
        String [] Line = line.split("#");
        System.out.println("The Target this month is : " + Line[0]);
        System.out.println("Target for each worker is : " + Line[1]);
        reader.close();
        return 0;
    }
    
    public String toString() {
        return getId() + "#" + getPassword() + "#" + getName() + "#" + getSalary() + "#" + getBonus() + "#" + getMonthlyRate() + "#"
                + getOverallRate() + "#" + getHiringDate() + "#" + getPhoneNumber() + "#" + getEmail() + "#" + getAddress().getHouseNumber()
                + "#" + getAddress().getFlateNumber() + "#" + getAddress().getStreetName() + "#" + getAddress().getPlace()
                + "#" + getBankAccount().getAccountNumber() + "#" + getBankAccount().getBalance();
    }
}

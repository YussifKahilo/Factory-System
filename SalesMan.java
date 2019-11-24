package FactorySystem;

public class SalesMan extends Employee{

    public SalesMan(Employee salesMan) {
        super(
                salesMan.getId(), salesMan.getPassword(),
                salesMan.getName(),salesMan.getSalary(),
                salesMan.getBonus(),salesMan.getMonthlyRate(),
                salesMan.getOverallRate(),salesMan.getHiringDate(),
                salesMan.getPhoneNumber(),salesMan.getEmail(),
                salesMan.getAddress().getHouseNumber(),
                salesMan.getAddress().getFlateNumber(),
                salesMan.getAddress().getStreetName(),
                salesMan.getAddress().getPlace(),
                salesMan.getBankAccount().getAccountNumber(),
                salesMan.getBankAccount().getBalance());
                
    }

}

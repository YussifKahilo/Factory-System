package FactorySystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SalesMan extends Employee {
    
    public SalesMan(Employee salesMan) {
        super(
                salesMan.getId(), salesMan.getPassword(),
                salesMan.getName(), salesMan.getSalary(),
                salesMan.getBonus(), salesMan.getMonthlyRate(),
                salesMan.getOverallRate(), salesMan.getHiringDate(),
                salesMan.getPhoneNumber(), salesMan.getEmail(),
                salesMan.getAddress().getHouseNumber(),
                salesMan.getAddress().getFlateNumber(),
                salesMan.getAddress().getStreetName(),
                salesMan.getAddress().getPlace(),
                salesMan.getBankAccount().getAccountNumber(),
                salesMan.getBankAccount().getBalance());
        
    }
    
    public void setTargetResult(int amount, int target) throws IOException {
        Storage storage = new Storage();
        System.out.println("And your sold "+ amount + " goods this month ..");
        storage.setNumberOfSoldGoods(amount);
        double ratio = (amount * 1.0) / target;
        this.setMonthlyRate(ratio * 10);
        this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
    }
    
    @Override
    public int showTarget() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Target.txt"));
        String line = reader.readLine();
        line = reader.readLine();
        System.out.println("The Target is to sell \"" + line + "\"goods this month");
        reader.close();
        return (Integer.parseInt(line));
    }
}

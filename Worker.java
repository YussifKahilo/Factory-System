package FactorySystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Worker extends Employee {
    
	Worker(Employee worker){
		 super(
	                worker.getId(), worker.getPassword(),
	                worker.getName(),worker.getSalary(),
	                worker.getBonus(),worker.getMonthlyRate(),
	                worker.getOverallRate(),worker.getHiringDate(),
	                worker.getPhoneNumber(),worker.getEmail(),
	                worker.getAddress().getHouseNumber(),
	                worker.getAddress().getFlateNumber(),
	                worker.getAddress().getStreetName(),
	                worker.getAddress().getPlace(),
	                worker.getBankAccount().getAccountNumber(),
	                worker.getBankAccount().getBalance());
	                
	}
        
	public void showTarget() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("WorkersTarget.txt"));
		String line;
		while ((line = br.readLine()) != null)
			System.out.println(line);
        
		br.close();
	}
}

package FactorySystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Worker extends Employee {

    Worker(Employee worker) {
        super(
                worker.getId(), worker.getPassword(),
                worker.getName(), worker.getSalary(),
                worker.getBonus(), worker.getMonthlyRate(),
                worker.getOverallRate(), worker.getHiringDate(),
                worker.getPhoneNumber(), worker.getEmail(),
                worker.getAddress(),
                worker.getBankAccount());
    }
}

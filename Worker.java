
public class Worker extends Employee {

    Worker(Employee worker) {
        super(
                worker.getId(), worker.getPassword(),
                worker.getName(), worker.getSalary(),
                worker.getBonus(), worker.getMonthlyRate(),
                worker.getOverallRate(), worker.getHiringDate(),
                worker.getPhoneNumber(), worker.getEmail(),
                worker.getAddress(),
                worker.getBankAccount(), worker.getBirthDate());
    }
}

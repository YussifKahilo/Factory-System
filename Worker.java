
public class Worker extends Employee {

    /**
     * Worker constructor.
     *
     * @param worker a reference from the employee to get to it's methods and
     * attributes.
     */
    Worker(Employee worker) {
        super(worker.getId(), worker.getPassword(), worker.getName(), worker.getSalary(), worker.getBonus(),
                worker.getMonthlyRate(), worker.getOverallRate(), worker.getHiringDate(), worker.getPhoneNumber(),
                worker.getEmail(), worker.getAddress(), worker.getBankAccount(), worker.getBirthDate());
    }
}

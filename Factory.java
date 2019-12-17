
import java.util.ArrayList;

public class Factory {

    private ArrayList<Worker> workers;
    private ArrayList<SuperVisor> superVisors;
    private ArrayList<SalesMan> salesMen;
    private Manager manager;
    private Storage storage;
    private Financial financial;
    private FactorySystem factorySystem;
    private Target target;

    public Factory() {
        manager = new Manager();
        workers = new ArrayList<>();
        superVisors = new ArrayList<>();
        salesMen = new ArrayList<>();
        storage = new Storage(FileData.getData("Storage.txt"));
        financial = new Financial(FileData.getData("Financial.txt"));
        target = new Target(FileData.getData("Target.txt"));
        setWorkers();
        assignWorkersToSupperVisors(workers.size(), superVisors.size());
        setSuperVisors();
        setSalesMen();
        this.factorySystem = new FactorySystem(workers, superVisors, salesMen, manager);
    }

    public FactorySystem getFactorySystem() {
        return factorySystem;
    }

    public void setWorkers() {
        ArrayList<String> LINES = new ArrayList<String>();
        FileData.getData(LINES, "Workers.txt");
        for (int i = 0; i < LINES.size(); i++) {
            String line = LINES.get(i);
            String[] Line = line.split("#");
            Worker person = new Worker(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
                    Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
                    Line[8], Line[9],
                    new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
                            Line[13], Line[14], Line[15]),
                    new BankAccount(Line[16], Double.parseDouble(Line[17])),
                    new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))));
            workers.add(person);
        }
    }

    public void setSuperVisors() {
        ArrayList<String> LINES = new ArrayList<String>();
        FileData.getData(LINES, "SuperVisors.txt");
        ArrayList<Employee> worker = new ArrayList<Employee>();
        for (int i = 0; i < LINES.size(); i++) {
            String line = LINES.get(i);
            String[] Line = line.split("#");
            SuperVisor person = new SuperVisor(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
                    Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
                    Line[8], Line[9],
                    new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
                            Line[13], Line[14], Line[15]),
                    new BankAccount(Line[16], Double.parseDouble(Line[17])),
                    new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))),
                    workers);
            superVisors.add(person);
        }
    }

    public void setSalesMen() {
        ArrayList<String> LINES = new ArrayList<String>();
        FileData.getData(LINES, "SalesMen.txt");
        for (int i = 0; i < LINES.size(); i++) {
            String line = LINES.get(i);
            String[] Line = line.split("#");
            SalesMan person = new SalesMan(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
                    Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
                    Line[8], Line[9],
                    new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
                            Line[13], Line[14], Line[15]),
                    new BankAccount(Line[16], Double.parseDouble(Line[17])),
                    new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))));
            salesMen.add(person);
        }
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public ArrayList<SuperVisor> getSuperVisors() {
        return superVisors;
    }

    public ArrayList<SalesMan> getSalesMen() {
        return salesMen;
    }

    public boolean checkForWorker(Worker user) {
        boolean isFound = false;
        for (int i = 0; i < workers.size() && !isFound; i++) {
            if (user.getId().equals(workers.get(i).getId())) {
                isFound = true;
            }
        }
        return isFound;
    }

    public void addWorker(Worker worker) {
        factorySystem.addUser(worker);
        workers.add(worker);
        assignWorkersToSupperVisors(workers.size(), superVisors.size());
    }

    public void addSuperVisor(SuperVisor superVisor) {
        factorySystem.addUser(superVisor);
        superVisors.add(superVisor);
        assignWorkersToSupperVisors(workers.size(), superVisors.size());
    }

    public void addSalesMan(SalesMan salesMan) {
        factorySystem.addUser(salesMan);
        salesMen.add(salesMan);
    }

    public void assignWorkersToSupperVisors(int totalNumberOFWorkers, int totalNumberOfSuperVisors) {
        ArrayList<String> idsOfWorkers = new ArrayList<String>();
        if (totalNumberOfSuperVisors == 0) {
            ArrayList<String> superVisorsNumbers = new ArrayList<>();
            FileData.getData(superVisorsNumbers, "SuperVisors.txt");
            totalNumberOfSuperVisors = superVisorsNumbers.size();
        }
        int numberOfWorkersForEachSuperVisor = totalNumberOFWorkers / totalNumberOfSuperVisors;
        int remainder = totalNumberOFWorkers % totalNumberOfSuperVisors;
        int numberofWorkersassigned = 0;
        String str = "";
        for (int j = 0; j < numberOfWorkersForEachSuperVisor * totalNumberOfSuperVisors; j++) {
            if ((j + 1) % numberOfWorkersForEachSuperVisor == 0) {
                str = str + "#" + workers.get(numberofWorkersassigned++).getId();
                idsOfWorkers.add(str.substring(1));
                str = "";
            } else {
                str = str + "#" + workers.get(numberofWorkersassigned++).getId();
            }
        }
        if (remainder != 0) {
            for (int j = 0; j < remainder; j++) {
                idsOfWorkers.add(j, idsOfWorkers.get(j) + "#" + workers.get(numberofWorkersassigned++).getId());
                idsOfWorkers.remove(j + 1);
            }
        }
        FileData.setData(idsOfWorkers, "WorkersOfSuperVisors.txt");
    }

    public void removeEmployee(Employee employee) {
        ArrayList<String> bankAccount = new ArrayList<String>();
        FileData.getData(bankAccount, "BankAccount.txt");
        bankAccount.remove(employee.getBankAccount().getAccountNumber());
        FileData.setData(bankAccount, "BankAccount.txt");
        if (employee.getId().startsWith("2")) {
            factorySystem.removeUser(employee);
            workers.remove(employee);
        } else if (employee.getId().startsWith("4")) {
            factorySystem.removeUser(employee);
            salesMen.remove(employee);
        } else if (employee.getId().startsWith("3")) {
            factorySystem.removeUser(employee);
            superVisors.remove(employee);
        }

        assignWorkersToSupperVisors(workers.size(), superVisors.size());
    }

    public void startUserInterface(Person user) {
        factorySystem.userUtility(user, manager, workers, superVisors, salesMen, financial, storage, target, this);
    }

}

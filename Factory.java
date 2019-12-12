
import java.util.ArrayList;
import java.util.Scanner;

public class Factory {

    private ArrayList<Employee> workers ;
    private ArrayList<Employee> superVisors ;
    private ArrayList<Employee> salesMen ;
    private Manager manager;
    private Storage storage;
    private Financial financial;
    private FactorySystem factorySystem;

    public Factory() {
        manager = new Manager();
        workers = new ArrayList<>();
        superVisors = new ArrayList<>();
        salesMen = new ArrayList<>();
        storage = new Storage();
        financial = new Financial();
        setEmployees(this.workers, "Workers");
        setEmployees(this.superVisors, "SuperVisors");
        setEmployees(this.salesMen, "SalesMen");
        this.factorySystem = new FactorySystem(workers, superVisors, salesMen, manager);
    }

    public FactorySystem getFactorySystem() {
        return factorySystem;
    }

    public void setEmployees(ArrayList<Employee> persons, String fileName) {
        ArrayList<String> LINES = new ArrayList<String>();
        FileData.getData(LINES, fileName + ".txt");
        for (int i = 0; i < LINES.size(); i++) {
            String line = LINES.get(i);
            String[] Line = line.split("#");
            Employee person = new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
                    Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
                    Line[8], Line[9],
                    new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
                            Line[13], Line[14], Line[15]),
                    new BankAccount(Line[16], Double.parseDouble(Line[17])),
                    new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20])));
            persons.add(person);
        }
    }

    public void addWorker(Employee worker) {
        factorySystem.addUser(worker);
        workers.add(worker);
    }

    public void removeWorker(Employee worker) {
        factorySystem.removeUser(worker);
        workers.remove(worker);
    }

    public void addSuperVisor(Employee superVisor) {
        factorySystem.addUser(superVisor);
        superVisors.add(superVisor);
    }

    public void removeSuperVisor(Employee superVisor) {
        factorySystem.removeUser(superVisor);
        superVisors.remove(superVisor);
    }

    public void removeSalesMan(Employee salesMan) {
        factorySystem.removeUser(salesMan);
        salesMen.remove(salesMan);
    }

    public void addSalesMan(Employee salesMan) {
        factorySystem.addUser(salesMan);
        salesMen.add(salesMan);
    }

    public ArrayList<Employee> getSuperVisors() {
        return superVisors;
    }

    public ArrayList<Employee> getSalesMen() {
        return salesMen;
    }

    public ArrayList<Employee> getWorkers() {
        return workers;
    }

    public void userUtility(Person user) {
        Scanner in = new Scanner(System.in);
        boolean logOut = false;
        if (user instanceof Manager) {
            Manager USER = (Manager) user;
            while (!logOut) {
                UserMenu.managerMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    UserMenu.employeeTableOptionsMenu();
                    int table_option = in.nextInt();
                    switch (table_option) {
                        case 1:
                            USER.showEmployees(workers);
                            break;
                        case 2:
                            USER.showEmployees(superVisors);
                            break;
                        case 3:
                            USER.showEmployees(salesMen);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid input ..");
                            break;
                    }
                } else if (choice == 2) {
                    System.out.print("Enter the employee's id : ");
                    String id = in.next();
                    Employee person = null;
                    if (id.startsWith("22")) {
                        person = USER.searchForEmployee(id, workers);
                    } else if (id.startsWith("33")) {
                        person = USER.searchForEmployee(id, superVisors);
                    } else if (id.startsWith("44")) {
                        person = USER.searchForEmployee(id, salesMen);
                    }
                    if (person != null) {
                        person.showInformations();
                        UserMenu.employeeOptionsMenu();
                        int employee_option = in.nextInt();
                        if (employee_option == 1) {
                            System.out.println("1-Promote to Super Visor");
                            System.out.println("2-Promote to Sales Man");
                            System.out.println("3-Back");
                            System.out.print("::");
                            int promoteTo_number = in.nextInt();
                            if (promoteTo_number == 1) {
                                manager.promote(person, "SuperVisor", this);
                            } else if (promoteTo_number == 2) {
                                manager.promote(person, "SalesMan", this);
                            }
                        } else if (employee_option == 2) {
                            System.out.print("Enter The New Salary : ");
                            person.setSalary(in.nextDouble());
                        } else if (employee_option == 3) {
                            manager.firingEmployee(person, this);
                        }
                    } else {
                        System.out.println("You entered a wrong id..");
                    }
                } else if (choice == 3) {
                    System.out.print("The Target this month is : ");
                    USER.setTarget(in.nextInt(), workers.size());
                } else if (choice == 4) {
                    UserMenu.managerStorageOptionsMenu();
                    String NUM = in.next();
                    manager.storageManagment(Integer.parseInt(NUM), storage);
                } else if (choice == 5) {
                    UserMenu.managerFinancialOptionsMenu();
                    String NUM = in.next();
                    manager.financialManagment(Integer.parseInt(NUM), financial);
                } else if (choice == 6) {
                    logOut = true;
                }
            }
        } else if (user instanceof Worker) {
            Worker USER = (Worker) user;
            while (!logOut) {
                UserMenu.workerMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    USER.showInformations();
                    System.out.print("Do you want to edit any informations ? (Y/N)\n::");
                    String ch = in.next();
                    if (ch.equalsIgnoreCase("Y")) {
                        ((Worker) user).editInformations();
                    }
                } else if (choice == 2) {
                    USER.showTarget();
                } else if (choice == 3) {
                    logOut = true;
                } else {
                    System.out.println("invalid input .. ");
                }
            }
        } else if (user instanceof SuperVisor) {
            SuperVisor USER = (SuperVisor) user;
            while (!logOut) {
                UserMenu.superVisorMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    USER.showInformations();
                    System.out.print("Do you want to edit any informations ? (Y/N)\n::");
                    String ch = in.next();
                    if (ch.equalsIgnoreCase("Y")) {
                        ((SuperVisor) user).editInformations();
                    }
                } else if (choice == 2) {
                    Employee worker = USER.showWorkersInformation();
                    if (worker != null) {
                        System.out.print("1-Give Feedback\n2-back\n::");
                        String NUM = in.next();
                        if (NUM.equalsIgnoreCase("1")) {
                            double rate = USER.answerFeedback();
                            worker.setMonthlyRate(rate);
                            worker.setBonus(rate / 100);
                            worker.setOverallRate((worker.getOverallRate() + rate) / 2);
                        }
                    }
                } else if (choice == 3) {
                    USER.showTarget();
                } else if (choice == 4) {
                    int target_result = USER.setTargetResult();
                    storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() + target_result);
                    storage.setnumberOfGoodsThisMonth(target_result);
                } else if (choice == 5) {
                    logOut = true;
                } else {
                    System.out.println("Invalid input .. ");
                }
            }
        } else if (user instanceof SalesMan) {
            SalesMan USER = (SalesMan) user;
            while (!logOut) {
                UserMenu.salesManMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    USER.showInformations();
                    System.out.print("Do you want to edit any information ? (Y/N)\n::");
                    String ch = in.next();
                    if (ch.equalsIgnoreCase("Y")) {
                        ((SalesMan) user).editInformations();
                    }
                } else if (choice == 2) {
                    USER.showTarget();
                } else if (choice == 3) {
                    int target_result = USER.setTargetResult();
                    storage.setNumberOfSoldGoods(target_result);
                    storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() - target_result);
                    financial.setTotalMoney(storage.getPriceofGoods() * target_result);
                } else if (choice == 4) {
                    logOut = true;
                }
            }
        }
        factorySystem.saveChanges();
    }

}

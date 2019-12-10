
import java.util.ArrayList;
import java.util.Scanner;

public class Factory {

    private ArrayList<Employee> workers;
    private ArrayList<Employee> superVisors;
    private ArrayList<Employee> salesMen;
    private Manager manager;
    private Storage storage;
    private Financial financial;
    private FactorySystem factorySystem;

    public Factory() {
        manager = new Manager();
        storage = new Storage();
        financial = new Financial();
        this.workers = setEmployees("Workers");
        this.superVisors = setEmployees("SuperVisors");
        this.salesMen = setEmployees("SalesMen");
        this.factorySystem = new FactorySystem(workers, superVisors, salesMen, manager);
    }

    public FactorySystem getFactorySystem() {
        return factorySystem;
    }

    public ArrayList<Employee> setEmployees(String fileName) {
        ArrayList<String> LINES = new ArrayList<String>();
        FileData.getData(LINES, fileName + ".txt");
        ArrayList<Employee> persons = new ArrayList<Employee>();
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
        return persons;
    }

    public void removeWorker(Employee employee) {
        workers.remove(employee);
    }

    public void addNewSuperVisor(Employee employee) {
        superVisors.add(employee);
    }

    public ArrayList<Employee> getSuperVisors() {
        return superVisors;
    }

    public void addNewSalesMan(Employee employee) {
        salesMen.add(employee);
    }

    public ArrayList<Employee> getSalesMen() {
        return salesMen;
    }

    public Financial getFinancial() {
        return financial;
    }

    public Storage getStorage() {
        return storage;
    }
    
    public void updateInformations(ArrayList<Employee> employees){
        ArrayList<String> employees_data = new ArrayList<String>();
        for(int i = 0 ; i < employees.size() ; i++){
            employees_data.add(employees.get(i).toString());
        }
        FileData.setData(employees_data, "Workers.txt");
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
                    if (table_option==1) {
                        USER.showEmployees(workers);
                    } else if (table_option==2) {
                        USER.showEmployees(superVisors);
                    } else if (table_option==3) {
                        USER.showEmployees(salesMen);
                    }
                } else if (choice == 2) {
                    System.out.print("Enter the employee's id : ");
                    Employee person = USER.searchForEmployee(in.next(), workers);
                    if (person != null) {
                        person.showInformations();
                        UserMenu.employeeOptionsMenu();
                        int employee_option = in.nextInt();
                        if(employee_option==1){
                            
                        }else if(employee_option==2){
                            System.out.print("Enter The New Salary : ");
                            person.setSalary(in.nextDouble());
                            updateInformations(workers);
                        }else if (employee_option==3){
                            
                        }
                        /*
                        String NUM = in.next();
                        MainClass.checkForClose(NUM);
                        if (NUM.equalsIgnoreCase("1")) {
                            USER.promote(person);
                        } else if (NUM.equalsIgnoreCase("1")) {
                            System.out.print("Enter the new salary : ");
                            String newSalary = in.next();
                            MainClass.checkForClose(newSalary);
                            person.setSalary(Double.parseDouble(newSalary));
                            if (person.getId().startsWith("22")) {
                                user.updateInformations("Workers", person);
                            } else if (person.getId().startsWith("33")) {
                                user.updateInformations("SuperVisors", person);
                            } else if (person.getId().startsWith("44")) {
                                user.updateInformations("SalesMan", person);
                            }
                        } else if (NUM.equalsIgnoreCase("1")) {
                            manager.firingEmployee(person);
                        }*/
                    } else {
                        System.out.println("You entered a wrong id..");
                    }
                } else if (choice == 3) {
                    System.out.print("The Target this month is : ");
                    USER.setTarget(in.nextInt());
                } else if (choice == 4) {
                    UserMenu.managerStorageOptionsMenu();
                    String NUM = in.next();
                    MainClass.checkForClose(NUM);
                    manager.storageManagment(Integer.parseInt(NUM));
                } else if (choice == 5) {
                    UserMenu.managerFinancialOptionsMenu();
                    String NUM = in.next();
                    MainClass.checkForClose(NUM);
                    manager.financialManagment(Integer.parseInt(NUM));
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

                    }
                } else if (choice == 2) {
                    Employee worker = USER.showWorkersInformation();
                    System.out.print("1-Give Feedback\n2-back\n::");
                    String NUM = in.next();
                    if (NUM.equalsIgnoreCase("1")) {
                        double rate = USER.answerFeedback();
                        worker.setMonthlyRate(rate);
                        worker.setBonus(rate / 100);
                        worker.setOverallRate((worker.getOverallRate() + rate) / 2);
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
                    MainClass.checkForClose(ch);
                    if (ch.equalsIgnoreCase("Y")) {

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
    }

}

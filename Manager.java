
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person {

    public Manager() {
        super("1100", "Kahilo", "00");
    }

    public void promote(Employee employee, String promotedEmployee, Factory factory) {
        employee.setOverallRate(0);
        if (promotedEmployee.equalsIgnoreCase("SuperVisor")) {
            factory.removeEmployee(employee);
            employee.setId("3" + employee.getId().substring(1));
            employee.setSalary(3000);
            factory.assignWorkersToSupperVisors(factory.getWorkers().size(), factory.getSuperVisors().size() + 1);
            factory.addSuperVisor(new SuperVisor(employee, factory.getWorkers()));
        } else {
            employee.setId("4" + employee.getId().substring(1));
            employee.setSalary(4000);
            factory.removeEmployee(employee);
            factory.addSalesMan(new SalesMan(employee));
        }
    }

    public void showEmployees(int table_option, ArrayList<Employee> persons) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        if (table_option == 1) {
            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).getId().startsWith("2")) {
                    employee.add(persons.get(i));
                }
            }
        } else if (table_option == 2) {
            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).getId().startsWith("3")) {
                    employee.add(persons.get(i));
                }
            }
        } else {
            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).getId().startsWith("4")) {
                    employee.add(persons.get(i));
                }
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Do you Want to sort employees By thier ID OR Over All Rate ?\n1)ID\n2)Over All Rate");
        int sortingChoice = input.nextInt();
        if (sortingChoice == 2) {
            FactorySystem.sortEmployeesByOverAllRate(employee);
        }
        UserMenu.employeesTable(employee);
    }

    public void storageManagment(int num, Storage storage, Target target) {
        Scanner input = new Scanner(System.in);
        if (num == 1) {
            System.out.println("The number of stored goods: " + storage.getNumberOfStoredGoods());
        } else if (num == 2) {
            System.out.println("The number of goods that have been manufactured this month: "
                    + storage.getNumberOfGoodsManufacturedThisMonth());
        } else if (num == 3) {
            System.out.println("The number of sold goods:" + storage.getNumberOfSoldGood());
        } else if (num == 4) {
            System.out.println("Enter The Number Of Goods To be Sold: ");
            String numOfGoodsToBeSold = input.next();
            target.setTargetOfGoodsToBeSold(Integer.parseInt(numOfGoodsToBeSold));
            System.out.println("Enter The price of each goods");
            String priceOfGoodsToBeSold = input.next();
            storage.setPriceOfGoods(Double.parseDouble(priceOfGoodsToBeSold));
        }
    }

    public void financialManagment(int num, Financial financial) {
        Scanner input = new Scanner(System.in);
        if (num == 1) {
            System.out.println("The total money is : " + financial.getTotalMoney());
        } else if (num == 2) {
            System.out.println("profits is : " + financial.getProfit());
        } else if (num == 3) {
            System.out.println("Enter the price of materials you bought :");
            String priceOfTheMaterials = input.next();
            financial.setMatrialsPrice(Double.parseDouble(priceOfTheMaterials) * (-1));
            financial.setTotalMoney(financial.getTotalMoney() + financial.getMatrialsPrice());
        }
    }

    public void setTarget(int satTarget, int numberOfWorkers ,Target target) {
        target.setTargetOfGoodsToBeManufactured(satTarget);
        target.setTargetOfGoodsToBeManufacturedForEachWorker(satTarget/numberOfWorkers);
    }

    public void firingEmployee(Employee employee, Factory factory) {
        factory.removeEmployee(employee);
    }

    public void giveSalary(ArrayList<Employee> employees, Financial financial) {
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).getBankAccount().setBalance(employees.get(i).getSalary() + employees.get(i).getBonus()
                    + employees.get(i).getBankAccount().getBalance());
            financial.setTotalMoney((financial.getTotalMoney()) - employees.get(i).getSalary());
        }
    }

    public Employee searchForWorker(String id, ArrayList<Worker> workers) {
        Employee chosenEmployee = null;
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getId().equals(id)) {
                chosenEmployee = workers.get(i);
                i = workers.size();
            }
        }
        return chosenEmployee;
    }

    public Employee searchForSuperVisor(String id, ArrayList<SuperVisor> superVisors) {
        Employee chosenEmployee = null;
        for (int i = 0; i < superVisors.size(); i++) {
            if (superVisors.get(i).getId().equals(id)) {
                chosenEmployee = superVisors.get(i);
                i = superVisors.size();
            }
        }
        return chosenEmployee;
    }

    public Employee searchSalesMan(String id, ArrayList<SalesMan> salesMen) {
        Employee chosenEmployee = null;
        for (int i = 0; i < salesMen.size(); i++) {
            if (salesMen.get(i).getId().equals(id)) {
                chosenEmployee = salesMen.get(i);
                i = salesMen.size();
            }
        }
        return chosenEmployee;
    }

}

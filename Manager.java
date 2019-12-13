
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Manager extends Person {

    public Manager() {
        super("1100", "Kahilo", "00");
    }

    public void promote(Employee employee, String promotedEmployee, Factory factory) {
        employee.setOverallRate(0);
        if (promotedEmployee.equalsIgnoreCase("SuperVisor")) {
            factory.removeWorker(employee);
            employee.setId("33" + employee.getId().substring(2));
            factory.addSuperVisor(employee);
        } else {
            factory.removeWorker(employee);
            employee.setId("44" + employee.getId().substring(2));
            factory.addSalesMan(employee);
        }

    }

    public Employee searchForEmployee(String id, ArrayList<Employee> employees) {
        boolean employeeIsFound = false;
        Employee chosenEmployee = null;
        for (int i = 0; i < employees.size() && !employeeIsFound; i++) {
            if (id.equals(employees.get(i).getId())) {
                employeeIsFound = true;
                chosenEmployee = employees.get(i);
            }
        }
        return chosenEmployee;
    }

    public void showEmployees(ArrayList<Employee> persons) {

        Scanner input = new Scanner(System.in);
        System.out.println("Do you Want to sort employees By thier ID OR Over All Rate ?\n1)ID\n2)Over All Rate");
        int sortingChoice = input.nextInt();
        System.out.println(
                ".____________________________________________________________________________________________________________________________________.");
        System.out.println(
                "|   ID   |       Name        |  Overall Rate  |      Salary      |  Phone Number  | Hiring Date |               E-Mail               |");
        System.out.println(
                "+--------+-------------------+----------------+------------------+----------------+-------------+------------------------------------+");
        int j;
        int indexOfMax = 0;
        if (sortingChoice == 2) {
            for (int k = 0; k < persons.size(); k++) {
                double max = persons.get(k).getOverallRate();
                for (j = k; j < persons.size(); j++) {
                    if (max < persons.get(j).getOverallRate()) {
                        max = persons.get(j).getOverallRate();
                        indexOfMax = j;
                    }
                }
                Collections.swap(persons, indexOfMax, k);
            }
        }
        for (int i = 0; i < persons.size(); i++) {
            System.out.print("|");
            String[] Name = persons.get(i).getName().split(" ");
            String name = " " + Name[0];
            String space = "", space_for_email = "";
            for (int k = 0; k < 19 - name.length(); k++) {
                space += " ";
            }
            name = name.concat(space);

            for (j = 0; j < 35 - persons.get(i).getEmail().length(); j++) {
                space_for_email += " ";
            }
            String email = " " + persons.get(i).getEmail() + space_for_email;

            System.out.printf("%7s%2s%19s%1s%11s%6s%13.2f%6s%15s%2s%11s%3s%35s%1s", persons.get(i).getId(), "|", name,
                    "|", (int) persons.get(i).getOverallRate() + " / 10", "|", persons.get(i).getSalary(), "|",
                    "+02" + persons.get(i).getPhoneNumber(), "|", persons.get(i).getHiringDate(), "|", email, "|");
            System.out.println("");
        }
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public void storageManagment(int num, Storage storage) {
        Scanner input = new Scanner(System.in);
        if (num == 1) {
            System.out.println("The number of stored goods: " + storage.getNumberOfStoredGoods());
        } else if (num == 2) {
            System.out.println("The number of goods that have been manufactured this month: "
                    + storage.getnumberOfGoodsThisMonth());
        } else if (num == 3) {
            Financial financial = new Financial();
            System.out.println("The number of sold goods:" + storage.getNumberOfSoldGood());
            financial.setProfit(
                    financial.getMatrialsPrice() + (storage.getNumberOfSoldGood() * storage.getPriceofGoods()));
            financial.setTotalMoney(financial.getTotalMoney() + financial.getProfit());
        } else if (num == 4) {
            System.out.println("Enter The Number Of Goods To be Sold: ");
            String numOfGoodsToBeSold = input.next();
            storage.setNumberOfGoodsTobeSold(Integer.parseInt(numOfGoodsToBeSold));
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

    public void setTarget(int target, int numberOfWorkers) {
        ArrayList<String> arrayListOfTarget = new ArrayList<String>();
        arrayListOfTarget.add(target + "#" + (target / numberOfWorkers));
        FileData.setData(arrayListOfTarget, "Target.txt");
    }

    public void firingEmployee(Employee employee, Factory factory) {
        if (employee.getId().startsWith("22")) {
            factory.removeWorker(employee);
        } else if (employee.getId().startsWith("33")) {
            factory.removeSalesMan(employee);
        } else if (employee.getId().startsWith("44")){
            factory.removeSuperVisor(employee);
        }
    }
}

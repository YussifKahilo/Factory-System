
import java.util.ArrayList;

public class UserMenu {

    public void startUpMassege() {
        System.out.println("::IMPORTANT:: => IF YOU WANT TO EXIT AT ANY TIME TYPE 'Q' ::");
        System.out.println("(INFO)=>If you don't have a user press 'C' ..");
    }

    public void managerMenu() {
        System.out.println("-------------------------.");
        System.out.println("1-Show Employees         |");
        System.out.println("2-Search for Employee    |");
        System.out.println("3-Set Target             |");
        System.out.println("4-Storage informations   |");
        System.out.println("5-Financial Informations |");
        System.out.println("6-Log Out                |");
        System.out.println("-------------------------*");
        System.out.print("::");
    }

    public void workerMenu() {
        System.out.println("------------------------.");
        System.out.println("1-Show Your Information |");
        System.out.println("2-Show Target           |");
        System.out.println("3-Log out               |");
        System.out.println("------------------------*");
        System.out.print("::");
    }

    public void superVisorMenu() {
        System.out.println("---------------------------------------.");
        System.out.println("1-Show Your Information                |");
        System.out.println("2-Show Workers                         |");
        System.out.println("3-Get Your Team Target                 |");
        System.out.println("4-Set the number of manufactured goods |");
        System.out.println("5-Log out                              |");
        System.out.println("---------------------------------------*");
        System.out.print("::");
    }

    public void salesManMenu() {
        System.out.println("-------------------------------------.");
        System.out.println("1-Show Your Information              |");
        System.out.println("2-Show the target for the sold goods |");
        System.out.println("3-Set the number of sold goods       |");
        System.out.println("4-Log out                            |");
        System.out.println("-------------------------------------*");
        System.out.print("::");
    }

    public void employeeOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1-Promote                               *");
        System.out.println("* 2-Change salary                         *");
        System.out.println("* 3-Fire                                  *");
        System.out.println("* 4-back                                  *");
        System.out.print("*******************************************\n::");

    }

    public void managerStorageOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1-Show the number of the stored goods   *");
        System.out.println("* 2-Show the number of goods manufactured *");
        System.out.println("* 3-Show the number of the Sold goods     *");
        System.out.println("* 4-Set target of goods to be sold        *");
        System.out.println("*******************************************\n::");
    }

    public void managerFinancialOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1-Show the total money                  *");
        System.out.println("* 2-Show the profit of this month         *");
        System.out.println("* 3-Set the budget for the materials      *");
        System.out.println("*******************************************\n::");
    }

    public void employeeTableOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1- Worker                               *");
        System.out.println("* 2- Supervisor                           *");
        System.out.println("* 3- Sales man                            *");
        System.out.println("* 4- Back                                 *");
        System.out.print("*******************************************\n::");
    }

    /*public void employeesTable(ArrayList<Employee> persons) {
        System.out.println(
                ".____________________________________________________________________________________________________________________________________.");
        System.out.println(
                "|   ID   |       Name        |  Overall Rate  |      Salary      |  Phone Number  | Hiring Date |               E-Mail               |");
        System.out.println(
                "+--------+-------------------+----------------+------------------+----------------+-------------+------------------------------------+");

        for (int i = 0; i < persons.size(); i++) {
            System.out.print("|");
            String[] Name = persons.get(i).getName().split(" ");
            String name = " " + Name[0];
            String space = "", space_for_email = "";
            for (int k = 0; k < 19 - name.length(); k++) {
                space += " ";
            }
            name = name.concat(space);

            for (int j = 0; j < 35 - persons.get(i).getEmail().length(); j++) {
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
    }*/
}

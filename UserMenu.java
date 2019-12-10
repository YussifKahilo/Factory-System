
public class UserMenu {

    public static void startUpMassege() {
        System.out.println("::IMPORTANT:: => IF YOU WANT TO EXIT AT ANY TIME TYPE 'Q' ::");
        System.out.println("(INFO)=>If you don't have a user press 'C' ..");
    }

    public static void managerMenu() {
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

    public static void workerMenu() {
        System.out.println("------------------------.");
        System.out.println("1-Show Your Information |");
        System.out.println("2-Show Target           |");
        System.out.println("3-Log out               |");
        System.out.println("------------------------*");
        System.out.print("::");
    }

    public static void superVisorMenu() {
        System.out.println("---------------------------------------.");
        System.out.println("1-Show Your Information                |");
        System.out.println("2-Show Workers                         |");
        System.out.println("3-Get Your Team Target                 |");
        System.out.println("4-Set the number of manufactured goods |");
        System.out.println("5-Log out                              |");
        System.out.println("---------------------------------------*");
        System.out.print("::");
    }

    public static void salesManMenu() {
        System.out.println("-------------------------------------.");
        System.out.println("1-Show Your Information              |");
        System.out.println("2-Show the target for the sold goods |");
        System.out.println("3-Set the number of sold goods       |");
        System.out.println("4-Log out                            |");
        System.out.println("-------------------------------------*");
        System.out.print("::");
    }

    public static void employeeOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1-Promote                               *");
        System.out.println("* 2-Change salary                         *");
        System.out.println("* 3-Fire                                  *");
        System.out.println("* 4-back                                  *");
        System.out.print("*******************************************\n::");

    }

    public static void managerStorageOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1-Show the number of the stored goods   *");
        System.out.println("* 2-Show the number of goods manufactured *");
        System.out.println("* 3-Show the number of the Sold goods     *");
        System.out.println("* 4-Set target of goods to be sold        *");
        System.out.println("*******************************************\n::");
    }

    public static void managerFinancialOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1-Show the total money                  *");
        System.out.println("* 2-Show the profit of this month         *");
        System.out.println("* 3-Set the budget for the materials      *");
        System.out.println("*******************************************\n::");
    }

    public static void employeeTableOptionsMenu() {
        System.out.println("*******************************************");
        System.out.println("* 1- Worker                               *");
        System.out.println("* 2- Supervisor                           *");
        System.out.println("* 3- Sales man                            *");
        System.out.println("* 4- Back                                 *");
        System.out.print("*******************************************\n::");
    }

}

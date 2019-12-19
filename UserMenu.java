
///**
//* this class has all the menus that will be showed to every user in the system.
//* @author Eslam Amin Ahmed.
//* @ID 220180011
//*/
import java.util.ArrayList;

public class UserMenu {

	/// **
	// * shows the start up menu of the program.
	// */
	public static void startUpMassege() {
		System.out.println("::IMPORTANT:: => IF YOU WANT TO EXIT TYPE 'Q' AT THE LOGIN MENU::");
		System.out.println("(INFO)=>If you don't have a user press 'C' ..");
	}

	/// **
	// * shows the edit menu to the employee to choose between them.
	// */
	public static void editMenu() {
		System.out.println("----------------.");
		System.out.println("1- Name         |");
		System.out.println("2- password     |");
		System.out.println("3- Phone Number |");
		System.out.println("4- Address      |");
		System.out.println("5- Email        |");
		System.out.println("6- Back         |");
		System.out.println("----------------*");
		System.out.print("::");

	}

	/// **
	// * shows the password criteria and conditions.
	// */
	public static void passwordConditions() {
		System.out.println("(INFO)=> \n :: Your password must have at least : ");
		System.out.println("   - Four Charecters \n   - One upercase letter . " + "\n   - One lowercase letter . "
				+ "\n   - One Number or Symbol .");
	}

	/// **
	// * shows bank account's services to choose between them.
	// */
	public static void bankAccountServices() {
		System.out.println("------------.");
		System.out.println("1- Deposit  |");
		System.out.println("2- Withdraw |");
		System.out.println("3- Back     |");
		System.out.println("------------*");
		System.out.print("::");
	}

	/// **
	// * shows manager's menu to choose between them.
	// */
	public static void managerMenu() {
		System.out.println("----------------------------------.");
		System.out.println("1-Show Employees                  |");
		System.out.println("2-Search for Employee             |");
		System.out.println("3-Storage informations            |");
		System.out.println("4-Financial Informations          |");
		System.out.println("5-Give The Salaries For Employees |");
		System.out.println("6-Log Out                         |");
		System.out.println("----------------------------------*");
		System.out.print("::");
	}

	/// **
	// * shows worker's menu to choose between them.
	// */
	public static void workerMenu() {
		System.out.println("------------------------.");
		System.out.println("1-Show Your Information |");
		System.out.println("2-Show Target           |");
		System.out.println("3-Bank Account Services |");
		System.out.println("4-Log out               |");
		System.out.println("------------------------*");
		System.out.print("::");
	}

	/// **
	// * shows supervisor's menu to choose between them.
	// */
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

	/// **
	// * shows sales man's menu to choose between them.
	// */
	public static void salesManMenu() {
		System.out.println("-------------------------------------.");
		System.out.println("1-Show Your Information              |");
		System.out.println("2-Show the target for the sold goods |");
		System.out.println("3-Set the number of sold goods       |");
		System.out.println("4-Log out                            |");
		System.out.println("-------------------------------------*");
		System.out.print("::");
	}

	/// **
	// * shows employee's menu to choose between them.
	// */
	public static void employeeOptionsMenu() {
		System.out.println("*******************************************");
		System.out.println("* 1-Promote                               *");
		System.out.println("* 2-Fire                                  *");
		System.out.println("* 3-Back                                  *");
		System.out.println("*******************************************");
		System.out.print("::");
	}

	/// **
	// * shows storage menu to the manager to choose between them.
	// */
	public static void managerStorageOptionsMenu() {
		System.out.println("*******************************************");
		System.out.println("* 1-Show the number of the stored goods    *");
		System.out.println("* 2-Show the number of goods manufactured  *");
		System.out.println("* 3-Show the number of the Sold goods      *");
		System.out.println("* 4-Set target of goods to be manufactured *");
		System.out.println("* 5-Set target of goods to be sold         *");
		System.out.println("* 6-back                                   *");
		System.out.println("*******************************************");
		System.out.print("::");
	}

	/// **
	// * shows financial's menu to the manager to choose between them.
	// */
	public static void managerFinancialOptionsMenu() {
		System.out.println("*******************************************");
		System.out.println("* 1-Show the total money                  *");
		System.out.println("* 2-Show the profit of this month         *");
		System.out.println("* 3-Set the budget for the materials      *");
		System.out.println("* 4-Back                                  *");
		System.out.println("*******************************************");
		System.out.print("::");
	}

	/// **
	// * shows employee's menu to manager to choose between them.
	// */
	public static void employeeTableOptionsMenu() {
		System.out.println("*******************************************");
		System.out.println("* 1- Worker                               *");
		System.out.println("* 2- Supervisor                           *");
		System.out.println("* 3- Sales man                            *");
		System.out.println("* 4- Back                                 *");
		System.out.println("*******************************************");
		System.out.print("::");
	}

	/// **
	// * shows employee table to the manager to choose between them in which way the
	// * employees will be sorted.
	// */
	public static void employeesTableSortingOptions() {
		System.out.println("Sort the employees by : ");
		System.out.println("********************");
		System.out.println("* 1 - ID           *");
		System.out.println("* 2 - OverAll Rate *");
		System.out.println("********************");
		System.out.print("::");
	}

	/// **
	// * shows promotion to the manager to choose between them to promote the
	/// worker.
	// */
	public static void promotionOptions() {
		System.out.println("***************************");
		System.out.println("* 1-Promote to Super Visor *");
		System.out.println("* 2-Promote to Sales Man   *");
		System.out.println("* 3-Back                   *");
		System.out.println("****************************");
		System.out.print("::");
	}

	/// **
	// * shows message to the user if the password or the id is valid.
	// */
	public static void invalidIdOrPassword() {
		System.out.println("**************************");
		System.out.println("**Invalid ID or Password**");
		System.out.println("**************************");
	}

	/// **
	// * shows the employees to the manager.
	// *
	// * @param employees who will be showed.
	// */
	public static void employeesTable(ArrayList<Employee> employee) {
		System.out.println(
				"._________________________________________________________________________________________________________________________.");
		System.out.println(
				"|   ID   |       Name        |  Overall Rate  |  Age  |  Phone Number  | Hiring Date |               E-Mail               |");
		System.out.println(
				"+--------+-------------------+----------------+-------+----------------+-------------+------------------------------------+");
		for (int i = 0; i < employee.size(); i++) {
			System.out.print("|");
			String[] Name = employee.get(i).getName().split(" ");
			String name = " " + Name[0];
			String space = "", space_for_email = "";
			for (int k = 0; k < 19 - name.length(); k++) {
				space += " ";
			}
			name = name.concat(space);

			for (int j = 0; j < 35 - employee.get(i).getEmail().length(); j++) {
				space_for_email += " ";
			}
			String email = " " + employee.get(i).getEmail() + space_for_email;

			System.out.printf("%7s%2s%19s%1s%7.2f%s%5s%5d%3s%15s%2s%11s%3s%35s%1s", employee.get(i).getId(), "|", name,
					"|", employee.get(i).getOverallRate(), " / 10", "|", employee.get(i).getBirthDate().getAge(), "|",
					"+02" + employee.get(i).getPhoneNumber(), "|", employee.get(i).getHiringDate(), "|", email, "|");
			System.out.println("");

		}
		System.out.println(
				"+-------------------------------------------------------------------------------------------------------------------------+");
	}
}

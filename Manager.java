
///**
//* this class contains the only manager of the factory and all his relations and connects the component of the factory with each other.
//* the manager can promote,fire,access to the storage,financial and sets the target for the employees.
//* @author Eslam Amin Ahmed
//* @ID 220180011
//*/
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person {

	public Manager() {
		// the only manager of the factory has.
		// first his id.
		// second his name.
		// his password.
		super("1100", "Kahilo", "00");
	}

	/// **
	// * promotes a Specified employee
	// *
	// * @param employee a reference from employee class to access its methods
	// * and attributes a
	// * @param promptionType if the promotion type is a supervisor the employee
	/// will
	// * be promoted to supervisor otherwise it will be promoted
	// * to sales man.
	// * @param factory a reference form factory to access its methods and
	// * attributes.
	// */
	public void promote(Employee employee, String promptionType, Factory factory) {
		// sets the overall rate of the employee to zero.
		factory.removeEmployee(employee);// removes the employee from the array list in of factory.
		employee.setOverallRate(5);
		// if the promoted was a supervisor.
		if (promptionType.equalsIgnoreCase("SuperVisor")) {
			employee.setId("3" + employee.getId().substring(1));// changes the first number of an employee's id.
			employee.setSalary(3000);// changes the salary of the promoted employee.
			// assign the workers to the supervisors after promoting an employee.
			factory.assignWorkersToSupperVisors(factory.getWorkers().size(), factory.getSuperVisors().size() + 1);
			// adds the promoted employee to the supervisor array list in the factory.
			factory.addSuperVisor(new SuperVisor(employee, factory.getWorkers()));
		} else {
			employee.setId("4" + employee.getId().substring(1));// changes the first number of an employee's id.
			employee.setSalary(4000);// changes the salary of the promoted employee
			factory.addSalesMan(new SalesMan(employee)); // adds the employee to the array list of factory.
		}
	}

	/// **
	// * shows the employees to the manager.
	// *
	// * @param table_option which type of employees that will be showed.
	// * @param persons all the employees in the factory.
	// */
	public void showEmployees(char table_option, ArrayList<Employee> persons) {
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<Employee> employee = new ArrayList<Employee>();
		if (table_option == '1') {
			for (int i = 0; i < persons.size(); i++) {
				// if it was worker, it will be added to the employee list.
				if (persons.get(i).getId().startsWith("2")) {
					employee.add(persons.get(i));
				}
			}
		} else if (table_option == '2') {
			// if it was supervisor, it will be added to the employee list.
			for (int i = 0; i < persons.size(); i++) {
				if (persons.get(i).getId().startsWith("3")) {
					employee.add(persons.get(i));
				}
			}
		} else if (table_option == '3') {
			// if it was salesman, it will be added to the employee list.
			for (int i = 0; i < persons.size(); i++) {
				if (persons.get(i).getId().startsWith("4")) {
					employee.add(persons.get(i));
				}
			}
		}
		Scanner input = new Scanner(System.in);
		// asking the manager if he wants to sort the employees.
		UserMenu.employeesTableSortingOptions();
		boolean isValid = false;
		do {
			char sortingChoice = input.next().charAt(0);
			if (sortingChoice == '1') {
				// sort employees list.
				FactorySystem.sortEmployeesById(employee);
				isValid = true;

			} else if (sortingChoice == '2') {
				// sort employees list.
				FactorySystem.sortEmployeesByOverAllRate(employee);
				isValid = true;

			} else {
				System.out.println("Invalid input..\ninput again:: ");
			}
		} while (!isValid);

		UserMenu.employeesTable(employee);
	}

	/// **
	// * storage management that will make the manager access to it.
	// *
	// * @param choice to be chosen from the list, if the choice was : 1) shows
	// * number of stored goods. 2) shows number of manufactured goods
	// * during the month. 3) shows the sold goods. 4) sets the number
	// * of the goods that will be sold and their prices.
	// * @param storage a reference from storage class to access its methods and
	// * attributes.
	// * @param target a reference from target class to access its methods and
	// * attributes.
	// * @param number of the workers in the factory
	// * @param number of sales men in the factory
	// */
	public void storageManagment(char choice, Storage storage, Target target, int numberOfWorkers,
			int numberOfSalesMen) {
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		while (!isValid) {
			if (choice == '1') {
				System.out.println("The number of stored goods: " + storage.getNumberOfStoredGoods());
				isValid = true;

			} else if (choice == '2') {
				System.out.println("The number of goods that have been manufactured this month: "
						+ storage.getNumberOfGoodsManufacturedThisMonth());
				isValid = true;

			} else if (choice == '3') {
				System.out.println("The number of sold goods:" + storage.getNumberOfSoldGood());
				isValid = true;

			} else if (choice == '4') {
				System.out.print("Enter The Number Of Goods To be manufactured : ");
				String numOfGoodsToBeSold = input.next();
				if (numberOfWorkers < Long.parseLong(numOfGoodsToBeSold)) {
					target.setTargetOfGoodsToBeManufactured(Long.parseLong(numOfGoodsToBeSold));
					target.setTargetOfGoodsToBeManufacturedForEachWorker(
							Long.parseLong(numOfGoodsToBeSold) / numberOfWorkers);
					isValid = true;
				} else {
					System.out.println(
							"You can not set a target less than the number of workers .. \"HINT:NUMBER OF WORKERS IS :"
									+ numberOfWorkers + "\"");
				}
			} else if (choice == '5') {
				System.out.println("___________________________________________");
				System.out.println("Enter The Number Of Goods To be Sold : ");
				String numOfGoodsToBeSold = input.next();
				if (Integer.parseInt(numOfGoodsToBeSold) > numberOfSalesMen) {
					target.setTargetOfGoodsToBeSold(Integer.parseInt(numOfGoodsToBeSold));
					target.setTargetOfGoodsToBeSoldByEachSalesMan(
							Integer.parseInt(numOfGoodsToBeSold) / numberOfSalesMen);
					System.out.print("Enter The price of each goods : ");
					System.out.println("-------------------------------------------");
					String priceOfGoodsToBeSold = input.next();
					storage.setPriceOfGoods(Double.parseDouble(priceOfGoodsToBeSold));
					isValid = true;
				} else {
					System.out.println(
							"You can not set a target less than the number of sales men .. \"HINT:NUMBER OF WORKERS IS :"
									+ numberOfSalesMen + "\"");
				}
			} else if (choice == '6') {
				isValid = true;
			} else {
				System.out.println("Invalid input\ninput again :: ");
				choice = input.next().charAt(0);
			}
		}
	}

	/// *
	//
	// @param num of the choice from the menu that have been showed to the manager.
	// @param financial of the
	// *\
	public void financialManagment(char num, Financial financial) {
		Scanner input = new Scanner(System.in);
		if (num == '1') {
			System.out.println("The total money is : " + financial.getTotalMoney());
		} else if (num == '2') {
			System.out.println("profits is : " + financial.getProfit());
		} else if (num == '3') {
			System.out.println("Enter the price of materials you bought :");
			String priceOfTheMaterials = input.next();
			financial.setMaterialsPrice(Double.parseDouble(priceOfTheMaterials) * (-1));
			financial.setTotalMoney(financial.getTotalMoney() + financial.getMaterialsPrice());
		}
	}

	/// **
	// * fires employee from the factory.
	// *
	// * @param employee that will be fired.
	// * @param factory a reference from the factory to the fire the employee from.
	// */
	public void firingEmployee(Employee employee, Factory factory) {
		factory.removeEmployee(employee);
	}

	/// **
	// * gives the salary for the employees.
	// *
	// * @param employees to get the salaries.
	// * @param financial a reference from financial to access to the total money in
	// * in.
	// */
	public void giveSalary(ArrayList<Employee> employees, Financial financial) {
		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).getBankAccount().setBalance(employees.get(i).getSalary() + employees.get(i).getBonus()
					+ employees.get(i).getBankAccount().getBalance());
			financial.setTotalMoney((financial.getTotalMoney()) - employees.get(i).getSalary());
		}
	}

	/// **
	// * searches for an worker.
	// *
	// * @param id of an employee to be searched by.
	// * @param workers of the factory.
	// * @return the chosen worker.
	// */
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

	/// **
	// * searches for an supervisor.
	// *
	// * @param id of an employee to be searched by.
	// * @param superVisors of the factory.
	// * @return the chosen worker.
	// */
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

	/// **
	// * searches for an salesman.
	// *
	// * @param id of an employee to be searched by.
	// * @param salesMen of the factory.
	// * @return the chosen worker.
	// */
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

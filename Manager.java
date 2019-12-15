
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

			factory.removeEmployee(employee);
			employee.setId("33" + employee.getId().substring(2));
			factory.assignWorkersToSupperVisors(factory.getWorkers().size(), factory.getSuperVisors().size() + 1);
			factory.addSuperVisor(new SuperVisor(employee, factory.getWorkers()));
		} else {
			employee.setId("44" + employee.getId().substring(2));
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
		System.out.println(
				".____________________________________________________________________________________________________________________________________.");
		System.out.println(
				"|   ID   |       Name        |  Overall Rate  |      Salary      |  Phone Number  | Hiring Date |               E-Mail               |");
		System.out.println(
				"+--------+-------------------+----------------+------------------+----------------+-------------+------------------------------------+");
		int j;
		int indexOfMax = 0;
		if (sortingChoice == 2) {
			for (int k = 0; k < employee.size(); k++) {
				double max = employee.get(k).getOverallRate();
				for (j = k; j < employee.size(); j++) {
					if (max < employee.get(j).getOverallRate()) {
						max = employee.get(j).getOverallRate();
						indexOfMax = j;
					}
				}
				Collections.swap(employee, indexOfMax, k);
			}
		}
		for (int i = 0; i < employee.size(); i++) {
			System.out.print("|");
			String[] Name = employee.get(i).getName().split(" ");
			String name = " " + Name[0];
			String space = "", space_for_email = "";
			for (int k = 0; k < 19 - name.length(); k++) {
				space += " ";
			}
			name = name.concat(space);

			for (j = 0; j < 35 - employee.get(i).getEmail().length(); j++) {
				space_for_email += " ";
			}
			String email = " " + employee.get(i).getEmail() + space_for_email;

			System.out.printf("%7s%2s%19s%1s%11s%6s%13.2f%6s%15s%2s%11s%3s%35s%1s", employee.get(i).getId(), "|", name,
					"|", (int) employee.get(i).getOverallRate() + " / 10", "|", employee.get(i).getSalary(), "|",
					"+02" + employee.get(i).getPhoneNumber(), "|", employee.get(i).getHiringDate(), "|", email, "|");
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
			System.out.println("The number of sold goods:" + storage.getNumberOfSoldGood());
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
		factory.removeEmployee(employee);
	}

	public void giveSalary(ArrayList<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).getBankAccount().setBalance(employees.get(i).getSalary() + employees.get(i).getBonus()
					+ employees.get(i).getBankAccount().getBalance());
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

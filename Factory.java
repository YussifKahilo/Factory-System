
import java.net.Socket;
import java.util.ArrayList;

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

	public void userUtility(Person user) {
		for (;;) {
			if (user instanceof Manager) {
				UserMenu.managerMenu();

			} else if (user instanceof Worker) {
				UserMenu.workerMenu();

			} else if (user instanceof SuperVisor) {
				UserMenu.superVisorMenu();

			} else if (user instanceof SalesMan) {
				UserMenu.salesManMenu();

			}
		}
	}
}

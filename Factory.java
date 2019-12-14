import java.util.ArrayList;

public class Factory {

	private ArrayList<Worker> workers;
	private ArrayList<SuperVisor> superVisors;
	private ArrayList<SalesMan> salesMen;
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
		setWorkers(this.workers, "Workers");
		setSuperVisors(this.superVisors, "SuperVisors");
		setSalesMen(this.salesMen, "SalesMen");
		this.factorySystem = new FactorySystem(workers, superVisors, salesMen, manager);
	}

	public FactorySystem getFactorySystem() {
		return factorySystem;
	}

	public void setWorkers(ArrayList<Worker> persons, String fileName) {
		ArrayList<String> LINES = new ArrayList<String>();
		FileData.getData(LINES, fileName + ".txt");
		for (int i = 0; i < LINES.size(); i++) {
			String line = LINES.get(i);
			String[] Line = line.split("#");
			Worker person = new Worker(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
					Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
					Line[8], Line[9],
					new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
							Line[13], Line[14], Line[15]),
					new BankAccount(Line[16], Double.parseDouble(Line[17])),
					new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))));
			persons.add(person);
		}
	}

	public void setSuperVisors(ArrayList<SuperVisor> persons, String fileName) {
		ArrayList<String> LINES = new ArrayList<String>();
		FileData.getData(LINES, fileName + ".txt");
		ArrayList<Employee> worker = new ArrayList<Employee>();
		for (int i = 0; i < LINES.size(); i++) {
			String line = LINES.get(i);
			String[] Line = line.split("#");
			SuperVisor person = new SuperVisor(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
					Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
					Line[8], Line[9],
					new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
							Line[13], Line[14], Line[15]),
					new BankAccount(Line[16], Double.parseDouble(Line[17])),
					new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))),
					workers);
			persons.add(person);
		}
	}

	public void setSalesMen(ArrayList<SalesMan> persons, String fileName) {
		ArrayList<String> LINES = new ArrayList<String>();
		FileData.getData(LINES, fileName + ".txt");
		for (int i = 0; i < LINES.size(); i++) {
			String line = LINES.get(i);
			String[] Line = line.split("#");
			SalesMan person = new SalesMan(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
					Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7],
					Line[8], Line[9],
					new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
							Line[13], Line[14], Line[15]),
					new BankAccount(Line[16], Double.parseDouble(Line[17])),
					new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))));
			persons.add(person);
		}
	}

	public void removeEmployee(Employee employee) {
		ArrayList<String> bankAccount = new ArrayList<String>();
		FileData.getData(bankAccount, "BankAccount.txt");
		bankAccount.remove(employee.getBankAccount().getAccountNumber());
		FileData.setData(bankAccount, "BankAccount.txt");
		if (employee.getId().startsWith("2")) {
			factorySystem.removeUser(employee);
			workers.remove(employee);
		} else if (employee.getId().startsWith("4")) {
			factorySystem.removeUser(employee);
			salesMen.remove(employee);
		} else if (employee.getId().startsWith("3")) {
			factorySystem.removeUser(employee);
			superVisors.remove(employee);
		}

	}

	public void assignWokersToSupervisors() {
		ArrayList<String> idsOfWorkers = new ArrayList<String>();
		String str = "";
		int totalNumberOfWorkers = workers.size();
		int totalNumberOfSuperVisors = superVisors.size();
		if (totalNumberOfWorkers % totalNumberOfSuperVisors == 0) {
			int numberOfWorkersForEach = totalNumberOfWorkers / totalNumberOfSuperVisors;
			for (int i = 0; i < totalNumberOfWorkers; i++) {
				if ((i + 1) % numberOfWorkersForEach != 0) {
					str += workers.get(i).getId() + "#";
				}
				idsOfWorkers.add(str);
			}
		}

	}

	public void addWorker(Worker worker) {
		factorySystem.addUser(worker);
		workers.add(worker);
	}

	public void addSuperVisor(SuperVisor superVisor) {
		factorySystem.addUser(superVisor);
		superVisors.add(superVisor);
	}

	public void addSalesMan(SalesMan salesMan) {
		factorySystem.addUser(salesMan);
		salesMen.add(salesMan);
	}

	public ArrayList<SuperVisor> getSuperVisors() {
		return superVisors;
	}

	public ArrayList<SalesMan> getSalesMen() {
		return salesMen;
	}

	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public void startUserInterface(Person user) {
		factorySystem.userUtility(user, manager, workers, superVisors, salesMen, financial, storage, this);
	}

}


///**
//* this class contains the workers,supervisors,salesmen and the manager.
//* and all its relatives.
//* contains the storage and financial.
//* @Author : Yussif Mohamed Salah.
//* @ID : 220180497
//* 
//* 
//*/
import java.util.ArrayList;

public class Factory {

	private ArrayList<Worker> workers;
	private ArrayList<SuperVisor> superVisors;
	private ArrayList<SalesMan> salesMen;
	private Manager manager;
	private Storage storage;
	private Financial financial;
	private FactorySystem factorySystem;
	private Target target;

	/// **
	// * no argument Factory class.
	// */
	public Factory() {
		manager = new Manager();
		workers = new ArrayList<>();
		superVisors = new ArrayList<>();
		salesMen = new ArrayList<>();
		storage = new Storage(FileData.getData("Storage.txt"));
		financial = new Financial(FileData.getData("Financial.txt"));
		target = new Target(FileData.getData("Target.txt"));
		setWorkers();
		assignWorkersToSupperVisors(workers.size(), superVisors.size());
		setSuperVisors();
		setSalesMen();
		// initializing a new system for the factory.
		this.factorySystem = new FactorySystem(workers, superVisors, salesMen, manager);
	}

	/// **
	// * gets the factory system .
	// *
	// * @return factory system.
	// */
	public FactorySystem getFactorySystem() {
		return factorySystem;
	}

	public void setWorkers() {
		ArrayList<String> LINES = new ArrayList<String>();
		FileData.getData(LINES, "Workers.txt");
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
			workers.add(person);
		}
	}

	/// **
	// * this method to set the supervisors to supervisor array list.
	// *
	// */
	public void setSuperVisors() {
		ArrayList<String> LINES = new ArrayList<String>();
		FileData.getData(LINES, "SuperVisors.txt");
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
			superVisors.add(person);
		}
	}

	/// **
	// * this method to set the salesmen to salesmen array list.
	// *
	// */
	public void setSalesMen() {
		ArrayList<String> LINES = new ArrayList<String>();
		FileData.getData(LINES, "SalesMen.txt");
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
			salesMen.add(person);
		}
	}

	/// **
	// *
	// *@param gets the workers form the workers array list
	// */
	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	/// **
	// * it's to get all of the supervisor.
	// *
	// * @return array list of the super visors.
	// */
	public ArrayList<SuperVisor> getSuperVisors() {
		return superVisors;
	}

	/// **
	// * it's to get all of the sales mem.
	// *
	// * @return array list of the salesmen.
	// */
	public ArrayList<SalesMan> getSalesMen() {
		return salesMen;
	}

	/// **
	// * checks for a worker if it's exist.
	// *
	// * @param user to searched for.
	// * @return if the employee is found or not
	// */
	public boolean checkForWorker(Worker user) {
		boolean isFound = false;
		for (int i = 0; i < workers.size() && !isFound; i++) {
			if (user.getId().equals(workers.get(i).getId())) {
				isFound = true;// to break the loop if the employee is found.
			}
		}
		return isFound;
	}

	/// **
	// * adds a new worker to the workers.
	// *
	// * @param worker to be added.
	// */
	public void addWorker(Worker worker) {
		factorySystem.addUser(worker);
		workers.add(worker);
		assignWorkersToSupperVisors(workers.size(), superVisors.size());
	}

	/// **
	// * adds a new superVisor to the system , this used when the manager promotes
	/// an
	// * employee to salesman.
	// *
	// * @param superVisor to add the the system.
	// */
	public void addSuperVisor(SuperVisor superVisor) {
		factorySystem.addUser(superVisor);
		superVisors.add(superVisor);
		assignWorkersToSupperVisors(workers.size(), superVisors.size());
	}

	/// **
	// * adds a new salesman to the system , this used when the manager promotes an
	// * employee to supervisor.
	// *
	// * @param salesMan to add the the system.
	// */
	public void addSalesMan(SalesMan salesMan) {
		factorySystem.addUser(salesMan);
		salesMen.add(salesMan);
	}

	/// **
	// * Assigns the employee to the supervisors by dividing the number of the
	// * employees over the number of supervisor.
	// *
	// * @param totalNumberOFWorkers who will be assigns to the supervisor.
	// * @param totalNumberOfSuperVisors who will be responsible for the queen has
	// * asked for.
	// */
	public void assignWorkersToSupperVisors(int totalNumberOFWorkers, int totalNumberOfSuperVisors) {
		// creating a new array list carrying the values of supervisors's employees.
		ArrayList<String> idsOfWorkers = new ArrayList<String>();
		if (totalNumberOfSuperVisors == 0) {
			ArrayList<String> superVisorsNumbers = new ArrayList<>();
			FileData.getData(superVisorsNumbers, "SuperVisors.txt");// get data from the file.
			totalNumberOfSuperVisors = superVisorsNumbers.size();// gets the total number of supervisors.
		}
		int numberOfWorkersForEachSuperVisor = totalNumberOFWorkers / totalNumberOfSuperVisors;
		int remainder = totalNumberOFWorkers % totalNumberOfSuperVisors;
		int numberofWorkersassigned = 0;
		String str = "";
		for (int j = 0; j < numberOfWorkersForEachSuperVisor * totalNumberOfSuperVisors; j++) {
			if ((j + 1) % numberOfWorkersForEachSuperVisor == 0) {
				str = str + "#" + workers.get(numberofWorkersassigned++).getId();
				idsOfWorkers.add(str.substring(1));
				str = "";
			} else {
				str = str + "#" + workers.get(numberofWorkersassigned++).getId();
			}
		}
		if (remainder != 0) {
			for (int j = 0; j < remainder; j++) {
				idsOfWorkers.add(j, idsOfWorkers.get(j) + "#" + workers.get(numberofWorkersassigned++).getId());
				idsOfWorkers.remove(j + 1);
			}
		}
		FileData.setData(idsOfWorkers, "WorkersOfSuperVisors.txt");
	}

	/// **
	// * remove the user from the system this method is for firing an employee.
	// *
	// * @param employee to be removed.
	// */
	public void removeEmployee(Employee employee) {
		ArrayList<String> bankAccount = new ArrayList<String>();
		FileData.getData(bankAccount, "BankAccount.txt");
		// remove its bank accout.
		bankAccount.remove(employee.getBankAccount().getAccountNumber());
		// removes him from the system.
		factorySystem.removeUser(employee);
		FileData.setData(bankAccount, "BankAccount.txt");
		if (employee.getId().startsWith("2")) {
			workers.remove(employee);// if it was a worker it would be removed form worker list.
		} else if (employee.getId().startsWith("4")) {
			salesMen.remove(employee);// if it was a worker it would be removed form salesmen list.
		} else if (employee.getId().startsWith("3")) {
			superVisors.remove(employee);// if it was a worker it would be removed form supervisor list.
		}

		assignWorkersToSupperVisors(workers.size(), superVisors.size());
	}

	/// **
	// * start user interface
	// *
	// * @param user the one who entered to the system.
	// */
	public void startUserInterface(Person user) {
		factorySystem.userUtility(user, manager, workers, superVisors, salesMen, financial, storage, target, this);
	}

}

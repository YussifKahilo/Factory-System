
///**
//* it's the system that responsible for the factory and runs it as a system.
//* @author Yussif Mohamed Salah.
//* @ID 220180497
//* 
//*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FactorySystem {
	// factory system attributes.
	final private ArrayList<Employee> users = new ArrayList<Employee>();
	final private Manager userOfManager;

	/// **
	// * factory system constructor.
	// *
	// * @param usersOfWorkers who are the users of the workers in the factory.
	// * @param usersOfSuperVisors who are the users of the supervisor in the
	/// factory.
	// * @param usersOfSalesMen who are the users of the salesmen in the factory.
	// * @param userOfManagerwho is the user of the manager in the factory.
	// */
	public FactorySystem(ArrayList<Worker> usersOfWorkers, ArrayList<SuperVisor> usersOfSuperVisors,
			ArrayList<SalesMan> usersOfSalesMen, Manager userOfManager) {
		// adds all the employees to the same array list which called users.
		this.userOfManager = userOfManager;
		for (int i = 0; i < usersOfWorkers.size(); i++) {
			users.add(usersOfWorkers.get(i));
		}
		for (int i = 0; i < usersOfSuperVisors.size(); i++) {
			users.add(usersOfSuperVisors.get(i));
		}
		for (int i = 0; i < usersOfSalesMen.size(); i++) {
			users.add(usersOfSalesMen.get(i));
		}
	}

	/// **
	// * adds user to the system by adding him in the users array list. this method
	/// is
	// * used when a new employeee sings in the factory and when the manager
	/// promotes
	// * a worker.
	// *
	// * @param user to be added to the system.
	// */
	public void addUser(Employee user) {
		users.add(user);
	}

	/// **
	// * removes user from the system by removing him from the users array list.
	/// this
	// * method is used when the manager fires an employee.
	// *
	// * @param user to be removed.
	// */
	public void removeUser(Employee user) {
		users.remove(user);
	}

	/// **
	// * this method is for making the new user create a password for his account is
	// * the system.
	// *
	// * @param in a reference of scanner class used it to input password value.
	// * @return user's password.
	// */
	private String makePasswordForTheNewUser(Scanner in) {
		boolean passwordIsValid = false;
		boolean arePasswordsAreIdentical = false;
		String password = "";
		System.out.println("---------------------------");
		while (!arePasswordsAreIdentical) { // check if the two passwords are identical or not.
			while (!passwordIsValid) {// check if the password is valid.
				UserMenu.passwordConditions();
				System.out.print("Enter a password : ");
				password = in.next();
				// invokes is password valid method to check if it is valid.
				if (isPasswordValid(password)) {
					passwordIsValid = true;// to break the inner loop.
				}
			}
			System.out.print("Confirm your password : ");
			String password2 = in.next();
			// checking for the second password is identical with the first one.
			if (password.equals(password2)) {
				arePasswordsAreIdentical = true;// to break the outer loop.
			} else {
				System.out.println("The two password are not identical ..");
			}
		}
		System.out.println("---------------------------");
		return password;
	}

	/// **
	// * this method is to make the new user input his address apartment
	// * number,building number,floor number,street name,block name and the city.
	// *
	// * @param in a reference of scanner class used it to input address values.
	// * @return address of the user in a formatted way.
	// */
	private String addAddressOfTheNewUser(Scanner in) {
		System.out.println("---------------------------");
		System.out.println("Your Address :");
		System.out.print("-->Apartment Number : ");
		String apartmentNumber = in.next();
		System.out.print("-->Floor number : ");
		String floorNumber = in.next();
		System.out.print("-->Building Number : ");
		String buildingNumber = in.next();
		System.out.print("-->Street name : ");
		in.nextLine();
		String streetName = in.nextLine();
		System.out.print("-->Block name : ");
		String blockName = in.nextLine();
		System.out.print("-->City name : ");
		String cityName = in.nextLine();
		System.out.println("---------------------------");
		return apartmentNumber + "#" + floorNumber + "#" + buildingNumber + "#" + streetName + "#" + blockName + "#"
				+ cityName;

	}

	/// **
	// * this method is to make the new user add his email.
	// *
	// * @param in a reference of scanner class used it to input email value.
	// * @return email.
	// */
	private String addEmailForTheNewUser(Scanner in) {
		boolean emailIsValid = false;
		String email = "";
		while (!emailIsValid) {
			System.out.print("Please enter your Email : ");
			email = in.next();
			/// *
			// * entering the email of the user and checks if the email is valid or not by
			// * checking if it contains a '@' and ".com".
			// */
			if (email.contains("@") && email.contains(".com")) {
				emailIsValid = true;// to break the loop.
			} else {
				System.out.println("invalid E-mail");
			}
			System.out.println("---------------------------");
		}
		return email;
	}

	/// **
	// * this method is to make the new user add his phone number.
	// *
	// * @param in a reference of scanner class used it to input phone number value.
	// * @return phone number.
	// */
	private String addPhoneNumberForTheNewUser(Scanner in) {
		String phoneNumber = "";
		boolean phoneNumberIsValid = false;
		while (!phoneNumberIsValid) {
			System.out.print("Please enter your phone number : ");
			phoneNumber = in.next();
			// checks if the phone number is valid or not by checking if the length of the
			// number is 11 and starts with "01".
			if (phoneNumber.length() == 11 && phoneNumber.startsWith("01")) {
				phoneNumberIsValid = true;// to break the loop.
			} else {
				System.out.println("Invalid phone number..");
			}
		}
		System.out.println("---------------------------");
		return phoneNumber;
	}

	/// **
	// * this method is to make the new user add his birth date.
	// *
	// * @param in a reference of scanner class used it to input email value.
	// * @return the user's birth date in a formatted way.
	// */
	private String addBirthDateOfTheNewUser(Scanner in) {
		String dayOfBirth;
		String monthOfBirth;
		String yearOfBirth;
		do {
			// enters birth date of the user.
			System.out.println("Your Birth Date :");
			System.out.print("-->Day : ");
			dayOfBirth = in.next();
			System.out.print("-->Month : ");
			monthOfBirth = in.next();
			System.out.print("-->Year : ");
			yearOfBirth = in.next();
			if (!BirthDate.birthDateValidation(yearOfBirth, monthOfBirth, dayOfBirth)) {
				System.out.println("invalid Input\nInput again");
			}
			// checks if the birth date is valid or not.
		} while (!BirthDate.birthDateValidation(yearOfBirth, monthOfBirth, dayOfBirth));
		return dayOfBirth + "#" + monthOfBirth + "#" + yearOfBirth;
	}

	/// **
	// * creating new user for a new employee.
	// */
	private void creatingUser() {
		Scanner in = new Scanner(System.in);
		String information = null;
		System.out.print("Enter your name : ");
		String name = in.nextLine();
		/// *
		// * invoking the methods of the new user to input his data.
		// */
		information = makePasswordForTheNewUser(in) + "#" + name + "#" + addPhoneNumberForTheNewUser(in) + "#"
				+ addEmailForTheNewUser(in) + "#" + addAddressOfTheNewUser(in) + "#" + addBirthDateOfTheNewUser(in);
		// a string contains all information of the new user.
		addUser(information);// invoking the add user method to add the user to the system.

	}

	/// **
	// * checks if the password is valid.
	// *
	// * @param password to be checked.
	// * @return whether it's vaild or not valid.
	// */
	public static boolean isPasswordValid(String password) {
		int[] arr = new int[3];
		boolean isValid = false;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				arr[0]++;
			} else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				arr[1]++;
			} else if (password.charAt(i) >= '!' && password.charAt(i) <= '@') {
				arr[2]++;
			}
		}
		if (arr[0] > 0 && arr[1] > 0 && arr[2] > 0 && password.length() >= 4) {
			isValid = true;
		}
		return isValid;
	}

	/// **
	// * login in as a super visor.
	// *
	// * @param id to get the workers that he is responsible for.
	// * @return the logged in user.
	// */
	public Person loginAsSupervisor(String id) {
		Person user = null;
		ArrayList<Worker> workers = new ArrayList<Worker>();
		// adds the workers of the supervisor to the array list workers.
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof Worker) {
				workers.add(new Worker(users.get(i)));
			}
		}
		// invokes supervisor constructor to add his workers in the array list workers.
		user = new SuperVisor(getEmployee(id), workers);
		return user;
	}

	/// **
	// * login in to the system by adding the user's id and pass and checks if they
	// * are connected. the user will login in.
	// *
	// * @return user that logins in.
	// */
	public Person loginingIn() {
		Scanner in = new Scanner(System.in);
		String id;
		boolean logedIn = false;
		Person user = null;
		while (!logedIn) {
			System.out.println("---------------------");
			System.out.print("Enter your ID : ");
			id = in.next();
			// checks if the user entered 'Q' in the login menu the program will close.
			if (id.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			// checks if the user entered 'C' in the login menu, it will show him creating
			// user.
			if (id.equalsIgnoreCase("c")) {
				this.creatingUser();// invoking creating user method.
				logedIn = true;// to break the loop.
			} else {
				System.out.print("Enter your Password : ");
				String password = in.next();
				// checks if the user's id for the manager or not.
				if (id.equals(userOfManager.getId())) {
					if (userOfManager.getPassword().equals(password)) {
						logedIn = true;// to break the loop.
						user = userOfManager;
					}
				} else if (this.verifyLogin(id, password)) {

					// checks if the user's id for the worker or not.
					if (id.startsWith("2")) {
						user = new Worker(getEmployee(id));
						// checks if the user's id for the supervisor or not.
					} else if (id.startsWith("3")) {
						user = loginAsSupervisor(id);
						// checks if the user's id for the salesman or not.
					} else if (id.startsWith("4")) {
						user = new SalesMan(getEmployee(id));
					}
					logedIn = true;// to break the loop if the user has logged in.
					// if any input is invalid a message would show up.
				} else {
					UserMenu.invalidIdOrPassword();
				}
			}
		}
		return user;

	}

	/// **
	// * gets an employee by his id.
	// *
	// * @param id to be searched by.
	// * @return the chosen employee.
	// */
	public Employee getEmployee(String id) {
		Employee user = null;
		boolean employeeIsFound = false;
		for (int i = 0; i < users.size() && !employeeIsFound; i++) {
			if (id.equals(users.get(i).getId())) {
				user = users.get(i);
				employeeIsFound = true;
			}
		}
		return user;
	}

	/// **
	// * checks for the id and the password of a user if it's exist or it's invalid
	// * inputs.
	// *
	// * @param id to be searched.
	// * @param password to be searched.
	// * @return whether the id and password already in the users array list.
	// */
	public boolean verifyLogin(String id, String password) {
		for (int i = 0; i < users.size(); i++) {
			if (id.equals(users.get(i).getId())) {
				if (password.equals(users.get(i).getPassword())) {
					return true;
				}
			}
		}
		return false;
	}

	/// **
	// * add the information of an user to the factory system and its array list.
	// *
	// * @param informations to be added in the array list and the system.
	// */
	public void addUser(String informations) {
		LocalDate date = LocalDate.now();
		StringBuilder line = new StringBuilder();
		String[] infromations_array = informations.split("#");
		line.append(infromations_array[0] + "#" + infromations_array[1] + "#" + 2000 + "#0#" + "0#0#" + date + "#"
				+ infromations_array[2] + "#" + infromations_array[3] + "#" + infromations_array[4] + "#"
				+ infromations_array[5] + "#" + infromations_array[6] + "#" + infromations_array[7] + "#"
				+ infromations_array[8] + "#" + infromations_array[9] + "#");

		line.insert(0, generateId() + "#");
		BankAccount bankAccount = new BankAccount();
		line.append(bankAccount.getAccountNumber() + "#" + bankAccount.getBalance() + "#" + infromations_array[10] + "#"
				+ infromations_array[11] + "#" + infromations_array[12]);
		ArrayList<String> workers = new ArrayList<String>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().startsWith("22")) {
				workers.add(users.get(i).toString());
			}
		}
		// save the information to the system.
		String[] Line = line.toString().split("#");
		Worker worker = new Worker(new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
				Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7], Line[8],
				Line[9],
				new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
						Line[13], Line[14], Line[15]),
				new BankAccount(Line[16], Double.parseDouble(Line[17])),
				new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20]))));
		this.addUser(worker);
		displayTheNewId(worker);// displays new worker id.

	}

	/// **
	// * displays new worker id.
	// *
	// * @param worker whose the id is.
	// */
	private void displayTheNewId(Worker worker) {
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("** Your id is : " + worker.getId() + " **");
		System.out.println("*************************");
		System.out.println("*************************");
	}

	/// **
	// * this method to generate new id for the new user.
	// *
	// * @return the generated id.
	// */
	public String generateId() {
		if (!users.isEmpty()) {
			// this array list to save id's of the users.
			ArrayList<String> IDs = new ArrayList<String>();
			for (int i = 0; i < users.size(); i++) {
				IDs.add(users.get(i).getId().substring(1));
			}
			// this loop to sort the workers in the array list by using the id.
			for (int i = 0; i < IDs.size(); i++) {
				int max = Integer.parseInt(IDs.get(i));
				int maxIndex = i;
				for (int j = i; j < IDs.size(); j++) {
					if (max < Integer.parseInt(IDs.get(j))) {
						max = Integer.parseInt(IDs.get(j));
						maxIndex = j;
					}
				}
				// swap the elements of the list.
				Collections.swap(IDs, i, maxIndex);
			}
			/// *
			// * this to get the last element of the ids which is the first one after the
			// * sorting, to add 1 to it and the new id is generated
			// */
			String lastID = "2" + IDs.get(0);
			int id = Integer.parseInt(lastID);
			return (id + 1) + "";
			// if the list was empty the id will be this..
		} else {
			return "200000";
		}
	}

	/// **
	// * this method to save any changes happens in any part or personal data of the
	// * users in the system.
	// *
	// * @param workers who work for factory.
	// * @param superVisors who manage the workers.
	// * @param salesMen who sale and distribute the goods of the factory.
	// * @param storage of the factory.
	// * @param financial of the factory.
	// * @param target which all employees aim to achieve.
	// */
	public void saveChanges(ArrayList<Worker> workers, ArrayList<SuperVisor> superVisors, ArrayList<SalesMan> salesMen,
			Storage storage, Financial financial, Target target) {
		ArrayList<String> workersData = new ArrayList<String>();
		ArrayList<String> superVisorsData = new ArrayList<String>();
		ArrayList<String> salesMenData = new ArrayList<String>();
		// copy the data of the workers to array list of string.
		for (int i = 0; i < workers.size(); i++) {
			workersData.add(workers.get(i).toString());
		}
		// copy the data of the supervisor to array list of string.
		for (int i = 0; i < superVisors.size(); i++) {
			superVisorsData.add(superVisors.get(i).toString());
		}
		// copy the data of the salesmen to array list of string.

		for (int i = 0; i < salesMen.size(); i++) {
			salesMenData.add(salesMen.get(i).toString());
		}
		// save the data to the files(dataBase of the factory).
		FileData.setData(workersData, "Workers.txt");
		FileData.setData(superVisorsData, "SuperVisors.txt");
		FileData.setData(salesMenData, "SalesMen.txt");
		FileData.setData(storage.toString(), "Storage.txt");
		FileData.setData(financial.toString(), "Financial.txt");
		FileData.setData(target.toString(), "Target.txt");

	}

	/// **
	// * manager utility where the manager can run or manage the factory and access
	/// to
	// * its component.
	// *
	// * @param in reference of scanner class it's used to input the values
	// * using it.
	// * @param manager who run the factory.
	// * @param workers who work for the factory.
	// * @param superVisors who supervised the workers.
	// * @param salesMen who can sell and distribute the goods of the factory.
	// * @param financial of the factory.
	// * @param storage of the factory.
	// * @param factory
	// * @param target which all the employees aim to achieve.
	// */
	public void managerUtility(Scanner in, Manager manager, ArrayList<Worker> workers,
			ArrayList<SuperVisor> superVisors, ArrayList<SalesMan> salesMen, Financial financial, Storage storage,
			Factory factory, Target target) {
		boolean logOut = false;
		while (!logOut) {
			UserMenu.managerMenu();
			char choice = in.next().charAt(0);
			if (choice == '1') {
				UserMenu.employeeTableOptionsMenu();
				boolean isValid = false;
				// to make the manager to choose between the options and if it's different asks
				// the same questions again.
				do {
					char table_option = in.next().charAt(0);
					if (table_option <= '3' && table_option >= '1') {
						manager.showEmployees(table_option, users);
						isValid = true;
					} else if (table_option == '4') {
						isValid = true;
					} else {
						System.out.println("Invalid Input :: ");
					}
				} while (!isValid);
				// to search for an employee using his id.
			} else if (choice == '2') {
				System.out.print("Enter the employee's id : ");
				String id = in.next();
				Employee person = null;
				if (id.startsWith("2")) {
					person = manager.searchForWorker(id, workers);
				} else if (id.startsWith("3")) {
					person = manager.searchForSuperVisor(id, superVisors);
				} else if (id.startsWith("4")) {
					person = manager.searchSalesMan(id, salesMen);
				}
				// after the manager chose the employee , he decided what to do with him or just
				// showing his searching for him.
				if (person != null) {
					// shows person's information
					person.showInformations();
					UserMenu.employeeOptionsMenu();
					char employee_option = in.next().charAt(0);
					if (employee_option == '1') {
						UserMenu.promotionOptions();
						char promoteTo_number = in.next().charAt(0);
						if (promoteTo_number == '1') {
							// promote the employee to supervisor.
							manager.promote(person, "SuperVisor", factory);
						} else if (promoteTo_number == '2') {
							// promote the employee to salesman.
							manager.promote(person, "SalesMan", factory);
						}

					} else if (employee_option == '2') {
						// fires the employee from tha factory.
						manager.firingEmployee(person, factory);
					}
				} else {
					System.out.println("You entered a wrong id..");
				}
			} else if (choice == '3') {
				UserMenu.managerStorageOptionsMenu();
				char num = in.next().charAt(0);
				manager.storageManagment(num, storage, target, workers.size(), salesMen.size());
			} else if (choice == '4') {
				UserMenu.managerFinancialOptionsMenu();
				char num = in.next().charAt(0);
				manager.financialManagment(num, financial);
			} else if (choice == '5') {
				manager.giveSalary(users, financial);
			} else if (choice == '6') {
				logOut = true;
			}
		}
	}

	/// **
	// *
	// * supervisor utility where the actions are done and made the changes.
	// *
	// * @param in reference of Scanner class to input the values using it.
	// * @param user of the system.
	// * @param storage of the factory where the goods are kept.
	// * @param target that all the employees aim to achieve.
	// */
	public void SuperVisorUtility(Scanner in, SuperVisor user, Storage storage, Target target) {
		boolean logOut = false;
		while (!logOut) {
			UserMenu.superVisorMenu();
			int choice = in.nextInt();
			if (choice == 1) {
				user.showInformations();
				System.out.print("Do you want to edit any informations ? (Y/N)\n::");
				String ch = in.next();
				if (ch.equalsIgnoreCase("Y")) {
					user.editInformations();
				}
			} else if (choice == 2) {
				Employee worker = user.showWorkersInformation();
				if (worker != null) {
					System.out.print("1-Give Feedback\n2-back\n::");
					String NUM = in.next();
					if (NUM.equalsIgnoreCase("1")) {
						double rate = user.answerFeedback(target);
						worker.setMonthlyRate(rate);
						worker.setBonus(rate / 100);
						worker.setOverallRate((worker.getOverallRate() + rate) / 2);
					}
				}
			} else if (choice == 3) {
				user.showTarget(target);
			} else if (choice == 4) {
				int target_result = user.setTargetResult(target);
				storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() + target_result);
				storage.setNumberOfGoodsManufacturedThisMonth(target_result);
			} else if (choice == 5) {
				logOut = true;
			} else {
				System.out.println("Invalid input .. ");
			}
		}
	}

	/// **
	// *
	// * salesman utility where the actions are done and made the changes.
	// *
	// * @param in reference of Scanner class to input the values using it.
	// * @param user of the system.
	// * @param financial of the factory where the money is kept.
	// * @param storage of the factory where the goods are kept.
	// * @param target that all the employees aim to achieve.
	// */
	public void SalesManUtility(Scanner in, SalesMan user, Financial financial, Storage storage, Target target) {
		boolean logOut = false;
		while (!logOut) {
			// shows the salesman menu to the salesman.
			UserMenu.salesManMenu();
			int choice = in.nextInt();
			if (choice == 1) {
				// shows the information of the sales man.
				user.showInformations();
				System.out.print("Do you want to edit any information ? (Y/N)\n::");
				String ch = in.next();
				if (ch.equalsIgnoreCase("Y")) {
					// edits his information.
					user.editInformations();
				}
			} else if (choice == 2) {
				// shows the target.
				user.showTarget(target);
			} else if (choice == 3) {
				int target_result = user.setTargetResult(target);
				storage.setNumberOfSoldGoods(target_result);
				storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() - target_result);
				financial.setTotalMoney(storage.getPriceofGoods() * target_result);
			} else if (choice == 4) {
				logOut = true;// to break the loop.
			}
		}
	}

	/// **
	// * worker utility where the actions are done and made the changes.
	// *
	// * @param in a reference from the scanner class.
	// * @param user the user of the system
	// * @param target the number of goods that employees aim to achieve.
	// */
	public void WorkerUtility(Scanner in, Worker user, Target target) {
		boolean logOut = false;
		while (!logOut) {
			// shows the worker menu to the worker.
			UserMenu.workerMenu();
			// inputs the choice of the showed list.
			int choice = in.nextInt();
			// check on the choice.
			if (choice == 1) {
				user.showInformations();
				System.out.print("Do you want to edit any informations ? (Y/N)\n::");
				String ch = in.next();
				if (ch.equalsIgnoreCase("Y")) {
					// edits information if the worker said so.
					user.editInformations();
				}
			} else if (choice == 2) {
				// shows the target for the worker.
				user.showTarget(target);
			} else if (choice == 3) {
				System.out.println("What do you want to do?");
				// bank account services menu.
				UserMenu.bankAccountServices();
				boolean isValidInput = false;// to break the loop.
				do {
					int bankServiceChoice = in.nextInt();
					if (bankServiceChoice == 1) {
						System.out.println("input your ammount :: ");
						int amount = in.nextInt();
						Employee employee = (Employee) user;
						// added an amount to the balance.
						employee.deposit(amount);
						System.out.println("Now Your Balance Is " + employee.getBankAccount().getBalance());
						isValidInput = true;// to break the loop.
					} else if (bankServiceChoice == 2) {
						System.out.println("input your ammount :: ");
						int amount = in.nextInt();
						Employee employee = (Employee) user;
						// takes an amount from the balance in the account.
						employee.withDraw(amount);
						System.out.println("Now Your Balance Is " + employee.getBankAccount().getBalance());
						isValidInput = true;// to break the loop.
					} else if (bankServiceChoice == 3) {
						isValidInput = true;// to break the loop.
					} else {
						System.out.println("Invalid input");
					}
					// check on the conditions.
				} while (!isValidInput);

			} else if (choice == 4) {
				logOut = true;// to break the loop.
			} else {
				System.out.println("invalid input .. ");
			}
		}
	}

	/// **
	// * this where the program make action in the code.
	// *
	// * @param user of the system.
	// * @param manager who manage the factory.
	// * @param workers who work for the factory.
	// * @param superVisors who supervised the workers
	// * @param salesMen who sales and distributes the goods of the factory.
	// * @param financial of the factory where the money is kept.
	// * @param storage of the factory where the goods are kept.
	// * @param target number of the goods to be achieved.
	// * @param factory reference from the factory class.
	// */
	public void userUtility(Person user, Manager manager, ArrayList<Worker> workers, ArrayList<SuperVisor> superVisors,
			ArrayList<SalesMan> salesMen, Financial financial, Storage storage, Target target, Factory factory) {
		Scanner in = new Scanner(System.in);
		if (user instanceof Manager) {
			// manager utility has all the actions of the manager.
			managerUtility(in, manager, workers, superVisors, salesMen, financial, storage, factory, target);
		} else if (user instanceof Worker) {
			Worker user1 = null;
			for (int i = 0; i < workers.size(); i++) {
				if (user.getId().equals(workers.get(i).getId())) {
					user1 = workers.get(i);
				}
			}
			// worker utility has all the actions of the worker.
			WorkerUtility(in, user1, target);
		} else if (user instanceof SuperVisor) {
			SuperVisor user1 = null;
			for (int i = 0; i < superVisors.size(); i++) {
				if (user.getId().equals(superVisors.get(i).getId())) {
					user1 = superVisors.get(i);
				}
			}
			// supervisor utility has all the actions of the supervisor.
			SuperVisorUtility(in, user1, storage, target);
		} else if (user instanceof SalesMan) {
			SalesMan user1 = null;
			for (int i = 0; i < salesMen.size(); i++) {
				if (user.getId().equals(salesMen.get(i).getId())) {
					user1 = salesMen.get(i);
				}
			}
			// salesman utility has all the actions of the salesman.
			SalesManUtility(in, user1, financial, storage, target);
		}
		// to save any change in the file.
		saveChanges(workers, superVisors, salesMen, storage, financial, target);
	}

	/// **
	// * sort the employee descending by their over all rate.
	// *
	// * @param employee the employees to be sorted in the array list.
	// */
	public static void sortEmployeesByOverAllRate(ArrayList<Employee> employees) {
		int indexOfMax = 0;
		for (int k = 0; k < employees.size(); k++) {
			double max = employees.get(k).getOverallRate();
			for (int j = k; j < employees.size(); j++) {
				if (max < employees.get(j).getOverallRate()) {
					max = employees.get(j).getOverallRate();
					indexOfMax = j;
				}
			}
			// swaps two elements.
			Collections.swap(employees, indexOfMax, k);
		}
	}

	/// **
	// * sort the the employees by the Id to them for the manager.
	// *
	// * @param employees the workers that will be sorted.
	// */
	public static void sortEmployeesById(ArrayList<Employee> employees) {
		int indexOfMax = 0;
		for (int k = 0; k < employees.size(); k++) {
			double max = Integer.parseInt(employees.get(k).getId());
			for (int j = k; j < employees.size(); j++) {
				if (max < Integer.parseInt(employees.get(j).getId())) {
					max = Integer.parseInt(employees.get(j).getId());
					indexOfMax = j;
				}
			}
			// swaps two elements.
			Collections.swap(employees, indexOfMax, k);
		}
	}
}
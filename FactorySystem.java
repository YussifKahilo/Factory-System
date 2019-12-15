
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FactorySystem {

	final private ArrayList<Employee> users = new ArrayList<Employee>();
	final private Manager userOfManager;

	public FactorySystem(ArrayList<Worker> usersOfWorkers, ArrayList<SuperVisor> usersOfSuperVisors,
			ArrayList<SalesMan> usersOfSalesMen, Manager userOfManager) {
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

	public void addUser(Employee user) {
		users.add(user);
	}

	public void removeUser(Employee user) {
		users.remove(user);
	}

	private void creatingUser() {
		Scanner in = new Scanner(System.in);
		String password = "";
		String email = "";
		boolean passwordIsValid = false;
		boolean arePasswordsAreIdentical = false;
		System.out.print("Enter your name : ");
		String name = in.nextLine();
		System.out.println("---------------------------");
		while (!arePasswordsAreIdentical) {
			while (!passwordIsValid) {
				System.out.println("(INFO)=> \n :: Your password must have at least : ");
				System.out.println("   - Four Charecters \n   - One upercase letter . "
						+ "\n   - One lowercase letter . " + "\n   - One Number or Symbol .");
				System.out.print("Enter a password : ");
				password = in.next();
				if (isPasswordValid(password)) {
					passwordIsValid = true;
				}
			}
			System.out.print("Confirm your password : ");
			String password2 = in.next();
			if (password.equals(password2)) {
				arePasswordsAreIdentical = true;
			} else {
				System.out.println("The two password are not identical ..");
			}
		}
		System.out.println("---------------------------");
		System.out.println("Your Birth Date :");
		System.out.print("-->Day : ");
		String dayOfBirth = in.next();
		System.out.print("-->Month : ");
		String monthOfBirth = in.next();
		System.out.print("-->Year : ");
		String yearOfBirth = in.next();
		if (Integer.parseInt(yearOfBirth) > 2000 || Integer.parseInt(yearOfBirth) < 1970) {

			do {
				System.out.println("Invalid year of birth\nInput Again ::");
				yearOfBirth = in.next();
			} while (Integer.parseInt(yearOfBirth) > 2000 && Integer.parseInt(yearOfBirth) < 1970);
		}
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
		String phoneNumber = "";
		boolean phoneNumberIsValid = false;
		while (!phoneNumberIsValid) {
			System.out.print("Please enter your phone number : ");
			phoneNumber = in.next();
			if (phoneNumber.length() == 11 && phoneNumber.startsWith("01")) {
				phoneNumberIsValid = true;
			} else {
				System.out.println("Invalid phone number..");
			}
		}
		System.out.println("---------------------------");
		boolean emailIsValid = false;
		while (!emailIsValid) {
			System.out.print("Please enter your Email : ");
			email = in.next();
			if (email.contains("@") && email.contains(".com")) {
				emailIsValid = true;
			} else {
				System.out.println("invalid E-mail");
			}
			System.out.println("---------------------------");
		}
		String informations = password + "#" + name + "#" + phoneNumber + "#" + email + "#" + apartmentNumber + "#"
				+ floorNumber + "#" + buildingNumber + "#" + streetName + "#" + blockName + "#" + cityName + "#"
				+ dayOfBirth + "#" + monthOfBirth + "#" + yearOfBirth;
		addUser(informations);

	}

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

	public Person loginingIn() {
		Scanner in = new Scanner(System.in);
		String id;
		boolean logedIn = false;
		Person user = null;
		while (!logedIn) {
			System.out.println("---------------------");
			System.out.print("Enter your ID : ");
			id = in.next();
			if (id.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			if (id.equalsIgnoreCase("c")) {
				this.creatingUser();
				logedIn = true;
			} else {
				System.out.print("Enter your Password : ");
				String password = in.next();
				if (id.equals(userOfManager.getId())) {
					if (userOfManager.getPassword().equals(password)) {
						logedIn = true;
						user = userOfManager;
					}
				} else if (id.startsWith("22")) {
					if (this.verifyLogin(id, password)) {
						logedIn = true;
						user = new Worker(getEmployee(id));
					} else {
						System.out.println("**************************");
						System.out.println("**Invalid ID or Password**");
						System.out.println("**************************");
					}
				} else if (id.startsWith("33")) {
					if (this.verifyLogin(id, password)) {
						logedIn = true;
						ArrayList<Worker> workers = new ArrayList<Worker>();
						for (int i = 0; i < users.size(); i++) {
							if (users.get(i) instanceof Worker) {
								workers.add(new Worker(users.get(i)));
							}
						}
						user = new SuperVisor(getEmployee(id), workers);
					}
				} else if (id.startsWith("44")) {
					if (this.verifyLogin(id, password)) {
						logedIn = true;
						user = new SalesMan(getEmployee(id));
					}
				} else {
					System.out.println("**************");
					System.out.println("**Invalid ID**");
					System.out.println("**************");
				}
			}
		}
		return user;
	}

	public Employee getEmployee(String id) {
		Employee user = null;
		for (int i = 0; i < users.size(); i++) {
			if (id.equals(users.get(i).getId())) {
				user = users.get(i);
			}
		}
		return user;
	}

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

	public void addUser(String informations) {
		LocalDate date = LocalDate.now();
		StringBuilder line = new StringBuilder();
		String[] infromations_array = informations.split("#");
		line.append(infromations_array[0] + "#" + infromations_array[1] + "#" + 2000 + "#0#" + "0#0#" + date + "#"
				+ infromations_array[2] + "#" + infromations_array[3] + "#" + infromations_array[4] + "#"
				+ infromations_array[5] + "#" + infromations_array[6] + "#" + infromations_array[7] + "#"
				+ infromations_array[8] + "#" + infromations_array[9] + "#");
		if (!users.isEmpty()) {
			ArrayList<String> IDs = new ArrayList<String>();
			for (int i = 0; i < users.size(); i++) {
				IDs.add(users.get(i).getId().substring(3));
			}
			for (int i = 0; i < IDs.size(); i++) {
				int max = Integer.parseInt(IDs.get(i));
				int maxIndex = i;
				for (int j = i; j < IDs.size(); j++) {
					if (max < Integer.parseInt(IDs.get(j))) {
						max = Integer.parseInt(IDs.get(j));
						maxIndex = j;
					}
				}
				Collections.swap(IDs, i, maxIndex);
			}
			String lastID = "220" + IDs.get(0);
			int id = Integer.parseInt(lastID);
			line.insert(0, (id + 1) + "#");
		} else {
			line.insert(0, "220000" + "#");
		}
		BankAccount ba = new BankAccount();
		line.append(ba.getAccountNumber() + "#" + ba.getBalance() + "#" + infromations_array[10] + "#"
				+ infromations_array[11] + "#" + infromations_array[12]);
		ArrayList<String> workers = new ArrayList<String>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().startsWith("22")) {
				workers.add(users.get(i).toString());
			}
		}
		String[] Line = line.toString().split("#");
		Employee person = new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
				Double.parseDouble(Line[4]), Double.parseDouble(Line[5]), Double.parseDouble(Line[6]), Line[7], Line[8],
				Line[9],
				new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]),
						Line[13], Line[14], Line[15]),
				new BankAccount(Line[16], Double.parseDouble(Line[17])),
				new BirthDate(Integer.parseInt(Line[18]), Integer.parseInt(Line[19]), Integer.parseInt(Line[20])));
		this.addUser(person);
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("** Your id is : " + person.getId() + " **");
		System.out.println("*************************");
		System.out.println("*************************");
	}

	public boolean checkForUser(Employee user) {
		boolean isFound = false;
		for (int i = 0; i < users.size() && !isFound; i++) {
			if (user.getId().equals(users.get(i).getId())) {
				isFound = true;
			}
		}
		return isFound;
	}

	public void saveChanges(ArrayList<Worker> workers, ArrayList<SuperVisor> superVisors, ArrayList<SalesMan> salesMen,
			Storage storage, Financial financial) {
		ArrayList<String> workersData = new ArrayList<String>();
		ArrayList<String> superVisorsData = new ArrayList<String>();
		ArrayList<String> salesMenData = new ArrayList<String>();
		for (int i = 0; i < workers.size(); i++) {
			workersData.add(workers.get(i).toString());
		}
		for (int i = 0; i < superVisors.size(); i++) {
			superVisorsData.add(superVisors.get(i).toString());
		}
		for (int i = 0; i < salesMen.size(); i++) {
			salesMenData.add(salesMen.get(i).toString());
		}
		FileData.setData(workersData, "Workers.txt");
		FileData.setData(superVisorsData, "SuperVisors.txt");
		FileData.setData(salesMenData, "SalesMen.txt");
		FileData.setData(storage.toString(), "Storage.txt");
		FileData.setData(financial.toString(), "Financial.txt");

	}

	public void userUtility(Person user, Manager manager, ArrayList<Worker> workers, ArrayList<SuperVisor> superVisors,
			ArrayList<SalesMan> salesMen, Financial financial, Storage storage, Factory factory) {
		Scanner in = new Scanner(System.in);
		boolean logOut = false;
		if (user instanceof Manager) {
			while (!logOut) {
				UserMenu.managerMenu();
				int choice = in.nextInt();
				if (choice == 1) {
					UserMenu.employeeTableOptionsMenu();
					int table_option = in.nextInt();
					if (table_option <= 3 && table_option >= 1) {
						manager.showEmployees(table_option, users);
					}
				} else if (choice == 2) {
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
					if (person != null) {
						person.showInformations();
						UserMenu.employeeOptionsMenu();
						int employee_option = in.nextInt();
						if (employee_option == 1) {
							System.out.println("1-Promote to Super Visor");
							System.out.println("2-Promote to Sales Man");
							System.out.println("3-Back");
							System.out.print("::");
							int promoteTo_number = in.nextInt();
							if (promoteTo_number == 1) {
								manager.promote(person, "SuperVisor", factory);
							} else if (promoteTo_number == 2) {
								manager.promote(person, "SalesMan", factory);
							}
						} else if (employee_option == 2) {
							System.out.print("Enter The New Salary : ");
							person.setSalary(in.nextDouble());
						} else if (employee_option == 3) {
							manager.firingEmployee(person, factory);
						}
					} else {
						System.out.println("You entered a wrong id..");
					}
				} else if (choice == 3) {
					System.out.print("The Target this month is : ");
					manager.setTarget(in.nextInt(), workers.size());
				} else if (choice == 4) {
					UserMenu.managerStorageOptionsMenu();
					String NUM = in.next();
					manager.storageManagment(Integer.parseInt(NUM), storage);
				} else if (choice == 5) {
					UserMenu.managerFinancialOptionsMenu();
					String NUM = in.next();
					manager.financialManagment(Integer.parseInt(NUM), financial);
				} else if (choice == 6) {
					manager.giveSalary(users);
				} else if (choice == 7) {
					logOut = true;
				}
			}
		} else if (user instanceof Worker) {
			Worker USER = null;
			for (int i = 0; i < workers.size(); i++) {
				if (user.getId().equals(workers.get(i).getId())) {
					USER = workers.get(i);
				}
			}
			while (!logOut) {
				UserMenu.workerMenu();
				int choice = in.nextInt();
				if (choice == 1) {
					USER.showInformations();
					System.out.print("Do you want to edit any informations ? (Y/N)\n::");
					String ch = in.next();
					if (ch.equalsIgnoreCase("Y")) {
						USER.editInformations();
					}
				} else if (choice == 2) {
					USER.showTarget();
				} else if (choice == 3) {
					System.out.println("What do you want to do?\n 1)Deposit\n2)Withdraw:: ");
					int bankServiceChoice = in.nextInt();
					if (bankServiceChoice == 1) {
						System.out.println("input your ammount :: ");
						int amount = in.nextInt();
						Employee employee = (Employee) user;
						employee.deposit(amount);
						System.out.println("Now Your Balance Is " + employee.getBankAccount().getBalance());
					} else if (bankServiceChoice == 2) {
						System.out.println("input your ammount :: ");
						int amount = in.nextInt();
						Employee employee = (Employee) user;
						employee.withDraw(amount);
						System.out.println("Now Your Balance Is " + employee.getBankAccount().getBalance());
					} else {
						System.out.println("Invalid input");
					}

				} else if (choice == 4) {
					logOut = true;
				} else {
					System.out.println("invalid input .. ");
				}
			}
		} else if (user instanceof SuperVisor) {
			SuperVisor USER = null;
			for (int i = 0; i < superVisors.size(); i++) {
				if (user.getId().equals(superVisors.get(i).getId())) {
					USER = superVisors.get(i);
				}
			}
			while (!logOut) {
				UserMenu.superVisorMenu();
				int choice = in.nextInt();
				if (choice == 1) {
					USER.showInformations();
					System.out.print("Do you want to edit any informations ? (Y/N)\n::");
					String ch = in.next();
					if (ch.equalsIgnoreCase("Y")) {
						USER.editInformations();
					}
				} else if (choice == 2) {
					Employee worker = USER.showWorkersInformation();
					if (worker != null) {
						System.out.print("1-Give Feedback\n2-back\n::");
						String NUM = in.next();
						if (NUM.equalsIgnoreCase("1")) {
							double rate = USER.answerFeedback();
							worker.setMonthlyRate(rate);
							worker.setBonus(rate / 100);
							worker.setOverallRate((worker.getOverallRate() + rate) / 2);
						}
					}
				} else if (choice == 3) {
					USER.showTarget();
				} else if (choice == 4) {
					int target_result = USER.setTargetResult();
					storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() + target_result);
					storage.setnumberOfGoodsThisMonth(target_result);
				} else if (choice == 5) {
					logOut = true;
				} else {
					System.out.println("Invalid input .. ");
				}
			}

		} else if (user instanceof SalesMan) {
			SalesMan USER = null;
			for (int i = 0; i < salesMen.size(); i++) {
				if (user.getId().equals(salesMen.get(i).getId())) {
					USER = salesMen.get(i);
				}
			}
			while (!logOut) {
				UserMenu.salesManMenu();
				int choice = in.nextInt();
				if (choice == 1) {
					USER.showInformations();
					System.out.print("Do you want to edit any information ? (Y/N)\n::");
					String ch = in.next();
					if (ch.equalsIgnoreCase("Y")) {
						USER.editInformations();
					}
				} else if (choice == 2) {
					USER.showTarget();
				} else if (choice == 3) {
					int target_result = USER.setTargetResult();
					storage.setNumberOfSoldGoods(target_result);
					storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() - target_result);
					financial.setTotalMoney(storage.getPriceofGoods() * target_result);
				} else if (choice == 4) {
					logOut = true;
				}
			}
		}

		saveChanges(workers, superVisors, salesMen, storage, financial);
	}
}

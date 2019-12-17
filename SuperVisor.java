
import java.util.ArrayList;
import java.util.Scanner;

public class SuperVisor extends Employee {

<<<<<<< HEAD
	private ArrayList<Worker> Workers = new ArrayList<Worker>();

	/**
	 * Supervisor constructor.
	 * 
	 * @param superVisor reference from Employee to access its methods and
	 *                   attributes
	 * @param workers    array list of all the workers in the factory.
	 */
	public SuperVisor(Employee superVisor, ArrayList<Worker> workers) {
		super(superVisor.getId(), superVisor.getPassword(), superVisor.getName(), superVisor.getSalary(),
				superVisor.getBonus(), superVisor.getMonthlyRate(), superVisor.getOverallRate(),
				superVisor.getHiringDate(), superVisor.getPhoneNumber(), superVisor.getEmail(), superVisor.getAddress(),
				superVisor.getBankAccount(), superVisor.getBirthDate());
		setWorkers(workers); // sets the workers to the array list by reference.
	}

	/**
	 * sets the workers of a specific supervisor.
	 * 
	 * @param workers of the factory.
	 */
	private void setWorkers(ArrayList<Worker> workers) {
		int index = 0;
		ArrayList<String> SuperVisors = new ArrayList<String>();
		FileData.getData(SuperVisors, "SuperVisors.txt");
		boolean indexFound = false;
		for (int i = 0; i < SuperVisors.size() && !indexFound; i++) {
			if (this.getId().equalsIgnoreCase(SuperVisors.get(i).substring(0, SuperVisors.get(i).indexOf('#')))) {
				index = i;
				indexFound = true;
			}
		}
		/*
		 * array list of workers of a specific supervisor.
		 */
		ArrayList<String> WorkersId = new ArrayList<String>();
		FileData.getData(WorkersId, "WorkersOfSuperVisors.txt");
		String[] workersid = WorkersId.get(index).split("#");
		for (int i = 0; i < workersid.length; i++) {
			for (int j = 0; j < workers.size(); j++) {
				if (workersid[i].equalsIgnoreCase(workers.get(j).getId())) {
					this.Workers.add(workers.get(j));
					break;
				}
			}
		}
	}

	/**
	 * shows workers information to the supervisor.
	 * 
	 * @return the chosen worker.
	 */
	public Employee showWorkersInformation() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		for (; i < Workers.size(); i++) {
			System.out.println((i + 1) + "- " + this.Workers.get(i).getName());

		}
		System.out.println((i + 1) + "- " + "Back");

		System.out.print("Choose : ");
		String choice = input.next();
		int choiceNumber = Integer.parseInt(choice);
		if (Integer.parseInt(choice) <= Workers.size()) {
			System.out.println("*------------------------------------------------------------------");
			System.out.println("|Name         :" + Workers.get(choiceNumber - 1).getName());
			System.out.println("|ID           : " + Workers.get(choiceNumber - 1).getId());
			System.out.println("|Overall Rate : " + Workers.get(choiceNumber - 1).getOverallRate());
			System.out.println("|Hiring Date  : " + Workers.get(choiceNumber - 1).getHiringDate());
			System.out.println("|Phone Number : " + Workers.get(choiceNumber - 1).getPhoneNumber());
			System.out.println("|E-mail       : " + Workers.get(choiceNumber - 1).getEmail());
			System.out.println("|Address      : " + Workers.get(choiceNumber - 1).getAddress().Display_Address());
			System.out.println("*-------------------------------------------------------------------");
			return Workers.get(choiceNumber - 1);

		}
		return null;
	}

	/**
	 * supervisor answers the feedback about the workers he responsible for.
	 * 
	 * @param target that the manager put.
	 * @return rating of the worker.
	 */
	public double answerFeedback(Target target) {
		Scanner input = new Scanner(System.in);
		double ratingOfTheWorker = 0;
		String answer;
		String questions[] = new String[7];
		questions[0] = "Does the worker come on time ? : ";
		questions[1] = "Does the worker have passion on work ? : ";
		questions[2] = "Is the worker good at collaborating with teammates ? : ";
		questions[3] = "Does the worker behave well ? : ";
		questions[4] = "Does the worker do his job efficiently ? : ";
		questions[5] = "Does the worker bear the pressure of work ? : ";
		questions[6] = "-->So the number of goods made by him is : ";

		for (int i = 0; i < 6; i++) {
			System.out.print(questions[i]);
			answer = input.next();
			if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("T")) {
				ratingOfTheWorker++;
			}
		}
		int satTarget = super.showTarget(target);
		System.out.print(questions[6]);
		for (;;) {
			answer = input.next();

			if (Integer.parseInt(answer) > satTarget) {
				System.out.print("You entered a number greater than the target please try again : ");
			} else {
				ratingOfTheWorker += ((Double.parseDouble(answer) / satTarget) * 4);
				break;
			}
		}
		return ratingOfTheWorker;
	}

	/**
	 * show the target to the supervisor.
	 */
	@Override
	public int showTarget(Target target) {
		super.showTarget(target);
		System.out.println("The total team target is : "
				+ target.getTargetOfGoodsToBeManufacturedForEachWorker() * Workers.size());
		return target.getTargetOfGoodsToBeManufacturedForEachWorker() * Workers.size();
	}

	/**
	 * sets target result.
	 * 
	 * @param target to be set.
	 * @return the target.
	 */
	public int setTargetResult(Target target) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of manufactured goods this month");
		String amount = input.next();
		int satTarget = this.showTarget(target);
		System.out.println("And your team manufactured " + amount + " goods this month ..");
		double ratio = (Integer.parseInt(amount) * 1.0) / satTarget;
		this.setMonthlyRate(ratio * 10);
		this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
		return Integer.parseInt(amount);
	}

	/**
	 * shows the information of the supervisor.
	 */
	@Override
	public void showInformations() {
		super.showInformations();
		System.out.println("| The Workers responsible for : ");
		for (int i = 0; i < Workers.size(); i++) {
			System.out.println("| " + (i + 1) + "- " + Workers.get(i).getName());
		}
		System.out.println("*--------------------------------------------------------------------------");
	}
=======
    private ArrayList<Worker> Workers = new ArrayList<Worker>();

    public SuperVisor(Employee superVisor, ArrayList<Worker> workers) {
        super(superVisor.getId(), superVisor.getPassword(), superVisor.getName(), superVisor.getSalary(),
                superVisor.getBonus(), superVisor.getMonthlyRate(), superVisor.getOverallRate(),
                superVisor.getHiringDate(), superVisor.getPhoneNumber(), superVisor.getEmail(), superVisor.getAddress(),
                superVisor.getBankAccount(), superVisor.getBirthDate());
        setWorkers(workers);
    }

    private void setWorkers(ArrayList<Worker> workers) {
        int index = 0;
        ArrayList<String> SuperVisors = new ArrayList<String>();
        FileData.getData(SuperVisors, "SuperVisors.txt");
        for (int i = 0; i < SuperVisors.size(); i++) {
            if (this.getId().equalsIgnoreCase(SuperVisors.get(i).substring(0, SuperVisors.get(i).indexOf('#')))) {
                index = i;
                break;
            }
        }
        ArrayList<String> WorkersId = new ArrayList<String>();
        FileData.getData(WorkersId, "WorkersOfSuperVisors.txt");
        String[] workersid = WorkersId.get(index).split("#");
        for (int i = 0; i < workersid.length; i++) {
            for (int j = 0; j < workers.size(); j++) {
                if (workersid[i].equalsIgnoreCase(workers.get(j).getId())) {
                    this.Workers.add(workers.get(j));
                    break;
                }
            }
        }
    }

    public Employee showWorkersInformation() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        for (; i < Workers.size(); i++) {
            System.out.println((i + 1) + "- " + this.Workers.get(i).getName());

        }
        System.out.println((i + 1) + "- " + "Back");

        System.out.print("Choose : ");
        String inn = input.next();
        int ss = Integer.parseInt(inn);
        if (Integer.parseInt(inn) <= Workers.size()) {
            System.out.println("*--------------------------------------------------------------------------");
            System.out.println("|Name                    : " + Workers.get(ss - 1).getName());
            System.out.println("|ID                      : " + Workers.get(ss - 1).getId());
            System.out.println("|Overall Rate            : " + Workers.get(ss - 1).getOverallRate());
            System.out.println("|Hiring Date             : " + Workers.get(ss - 1).getHiringDate());
            System.out.println("|Phone Number            : " + Workers.get(ss - 1).getPhoneNumber());
            System.out.println("|E-mail                  : " + Workers.get(ss - 1).getEmail());
            System.out.println("|Address                 : " + Workers.get(ss - 1).getAddress().Display_Address());
            System.out.println("*--------------------------------------------------------------------------");
            return Workers.get(ss - 1);

        }
        return null;
    }

    public double answerFeedback(Target target) {
        Scanner input = new Scanner(System.in);
        double Y = 0;
        String answer;
        String questions[] = new String[7];
        questions[0] = "Does the worker come on time ? : ";
        questions[1] = "Does the worker have passion on work ? : ";
        questions[2] = "Is the worker good at collaborating with teammates ? : ";
        questions[3] = "Does the worker behave well ? : ";
        questions[4] = "Does the worker do his job efficiently ? : ";
        questions[5] = "Does the worker bear the pressure of work ? : ";
        questions[6] = "-->So the number of goods made by him is : ";

        for (int i = 0; i < 6; i++) {
            System.out.print(questions[i]);
            answer = input.next();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("T")) {
                Y++;
            }
        }
        int satTarget = super.showTarget(target);
        System.out.print(questions[6]);
        for (;;) {
            answer = input.next();

            if (Integer.parseInt(answer) > satTarget) {
                System.out.print("You entered a number greater than the target please try again : ");
            } else {
                Y += ((Double.parseDouble(answer) / satTarget) * 4);
                break;
            }
        }
        return Y;
    }

    @Override
    public int showTarget(Target target) {
        super.showTarget(target);
        System.out.println("The total team target is : "
                + target.getTargetOfGoodsToBeManufacturedForEachWorker() * Workers.size());
        return target.getTargetOfGoodsToBeManufacturedForEachWorker() * Workers.size();
    }

    public int setTargetResult(Target target) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of manufactured goods this month");
        String amount = input.next();
        int satTarget = this.showTarget(target);
        System.out.println("And your team manufactured " + amount + " goods this month ..");
        double ratio = (Integer.parseInt(amount) * 1.0) / satTarget;
        this.setMonthlyRate(ratio * 10);
        this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
        return Integer.parseInt(amount);
    }

    @Override
    public void showInformations() {
        super.showInformations();
        System.out.println("| The Workers responsible for : ");
        for (int i = 0; i < Workers.size(); i++) {
            System.out.println("| " + (i + 1) + "- " + Workers.get(i).getName());
        }
        System.out.println("*--------------------------------------------------------------------------");
    }
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd

}

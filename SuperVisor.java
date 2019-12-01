package FactorySystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class SuperVisor extends Employee {

    private Employee[] workers = new Employee[5];

    public SuperVisor(Employee superVisor) {
        super(
                superVisor.getId(), superVisor.getPassword(),
                superVisor.getName(), superVisor.getSalary(),
                superVisor.getBonus(), superVisor.getMonthlyRate(),
                superVisor.getOverallRate(), superVisor.getHiringDate(),
                superVisor.getPhoneNumber(), superVisor.getEmail(),
                superVisor.getAddress().getHouseNumber(),
                superVisor.getAddress().getFlateNumber(),
                superVisor.getAddress().getStreetName(),
                superVisor.getAddress().getPlace(),
                superVisor.getBankAccount().getAccountNumber(),
                superVisor.getBankAccount().getBalance());

    }

    public Employee showWorkersInformation() throws IOException {
        User u1 = new User();
        Scanner input = new Scanner(System.in);
        int index = 0;
        ArrayList<Employee> SuperVisors = u1.getPersons("SuperVisors");
        for (int i = 0; i < SuperVisors.size(); i++) {
            if (this.getId().equalsIgnoreCase(SuperVisors.get(i).getId())) {
                index = i;
                break;
            }
        }
        BufferedReader reader = new BufferedReader(new FileReader("WorkersId.txt"));
        String line = reader.readLine();
        ArrayList<String> WorkersId = new ArrayList<String>();
        while (line != null) {
            WorkersId.add(line);
            line = reader.readLine();

        }
        reader.close();
        String[] workersid = WorkersId.get(index).split("#");
        ArrayList<Employee> Workers = u1.getPersons("Workers");
        int ind = 0;
        for (int i = 0; i < workersid.length; i++) {
            for (int j = 0; j < Workers.size(); j++) {
                if (workersid[i] == Workers.get(j).getId()) {
                    this.workers[ind++] = Workers.get(j);
                    break;
                }
            }
        }
        int numOfWorkers = 0;
        for (;;) {
            for (int i = 0; i < 5; i++) {
                if (this.workers[i] != null) {
                    System.out.println((i + 1) + "- " + this.workers[i].getName());
                    numOfWorkers++;
                } else {
                    System.out.println((i + 1) + "- " + "Back");
                    break;
                }
            }
            System.out.print("Choose : ");
            String inn = input.next();
            char x = inn.charAt(0);
            if (x < '9' && x > '0') {
                if (inn.equals("1") && Integer.parseInt(inn) <= numOfWorkers) {
                    System.out.println("name of this employee is" + workers[0].getName());
                    System.out.println("id of this employee is" + workers[0].getId());
                    System.out.println("phone number of this employee is" + workers[0].getPhoneNumber());
                    System.out.println("email of this employee is" + workers[0].getEmail());
                    System.out.println("address of this employee is" + workers[0].getAddress());
                    System.out.println("hiring date of this employee is" + workers[0].getHiringDate());
                    System.out.println("overall rate of this employee is" + workers[0].getOverallRate());
                    System.out.println("----------------------------------------------------");
                    return workers[0];
                } else if (inn.equals("2") && Integer.parseInt(inn) <= numOfWorkers) {
                    System.out.println("name of this employee is" + workers[1].getName());
                    System.out.println("id of this employee is" + workers[1].getId());
                    System.out.println("phone number of this employee is" + workers[1].getPhoneNumber());
                    System.out.println("email of this employee is" + workers[1].getEmail());
                    System.out.println("address of this employee is" + workers[1].getAddress());
                    System.out.println("hiring date of this employee is" + workers[1].getHiringDate());
                    System.out.println("overall rate of this employee is" + workers[1].getOverallRate());
                    System.out.println("----------------------------------------------------");
                    return workers[1];
                } else if (inn.equals("3") && Integer.parseInt(inn) <= numOfWorkers) {
                    System.out.println("name of this employee is" + workers[2].getName());
                    System.out.println("id of this employee is" + workers[2].getId());
                    System.out.println("phone number of this employee is" + workers[2].getPhoneNumber());
                    System.out.println("email of this employee is" + workers[2].getEmail());
                    System.out.println("address of this employee is" + workers[2].getAddress());
                    System.out.println("hiring date of this employee is" + workers[2].getHiringDate());
                    System.out.println("overall rate of this employee is" + workers[2].getOverallRate());
                    System.out.println("----------------------------------------------------");
                    return workers[2];
                } else if (inn.equals("4") && Integer.parseInt(inn) <= numOfWorkers) {
                    System.out.println("name of this employee is" + workers[3].getName());
                    System.out.println("id of this employee is" + workers[3].getId());
                    System.out.println("phone number of this employee is" + workers[3].getPhoneNumber());
                    System.out.println("email of this employee is" + workers[3].getEmail());
                    System.out.println("address of this employee is" + workers[3].getAddress());
                    System.out.println("hiring date of this employee is" + workers[3].getHiringDate());
                    System.out.println("overall rate of this employee is" + workers[3].getOverallRate());
                    System.out.println("----------------------------------------------------");
                    return workers[3];
                } else if (inn.equals("5") && Integer.parseInt(inn) <= numOfWorkers) {
                    System.out.println("name of this employee is" + workers[4].getName());
                    System.out.println("id of this employee is" + workers[4].getId());
                    System.out.println("phone number of this employee is" + workers[4].getPhoneNumber());
                    System.out.println("email of this employee is" + workers[4].getEmail());
                    System.out.println("address of this employee is" + workers[4].getAddress());
                    System.out.println("hiring date of this employee is" + workers[4].getHiringDate());
                    System.out.println("overall rate of this employee is" + workers[4].getOverallRate());
                    System.out.println("----------------------------------------------------");
                    return workers[4];
                } else {
                    break;
                }
            }
        }
        return null;
    }

    public int answerFeedback() {
        Scanner input = new Scanner(System.in);
        int T = 0;
        char check[] = new char[6];
        String questions[] = new String[6];
        questions[0] = " employee is good:";
        questions[1] = " employee is kind :";
        questions[2] = " employee is intelgent:";
        questions[3] = " employee is fast :";
        questions[4] = " employee is best:";
        questions[5] = " how many tasks employee did it :";

        System.out.println("* Welcome please Answer this questions : *");
        for (int i = 0; i < 6; i++) {
            System.out.println("questions " + (1 + i) + ":" + questions[i]);
            check[i] = input.next().charAt(0);
            if (check[i] == 'T' || check[i] == 't') {
                T++;
            }
        }
        if (check[5] == '0') {
            T += 0;
        } else if (check[5] == '1') {
            T += 1;
        } else if (check[5] == '2') {
            T += 2;
        } else if (check[5] == '3') {
            T += 3;
        } else if (check[5] == '4') {
            T += 4;
        } else if (check[5] == '5') {
            T += 5;
        }
        return T;
    }

    @Override
    public int showTarget() throws IOException {
        super.showTarget();
        int numOfWorkers = 0;
        for (int i = 0; i < 5; i++) {
            if (this.workers[i] != null) {
                numOfWorkers++;
            } else {
                break;
            }
        }
        BufferedReader reader = new BufferedReader(new FileReader("Target.txt"));
        String line = reader.readLine();
        String [] Line = line.split("#");
        System.out.println("The total team target is : "+(Integer.parseInt(Line[1])*numOfWorkers));
        reader.close();
        return (Integer.parseInt(Line[1])*numOfWorkers);
    }

    public void setTargetResult(int amount,int target) throws IOException {
        Storage storage = new Storage();
        System.out.println("And your team manufactured "+ amount + " goods this month ..");
        storage.setNumberOfStoredGoods(storage.getNumberOfStoredGoods() + amount);
        double ratio = (amount * 1.0) / target;
        this.setMonthlyRate(ratio * 10);
        this.setOverallRate((this.getOverallRate() + this.getMonthlyRate()) / 2);
    }

}

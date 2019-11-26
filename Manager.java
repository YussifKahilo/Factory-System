package FactorySystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Manager extends Person {

    public Manager() {
        this("1100", "Kahilo", "00");
    }

    public Manager(String id, String name, String password) {
        super(id, name, password);
    }

    public void promote(Employee Person) throws IOException {
        User u1 = new User();
        if (Person.getId().startsWith("22")) {
            u1.removePerson(Person.getId(), "Workers");
            Person.setId("33" + Person.getId().substring(2));
            u1.addPerson("SuperVisors", Person.toString());
        } else if (Person.getId().startsWith("33")) {
            u1.removePerson(Person.getId(), "SuperVisors");
            Person.setId("44" + Person.getId().substring(2));
            u1.addPerson("SlalesMan", Person.toString());
        }
    }

    public Employee searchForEmployee() throws IOException {
        Scanner input = new Scanner(System.in);
        User u1 = new User();
        ArrayList<Employee> persons;
        String id;
        for (;;) {
            System.out.println("please enter id of employee");
            id = input.next();
            if (id.startsWith("22")) {
                persons = u1.getPersons("Workers");
                break;
            } else if (id.startsWith("33")) {
                persons = u1.getPersons("SuperVisors");
                break;
            } else if (id.startsWith("44")) {
                persons = u1.getPersons("SalesMan");
                break;
            } else {
                System.out.println("you input invalid id:");
                System.out.println("please try again");

            }
        }
        for (int i = 0; i < persons.size(); i++) {
            if (id.equals(persons.get(i).getId())) {
                return persons.get(i);
            }
        }
        return null;
    }

    public void showEmployees() throws IOException {
        Scanner input = new Scanner(System.in);
        User u1 = new User();
        ArrayList<Employee> persons = new ArrayList<Employee>();
        OUTER:
        for (;;) {
            System.out.println("please select one:");
            System.out.println(" 1- Worker");
            System.out.println(" 2- Supervisor");
            System.out.println(" 3- Sales man");
            System.out.println(" 4- Back");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    persons = u1.getPersons("Workers");
                    break OUTER;
                case 2:
                    persons = u1.getPersons("SuperVisors");
                    break OUTER;
                case 3:
                    persons = u1.getPersons("SalesMan");
                    break OUTER;
                case 4:
                    return;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i).getId() + " " + persons.get(i).getName());
        }
    }

    public void storageManagment(int num) throws IOException {
        Scanner input = new Scanner(System.in);
        Storage storage = new Storage();
        if (num == 1) {
            System.out.println("The number of stored goods: " + storage.getNumberOfStoredGoods());
        } else if (num == 2) {
            System.out.println("The number of goods that  have been manufactured this month: " + storage.getnumberOfGoodsThisMonth());

        } else if (num == 3) {
            System.out.println("The number of sold goods:" + storage.getNumberOfSoldGood());

        } else if (num == 4) {
            System.out.println("Enter The Number Of Goods To be Sold: ");
            storage.setNumberOfGoodsTobeSold(input.nextInt());
            System.out.println("Enter The price of each goods");
            storage.setPriceOfGoods(input.nextDouble());
        }
    }

    public void financialManagment(int num) throws IOException {
        Financial financial = new Financial();
        Scanner input = new Scanner(System.in);
        if (num == 1) {
            System.out.println("The total money is: " + financial.getTotalMoney());
        } else if (num == 2) {
            System.out.println("profits is: " + financial.getprofit());
        } else if (num == 3) {
            System.out.println("Enter the price of materials you bought :");
            financial.setTotalMoney(financial.getTotalMoney() - input.nextDouble());
        }
    }

    public void setTarget() throws IOException {
        Scanner input = new Scanner(System.in);
        FileWriter in = new FileWriter("SuperVisorTarget.txt");
        BufferedWriter buf = new BufferedWriter(in);
        System.out.println("Welcome manager:");
        System.out.println("please Set target:");
        int Target = input.nextInt();
        buf.write("The Target this month is : " + Target);
        User u = new User();
        ArrayList<Employee> superVisors = u.getPersons("SuperVisors");
        buf.write("Target for each SuperVisor is : " + (Target / superVisors.size()));
        buf.close();
    }

    public void firingEmployee(Employee Person) throws IOException {
        User u1 = new User();
        if (Person.getId().startsWith("22")) {
            u1.removePerson(Person.getId(), "Workers");
            u1.updateInformations("Workers");
        } else if (Person.getId().startsWith("33")) {
            u1.removePerson(Person.getId(), "SuperVisors");
            u1.updateInformations("SuperVisors");
        } else if (Person.getId().startsWith("44")) {
            u1.removePerson(Person.getId(), "SalesMan");
            u1.updateInformations("SalesMan");
        }
    }
}

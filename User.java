package FactorySystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private static ArrayList<Employee> persons = new ArrayList<Employee>();
    Employee person;
    Manager manager = new Manager();

    public User() {

    }

    private void creatingUser() throws IOException {
        Scanner in = new Scanner(System.in);
        String password;
        String email;
        System.out.print("Enter your name : ");
        String name = in.nextLine();
        MainClass.checkForClose(name);
        for (;;) {
            for (;;) {
                System.out.println("(INFO)=> \n :: Your pass word must have at least : ");
                System.out.println("   - Four Charecters \n   - One upercase letter . "
                        + "\n   - One lowercase letter . "
                        + "\n   - One Number or Symbol .");
                System.out.print("Enter a password : ");
                password = in.next();
                MainClass.checkForClose(password);
                if (isPasswordValid(password)) {
                    break;
                }
            }
            System.out.print("Confirm your password : ");
            String password2 = in.next();
            MainClass.checkForClose(password2);
            if (password.equals(password2)) {
                break;
            } else {
                System.out.println("The two password are not identical ..");
            }
        }
        System.out.print("Enter your house number : ");
        String houseNumber = in.next();
        MainClass.checkForClose(houseNumber);
        System.out.print("Enter your flat number : ");
        String flatNumber = in.next();
        MainClass.checkForClose(flatNumber);
        System.out.print("Enter your street name : ");
        String streetName = in.next();
        MainClass.checkForClose(streetName);
        System.out.print("Enter your place name : ");
        String placeName = in.next();
        MainClass.checkForClose(placeName);
        System.out.print("Please enter your phone number : ");
        String phoneNumber = in.next();
        MainClass.checkForClose(phoneNumber);
        for (;;) {
            System.out.print("Please enter your Email : ");
            email = in.next();
            if (email.contains("@") && email.contains(".com")) {
                break;
            } else {
                System.out.println("invalid E-mail");
            }
        }
        addPerson("Workers", name, password, phoneNumber, email, houseNumber, flatNumber, streetName, placeName);
    }

    public boolean isPasswordValid(String password) {
        int[] arr = new int[3];
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
            return true;
        } else {
            return false;
        }
    }

    public int loginingIn() throws IOException {
        Scanner in = new Scanner(System.in);
        String id;
        for (;;) {
            System.out.print("Enter your ID : ");
            id = in.next();
            MainClass.checkForClose(id);
            if (id.equalsIgnoreCase("c")) {
                this.creatingUser();
            } else {
                System.out.print("Enter your Password : ");
                String password = in.next();
                MainClass.checkForClose(password);
                if (password.equalsIgnoreCase("c")) {
                    this.creatingUser();
                } else {
                    if (id.equals(manager.getId())) {
                        break;
                    } else if (id.startsWith("22")) {
                        setPersons("Workers");
                        if (this.verifyLogin(id, password)) {
                            return 22;
                        }
                    } else if (id.startsWith("33")) {
                        setPersons("SuperVisors");
                        if (this.verifyLogin(id, password)) {
                            return 33;
                        }
                    } else if (id.startsWith("44")) {
                        setPersons("SalesMan");
                        if (this.verifyLogin(id, password)) {
                            return 44;
                        }
                    }
                }
            }
        }
        return 11;
    }

    public boolean verifyLogin(String id, String password) {
        for (int i = 0; i < persons.size(); i++) {
            if (id.equals(persons.get(i).getId())) {
                if (password.equals(persons.get(i).getPassword())) {
                    person = persons.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void setPersons(String fileName) throws IOException {
        persons.clear();
        BufferedReader reader = new BufferedReader(new FileReader(
                fileName + ".txt"));
        String line = reader.readLine();
        while (line != null) {
            String[] Line = line.split("#");
            Employee pi = new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
                    Double.parseDouble(Line[4]), Double.parseDouble(Line[5]),
                    Double.parseDouble(Line[6]), Line[7], Line[8], Line[9],
                    Integer.parseInt(Line[10]), Integer.parseInt(Line[11]),
                    Line[12], Line[13], Line[14], Double.parseDouble(Line[15]));
            persons.add(pi);
            line = reader.readLine();
        }
        reader.close();
    }

    public ArrayList<Employee> getPersons(String fileName) throws IOException {
        setPersons(fileName);
        return persons;
    }

    public Employee getPerson() {
        return person;
    }

    public void updateInformations(String fileName, Employee person) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
        for (int i = 0; i < persons.size(); i++) {
            if (person != null) {
                if (person.getId().equals(persons.get(i).getId())) {
                    writer.write(person.toString());
                } else {
                    writer.write(persons.get(i).toString());
                    writer.write("\n");
                }
            } else {
                writer.write(persons.get(i).toString());
                writer.write("\n");
            }
        }
        writer.close();
    }

    public void addPerson(String fileName, String name, String password,
            String phoneNumber, String email, String houseNumber, String flateNumber, String streetName, String placeName) throws IOException {

        LocalDate date = LocalDate.now();
        StringBuilder line = new StringBuilder();
        line.append(password + "#" + name + "#" + 2000 + "#0#" + "0#0#" + date
                + "#" + phoneNumber + "#" + email + "#" + houseNumber + "#" + flateNumber
                + "#" + streetName + "#" + placeName + "#" + 0 + "#");
        getPersons("Workers");
        if (!persons.isEmpty()) {
            int id = Integer.parseInt(this.persons.get(this.persons.size() - 1).getId());
            line.insert(0, (id + 1) + "#");
        } else {
            line.insert(0, "220000" + "#");
        }
        BankAccount ba = new BankAccount();
        line.append(ba.getAccountNumber() + "#" + ba.getBalance() + "#" + 0);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
        for (int i = 0; i < persons.size(); i++) {
            writer.write(persons.get(i).toString());
            writer.write("\n");
        }
        writer.write(line.toString());
        writer.close();
    }

    public void addPerson(String fileName, String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
        for (int i = 0; i < persons.size(); i++) {
            writer.write(persons.get(i).toString());
            writer.write("\n");
        }
        writer.write(line);
        writer.close();
    }

    public void removePerson(String id, String fileName) throws IOException {
        for (int i = 0; i < persons.size(); i++) {
            if (id.equalsIgnoreCase(persons.get(i).getId())) {
                persons.remove(i);
                break;
            }
        }
        updateInformations(fileName, null);
    }
}

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

    ArrayList<Employee> persons = new ArrayList<Employee>();
    Employee person;
    Manager manager;

    public User() {

    }

    public void creatingUser() throws IOException {
        Scanner in = new Scanner(System.in);
        String password;
        String email;
        System.out.print("Enter your name : ");
        String name = in.nextLine();

        if (name.equalsIgnoreCase("q")) {
            System.exit(0);
        }

        for (;;) {
            for (;;) {
                System.out.println("(INFO)=> \n :: Your pass word must have at least : ");
                System.out.println("   - Four Charecters \n  - One upercase letter . "
                        + "\n   - One lowercase letter . "
                        + "\n   - One Number or Symbol .");
                System.out.print("Enter a password : ");
                password = in.next();
                if (password.equalsIgnoreCase("q")) {
                    System.exit(0);
                }
                boolean passwordCondition = false;
                int[] arr = new int[3];
                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                        arr[0]++;
                    } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                        arr[1]++;
                    } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                        arr[2]++;
                    }
                }
                if (arr[0] > 0 && arr[1] > 0 && arr[2] > 0 && password.length() >= 4) {
                    passwordCondition = true;
                }
                if (passwordCondition) {
                    break;
                }
            }
            System.out.print("Confirm your password : ");
            String password2 = in.next();
            if (password.equalsIgnoreCase("q")) {
                System.exit(0);
            }
            if (password.equals(password2)) {
                break;
            } else {
                System.out.println("The two password are not identical ..");
            }
        }
        System.out.print("Enter your house number : ");
        String housenumber = in.next();
        System.out.print("Enter your flat number : ");
        String flatNumber = in.next();
        System.out.print("Enter your street name : ");
        String streetNumber = in.next();
        System.out.print("Enter your place name : ");
        String placeNumber = in.next();

        System.out.print("Please enter your phone number : ");
        String phoneNumber = in.next();
        for (;;) {
            System.out.print("Please enter your phone number : ");
            email = in.next();
            if (email.contains("@") && email.substring(email.indexOf("@")).contains(".com")) {
                break;
            } else {
                System.out.println("invalid E-mail");
            }
        }
        LocalDate date = LocalDate.now();
        StringBuilder line = new StringBuilder();
        line.append(password + "#" + name + "#" + 2000 + "#0#" + "0#0#" + date
                + "#" + phoneNumber + "#" + email + "#" + housenumber + "#" + flatNumber
                + "#" + streetNumber + "#" + placeNumber + 0 + "#");
        getPersons("Workers");
        if (!persons.isEmpty()) {
            int id = Integer.parseInt(this.persons.get(this.persons.size() - 1).getId());
            line.insert(0, (id + 1) + "#");
        } else {
            line.insert(0, "2200" + "#");
        }
        BankAccount ba = new BankAccount();
        line.append(ba.getAccountNumber() + "#" + ba.getBalance() + "#" + 0);

        addPerson("Worker", line.toString());

    }

    public int loginingIn() throws IOException {
        Scanner in = new Scanner(System.in);
        String id;
        for (;;) {
            System.out.print("Enter your ID : ");
            id = in.next();
            if (id.equalsIgnoreCase("q")) {
                System.exit(0);
            }
            if (id.equalsIgnoreCase("c")) {
                this.creatingUser();
            }
            System.out.print("Enter your Password : ");
            String password = in.next();
            if (password.equalsIgnoreCase("q")) {
                System.exit(0);
            }
            if (password.equalsIgnoreCase("c")) {
                this.creatingUser();
            }
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
        return 11;
    }

    public boolean verifyLogin(String id, String password) {
        for (int i = 0; i < persons.size(); i++) {
            if (id.equals(persons.get(i).getId())) {
                if (password.equals(persons.get(i).getPassword())) {
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
            Employee pi = new Employee(Line[0],Line[1],Line[2],Double.parseDouble(Line[3]),
                     Double.parseDouble(Line[4]),Double.parseDouble(Line[5]),
                     Double.parseDouble(Line[6]),Line[7],Line[8],Line[9],
                     Integer.parseInt(Line[10]),Integer.parseInt(Line[11]),
                     Line[12],Line[13],Line[14],Double.parseDouble(Line[15]));
            persons.add(pi);
            line = reader.readLine();
        }
        reader.close();
    }

    public ArrayList<Employee> getPersons(String fileName) {
        return persons;
    }

    public Employee getPerson() {
        return person;
    }

    public void updateInformations(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
        for (int i = 0; i < persons.size(); i++) {
            writer.write(persons.get(i).toString());
            writer.write("\n");
        }
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
        updateInformations(fileName);
    }
}

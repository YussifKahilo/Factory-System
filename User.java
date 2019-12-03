
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        System.out.println("---------------------------");
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
        System.out.println("---------------------------");
        System.out.println("Your Birth Date :");
        System.out.print("-->Day : ");
        String dayOfBirth = in.next();
        MainClass.checkForClose(dayOfBirth);
        System.out.print("-->Month : ");
        String monthOfBirth = in.next();
        MainClass.checkForClose(monthOfBirth);
        System.out.print("-->Year : ");
        String yearOfBirth = in.next();
        MainClass.checkForClose(yearOfBirth);
        System.out.println("---------------------------");
        System.out.print("Enter your house number : ");
        String houseNumber = in.next();
        MainClass.checkForClose(houseNumber);
        System.out.print("Enter your floor number : ");
        String flatNumber = in.next();
        MainClass.checkForClose(flatNumber);
        System.out.print("Enter your blook number : ");
        String blookNumber = in.next();
        MainClass.checkForClose(blookNumber);
        System.out.print("Enter your street name : ");
        in.nextLine();
        String streetName = in.nextLine();
        MainClass.checkForClose(streetName);
        System.out.print("Enter your place name : ");
        String placeName = in.nextLine();
        MainClass.checkForClose(placeName);
        System.out.println("---------------------------");
        String phoneNumber;
        for (;;) {
            System.out.print("Please enter your phone number : ");
            phoneNumber = in.next();
            MainClass.checkForClose(phoneNumber);
            if (phoneNumber.length() == 11 && phoneNumber.startsWith("01")) {
                break;
            } else {
                System.out.println("Invalid phone number..");
            }
        }
        System.out.println("---------------------------");
        for (;;) {
            System.out.print("Please enter your Email : ");
            email = in.next();
            MainClass.checkForClose(email);
            if (email.contains("@") && email.contains(".com")) {
                break;
            } else {
                System.out.println("invalid E-mail");
            }
            System.out.println("---------------------------");
        }
        addPerson("Workers", name, password, phoneNumber, email, houseNumber, flatNumber, blookNumber, streetName, placeName, dayOfBirth, monthOfBirth, yearOfBirth);
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
                        if (manager.getPassword().equals(password)) {
                            break;
                        }
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
            Employee person = new Employee(Line[0], Line[1], Line[2], Double.parseDouble(Line[3]),
                    Double.parseDouble(Line[4]), Double.parseDouble(Line[5]),
                    Double.parseDouble(Line[6]), Line[7], Line[8], Line[9],
                    new Address(Integer.parseInt(Line[10]), Integer.parseInt(Line[11]), Integer.parseInt(Line[12]), Line[12], Line[13]),
                    new BankAccount(Line[14], Double.parseDouble(Line[15])), new BirthDate(Integer.parseInt(Line[16]),
                            Integer.parseInt(Line[17]), Integer.parseInt(Line[18])));
            persons.add(person);
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
                    writer.write("\n");
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
            String phoneNumber, String email, String houseNumber, String flateNumber,
            String blookNumber, String streetName, String placeName, String dayOfBirth, String monthIfBirth, String yearOfBirth) throws IOException {
        LocalDate date = LocalDate.now();
        StringBuilder line = new StringBuilder();
        line.append(password + "#" + name + "#" + 2000 + "#0#" + "0#0#" + date
                + "#" + phoneNumber + "#" + email + "#" + houseNumber + "#" + flateNumber
                + "#" + blookNumber + "#" + streetName + "#" + placeName + "#");
        if (getPersons("Workers").isEmpty() && getPersons("SuperVisors").isEmpty() && getPersons("SalesMan").isEmpty()) {
            ArrayList<String> IDs = new ArrayList<String>();
            setPersons("Workers");
            for (int i = 0; i < persons.size(); i++) {
                IDs.add(persons.get(i).getId().substring(3));
            }
            setPersons("SuperVisors");
            for (int i = 0; i < persons.size(); i++) {
                IDs.add(persons.get(i).getId().substring(3));
            }
            setPersons("SalesMan");
            for (int i = 0; i < persons.size(); i++) {
                IDs.add(persons.get(i).getId().substring(3));
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
        line.append(ba.getAccountNumber() + "#" + ba.getBalance() + dayOfBirth + "#" + monthIfBirth + "#" + yearOfBirth);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
        for (int i = 0; i < persons.size(); i++) {
            writer.write(persons.get(i).toString());
            writer.write("\n");
        }
        writer.write(line.toString());
        writer.close();
    }

    public void addPerson(String fileName, String line) throws IOException {
        setPersons(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
        for (int i = 0; i < persons.size(); i++) {
            writer.write(persons.get(i).toString());
            writer.write("\n");
        }
        writer.write(line);
        writer.close();
    }

    public void removePerson(String id, String fileName) throws IOException {
        setPersons(fileName);
        for (int i = 0; i < persons.size(); i++) {
            if (id.equalsIgnoreCase(persons.get(i).getId())) {
                persons.remove(i);
                break;
            }
        }
        updateInformations(fileName, null);
    }
}

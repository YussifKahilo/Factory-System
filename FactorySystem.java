
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FactorySystem {

    private static ArrayList<Employee> users = new ArrayList<Employee>();
    private ArrayList<Employee> usersOfWorkers;
    private ArrayList<Employee> usersOfSuperVisors;
    private ArrayList<Employee> usersOfSalesMen;
    private Manager userOfManager;

    public FactorySystem(ArrayList<Employee> usersOfWorkers, ArrayList<Employee> usersOfSuperVisors, ArrayList<Employee> usersOfSalesMen, Manager userOfManager) {
        this.usersOfWorkers = usersOfWorkers;
        this.usersOfSuperVisors = usersOfSuperVisors;
        this.usersOfSalesMen = usersOfSalesMen;
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

    private void creatingUser() {
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
        addUser("Workers", name, password, phoneNumber, email, houseNumber, flatNumber, blookNumber, streetName, placeName, dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public boolean isPasswordValid(String password) {
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
            System.out.print("Enter your ID : ");
            id = in.next();
            MainClass.checkForClose(id);
            if (id.equalsIgnoreCase("c")) {
                this.creatingUser();
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
                        user = getEmployee(id);
                    }
                } else if (id.startsWith("33")) {
                    if (this.verifyLogin(id, password)) {
                        logedIn = true;
                        user = getEmployee(id);
                    }
                } else if (id.startsWith("44")) {
                    if (this.verifyLogin(id, password)) {
                        logedIn = true;
                        user = getEmployee(id);

                    }
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

    public void addUser(String fileName, String name, String password,
            String phoneNumber, String email, String houseNumber, String flateNumber,
            String blookNumber, String streetName, String placeName, String dayOfBirth, String monthIfBirth, String yearOfBirth) {
        LocalDate date = LocalDate.now();
        StringBuilder line = new StringBuilder();
        line.append(password + "#" + name + "#" + 2000 + "#0#" + "0#0#" + date
                + "#" + phoneNumber + "#" + email + "#" + houseNumber + "#" + flateNumber
                + "#" + blookNumber + "#" + streetName + "#" + placeName + "#");
        if (users == null) {
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
                Collections.swap(IDs, maxIndex, maxIndex);
            }
            String lastID = "220" + IDs.get(0);
            int id = Integer.parseInt(lastID);
            line.insert(0, (id + 1) + "#");
        } else {
            line.insert(0, "220000" + "#");
        }
        BankAccount ba = new BankAccount();
        line.append(ba.getAccountNumber() + "#" + ba.getBalance() + "#" + dayOfBirth + "#" + monthIfBirth + "#" + yearOfBirth);
        ArrayList<String> workers = new ArrayList<String>();
        for (int i = 0; i < usersOfWorkers.size(); i++) {
            workers.add(usersOfWorkers.get(i).toString());
        }
        workers.add(line.toString());
        FileData.setData(workers, "Workers.txt");
    }

}

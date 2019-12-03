
import java.io.IOException;
import java.util.Scanner;

public class MainClass {

    public static void checkForClose(String line) {
        if (line.equalsIgnoreCase("q")) {
            System.exit(0);
        }
    }

    public static boolean ifNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!((input.charAt(i) >= '0' && input.charAt(i) <= '9'))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        FactorySystem factorySystem = new FactorySystem();
        for (;;) {
            Scanner in = new Scanner(System.in);
            int num = factorySystem.loginMenu();
            for (;;) {
                factorySystem.displayMenu(num);
                String choice = in.next();
                checkForClose(choice);
                if (!factorySystem.menuOptions(num, Integer.parseInt(choice))) {
                    break;
                }
            }
        }
    }
}
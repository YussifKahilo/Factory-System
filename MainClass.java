
import java.io.IOException;
import java.util.Scanner;

public class MainClass {

    public static void checkForClose(String line) {
        if (line.equalsIgnoreCase("q")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        FactorySystem factorySystem = new FactorySystem();
        for (;;) {
            Scanner in = new Scanner(System.in);
            int num = factorySystem.loginMenu();
            if (num == 11 || num == 22 || num == 33 || num == 44) {
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
}

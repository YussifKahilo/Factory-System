package FactorySystem;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {
        try {
            FactorySystem factorySystem = new FactorySystem();
            for (;;) {
                Scanner in = new Scanner(System.in);
                int num = factorySystem.loginMenu();
                if (num == 11 || num == 22 || num == 33 || num == 44) {
                    for (;;) {
                        factorySystem.displayMenu(num);
                        if (!factorySystem.menuOptions(num, in.nextInt())) {
                            break;
                        }
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

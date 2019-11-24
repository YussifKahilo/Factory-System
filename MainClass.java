package FactorySystem;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException{
        FactorySystem factorySystem = new FactorySystem();

        for (;;) {
           int num = factorySystem.loginMenu();
            for (;;) {
                factorySystem.displayMenu(num);
                factorySystem.menuOptions(num);
            }
        }
    }
}

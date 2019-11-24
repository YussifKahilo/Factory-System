package FactorySystem;

import java.io.IOException;
import java.util.Scanner;

public class FactorySystem {

    private SalesMan salesMan;
    private Manager manager;
    private User user;

    public FactorySystem() {
    }

    public int loginMenu() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("::IMPORTANT:: => IF YOU WANT TO EXIT AT ANY TIME TYPE 'Q' ::");
        System.out.println("(INFO)=>If you don't have a user press 'C' ..");
        int sna = user.loginingIn();
        if (sna == 11) {
            manager = new Manager();
            return 11;
        }/* else if (sna == 22){
            worker = new worker(user.getPerson());
        return 22;
        }else if (sna == 33) {
            SuperVisor = new SuperVisor(user.getPerson());
        return 33;
        }*/else if (sna == 44) {
            salesMan = new SalesMan(user.getPerson());
            return 44;
        }
        return 11;
    }

    public void displayMenu(int num) {

    }

    public void menuOptions(int num) {

    }

}

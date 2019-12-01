package FactorySystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FactorySystem {

    private SuperVisor superVisor;
    private SalesMan salesMan;
    private Worker worker;
    private Manager manager;
    private User user = new User();

    public FactorySystem() throws IOException {
        user.setPersons("SalesMan");
        salesMan = (SalesMan) user.getPerson();
        manager = new Manager();

    }

    public int loginMenu() throws IOException {
        System.out.println("::IMPORTANT:: => IF YOU WANT TO EXIT AT ANY TIME TYPE 'Q' ::");
        System.out.println("(INFO)=>If you don't have a user press 'C' ..");
        int sna = user.loginingIn();
        if (sna == 11) {
            manager = new Manager();
            return 11;
        } else if (sna == 22) {
            worker = new Worker(user.getPerson());
            return 22;
        } else if (sna == 33) {
            superVisor = new SuperVisor(user.getPerson());
            return 33;
        } else if (sna == 44) {
            salesMan = new SalesMan(user.getPerson());
            return 44;
        }
        return 00;
    }

    public void displayMenu(int num) {
        switch (num) {
            case 11:
                System.out.println("_________________________");
                System.out.println("1-Show Employees");
                System.out.println("2-Search for Employee");
                System.out.println("3-Set Target");
                System.out.println("4-Storage informations");
                System.out.println("5-Financial Informations");
                System.out.println("6-Log Out");
                System.out.println("-------------------------");
                System.out.print("::");
                break;
            case 22:
                System.out.println("________________________");
                System.out.println("1-Show Your Information");
                System.out.println("2-Show Target");
                System.out.println("3-Log out");
                System.out.println("------------------------");
                System.out.print("::");
                break;
            case 33:
                System.out.println("_______________________________________");
                System.out.println("1-Show Your Information");
                System.out.println("2-Show Workers");
                System.out.println("3-Get Your Team Target");
                System.out.println("4-Set the number of manufactured goods");
                System.out.println("5-Log out");
                System.out.println("---------------------------------------");
                System.out.print("::");
                break;
            case 44:
                System.out.println("_____________________________________");
                System.out.println("1-Show Your Information");
                System.out.println("2-Show the target for the sold goods");
                System.out.println("3-Set the number of sold goods");
                System.out.println("4-Log out");
                System.out.println("-------------------------------------");
                System.out.print("::");
                break;
        }
    }

    public boolean menuOptions(int num, int choice) throws IOException {
        Scanner in = new Scanner(System.in);
        switch (num) {
            case 11:
                if (choice == 1) {
                    int e = manager.showEmployees();
                    if (e != 0) {
                        System.out.print("1-Give Salary\n2-back\n::");
                        String NUM = in.next();
                        MainClass.checkForClose(NUM);
                        if (NUM.equalsIgnoreCase("1")) {
                            if (e == 11) {
                                ArrayList<Employee> workers = user.getPersons("Workers");
                                for (int i = 0; i < workers.size(); i++) {
                                    workers.get(i).getBankAccount().setBalance(workers.get(i).getSalary() + workers.get(i).getBankAccount().getBalance());
                                    user.updateInformations("Workers", workers.get(i));
                                }
                            } else if (e == 22) {
                                ArrayList<Employee> superVisors = user.getPersons("SuperVisors");
                                for (int i = 0; i < superVisors.size(); i++) {
                                    superVisors.get(i).getBankAccount().setBalance(superVisors.get(i).getSalary() + superVisors.get(i).getBankAccount().getBalance());
                                    user.updateInformations("SuperVisors", superVisors.get(i));
                                }
                            } else if (e == 33) {
                                ArrayList<Employee> salesmans = user.getPersons("SalesMan");
                                for (int i = 0; i < salesmans.size(); i++) {
                                    salesmans.get(i).getBankAccount().setBalance(salesmans.get(i).getSalary() + salesmans.get(i).getBankAccount().getBalance());
                                    user.updateInformations("SalesMan", salesmans.get(i));
                                }
                            }
                        }
                    }

                } else if (choice == 2) {
                    Employee person = manager.searchForEmployee();
                    if (person != null) {
                        person.showInformations();
                        System.out.println("*******************************************");
                        System.out.println("* 1-Promote                               *");
                        System.out.println("* 2-Change salary                         *");
                        System.out.println("* 3-Fire                                  *");
                        System.out.println("* 4-back                                  *");
                        System.out.print("*******************************************\n::");
                        String NUM = in.next();
                        MainClass.checkForClose(NUM);
                        if (NUM.equalsIgnoreCase("1")) {
                            manager.promote(person);
                        } else if (NUM.equalsIgnoreCase("1")) {
                            System.out.print("Enter the new salary : ");
                            String newSalary = in.next();
                            MainClass.checkForClose(newSalary);
                            person.setSalary(Double.parseDouble(newSalary));
                            if (person.getId().startsWith("22")) {
                                user.updateInformations("Workers", person);
                            } else if (person.getId().startsWith("33")) {
                                user.updateInformations("SuperVisors", person);
                            } else if (person.getId().startsWith("44")) {
                                user.updateInformations("SalesMan", person);
                            }
                        } else if (NUM.equalsIgnoreCase("1")) {
                            manager.firingEmployee(person);
                        }
                    } else {
                        System.out.println("You entered a wrong id..");
                    }
                } else if (choice == 3) {
                    manager.setTarget();
                } else if (choice == 4) {
                    System.out.println("*******************************************");
                    System.out.println("* 1-Show the number of the stored goods   *");
                    System.out.println("* 2-Show the number of goods manufactured *");
                    System.out.println("* 3-Show the number of the Sold goods     *");
                    System.out.println("* 4-Set target of goods to be sold        *");
                    System.out.println("*******************************************\n::");
                    String NUM = in.next();
                    MainClass.checkForClose(NUM);
                    manager.storageManagment(Integer.parseInt(NUM));
                } else if (choice == 5) {
                    System.out.println("*******************************************");
                    System.out.println("* 1-Show the total money                  *");
                    System.out.println("* 2-Show the profit of this month         *");
                    System.out.println("* 3-Set the budget for the materials      *");
                    System.out.println("*******************************************\n::");
                    String NUM = in.next();
                    MainClass.checkForClose(NUM);
                    manager.financialManagment(Integer.parseInt(NUM));
                } else if (choice == 6) {
                    return false;
                }
                break;
            case 22:
                if (choice == 1) {
                    worker.showInformations();
                    System.out.print("Do you want to edit any information ? (Y/N)\n::");
                    String ch = in.next();
                    MainClass.checkForClose(ch);
                    if (ch.equalsIgnoreCase("Y")) {
                        worker.editInformations();
                    }
                } else if (choice == 2) {
                    worker.showTarget();
                } else {
                    return false;
                }
                break;
            case 33:
                if (choice == 1) {
                    superVisor.showInformations();
                    System.out.print("Do you want to edit any information ? (Y/N)\n::");
                    String ch = in.next();
                    MainClass.checkForClose(ch);
                    if (ch.equalsIgnoreCase("Y")) {
                        worker.editInformations();
                    }
                } else if (choice == 2) {
                    Employee worker = superVisor.showWorkersInformation();
                    System.out.println("1-Give Feedback\n2-back\n::");
                    String NUM = in.next();
                    MainClass.checkForClose(NUM);
                    if (NUM.equalsIgnoreCase("1")) {
                        double rate = superVisor.answerFeedback();
                        worker.setMonthlyRate(rate);
                        worker.setBonus(rate / 100);
                        worker.setOverallRate((worker.getOverallRate() + rate) / 2);
                    }
                } else if (choice == 3) {
                    superVisor.showTarget();
                } else if (choice == 4) {
                    System.out.print("Enter the number of manufactured goods this month : ");
                    String numOfGoods = in.next();
                    MainClass.checkForClose(numOfGoods);
                    superVisor.setTargetResult(Integer.parseInt(numOfGoods), superVisor.showTarget());
                } else if (choice == 5) {
                    return false;
                }
                break;
            case 44:
                if (choice == 1) {
                    salesMan.showInformations();
                    System.out.print("Do you want to edit any information ? (Y/N)\n::");
                    String ch = in.next();
                    MainClass.checkForClose(ch);
                    if (ch.equalsIgnoreCase("Y")) {
                        worker.editInformations();
                    }
                } else if (choice == 2) {
                    salesMan.showTarget();
                } else if (choice == 3) {
                    System.out.print("Enter the amount of sold goods : ");
                    String numOfSoldGoods = in.next();
                    MainClass.checkForClose(numOfSoldGoods);
                    salesMan.setTargetResult(Integer.parseInt(numOfSoldGoods), salesMan.showTarget());
                } else if (choice == 4) {
                    return false;
                }
                break;
        }
        return true;
    }

}

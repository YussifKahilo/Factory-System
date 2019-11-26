package FactorySystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount() throws IOException {
        this.accountNumber = generatrNewBankAccount();
    }

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generatrNewBankAccount() throws IOException {
        ArrayList<String> oldAccount = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("BankAccount.txt"));
        String line = reader.readLine();
        while (line != null) {
            oldAccount.add(line.trim());
            line = reader.readLine();
        }
        reader.close();
        long newAccount;
        for (;;) {
            newAccount = (long) (5000000000000000L + Math.random()
                    * 1000000000000000L);
            long newAccountCopy = newAccount;

            int sumOFE = 0;
            long v;
            for (int i = 0; i <= 16; i++) {
                newAccountCopy /= 10;
                v = (int) (newAccountCopy % 10);
                v *= 2;
                long result, num, ans;
                num = newAccountCopy % 10;
                ans = newAccountCopy / 10;
                result = num + ans;
                if (v >= 10) {
                    sumOFE += result;
                } else {
                    sumOFE += v;
                }
            }
            newAccountCopy = newAccount;
            newAccountCopy /= 10;
            int sumOFO = 0;
            long X;
            String theSize = "" + newAccountCopy;
            for (int K = 1; K < theSize.length();) {
                theSize = "" + newAccountCopy;
                X = (newAccountCopy % 10);
                sumOFO += X;
                newAccountCopy /= 10;
                newAccountCopy /= 10;
            }
            boolean valid = false;
            int SUM = sumOFE + sumOFO;
            if (SUM % 10 == 0) {
                valid = true;
            }

            boolean isNew = true;

            for (int i = 0; i < oldAccount.size(); i++) {
                if (newAccount == Long.parseLong(oldAccount.get(i))) {
                    isNew = false;
                    break;
                }
            }
            if (isNew && valid) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("BankAccount.txt"));

                for (int i = 0; i < oldAccount.size(); i++) {

                    writer.write(oldAccount.get(i));
                    writer.write("\n");
                }
                writer.write(newAccount + "");
                writer.close();
                break;
            }

        }
        return newAccount+"";
    }

}

package factroy.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class bankaccount {

    private String accountNumber;
    private double balance;

    public bankaccount() {
    }

    public bankaccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void generatrNewBankAccount() throws IOException{
          ArrayList<String> oldAccount = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("BankAccount.txt"));
        String line = reader.readLine();
        while (line != null) {
            oldAccount.add(line.trim());
            line = reader.readLine();
        }
        reader.close();

        for (;;) {
            long newAccount1 = (long) (5000000000000000L + Math.random()
                    * 1000000000000000L);
            int sumOFE = 0;
            long newAccount = newAccount1;
            long v;
            for (int i = 0; i <= 16; i++) {
                newAccount /= 10;
                v = (int) (newAccount % 10);
                v *= 2;
                long result, num, ans;
                num = newAccount % 10;
                ans = newAccount / 10;
                result = num + ans;
                if (v >= 10) {
                    sumOFE += result;
                } else {
                    sumOFE += v;
                }
            }
            long a = newAccount1;
            newAccount /= 10;
            int sumOFO = 0;
            long X;
            String theSize = "" + newAccount;
            for (int K = 1; K < theSize.length();) {
                theSize = "" + newAccount;
                X = (newAccount % 10);
                sumOFO += X;
                newAccount /= 10;
                newAccount /= 10;
            }
            boolean valid = false;
            int SUM = sumOFE + sumOFO;
            if (SUM % 10 == 0) {
                valid = true;
            }

            boolean isNew = true;

            for (int i = 0; i < oldAccount.size(); i++) {
                if (newAccount1 == Long.parseLong(theSize)) {
                    isNew = false;
                    break;
                }
            }
            if (isNew && valid) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("BankAccount.txt"));
               

                System.out.println(newAccount1);
                for (int i = 0; i < oldAccount.size(); i++) {

                    writer.write(oldAccount.get(i));
                     writer.write("\n");
                }
                writer.write(newAccount1 + "");
                writer.close();
                break;

            }

        }
    }
    public String toString() {
        return accountNumber + "  " + balance;
    }

}

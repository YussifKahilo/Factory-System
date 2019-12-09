
import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount() {
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

    public String generatrNewBankAccount() {
        long newAccount = 0;
        boolean isCreated = false;
        while (!isCreated) {
            newAccount = (long) (5000000000000000L + Math.random()
                    * 1000000000000000L);
            if (isValid(newAccount)) {
                FileData.setData(newAccount + "", "BankAccount.txt");
                isCreated = true;
            }
        }
        return newAccount + "";

    }

    private boolean isValid(long newAccountCopy) {
        ArrayList<String> oldAccounts = FileData.getData("BankAccunt.txt");
        long newAccount = newAccountCopy;
        int sumOFeven = 0;
        long EevenNumber;
        for (int i = 0; i <= 16; i++) {
            newAccountCopy /= 10;
            EevenNumber = (int) (newAccountCopy % 10);
            EevenNumber *= 2;
            long result, x,y;
            x = newAccountCopy % 10;
            y = newAccountCopy / 10;
            result = x + y;
            if (EevenNumber >= 10) {
                sumOFeven += result;
            } else {
                sumOFeven += EevenNumber;
            }
        }
        newAccountCopy = newAccount;
        newAccountCopy /= 10;
        int sumOFodd = 0;
        long OddNumber;
        String theSize = "" + newAccountCopy;
        for (int K = 1; K < theSize.length();) {
            theSize = "" + newAccountCopy;
            OddNumber = (newAccountCopy % 10);
            sumOFodd += OddNumber;
            newAccountCopy /= 10;
            newAccountCopy /= 10;
        }
        boolean result = false;
        int SUM = sumOFeven + sumOFodd;
        if (SUM % 10 == 0) {
            result = true;
        }
        boolean isNew = true;

        for (int i = 0; i < oldAccounts.size(); i++) {
            if (newAccount == Long.parseLong(oldAccounts.get(i))) {
                isNew = false;
                break;
            }
        }
        boolean isValid = false;
        if (isNew && result) {
            isValid = true;
        }
        return isValid;
    }
}

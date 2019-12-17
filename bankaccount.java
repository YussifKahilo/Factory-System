
import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private double balance;

<<<<<<< HEAD
	/**
	 * Bank Account no argument Constructor.
	 */
	public BankAccount() {
		this.accountNumber = generatrNewBankAccount();
	}

	/**
	 * Bank Account overloaded constructor.
	 * 
	 * @param accountNumber of an employee's account.
	 * @param balance       of an employee's bank account.
	 */
	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
=======
    public BankAccount() {
        this.accountNumber = generatrNewBankAccount();
    }

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

<<<<<<< HEAD
	/**
	 * generates a bank account number.
	 * 
	 * @return a bank account number.
	 */
	public String generatrNewBankAccount() {
		long newAccount = 0;
		boolean isCreated = false;
		ArrayList<String> accounts = new ArrayList<String>();
		while (!isCreated) {
			/*
			 * creates a random bank account number.
			 */
			newAccount = (long) (5000000000000000L + Math.random() * 1000000000000000L);
			// if the bank account is valid and new will be added to the file.
			if (isValid(newAccount) && isNew(newAccount, accounts)) {
				accounts.add(newAccount + "");
				FileData.setData(accounts, "BankAccount.txt");
				isCreated = true; // to break the loop if the bank account is created.
			}
		}
		return newAccount + "";
=======
    public String generatrNewBankAccount() {
        long newAccount = 0;
        boolean isCreated = false;
        ArrayList<String> accounts = new ArrayList<String>();
        while (!isCreated) {
            newAccount = (long) (5000000000000000L + Math.random() * 1000000000000000L);
            if (isValid(newAccount, accounts)) {
                accounts.add(newAccount + "");
                FileData.setData(accounts, "BankAccount.txt");
                isCreated = true;
            }
        }
        return newAccount + "";
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd

    }

<<<<<<< HEAD
	/**
	 * checks if a created bank account number is valid.
	 * 
	 * @param newAccountCopy the created bank account number to be checked.
	 * @param accounts       all the accounts of the employees.
	 * @return
	 */
	private boolean isValid(long newAccountCopy) {
		long newAccount = newAccountCopy;

		int sumOfEvenNumbers = sumOfEvenNumbers(newAccount);
		newAccountCopy = newAccount;
		newAccountCopy /= 10;
		int sumOfOddNumbers = sumOfOddNumbers(newAccount);
		boolean result = false;
		int sum = sumOfEvenNumbers + sumOfOddNumbers;
		if (sum % 10 == 0) {
			result = true;
		}

		return result;
	}

	/**
	 * checks if the created Bank account is new or does exist before.
	 * 
	 * @param createdBankAccount to be checked.
	 * @param accounts           all the account of the employees.
	 * @return whether the created bank account is new or not.
	 */
	private boolean isNew(long createdBankAccount, ArrayList<String> accounts) {
		FileData.getData(accounts, "BankAccount.txt");
		boolean isNew = true;
		for (int i = 0; i < accounts.size() && isNew; i++) {
			if (createdBankAccount == Long.parseLong(accounts.get(i))) {
				isNew = false;
			}
		}
		return isNew;
	}

	/**
	 * the sum of odd numbers of the bank account number.
	 * 
	 * @param newAccount to get the sum of numbers from.
	 * @return the sum of the odd numbers.
	 */
	private int sumOfOddNumbers(long newAccount) {
		long newAccountCopy = newAccount;
		long OddNumber;
		int sumOfOdd = 0;
		String theSize = "" + newAccountCopy;
		for (int K = 1; K < theSize.length();) {
			theSize = "" + newAccountCopy;
			OddNumber = (newAccountCopy % 10);
			sumOfOdd += OddNumber;
			newAccountCopy /= 10;
			newAccountCopy /= 10;
		}

		return sumOfOdd;
	}

	/**
	 * the sum of odd numbers of the bank account number.
	 * 
	 * @param newAccount to get the sum of numbers from.
	 * @return the sum of the odd numbers.
	 */
	private int sumOfEvenNumbers(long newAccount) {
		long newAccountCopy = newAccount;

		int sumOfEven = 0;
		long EevenNumber;
		for (int i = 0; i <= 16; i++) {
			newAccountCopy /= 10;
			EevenNumber = (int) (newAccountCopy % 10);
			EevenNumber *= 2;
			long result, x, y;
			x = newAccountCopy % 10;
			y = newAccountCopy / 10;
			result = x + y;
			if (EevenNumber >= 10) {
				sumOfEven += result;
			} else {
				sumOfEven += EevenNumber;
			}
		}
		return sumOfEven;
	}
=======
    private boolean isValid(long newAccountCopy, ArrayList<String> accounts) {
        FileData.getData(accounts, "BankAccount.txt");
        long newAccount = newAccountCopy;
        int sumOFeven = 0;
        long EevenNumber;
        for (int i = 0; i <= 16; i++) {
            newAccountCopy /= 10;
            EevenNumber = (int) (newAccountCopy % 10);
            EevenNumber *= 2;
            long result, x, y;
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

        for (int i = 0; i < accounts.size(); i++) {
            if (newAccount == Long.parseLong(accounts.get(i))) {
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
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd
}

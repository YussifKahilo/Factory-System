
///**
//* This class contains the bank account for every employee.
//* generates a new bank account number and checks if the valid to set in the file.
//* @author Mostafa Hassan
//* @ID
//*/
import java.util.ArrayList;

public class BankAccount {
	// attributes of the bank account.
	private String accountNumber;
	private double balance;

	/// **
	// * Bank Account no argument Constructor.
	// */
	public BankAccount() {
		this.accountNumber = generatrNewBankAccount();
	}

	/// **
	// * Bank Account overloaded constructor.
	// *
	// * @param accountNumber of an employee's account.
	// * @param balance of an employee's bank account.
	// */
	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	/// **
	// *
	// * @return the bank account number of the employee.
	// */
	public String getAccountNumber() {
		return accountNumber;
	}

	/// **
	// *
	// * @return the balance of employee's bank account.
	// */
	public double getBalance() {
		return balance;
	}

	/// **
	// * sets a new balance in the employee's bank account.
	// * @param balance to be set
	// */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/// **
	// * generates a bank account number.
	// *
	// * @return a bank account number.
	// */
	public String generatrNewBankAccount() {
		long newAccount = 0;
		boolean isCreated = false;
		ArrayList<String> accounts = new ArrayList<String>();
		while (!isCreated) {
			/// *
			// * creates a random bank account number.
			// */
			newAccount = (long) (5000000000000000L + Math.random() * 1000000000000000L);
			// if the bank account is valid and new will be added to the file.
			if (isValid(newAccount) && isNew(newAccount, accounts)) {
				accounts.add(newAccount + "");
				FileData.setData(accounts, "BankAccount.txt");
				isCreated = true; // to break the loop if the bank account is created.
			}
		}
		return newAccount + "";

	}

	/// **
	// * checks if a created bank account number is valid.
	// *
	// * @param newAccountCopy the created bank account number to be checked.
	// * @param accounts all the accounts of the employees.
	// * @return
	// */
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

	/// **
	// * checks if the created Bank account is new or does exist before.
	// *
	// * @param createdBankAccount to be checked.
	// * @param accounts all the account of the employees.
	// * @return whether the created bank account is new or not.
	// */
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

	/// **
	// * the sum of odd numbers of the bank account number.
	// *
	// * @param newAccount to get the sum of numbers from.
	// * @return the sum of the odd numbers.
	// */
	private int sumOfOddNumbers(long newAccount) {
		long newAccountCopy = newAccount;
		//
		//
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

	/// **
	// * the sum of odd numbers of the bank account number.
	// *
	// * @param newAccount to get the sum of numbers from.
	// * @return the sum of the odd numbers.
	// */
	private int sumOfEvenNumbers(long newAccount) {
		long newAccountCopy = newAccount;
		//
		//
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
}

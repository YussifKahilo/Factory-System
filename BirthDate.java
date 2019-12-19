
///**
//* this class contains every birth date of each employee.
//* and gets the age from it.
//* @author Kirolos Wesam.
//* @ID 220180259
//*/
import java.time.LocalDate;

public class BirthDate {
	// birth date attributes.
	private int Day;
	private int Month;
	private int Year;
	private int Age;

	/// **
	// * birth date constructor.
	// *
	// * @param day of birth.
	// * @param month of birth.
	// * @param year of birth.
	// */
	public BirthDate(int day, int month, int year) {
		this.Day = day;
		this.Month = month;
		this.Year = year;
	}

	/// **
	// *
	// * @return employee's birth date day.
	// */
	public int getDay() {
		return Day;
	}

	/// **
	// *
	// * @return employee's birth date month.
	// */
	public int getMonth() {
		return Month;
	}

	/// **
	// *
	// * @return employee's birth date year.
	// */
	public int getYear() {
		return Year;
	}

	/// **
	// * check if the birth date is valid.
	// *
	// * @param yearOfBirth must be from 1970 :: 2000.
	// * @param monthOfBirth must be a valid number of a month (from 1::12).
	// * @param dayOfBirth must be a valid number of a day (from 1::31).
	// * @return whether the birth date is valid or not.
	// */
	public static boolean birthDateValidation(String yearOfBirth, String monthOfBirth, String dayOfBirth) {
		int year = Integer.parseInt(yearOfBirth);
		int month = Integer.parseInt(monthOfBirth);
		int day = Integer.parseInt(dayOfBirth);

		return (year > 1970 && year < 2000 && month < 13 && month > 0 && day < 32 && day > 0);
	}

	/// **
	// * gets age of an employee with the birth date.
	// *
	// * @return the age of an employee.
	// */
	public int getAge() {
		LocalDate Date = LocalDate.now();
		String s = Date.toString();
		String[] date = s.split("-");
		int YearDate = Integer.parseInt(date[0]);
		int monthDate = Integer.parseInt(date[1]);
		int DayDate = Integer.parseInt(date[2]);
		Age = YearDate - Year;
		if (monthDate == Month) {
			if (DayDate < Day) {
				Age--;
			}
		} else if (monthDate < Month) {
			Age--;
		}
		return Age;
	}
}


import java.sql.Date;
import java.time.LocalDate;

public class BirthDate {

	private int Day;
	private int Month;
	private int Year;
	private int Age;

	public BirthDate(int day, int month, int year) {
		this.Day = day;
		this.Month = month;
		this.Year = year;
	}

	public int getDay() {
		return Day;
	}

	public int getMonth() {
		return Month;
	}

	public int getYear() {
		return Year;
	}

	public static boolean birthDateValidation(String yearOfBirth, String monthOfBirth, String dayOfBirth) {
		int year = Integer.parseInt(yearOfBirth);
		int month = Integer.parseInt(monthOfBirth);
		int day = Integer.parseInt(dayOfBirth);

		return (year > 1970 && year < 2000 && month < 13 && month > 0 && day < 32 && day > 0);
	}

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


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

    public void setDay(int day) {
        this.Day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        this.Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public int getAge() {
        LocalDate Date = LocalDate.now();
        String s = Date.toString();
        String y = s.substring(0, 4);
        String m = s.substring(5, 7);
        String d = s.substring(8, 10);
        int YearDate = Integer.parseInt(y);
        int monthDate = Integer.parseInt(m);
        int DayDate = Integer.parseInt(d);
        if (monthDate >= Month) {
            if (DayDate >= Day) {
                Age = YearDate - Year;
            }
            if (DayDate < Day) {
                Age = (YearDate - Year) - 1;
            }
        } else if (monthDate < Month) {
            Age = (YearDate - Year) - 1;

        }

        return Age;
    }

}

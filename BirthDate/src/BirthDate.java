
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
        int yearnow = Integer.parseInt(y);
        Age = yearnow - Year;
        return Age;
    }

    
}

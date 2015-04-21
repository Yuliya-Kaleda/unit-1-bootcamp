import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yuliya Kaleda on 4/18/15.
 * Weekdays
 */
public class WeekdaysBonus
{
    public static void main(String[] args) throws ParseException
    {
        birthdayDayOfWeek("20/12/1988");
        System.out.println(countSundays1());
        System.out.println(countSundays());

    }

    //Project Euler without using an API
    public static long countSundays1()
    {
        //01 Jan 1901 is Tuesday
        String[] daysOfWeek = {"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday"};
        int[] monthsNotLeapYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthsLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //variable to keep track of Sundays that fell on the 1st of month
        long count = 0;
        int dayOfWeek = 0;
        int months[];

        for(int year = 1901; year <= 2000; year++)
        {
            //check if it is a leap year
            if(year % 4 == 0 || (year % 100 == 0 && year % 400 == 0))
            {
                months = monthsLeapYear;
            }
            else
            {
                months = monthsNotLeapYear;

            }
            //loop through every month
            for(int daysInMonth : months)
            {
                //loop through every day in a month
                for(int day = 1; day <= (daysInMonth + 1); day++)
                {
                    //if all days of a certain month are checked, switch to a different month
                    if(day == daysInMonth + 1)
                    {
                        break;
                    }
                    //check if the 1st of month is a Sunday
                    if(day == 1 && daysOfWeek[dayOfWeek].equalsIgnoreCase("Sunday"))
                    {
                        count++;
                    }
                    //increment day of the week
                    dayOfWeek++;
                    //if all days of the week are used, reassign 0 value and start checking again
                    if(dayOfWeek == 7)
                    {
                        dayOfWeek = 0;

                    }
                }

            }
        }
        return count;
    }


    // using Java Calendar API
    public static Long countSundays()
    {
        //create a calendar Object
        Calendar calendar = Calendar.getInstance();
        calendar.set(1901, 0, 1);

        //variable to count Sundays
        long count = 0;
        while(calendar.get(Calendar.YEAR) < 2001)
        {
            if(calendar.get(Calendar.DAY_OF_MONTH) == 1 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                count++;
            }
            //increment the date
            calendar.add(Calendar.DATE, 1);
        }
        return count;
    }

    //exercise 4 What day of the week were you born?
    public static void birthdayDayOfWeek(String date) throws ParseException
    {
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date result = newFormat.parse(date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String day = format2.format(result);
        System.out.println(day);
    }
}

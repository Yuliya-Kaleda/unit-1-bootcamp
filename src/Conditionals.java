import java.util.Map;

/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class Conditionals
{

    public static void main(String args[])
    {
        Person person = new Person ("Yuliya");
        person.setCity("Stolin");

        System.out.println(isOdd(0));
        System.out.println(isMultipleOfThree(0));
        System.out.println(isOddAndIsMultipleOfThree(9));
        fizzMultipleOfThree(7);
        System.out.println(isFromLondon(person));
        fiveCharacterName(person);
        System.out.println(cigarParty(61, true));
        System.out.println(caughtSpeeding(65, true));
        System.out.println(alarmClock(1, false));
        System.out.println(lotteryTicket(1, 1, 1));
        System.out.println(blackJack(22, 19));
        System.out.println(evenlySpaced(4, 6, 2));
        System.out.println(evenlySpacedConditonals(4, 6, 2));
    }

    //check if number is odd
    public static boolean isOdd (int n) {
        return (n%2 != 0);
    }

    //check if number is multiple of three
    public static boolean isMultipleOfThree (int n) {
        return n%3==0 && n!=0;
    }

    //check if number is odd and multiple of three
    public static boolean isOddAndIsMultipleOfThree( int n) {
        return (isOdd(n) && isMultipleOfThree(n));
    }

    //FizzMultipleOfThree
    public static void fizzMultipleOfThree(int n) {
        if (isMultipleOfThree(n)) {
            System.out.println("Fizz");
        }
        else {
            System.out.println(n);
        }
    }

    //method to check if the person is from London
    public static boolean isFromLondon (Person person) {
        return person.getCity().equalsIgnoreCase("London");
    }

    //method to check if the person's name is longer than 5 chars
    public static void fiveCharacterName (Person person) {
    if (person.getName().length()>5) {
        System.out.println(person.getName());
    }
        else {
        System.out.println("Name is too short.");
    }
}
    //exercise #1 Cigar Party
    public static boolean cigarParty (int cigars, boolean weekday) {
        boolean result = false;
        if (weekday) {
            if (cigars >= 40 && cigars <= 60) {
                result = true;
            }
        }
        else {
            if (cigars >= 40) {
                result = true;
            }
        }
        return result;
    }
    //exercise #2 Caught Speeding
    public static int caughtSpeeding(int speed, boolean birthday)
    {
        int result = 0;
        //speed limits if not a BD
        int speedLimit0NotBD = 60;
        int speedLimit1NotBD = 80;

        //change speed limits data when a BD
        if(birthday)
        {
            speedLimit0NotBD = speedLimit0NotBD + 5;
            speedLimit1NotBD = speedLimit1NotBD + 5;
        }

        //if speed < or == 60/65
        if(speed >= 0 && speed <= speedLimit0NotBD)
        {
            result = 0;
        }
        //if speed btw 61/66 and 80/85
        else if(speed > speedLimit0NotBD && speed <= speedLimit1NotBD)
        {
            result = 1;
        }
        // if speed > 81/86
        else
        {
            result = 2;
        }
        return result;
    }

    //exercise #3 Alarm Clock
    public static String alarmClock(int day, boolean vacation)
    {
        String result = "";
        //if a weekday
        if(day > 0 && day < 6)
        {
            if(! vacation)
            {
                result = "7:00";
            }
            else
            {
                result = "10:00";
            }
        }

        //if a weekend
        else if(day == 0 || day == 6)
        {
            if(! vacation)
            {
                result = "10:00";
            }
            else
            {
                result = "off";
            }
        }
        else
        {
            result = "Wrong input data!";
        }
        return result;
    }


    //exercise #4 Lottery Ticket
    public static int lotteryTicket(int a, int b, int c)
    {
        int result = 0;
        if(a != b && b != c && a != c)
        {
            result = 0;
        }
        else if(a == b && b == c && a == c)
        {
            result = 20;
        }
        else if(a == b || a == c || b == c)
        {
            result = 10;
        }
        return result;
    }

    //exercise #5 Blackjack
    public static int blackJack(int a, int b)
    {
        int result = 0;
        if(a < 21 && b < 21)
        {
            result = Math.max(a, b);
        }
        else if(a == 21 || b == 21)
        {
            result = 21;
        }
        else if(a > 21 || b > 21)
        {
            result = Math.min(a, b);
        }
        return result;
    }


    //exercise #6 Evenly Spaced (solution with Math class rather than Conditionals)
    public static boolean evenlySpaced(int a, int b, int c)
    {
        int maxOfTwoInt = Math.max(a, b);
        int maxIntOfThree = Math.max(c, maxOfTwoInt);

        int minOfTwoInt = Math.min(a, b);
        int minOfThreeInt = Math.min(c, minOfTwoInt);

        int mediumInt = (a + b + c) - maxIntOfThree - minOfThreeInt;
        return ((mediumInt - minOfThreeInt) == (maxIntOfThree - mediumInt));
    }

    //exercise #6 Evenly Spaced (using conditionals)
    public static boolean evenlySpacedConditonals(int a, int b, int c)
    {
        int max = 0;
        int min = 0;
        if(a > b)
        {
            max = a;
            min = b;
            if(max < c)
            {
                max = c;
            }
            else
            {
                if(c < b)
                {
                    min = c;
                }
                else
                {
                    min = b;
                }
            }
        }

        else
        {
            max = b;
            min = a;
            if(max < c)
            {
                max = c;
            }
            else
            {
                if(c < a)
                {
                    min = c;
                }
                else
                {
                    min = a;
                }
            }
        }
        int sumOfThreeInt = a + b + c;
        int med = sumOfThreeInt - max - min;
        return (med - min == max - med);
    }
}

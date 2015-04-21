import java.util.ArrayList;

/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class Loops
{
    public static void main(String args[])
    {
        printFrom1Through10While();
        printFrom1ThroughN(5);
        printEvenFrom2ToN(7);
        printSumOf1Through10();
        printSumOf1ThroughN(1000);
        printStringNTimes("oh", -5);
        printStringConcatenatedWithItselfNTimes("oh", 4);
        System.out.println(nFibonnacciNumbers(10));
        System.out.println(tenFibonnacciNumbers());
        System.out.println(sumNumbers("7 11"));
        System.out.println(isNot("This is right"));
        System.out.println(betweenWords("abcXY123XYijk", "XY"));
        digits();
        numberPuzzle();
    }

    //print the numbers 1 through 10 using for-loop
    public static void printFrom1Through10()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }
    }

    //print the numbers 1 through 10 using while-loop
    public static void printFrom1Through10While() {
        int i = 1;
        while(i<11) {
            System.out.println(i);
            i++;
        }
    }

    //print the numbers 1 through n
    public static void printFrom1ThroughN (int n) {
        for (int i = 1; i < n+1; i++) {
            System.out.println(i);
        }
    }

    //prints the even numbers 2 through n
    public static void printEvenFrom2ToN (int n) {
        for (int i = 2; i < n +1; i++) {
            if (i%2==0) {
                System.out.println(i);
            }
        }
    }

    //print the sum of 1 through 10 using a loop
    public static void printSumOf1Through10() {
        int sum = 0;
        for (int i=0; i<11; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }

    //print the sum of the numbers 1 through n using a loop.
    public static void printSumOf1ThroughN(long n) {
        long sum = 0;
        for (long i=0; i<n+1; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }

    //print out string on its own line, n times
    public static void printStringNTimes (String s, int n) {
        String result = "";
        if (n<=0) {
            System.out.println("");
        }
        else {
            for (int i=0; i<n; i++) {
                result += s;
            }
        }
        System.out.println(result);
    }

    //print out the string concatenated with itself n times.
    public static void printStringConcatenatedWithItselfNTimes (String s, int n) {
        String result = "";
        if (n<=0) {
            System.out.println("");
        }
        else {
            for (int i=0; i<n; i++) {
                result += s+s;
            }
        }
        System.out.println(result);
    }

    //print sum of n Fibonnaci numbers
    public static int nFibonnacciNumbers(int n) {
        int firstNum = 0;
        int secondNum = 1;
        int sumTwo;
        int result = 1;
        for (int k = 0; k < n-2; k++) {
            sumTwo = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = sumTwo;
            result += secondNum;
        }
        return result;
    }
    //print sum of 10 Fibonnaci numbers
    public static int tenFibonnacciNumbers() {
        int firstNum = 0;
        int secondNum = 1;
        int sumTwo;
        int result = 1;
        for (int k = 1; k<9; k++) {
            sumTwo = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = sumTwo;
            result += secondNum;
        }
        return result;
    }

    //exercise sumNumbers, summarise the numbers in the string
    private static int sumNumbers (String string) {
        // variable to store a sequence of digits
        String currentNumber = "";
        int result = 0;
        for (int i = 0; i<string.length(); i++)
        {
            //if a char is a digit
                if(Character.isDigit(string.charAt(i)))
                {
                    //if the char is not the last one in the string and the following char is a digit
                    if(i!= string.length()-1 && Character.isDigit(string.charAt(i + 1)))
                    {
                        currentNumber += string.charAt(i);
                    }
                    //when the digit char is not followed by another digit
                    else
                    {
                        currentNumber+=string.charAt(i);
                        result += Integer.parseInt(currentNumber);
                        currentNumber = "";
                    }
                }
            }

        return result;
    }


    //exercise #5, replace "is" with "is not" (does not cover the case when "is" followed by "not" bc it was not stated as a requirement in the task)
    public static String isNot(String string)
    {
        //loop through each char in the string
        for(int i = 0; i < string.length(); i++)
        {

            //when "is"
            if(string.charAt(i) == 'i' && string.charAt(i + 1) == 's')
            {
                //exclude the case "error: index out of bounds" when the string starts or ends with "is"
                if(i == 0 || i + 2 >= string.length())
                {
                    string = string.substring(0, i + 2) + " not" + string.substring(i + 2);
                }

                //if the preceding or following char is not a letter
                else if(! Character.isLetter(string.charAt(i + 2)) && ! Character.isLetter(string.charAt(i - 1)))
                {
                    //insert "not"
                    string = string.substring(0, i + 2) + " not" + string.substring(i + 2);
                }
            }
        }
        return string;
    }

    //exercise #6, between words
    public static String betweenWords(String full, String part)
    {
        //create a copy of the origin string to modify it
        String copy = full;
        String result = "";
        while(copy.contains(part))
        {
            //index of the first char of part
            int startIdx = copy.indexOf(part);
            //index of the last char of part
            int endIdx = startIdx + part.length() - 1;
            //exclude the error out of bound when the original string starts or ends with the part string
            if(startIdx != 0)
            {
                result += copy.charAt(startIdx - 1);
            }
            if(endIdx != copy.length() - 1)
            {
                result += copy.charAt(endIdx + 1);
            }
            //remove the first part string
            copy = copy.replaceFirst(part, "");
        }
        return result;
    }

    //exercise #5, digits
    public static void digits()
    {
        for(int i = 10; i < 100; i++)
        {
            String digit = "" + i;
            int value1 = (int) digit.charAt(0) - 48;
            int value2 = (int) digit.charAt(1) - 48;
            System.out.println(i + ", " + value1 + "+" + value2 + " = " + value1 + value2);
        }
    }

    //exercise #6, number puzzle
    public static void numberPuzzle()
    {
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 10; i < 100; i++)
        {
            for(int k = 10; k < 100; k++)
            {
                if(i + k == 60)
                {
                    if(k - i == 14 || i - k == 14)
                    {
                        result.add("" + i + "-" + k);
                    }
                }
            }
        }
        System.out.println(result);
    }
}

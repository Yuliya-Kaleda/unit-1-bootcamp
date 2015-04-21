import java.util.Random;

/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class Methods
{

    public static void main(String args[])
    {
        System.out.println(calculateSquare(4));
        System.out.println(calculateSquareRoot(16));
        System.out.println(toLowerCase("Hello, World!"));
        System.out.println(isMultiple(5, 101));
        prettyInteger(4);
        System.out.println(random(6, 9));
    }

    //exercise #1 Calculate Square
    public static int calculateSquare(int a)
    {
        return a * a;
    }

    //exercise #2 Calculate Square Root
    public static int calculateSquareRoot(int a)
    {
        double result = Math.sqrt(a);
        return (int) result;
    }

    //exercise #3 toLowerCase
    public static String toLowerCase(String string)
    {
        return string.toLowerCase();
    }

    //exercise #4 Is Multiple
    public static boolean isMultiple(int a, int b)
    {
        return ((b % a) == 0);
    }

    //exercise #5 Pretty Integer
    public static void prettyInteger(int num)
    {
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < num; j++)
            {
                System.out.print("*");
                if(j == num - 1 && i != 1)
                {
                    System.out.print(" " + num + " ");
                }
            }
        }
    }

    //exercise #6 Random
    public static int random(int a, int b)
    {
        //get the greatest number
        int maximum = Math.max(a, b);
        int sum = a + b;
        int minimum = sum - maximum;
        Random rn = new Random();
        //+1 to include the top number
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;

        return randomNum;
    }
}

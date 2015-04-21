import java.util.ArrayList;

/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class Variables
{

    public static void main(String args[])
    {
        ArrayList<Integer> num1 = new ArrayList<Integer>();
        num1.add(1);
        num1.add(2);
        num1.add(3);
        num1.add(4);
        num1.add(6);

        ArrayList<Integer> num2 = new ArrayList<Integer>();
        num2.add(1);
        num2.add(2);
        num2.add(4);
        num2.add(8);

        System.out.println(greatestCommonFactor(num1, num2));
    }

    //method that takes in two ArrayLists of factors and finds the greatest factor
    public static int greatestCommonFactor(ArrayList<Integer> num1, ArrayList<Integer> num2)
    {
        //create an ArrayList to hold common factors
        ArrayList<Integer> commonFactors = new ArrayList<Integer>();
        int greatestFactor = 0;
        for(Integer i : num1)
        {
            if(num2.contains(i))
            {
                commonFactors.add(i);
            }
        }

        //find the greatest factor by looping through each element in the commonFactors list
        for(Integer a : commonFactors)
        {
            if(a > greatestFactor)
            {
                greatestFactor = a;
            }
        }
        return greatestFactor;
    }
}

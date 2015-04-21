import java.util.ArrayList;

/**
 * Created by Yuliya Kaleda on 4/16/15.
 */
public class CollatzBonus
{
    public static void main(String[] args)
    {
        //an ArrayList to store the numbers of one chain
        ArrayList<Long> numbers = new ArrayList<Long>();
        long longChain = 0;
        long startNum = 0;

        for(int i = 1000000; i>0; i--) {
            long n = i;
            while(n != 1)
            {
                if(n % 2 == 0)
                {
                    n = n / 2;
                }
                else
                {
                    n = 3 * n + 1;
                }
                numbers.add(n);
            }

            //if the chain size is larger than the previous chain size, reassign a new value to longChain
            if(numbers.size() > longChain)
            {
                longChain = numbers.size();
                startNum = i;
            }
            numbers.clear();
        }
        System.out.println(longChain);
        System.out.println(startNum);
    }
}


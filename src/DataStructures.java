import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class DataStructures
{

    public static void main(String args[])
    {
        //exercise # 1
        ArrayList<Cat> catArrayList = new ArrayList<Cat>();

        Cat cat0 = new Cat("John");
        Cat cat1 = new Cat("Greg");
        Cat cat2 = new Cat("Tony");
        Cat cat3 = new Cat("David");
        Cat cat4 = new Cat("Sam");

        catArrayList.add(cat0);
        catArrayList.add(cat1);
        catArrayList.add(cat2);
        catArrayList.add(cat3);
        catArrayList.add(cat4);

        for(Cat cat : catArrayList)
        {
            System.out.println(cat);
        }


        // exercise # 3
        HashMap<String, Integer> pod = new HashMap<String, Integer>();
        pod.put("Yuliya", 26);
        pod.put("Kadeem", 23);
        pod.put("Jae", 28);
        pod.put("Charlyn", 28);
        pod.put("Reinard", 33);

        for(String s : pod.keySet())
        {
            System.out.println(s + " is " + pod.get(s) + " years old.");
        }

        //test case to count clumps for exercise #6 (Data Structure)
        ArrayList<Integer> any = new ArrayList<Integer>();
        any.add(2);
        any.add(2);
        any.add(2);
        any.add(2);
        any.add(0);
        System.out.println(countClumps(any));

        //test case to sort sentences for exercise #7
        sortSentences("I am very grateful to C4Q for the opportunity they gave me!");

    }

    // exercise # 2
    public static void mostFrequentElement(ArrayList<Integer> any)
    {
        //key - integer, value - number of its occurrences
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for(Integer number : any)
        {
            //if integer was already added to the "count"
            if(count.containsKey(number))
            {
                int value = count.get(number);
                count.put(number, value + 1);
            }
            //if integer was not count before
            else
            {
                count.put(number, 1);
            }
        }

        int max = 0;
        int element = 0;
        //loop through a HashMap count and compare occurrences of integers (values)

        for(Integer integer : count.keySet())
        {
            if(count.get(integer) > max)
            {
                max = count.get(integer);
                element = integer;
            }
        }

        System.out.println(
                "The most frequently occurring element is " + element + ". Its number of occurrences is " + max + ".");
    }

    // exercise # 2 BONUS
    public static void mostFrequentString(ArrayList<String> any)
    {
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        for(String s : any)
        {
            if(count.containsKey(s))
            {
                int value = count.get(s);
                count.put(s, value + 1);
            }
            else
            {
                count.put(s, 1);
            }
        }

        int max = 0;
        String search = "";

        for(String s : count.keySet())
        {
            if(count.get(s) > max)
            {
                max = count.get(s);
                search = s;
            }
        }
        System.out.println(
                "The most frequently occurring string is " + search + ". Its number of occurrences is " + max + ".");
    }


    // exercise #4
    public static boolean canRentACar(HashMap<String, Integer> hash)
    {
        for(String s : hash.keySet())
        {
            return (hash.get(s) == 25 || hash.get(s) > 25);
        }
        return false;
    }

    //exercise #5
    public static ArrayList<String> wordsWithoutList(ArrayList<String> any, int i)
    {
        for(String s : any)
        {
            if(s.length() == i)
            {
                any.remove(s);
            }
        }
        return any;
    }

    //exercise #6
    public static int countClumps(ArrayList<Integer> any)
    {
        //a variable to count clumps
        int count = 0;
        for(int i = 0; i < any.size(); i++)
        {
            //check the cases when a list has just two elements left in order not to go out of bound
            if(any.size() - i <= 2)
            {
                //stop looping when the last element left in the array because there is nothing to compare it with
                if (any.size() - i==1) {
                    break;
                }
                if(any.get(i) == any.get(i + 1))
                {
                    count++;
                }
            }
            //compare three elements in a row so that not to count them as separate clumps if they are the same
            else
            {
                if(any.get(i) == any.get(i + 1) && any.get(i) != any.get(i + 2))
                {
                    count++;
                }
            }
        }
        return count;
    }

    //exercise #7 sorting sentences
    public static void sortSentences(String string)
    {
        String[] words = string.split("\\s+");
        ArrayList<String> result = new ArrayList<String>();
        Collections.addAll(result, words);
        Collections.sort(result, String.CASE_INSENSITIVE_ORDER);
        for (String s : result) {
            System.out.println(s);
        }
    }
}

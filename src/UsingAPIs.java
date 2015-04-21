import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class UsingAPIs
{

    public static void main(String args[]) throws FileNotFoundException
    {
        //create a HashSet for unique words from Tale of Two Cities
        File tale = new File("./src/TaleOfTwoCities");
        HashSet<String> taleOfTwoCities = fileToHashSet(tale);

        //create a HashSet for unique words from Mobby Dick
        File mobby = new File("./src/MobbyDick");
        HashSet<String> mobbyDick = fileToHashSet(mobby);

        //create a HashSet that is an intersection of words between two files
        HashSet<String> intersection = new HashSet<String>();
        for (String s : taleOfTwoCities) {
            if (mobbyDick.contains(s)) {
                intersection.add(s);
            }
        }

        int intersectionSize = intersection.size();

        //create a HashSet that is a union of words between two files
        HashSet<String> union = new HashSet<String>();
        union.addAll(taleOfTwoCities);
        union.addAll(mobbyDick);

        //create an iterator for the union set
        Iterator<String> itr = union.iterator();
    }

    // read a file and store its contents in a HashSet
    public static HashSet<String> fileToHashSet(File file) throws FileNotFoundException
    {
        HashSet<String> any = new HashSet<String>();
        Scanner scanner = new Scanner(file);
        String word;
        while(scanner.hasNext())
        {
            word = scanner.next().replaceAll("\\p{P}", "").toLowerCase();
            any.add(word);
        }
        return any;
    }
}
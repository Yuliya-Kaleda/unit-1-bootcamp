/**
 * Created by Yuliya Kaleda on 4/14/15.
 */
public class ClassesAndObjects
{

    public static void main(String args[])
    {
        Cat garfield = new Cat("Garfield");
        Cat pinkPanther = new Cat("PinkPanther");
        Cat catwoman = new Cat("Catwoman");

        Person john = new Person("John");

        garfield.setFavoriteFood("Lasagna");
        pinkPanther.setFavoriteFood("KitKat");
        catwoman.setFavoriteFood("Chocolate");

        garfield.setAge(1);
        pinkPanther.setAge(2);
        catwoman.setAge(3);
    }

    public static boolean isOlder(Cat cat1, Cat cat2)
    {
        return (cat1.getAge() > cat2.getAge());
    }

    public static void makeBestFriends(Cat cat1, Cat cat2)
    {
        cat1.setFavoriteFood("Candy");
        cat2.setFavoriteFood("Candy");
    }

    public static Cat makeKitten(Cat cat1, Cat cat2)
    {

        String newCat = cat1.getName() + cat2.getName();
        Cat kitten = new Cat(newCat);
        kitten.setAge(0);

        return kitten;
    }

    public static void adoption(Cat cat, Person person)
    {
        if(cat.getName().equalsIgnoreCase("Catwoman"))
        {
            System.out.println("Catwoman will never be anyone's pet!");
        }
        else
        {
            cat.setOwner(person);
        }
    }

    public static boolean isFree(Cat cat)
    {
        return (cat.getOwner() != null);
    }

    public static boolean isSibling(Cat cat1, Cat cat2)
    {
        return (cat1.getOwner().equals(cat2.getOwner()));
    }
}

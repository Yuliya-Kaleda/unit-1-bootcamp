/**
 * Created by Yuliya Kaleda on 4/21/15.
 */
public class FizzBuzzBonus
{
    public static void main (String[] args) {
        System.out.println(sumOfMultiples3Or5(3,5,1000));
    }

    public static long sumOfMultiples3Or5 (long mult1, long mult2, long limit) {
        long sum = 0;
        for (int i = 1; i < 1000; i ++) {
            if (i%3==0 || i%5==0) {
                sum+=i;
            }
        }
        return sum;
    }
}

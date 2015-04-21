/**
 * Created by Yuliya Kaleda on 4/21/15.
 */
public class Currency
{
    public static void main( String[] args) {
        System.out.println(englishCurrency());
    }

    public static int englishCurrency () {
        int countWays = 0;
        int i, j, k, l, m, n, p, r;

        for (i = 0; i <= 200; i+=200){
            for(j = 0; j <= 200; j+= 100){
                for(k = 0; k <= 200; k+= 50){
                    for(l = 0; l <=200; l+= 20){
                        for(m = 0; m <= 200; m+= 10){
                            for(n = 0; n <= 200; n+= 5){
                                for(p = 0; p <= 200; p+= 2){
                                    for(r = 0; r <= 200; r+= 1){
                                        if((i + j + k + l + m + n + p + r) == 200)
                                        {
                                            countWays++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return countWays;
    }
}

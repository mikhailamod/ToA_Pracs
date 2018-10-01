import java.util.Arrays;
import java.util.Scanner;

public class Pricing {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.nextLine();

        long c = n/2;
        while(c > 999999){
            c = c/2;
        }
        long x = findk(n, c);
        System.out.println(x);
    }

    static long findk(long n, long count){
        if(count < 2){ count = 2; }
        long sum = calculate(count);
        long sum2 = calculate(count+1);
        long minCount = 0;
        while(true)
        {
            if(sum <= n && sum2 > n){
                return count;
            }
            else if(sum > n && sum2 < n)
            {
                return count-1;
            }
            else if(sum < n){
                long oldmin = minCount;
                minCount = count;
                count = count+(count-oldmin)/2;
                sum = calculate(count);
                sum2 = calculate(count+1);
            }
            else if(sum > n){
                count = count-(count-minCount)/2;
                while(count > 999999){
                    count = count-(count-minCount)/2;
                }
                sum = calculate(count);
                sum2 = calculate(count+1);
            }
        }
    }

    static long calculate(long k)
    {
        long sum = 0;
        for (int i = 1; i < k; i++) {
            sum += i*(k/i);
        }
        return sum;
    }

}

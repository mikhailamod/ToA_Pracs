import java.util.Arrays;
import java.util.Scanner;

public class Pricing {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.nextLine();

        long x = findk(n, n/2);
        System.out.println(x);
    }

    static long findk(long n, long count){
        long sum = calculate(count);
        long sum2 = calculate(count+1);
        long minCount = 0;
        int c = 0;
        while(true)
        {
            c++;
            System.out.println("count = " + count + ", sum = " + sum + ", sum2 = " + sum2);
            if(c > 4){return -1L;}
            if(sum < n && sum2 > n){
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
                long oldmin = minCount;
                minCount = count;
                count = count-(count-oldmin)/2;
                while(count > 999999){
                    oldmin = minCount;
                    minCount = count;
                    count = count-(count-oldmin)/2;
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

import java.util.ArrayList;
import java.util.Scanner;

public class Dividing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> plankLengths = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();

        int count = 0;
        int maxLength = scanner.nextInt();
        plankLengths.add(maxLength);
        scanner.nextLine();
        while (count != n-1){
            int temp = scanner.nextInt();
            if(temp > maxLength){ maxLength= temp; }
            plankLengths.add(temp);
            scanner.nextLine();
            count++;
        }
        int min = scanner.nextInt();
        scanner.nextLine();

        //System.out.println("N = " + n +
        //        "\nmin = " + min);

        int m = findM(min, plankLengths, maxLength);
        System.out.println(m);
        //System.out.println(plankLengths.toString());

    }

    static int findM(int minNumPlanks, ArrayList<Integer> listOfLengths, int maxLength){
        int plankLength = maxLength/2;
        int oldLength = 0;
        int max = 0;
        while(true){
            if(max == plankLength || plankLength == oldLength){
                break;
            }
            int numberOfPlanks = 0;
            for (int i = 0; i < listOfLengths.size(); i++) {
                numberOfPlanks += listOfLengths.get(i)/plankLength;
            }
            if(numberOfPlanks >= minNumPlanks && plankLength > max){
                max = plankLength;
                oldLength = plankLength;
                plankLength = plankLength + (maxLength-plankLength)/2;
            }
            //not enough planks made, go down
            else{
                oldLength = plankLength;
                plankLength = plankLength - (plankLength-max)/2;
            }
        }
        return max;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Dividing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> plankLengths = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();

        int count = 0;
        int minLength = scanner.nextInt();
        plankLengths.add(minLength);
        scanner.nextLine();
        while (count != n-1){
            int temp = scanner.nextInt();
            if(temp < minLength){ minLength= temp; }
            plankLengths.add(temp);
            scanner.nextLine();
            count++;
        }
        int min = scanner.nextInt();
        scanner.nextLine();

        int m = findM(min, plankLengths, minLength);
        System.out.println(m);
        //System.out.println(plankLengths.toString());

    }

    static int findM(int min, ArrayList<Integer> listOfLengths, int minLength){
        int plankLength = 1;
        int max = 0;
        while(true){
            if(plankLength > minLength){
                break;
            }
            int numberOfPlanks = 0;
            for (int i = 0; i < listOfLengths.size(); i++) {
                numberOfPlanks += listOfLengths.get(i)/plankLength;
            }
            if(numberOfPlanks >= min && plankLength > max){
                max = plankLength;
            }
            plankLength++;
        }
        return max;
    }
}

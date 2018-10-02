import java.util.ArrayList;
import java.util.Scanner;

public class Dividing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> plankLengths = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();

        //get list of lengths from input
        int count = 0;
        int maxLength = scanner.nextInt();//the biggest length we have
        plankLengths.add(maxLength);
        scanner.nextLine();
        //get rest of inputs, updating the max
        while (count != n-1){
            int temp = scanner.nextInt();
            if(temp > maxLength){ maxLength= temp; }
            plankLengths.add(temp);
            scanner.nextLine();
            count++;
        }
        int min = scanner.nextInt();
        scanner.nextLine();

        int m = findM(min, plankLengths, maxLength);
        System.out.println(m);

    }

    /**
     * Find the maximum number of planks to fufill order, using divide and conquer
     * This algorithm is O(n log n), I think :)
     * @param minNumPlanks - min number of planks we need (K)
     * @param listOfLengths - list of all the different lengths (Li)
     * @param maxLength - the biggest length
     * @return - the maximum number of planks (M)
     */
    static int findM(int minNumPlanks, ArrayList<Integer> listOfLengths, int maxLength){
        int plankLength = maxLength/2;//start at half the maximum length
        int oldLength = 0;
        int max = 0;//return the max
        while(true){
            if(max == plankLength || plankLength == oldLength){//stopping condition
                break;
            }
            //calculate how many planks we can get if we divide each plank by the given length
            int numberOfPlanks = 0;
            for (int i = 0; i < listOfLengths.size(); i++) {
                numberOfPlanks += listOfLengths.get(i)/plankLength;
            }

            //current plankLength was good, try higher lengths
            if(numberOfPlanks >= minNumPlanks && plankLength > max){
                max = plankLength;
                oldLength = plankLength;
                plankLength = plankLength + (maxLength-plankLength)/2;
            }
            //not enough planks made, go lower
            else{
                oldLength = plankLength;
                plankLength = plankLength - (plankLength-max)/2;
            }
        }
        return max;
    }
}

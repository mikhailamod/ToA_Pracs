import java.util.ArrayList;
import java.util.Scanner;

public class Cycling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> stops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stops.add(scanner.nextInt());
            scanner.nextLine();
        }

        int max = findCost(stops);
        System.out.println(max);
    }

    /**
     * Find the maximum cost given a set of stops
     * @param stops - a list of the costs of each stop
     * @return - the maximum cumulative cost
     */
    static int findCost(ArrayList<Integer> stops){
        int max = 0;//if max cumulative is negative, it will return 0
        int cumulative = stops.get(0);
        max = Math.max(max, cumulative);

        for (int i = 1; i < stops.size(); i++) {
            int x = cumulative + stops.get(i);
            int y = stops.get(i-1) + stops.get(i);
            cumulative = Math.max(x, y);//either continue with current path, or start new path
            max = Math.max(max, cumulative);
        }
        return max;
    }
}

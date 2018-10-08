import java.util.Arrays;
import java.util.Scanner;

public class Path {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int numObstacles = scanner.nextInt();
        scanner.nextLine();

        int[][] obstacles = new int[numObstacles][2];
        for (int i = 0; i < numObstacles; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            obstacles[i][1] = Integer.parseInt(tokens[0]) - 1;
            obstacles[i][0] = (n-1)-(Integer.parseInt(tokens[1]) - 1);
        }
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }

        int p = numPaths(grid, obstacles);
        System.out.println(p);

    }

    static int numPaths(int[][] grid, int[][] obstacles){
        //load obstacles into grid
        for (int i = 0; i < obstacles.length; i++) {
            grid[obstacles[i][0]][obstacles[i][1]] = 0;
        }

        boolean foundZero = false;
        for (int col = 0; col < grid.length; col++) {
            if(grid[grid.length-1][col] == 0){ foundZero = true; }

            if(!foundZero){
                grid[grid.length-1][col] = 1;
            }
            else{
                grid[grid.length-1][col] = 0;
            }
        }
        foundZero = false;
        for (int row = grid.length-1; row >= 0; row--) {
            if(grid[row][0] == 0){ foundZero = true; }

            if(!foundZero){
                grid[row][0] = 1;
            }
            else{
                grid[row][0] = 0;
            }
        }

        for (int row = grid.length-2; row >= 0 ; row--) {
            for (int col = 1; col < grid.length; col++) {
                if(grid[row][col] != 0){
                    grid[row][col] = grid[row+1][col] + grid[row][col-1];
                }
            }
        }

        return grid[0][grid.length-1];
    }
}

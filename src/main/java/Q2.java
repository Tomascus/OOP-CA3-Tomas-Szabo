import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

class Pair {
    int row;
    int column;

    public Pair(int row, int col) {
        this.row = row;
        this.column = col;
    }
}
public class Q2 {
    private static int[][] grid = new int[10][10]; //created a static int 2D array that is accessible through all the Q2 (even methods)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a starting row in the array: ");
        int startRow = sc.nextInt();
        System.out.println("Enter a starting column in the array: ");
        int startColumn = sc.nextInt();

        floodFill(startRow, startColumn);

        System.out.println("The grid: ");
        for (int i = 0; i < grid.length; i++) {  //Goes through the 2D array and prints each cell of the array
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf("%3d", grid[i][j]); //3d for spacing between each number
            }
            System.out.println();
        }
    }

    private static void floodFill(int startRow, int startColumn) {
        ArrayDeque<Pair> pairStack = new ArrayDeque<>();
        pairStack.push(new Pair(startRow, startColumn));
        int number = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //direction as follows: left(x-1), right(x+1), bottom(y-1), top(y+1)

        while (!pairStack.isEmpty()) {
            Pair current = pairStack.pop();
            if (current.row >= 0 && current.row < 10 && current.column >= 0 && current.column < 10 && grid[current.row][current.column] == 0) { //checks for correct boundaries and correct numbers of rows, columns

                grid[current.row][current.column] = number++; //Number that is incremented with each pair added
                for (int i = 0; i < directions.length; i++) { //This for loop iterates through all directions and checks if they are available and pushes a new pair if so
                    int[] direction = directions[i]; //changes directions based on the position of the for loop
                    pairStack.push(new Pair(current.row + direction[0], current.column + direction[1])); //Creates a new pair and pushes it into the stack to be processed later and uses first direction of directions array for correct floodfill logic(horizontally)
                }
            }

        }
    }




}






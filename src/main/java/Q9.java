import java.util.ArrayDeque;
import java.util.Random;
import java.util.Scanner;

class Point {
    int row;
    int column;

    public Point(int row, int col) {
        this.row = row;
        this.column = col;
    }
}
public class Q9 {
    //IMPLEMENT RANDOM SIZE AND LAYOUT MAZE EACH TIME PROGRAM RUNS
    public static void main(String[] args) {
        ArrayDeque<Point> paths = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //direction as follows: left, down, right, up


        //SHOW THE MAZE BEFORE THE START
        char[][] maze = {
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '0', '0', '0', '0', '0', '0', 'X'},
                {'X', 'X', 'X', 'X', '0', 'X', 'X', 'X'},
                {'E', '0', '0', '0', '0', '0', '0', 'X'},
                {'X', 'X', 'X', 'X', '0', 'X', 'X', 'X'},
                {'X', '0', '0', '0', '0', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', '0', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        System.out.println("The maze: ");
        for (int i = 0; i < maze.length; i++) {  //Goes through the 2D array and prints each cell of the maze
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " "); //print instead of println so that we print the whole row instead of having each char separately, added spacing as well
            }
            System.out.println();
        }

            System.out.println("Enter a starting row in the maze: ");
            int startRow = sc.nextInt();
            System.out.println("Enter a starting column in the maze: ");
            int startColumn = sc.nextInt();

            paths.push(new Point(startColumn, startRow));

           while (!paths.isEmpty()) {
               Point point = paths.pop();
               int x = point.row;
               int y = point.column;

               if (maze[x][y] == 'X') { // using '' because the maze is made up from characters which is more efficient than string maze
                   System.out.println("You started on X, try again... ");
                   break;

               } else if (maze[x][y] == 'E') { // using '' because the maze is made up from characters which is more efficient than string maze
                   System.out.println("Congratulations, you escaped the maze! ");break;



               } else if (maze[x][y] == '0') {
                   maze[x][y] = '1'; //Replaces all "0" (paths) to "1" when we passed through them to visualize what paths we already took in the maze

                   boolean pathExists = false;

                   for (int i = 0; i < directions.length; i++) { //we iterate through each direction from the directions array
                       int pathX = x + directions[i][0]; //We create new path at an intersection, first value is i that changes as we iterate through directions for x and 0 stays the same as we only want value x (row) of such direction
                       int pathY = y + directions[i][1]; //Same logic, but for y

                       if (pathX >= 0 && pathX < maze.length && pathY >= 0 && pathY < maze[0].length && (maze[pathX][pathY] == '0' || maze[pathX][pathY] == 'E')) {
                           paths.push(new Point(pathX,pathY));
                           pathExists = true;
                           System.out.println("Paths at: (" + pathY + ", " + pathX + ")");
                       }
                   }
                  if (!pathExists) {
                      System.out.println("Dead end at: (" + y + ", " + x + ")");
                  }

                   
               }
               System.out.println(" ");
               System.out.println("The maze: ");
               for (int i = 0; i < maze.length; i++) {  //Goes through the 2D array and prints each cell of the maze
                   for (int j = 0; j < maze[i].length; j++) {
                       System.out.print(maze[i][j] + " "); //print instead of println so that we print the whole row instead of having each char separately, added spacing as well
                   }
                   System.out.println();
               }
           }
          //Implement no exit was found
        }
    }

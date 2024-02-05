import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        Queue<String> takeoffQueue = new LinkedList<>();
        Queue<String> landQueue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        String command = "";

        while (!command.equals("quit")) {
            System.out.println(" ");
            System.out.println("Enter a command (takeoff (n.) | land (n.) | next | quit: )");
            command = sc.nextLine();

            if (command.contains("takeoff")) {
                takeoffQueue.add(command.substring(8)); //Substring begins after the takeoff command has been typed to avoid having it added to queue, same for the landing queue
                System.out.println("Flight: " + command.substring(8) + " added to takeoff queue");
            } else if (command.contains("land")) {
                landQueue.add(command.substring(5));
                System.out.println("Flight: " + command.substring(5) + " added to landing queue");
            } else if (command.equals("next")) {
                if (!landQueue.isEmpty()) {
                    System.out.println("Flight: " + landQueue.poll() + " has landed");
                } else if (!takeoffQueue.isEmpty()) {
                    System.out.println("Flight: " + takeoffQueue.poll() + " has taken off");
                } else {
                    System.out.println("No flights in queue");
                }
            }

        }
        System.out.println("Program finished");

    }
}

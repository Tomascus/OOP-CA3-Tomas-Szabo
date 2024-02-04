import java.util.ArrayDeque;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        ArrayDeque<Integer> drivewayStack = new ArrayDeque<>();
        ArrayDeque<Integer> streetStack = new ArrayDeque<>();


        Scanner sc = new Scanner(System.in);
        int carcode = 10;
        while (carcode != 0) {
        System.out.println("Enter a car code (positive for adding cars, negative for removing cars, 0 to end): ");
        carcode = sc.nextInt();


        if (carcode > 0) {
            drivewayStack.push(carcode);
            System.out.println("Cars inside the driveway: " + drivewayStack);
        }
        else if (carcode < 0) {
            carcode = -carcode;
            System.out.println(carcode);
            if (drivewayStack.contains(carcode)) {
                    while (!drivewayStack.isEmpty() && drivewayStack.peek() != carcode) {
                        int num = drivewayStack.pop();
                        streetStack.push(num);
                        System.out.println("Car " + num + " moved into street");
                        System.out.println("Cars inside the driveway: " + drivewayStack);
                        System.out.println("Cars on the street: " + streetStack);
                    } if (!drivewayStack.isEmpty()) {
                        System.out.println("Car " + drivewayStack.pop() + " left the driveway");

                    }
                    while (!streetStack.isEmpty()) {
                        int returned = streetStack.pop();
                        drivewayStack.push(returned);
                        System.out.println("Car " + returned + " returned to the driveway");

                    }


            } else {
                System.out.println("No car with such car code inside the driveway, try again... ");

            } System.out.println("Cars inside the driveway: " + drivewayStack);
            System.out.println("Cars on the street: " + streetStack);
        }
        }
        System.out.println("Program closed...");




    }
}

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        ArrayDeque<Integer> drivewayStack = new ArrayDeque<>();
        ArrayDeque<Integer> streetStack = new ArrayDeque<>();


        Scanner sc = new Scanner(System.in);
        int carcode = 10;
        while (carcode != 0) {
        System.out.println("Add a car using license: ");
        carcode = sc.nextInt();


        if (carcode > 0) {
            drivewayStack.push(carcode);
            System.out.println("Cars inside the driveway: " + drivewayStack);
            System.out.println("Cars on the street: " + streetStack);
        } else if (carcode < 0) {
            carcode = carcode * -1;
            if (drivewayStack.contains(carcode)) {
                while (!drivewayStack.isEmpty()) {
                    int num = drivewayStack.pop();
                    System.out.println(num);
                    if (carcode != num) {
                        streetStack.push(num);
                    } else if (carcode == num) {
                        while (!streetStack.isEmpty()) {
                            drivewayStack.push(streetStack.pop());
                        }
                        streetStack.push(num);break;
                    }
                }
                System.out.println("Cars inside the driveway: " + drivewayStack);
                System.out.println("Cars on the street: " + streetStack);
            } else {
                System.out.println("No car with such license inside the driveway, try again and Add a car using license: ");
                carcode = sc.nextInt();
            }
        }
        }




    }
}

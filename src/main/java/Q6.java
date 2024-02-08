import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q6 {

     static class Block {
        int quantity;
        double price;


        public Block(int quantity, double price) {
         this.quantity = quantity;
         this.price = price;
        }
     }
    public static void main(String[] args) {

        Queue<Block> shares = new LinkedList<>();
        double profit = 0;
        String command = "";
        Scanner sc = new Scanner(System.in);

        while (!command.equals("quit")) {
            System.out.println(" ");
            System.out.println("Enter a command (buy | sell | quit): ");
            command = sc.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("Enter the quantity of shares you want to buy: ");
                int quantity = sc.nextInt();
                System.out.println("Enter the current price of the stocks: ");
                double price = sc.nextDouble();
                shares.add(new Block(quantity, price));
                System.out.println(quantity + " Stocks bought at " + price + "$");

            } else if (command.equalsIgnoreCase("sell")) {
                System.out.println("Enter the quantity of stocks you want to sell: ");
                int quantity = sc.nextInt();
                System.out.println("Enter the current price of the stocks: ");
                int price = sc.nextInt();
                while (!shares.isEmpty() && quantity > 0) {
                    Block stock = shares.peek();
                    if (stock.quantity <= quantity) {
                        profit += (price - stock.price) * stock.quantity;
                        quantity = quantity - stock.quantity;
                        shares.poll();
                    } else {
                        profit += (price - stock.price) * quantity;
                        stock.quantity = stock.quantity - quantity;
                        quantity = 0;
                    }
                }
                System.out.println(" Profit from selling the stocks: " + profit + "$");

            } else {
                System.out.println("Wrong input...");
            }

        } System.out.println("Application terminated...");
    }
}

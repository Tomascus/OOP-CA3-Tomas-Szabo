import java.util.*;

public class Q7 {

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
        Map<String, Queue<Block>> map = new HashMap<>();
        double profit = 0;
        String command = "";
        Scanner sc = new Scanner(System.in);

        while (!command.equals("quit")) {
            System.out.println(" ");
            System.out.println("Enter a command (buy | sell | quit): ");
            command = sc.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("Enter the symbol of the company you want to buy stocks from: ");
                String symbol = sc.next();
                System.out.println("Enter the quantity of shares you want to buy: ");
                int quantity = sc.nextInt();
                System.out.println("Enter the current price of the stocks: ");
                double price = sc.nextDouble();
                shares = map.get(symbol); //getting a symbol associated with shares queue
                if (shares == null) {  //Probably is not needed as we are required to input a symbol to continue the input, but prevents not having a symbol associated with a queue, where it creates a queue for that symbol even if you do not have any shares in that company
                    shares = new LinkedList<>();
                    map.put(symbol, shares);
                }
                shares.add(new Block(quantity, price));
                //map.put(symbol, shares);
                System.out.println(quantity + " Stocks bought at " + price + "$");

            } else if (command.equalsIgnoreCase("sell")) {
                System.out.println("Enter the symbol of the company you want to sell stocks from: ");
                String symbol = sc.next();
                System.out.println("Enter the quantity of stocks you want to sell: ");
                int quantity = sc.nextInt();
                System.out.println("Enter the current price of the stocks: ");
                int price = sc.nextInt();
                shares = map.get(symbol); //getting a symbol associated with shares queue
                if (shares == null) { //if there is no such symbol it does not print the profit
                    System.out.println("No shares available for this symbol");
                    
                } else {
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
                    System.out.println(" Profit from selling the stocks of company: " + symbol + " = " + profit + "$");
                }

            } else if (!command.equals("quit")){
                System.out.println("Wrong input...");
            }

        } System.out.println("Application terminated...");
    }
}

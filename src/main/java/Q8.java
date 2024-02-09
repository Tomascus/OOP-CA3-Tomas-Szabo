import java.util.ArrayDeque;
import java.util.Scanner;

public class Q8 {

     static int precedence(String operator) { //Separate method that checks for correct precedence if it has multiple operators in the user input
        switch (operator) { // Uses switch, which I found most efficient way to solve it and returns specific numbers based on the precedence importance - 2 being the most important
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1; // returns -1 and if the operators match it does not affect anything
        }
    }
    public static void main(String[] args) {

        ArrayDeque<Integer> results = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        int result = 0;
        boolean end = false;

        Scanner sc = new Scanner(System.in); //My implementation of the code is made by inputting each number or math expression on separate line to show the algorithm more clearly with each step and make it less confusing, of course It could be made by reading the whole line and going through each math expression by splitting the lines using .split and going through the problem in a for loop while it ends...
        String line = "";

        while (end == false) {
            System.out.println(" ");
            System.out.println("Enter a Arithmetic Expression: ");
            line = sc.nextLine().trim();

            if (line.equals("(")) {
                operators.push(line);
                System.out.println("Operator pushed to the stack");
            } else if (line.equals("*") || line.equalsIgnoreCase("x") || line.equals("/") || line.equals("-") || line.equals("+")) { //Checks for operators with diffrent inputs
                while (!operators.isEmpty() && precedence(line) <= precedence(operators.peek())) { //checks if operators are empty and also checks for precedence comparing latest input and latest operator in a stack, if there are two same operators as well
                    //EVALUATE THE TOP
                    //Currently everytime we evaluate the top I have to copy this part, so I might do a method for it as it is more effective later
                    if (results.size() < 2) { //checks if there are more than two numbers in a stack, if not it does not start the operation because it would crash with an exception error
                        System.out.println("Not enough numbers to perform operation");
                        break;
                    }
                        int num1 = results.pop();
                        int num2 = results.pop();
                        String op = operators.pop();
                        switch (op) {
                            case "+":
                                result = num1 + num2;break;
                            case "-":
                                result = num1 - num2;break;
                            case "/":
                                if (num1 == 0) {
                                    System.out.println("Cannot divide by 0");break; //checks for dividing if its zero and prints and error so that the program does not crash
                                }
                                result = num2 / num1;break;
                            case "*":
                                result = num1 * num2;break;
                            default:
                                System.out.println("Incorrect symbol...");break;
                        } results.push(result);
                        System.out.println("number pushed to the stack");
                }
                operators.push(line);
                System.out.println("Operator pushed to the stack");

            } else if (line.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    //EVALUATE THE TOP
                    if (results.size() < 2) {
                        System.out.println("Not enough numbers to perform operation");
                        break;
                    }
                    int num1 = results.pop();
                    int num2 = results.pop();
                    String op = operators.pop();
                    switch (op) {
                        case "+":
                            result = num1 + num2;break;
                        case "-":
                            result = num1 - num2;break;
                        case "/":
                            if (num1 == 0) {
                                System.out.println("Cannot divide by 0");break;
                            }
                            result = num2 / num1;break;
                        case "*":
                            result = num1 * num2;break;
                        default:
                            System.out.println("Incorrect symbol...");break;
                    } results.push(result);
                    System.out.println("number pushed to the stack");
                }
                operators.pop();
            } else if (line.isEmpty()) { //if we have no more input we evaluate the final numbers in results, redundant if we want to get results using the quit, to finalize - depends on the user
                while (!operators.isEmpty()) {
                    //EVALUATE THE TOP
                    if (results.size() < 2) {
                        System.out.println("Not enough numbers to perform operation");
                        break;
                    }
                    int num1 = results.pop();
                    int num2 = results.pop();
                    String op = operators.pop();
                    switch (op) {
                        case "+":
                            result = num1 + num2;break;
                        case "-":
                            result = num1 - num2;break;
                        case "/":
                            if (num1 == 0) {
                                System.out.println("Cannot divide by 0");break;
                            }
                            result = num2 / num1;break;
                        case "*":
                            result = num1 * num2;break;
                        default:
                            System.out.println("Incorrect symbol...");break;
                    } results.push(result);
                    System.out.println("number pushed to the stack");
                }
            } else if (line.equalsIgnoreCase("quit")) { //I also implemented this to finalize the math equation when exiting - for better user experience
                while (!operators.isEmpty()) {
                    if (results.size() < 2) {
                        System.out.println("Not enough numbers to perform operation");
                        break;
                    }
                    int num1 = results.pop();
                    int num2 = results.pop();
                    String op = operators.pop();
                    switch (op) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "/":
                            if (num1 == 0) {
                                System.out.println("Cannot divide by 0");
                                break;
                            }
                            result = num2 / num1;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        default:
                            System.out.println("Incorrect symbol...");
                            break;
                    }
                    results.push(result);
                    System.out.println("number pushed to the stack");
                }
                end = true;
            } else {
                results.push(Integer.parseInt(line));
                System.out.println("number pushed to the stack");
            } System.out.println("Results stack: " + results);
            System.out.println("Operators stack: " + operators);
        }

    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class Q4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("htmlcode.txt");
        Scanner sc = new Scanner(file);


        ArrayDeque<String> htmlStack = new ArrayDeque<>();

        while (sc.hasNext()) {
            String tag = sc.next();
            System.out.println(tag);

            if (tag.startsWith("</")) { //using startsWith method from the interface
                String closedchecking = tag.replace("/", ""); //Replaces the "/" with nothing to compare closing and starting tags
                if (htmlStack.isEmpty() || !htmlStack.peek().equals(closedchecking)) { //Compares if they equal, therefore closing tag exists or does not
                    System.out.println("There is an error in the closing tag");
                    break;
                } else {
                    htmlStack.pop();
                    System.out.println(tag + " was successfully closed");
                }
            } else { //If no closing tag has been found for now push the tags onto a stack
                htmlStack.push(tag);
            }

            System.out.println(" ");
            System.out.println(htmlStack);
        }

        if (htmlStack.isEmpty()) {
            System.out.println("All tags are properly nested");
        } else {
            System.out.println("Some tags are not properly closed");
        }
    }
}

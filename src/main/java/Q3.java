import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q1.java");
        Scanner sc = new Scanner(file);



        TreeMap<String, HashSet<Integer>> map = new TreeMap<>();
        HashSet<Integer> lines = new HashSet<>();
        String token = "";


        Map.of(token, lines);

        int lineNumber = 1;
        while (sc.hasNextLine()) {
            Scanner in = new Scanner(sc.nextLine());
            in.useDelimiter("[^A-Za-z0-9_]+");

            while (in.hasNext()) {
                token = in.next();

                if (map.containsKey(token)) {
                    map.get(token).add(lineNumber);
                } else {
                    HashSet <Integer> set = new HashSet<>();
                    map.put(token, set);
                    set.add(lineNumber);
                }
            }
        lineNumber++;
        }


        for (Map.Entry<String, HashSet<Integer>> entry : map.entrySet()) {
            System.out.println("Token: " + entry.getKey() + ", Lines: " + entry.getValue());
        }






    }
}

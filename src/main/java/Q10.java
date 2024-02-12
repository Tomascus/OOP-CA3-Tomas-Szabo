import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class DistanceTo implements Comparable<DistanceTo> {
    private String target;
    private int distance;

    public DistanceTo(String city, int dist) {
        target = city;
        distance = dist;
    }

    public String getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    public int compareTo(DistanceTo other) {
        return distance - other.distance;
    }
}

public class Q10 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("cityDistances.txt");
        Scanner sc = new Scanner(file);
        //From what I understood is that we need two maps, first one that stores all the connections between cities and second one that stores shortest distances
        //I switched from using tree sets to hash sets because treesets considered two objects from DistanceTo class equal if their distances are equal, meanwhile HashSet allowed me to store multiple paths to the same city bc of equals and other methods inside it (they are not the same object)
        HashMap<String, HashSet<DistanceTo>> cityConnections = new HashMap<>(); //Map of connected cities
        HashMap<String, Integer> shortestKnownDistance = new HashMap<>(); //Maps city to the shortest distance
        PriorityQueue<DistanceTo> cityQueue = new PriorityQueue<>();
        String from = "";

        while (sc.hasNextLine()) { //Reading through the file
            String[] line = sc.nextLine().split(" "); //Create an array for each word inside a line, so we can later add them to calculate the shortest distance
            String city1 = line[0];
            String city2 = line[1];
            int distance = Integer.parseInt(line[2]); //Change from String to Int for distance

            if (from.isEmpty()){
                from = city1;
            }

            cityConnections.putIfAbsent(city1, new HashSet<>()); //I use .putIfAbsent instead of just .put to prevent overwriting the map if the same HashSet is already there, maps it
            cityConnections.get(city1).add(new DistanceTo(city2, distance)); //Fills the key of city1 from cityConnections map with a distanceTo object that has data of city2 that it is connected to and the distance to it

            cityConnections.putIfAbsent(city2, new HashSet<>()); //same as for city1, but maps city2
            cityConnections.get(city2).add(new DistanceTo(city1, distance)); //Opposite of city1 code above, connects city2 to city1
        }

        cityQueue.add(new DistanceTo(from, 0)); //Add DistanceTo(from, 0) to a priority queue

        //Calculation of distances between distanceTo objects until it finds the shortest one
        while (!cityQueue.isEmpty()) { //While the priority queue is not empty
            DistanceTo smallest = cityQueue.poll(); //Get its smallest element - we poll the queue and get a distanceTo object of current smallest object


            //This essentially works as Dijkstra's algorithm to find the shortest paths
            if (!shortestKnownDistance.containsKey(smallest.getTarget())) { //If its target is not a key in shortestKnownDistance
                int d = smallest.getDistance(); //Let d be the distance to that target
                shortestKnownDistance.put(smallest.getTarget(), d); //Put (target, d) into shortestKnownDistance - Makes it current shortest distance in the map

                for (DistanceTo c : cityConnections.get(smallest.getTarget())) { //For all cities c (neighbours) that have a direct connection from target
                    cityQueue.add(new DistanceTo(c.getTarget(), d + c.getDistance())); //Add DistanceTo(c, d + distance from target to c) to the priority queue - c being neighbours, and d+c being the sum which is a sum of smallest distance and neighbour distance
                }
            }
        }
        System.out.println("Starting city: " + from);
        shortestKnownDistance.forEach((city, distance) -> System.out.println("Shortest distance to " + city + ": " + distance)); //for each loop using lambda to display each entry of a key(city) and value(distance) inside the map


    }
}

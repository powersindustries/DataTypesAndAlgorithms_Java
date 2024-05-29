package DataTypes;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> map = new HashMap<>();


    public void print() {
        System.out.println(map);
    }

    // Adds a new vertex to the graph as a String. Returns true if successful.
    public boolean addVertex(String vertex) {

        if (map.get(vertex) == null) {
            map.put(vertex, new ArrayList<>());
            return true;
        }

        return true;
    }

    // Adds a new edge between two vertexs. Returns true if successful.
    public boolean addEdge(String vertex1, String vertex2) {

        ArrayList<String> vertext1Array = map.get(vertex1);
        ArrayList<String> vertext2Array = map.get(vertex2);

        if (vertext1Array != null && vertext2Array != null) {
            vertext1Array.add(vertex2);
            vertext2Array.add(vertex1);
            return true;
        }

        return false;
    }

    // Removes an edge between two vertices. Returns true if successful.
    public boolean removeEdge(String vertex1, String vertex2) {

        ArrayList<String> vertext1Array = map.get(vertex1);
        ArrayList<String> vertext2Array = map.get(vertex2);

        if (vertext1Array != null && vertext2Array != null) {
            vertext1Array.remove(vertex2);
            vertext2Array.remove(vertex1);
            return true;
        }

        return false;
    }

    // Removes a vertex from the graph and its associated edges. Returns true if successful.
    public boolean removeVertext(String vertex) {

        ArrayList<String> vertextArray = map.get(vertex);

        // Safety check.
        if (vertextArray == null) {
            return false;
        }

        // Iterate through the other vertex and remove reference to the input parameter vertex.
        for (String nextVertex : map.get(vertex)) {
            map.get(nextVertex).remove(vertex);
        }

        // Final removal of the input parameter vertex.
        map.remove(vertex);

        return true;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("DataTypes.Graph - Adjacency List.");

        Graph graph = new Graph();

        // Create a three vertex graph that forms an equilateral triangle.
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        graph.print();

        graph.removeEdge("A", "B");

        graph.print();

        graph.removeVertext("A");

        graph.print();
    }
}


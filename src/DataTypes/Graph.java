package DataTypes;

import DataTypes.Types.GraphVertex;

import java.util.*;

public class Graph {
    public Map<GraphVertex, List<GraphVertex>> graph;

    public Graph() {
        graph = new HashMap<GraphVertex, List<GraphVertex>>();
    }

    public void addVertex(String inValue) {
        graph.putIfAbsent(new GraphVertex(inValue), new ArrayList<GraphVertex>());
    }

    public void addEdge(String inValue1, String inValue2) {
        GraphVertex newVertex1 = new GraphVertex(inValue1);
        GraphVertex newVertex2 = new GraphVertex(inValue2);

        if (graph.containsKey(newVertex1)) {
            graph.get(newVertex1).add(newVertex2);
        }

        if (graph.containsKey(newVertex2)) {
            graph.get(newVertex2).add(newVertex1);
        }
    }

    public void removeVertex(String inValue) {
        GraphVertex newGraphVertex = new GraphVertex(inValue);
        graph.values().stream().forEach(e -> e.remove(newGraphVertex));
        graph.remove(new GraphVertex(inValue));
    }

    public void removeEdge(String inValue1, String inValue2) {
        GraphVertex newVertex1 = new GraphVertex(inValue1);
        GraphVertex newVertex2 = new GraphVertex(inValue2);
        List<GraphVertex> newGraphVertex1 = graph.get(newVertex1);
        List<GraphVertex> newGraphVertex2 = graph.get(newVertex2);

        if (newGraphVertex1 != null) {
            newGraphVertex1.remove(newVertex2);
        }

        if (newGraphVertex2 != null) {
            newGraphVertex2.remove(newVertex1);
        }
    }

    public List<GraphVertex> getVertices(String inLabel) {
        return graph.get(new GraphVertex(inLabel));
    }

}

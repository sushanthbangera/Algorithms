/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graphs;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sushanth Bangera
 */
public class DirectedGraphCycle {

    public static void main(String[] args) {

        Edge[] edgeArray = {new Edge(0, 1), new Edge(1, 2), new Edge(2, 3)};
        List<Edge> edges = Arrays.asList(edgeArray);

        int numVertices = 4;
        Graph graph = new Graph(edges, numVertices);

        DirectedGraphCycle dCycle = new DirectedGraphCycle();
        if (dCycle.isCyclic(graph)) {
            System.out.println("Graph has a cycle");
        } else {
            System.out.println("Graph doesn't have a cycle");
        }

    }

    public boolean isCyclic(Graph graph) {

        int numVertices = graph.adjacencyList.size();
        boolean[] visited = new boolean[numVertices];

        boolean[] inRecursion = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(graph, i, visited, inRecursion)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUtil(Graph graph, int vertex, boolean[] visited, boolean inRecursion[]) {

        if (inRecursion[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        inRecursion[vertex] = true;
        visited[vertex] = true;

        List<Integer> destList = graph.adjacencyList.get(vertex);

        for (Integer u : destList) {
            if (isCyclicUtil(graph, u, visited, inRecursion)) {
                return true;
            }
        }
        inRecursion[vertex] = false;
        return false;
    }

}

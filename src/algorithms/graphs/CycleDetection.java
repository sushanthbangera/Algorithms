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
public class CycleDetection {

    /*
    Time Complexity: O(V+E)
    The program does a simple DFS Traversal of the graph which is represented 
    using adjacency list. So the time complexity is O(V+E).
    Space Complexity: O(V) - To store the visited array O(V) space is required.
     */
    public boolean isCycle(Graph graph) {
        int numVertices = graph.adjacencyList.size();
        boolean visited[] = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (cycleDetectionUtil(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cycleDetectionUtil(Graph graph, int vertex, boolean[] visited, int parent) {

        visited[vertex] = true;
        List<Integer> destList = graph.adjacencyList.get(vertex);

        for (Integer u : destList) {
            if (!visited[u]) {
                if (cycleDetectionUtil(graph, u, visited, vertex)) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Edge[] edgeArray = {new Edge(0, 1), new Edge(1, 2)};
        List<Edge> edges = Arrays.asList(edgeArray);

        int numVertices = 5;
        Graph graph = new Graph(edges, numVertices);
        
        CycleDetection cycleDet = new CycleDetection();
        
        if (cycleDet.isCycle(graph)) {
            System.out.println("Graph contains Cycle");
        } else {
            System.out.println("Graph doesn't contain a Cycle");
        }
    }

}

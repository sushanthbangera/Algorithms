/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sushanth Bangera
 */
public class Graph {

    public List<List<Integer>> adjacencyList = null;

    // N is the no. of vertices
    public Graph(List<Edge> edges, int N) {
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        edges.forEach((edge) -> {
            int src = edge.src;
            int dest = edge.dest;

            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);
        });
    }
    
    public Graph(List<Edge> edges, int N, boolean isUnDirected) {
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        edges.forEach((edge) -> {
            int src = edge.src;
            int dest = edge.dest;

            adjacencyList.get(src).add(dest);
            if (isUnDirected) {
                adjacencyList.get(dest).add(src);
            }
        });
    }
}

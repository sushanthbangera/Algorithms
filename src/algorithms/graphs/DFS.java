/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Sushanth Bangera
 */
public class DFS {
    
    public static void DFS(Graph graph, int v, boolean[] discovered) {
        
        discovered[v] = true;
        
        System.out.print(v + " ");
        
        List<Integer> destList = graph.adjacencyList.get(v);
        
        destList.forEach(u -> {
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        });
    }
    
    public static void iterativeDFS(Graph graph, int v, boolean[] discovered) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        
        while (!stack.isEmpty()) {
            
            v = stack.pop();
            
            if (discovered[v]) continue;
            
            discovered[v] = true;
            System.out.println(v + " ");
            
            List<Integer> destList = graph.adjacencyList.get(v);
            destList.forEach(u -> {
                if (!discovered[u]) {
                    stack.push(u);
                }
            });
        }
    }
    
    
    public static void main(String[] args) {
        
        List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
        new Edge(2, 5), new Edge(2, 6), new Edge(5, 9), new Edge(5, 10),
        new Edge(4, 7), new Edge(4, 8), new Edge(7, 11), new Edge(7, 12));
        
        // vertex 0, 13, 14 are single nodes
        int N = 15;
        
        Graph graph = new Graph(edges, N);
        
        boolean discovered[] = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
        }
        
        // For Iterative DFS
        boolean visited[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                iterativeDFS(graph, i, visited);
            }
        }
    }
}

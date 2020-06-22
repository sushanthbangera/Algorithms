/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sushanth Bangera
 */
public class BFS {
    
   public static void BFS (Graph graph, int v, boolean[] discovered) {
       
       Queue<Integer> queue = new ArrayDeque<>();

       discovered[v] = true;
       
       queue.add(v);
       
       while (!queue.isEmpty()) {
           
           int srcVertex = queue.poll();
           
           List<Integer> destinations = graph.adjacencyList.get(srcVertex);
           
           destinations.forEach( u -> {
               if (!discovered[u]) {
                   discovered[u] = true;
                   queue.add(u);
               }
           });
       }
       
   }
   
   public static void recursiveBFS(Graph graph, Queue<Integer> queue, boolean[] discovered) {
       
       if (queue.isEmpty()) return;
       
       int v = queue.poll();
       System.out.print(v + " ");
       
       // Do for every edge [v -> u]
       List<Integer> destList = graph.adjacencyList.get(v);
       
       destList.forEach(u -> {
           if (!discovered[u]) {
               discovered[u] = true;
               queue.add(u);
           }
       });
       recursiveBFS(graph, queue, discovered);
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
            if (discovered[i] == false) {
                BFS(graph, i, discovered);
            }
        }
        
        // For recursive BFS
        boolean visited[] = new boolean[N];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            
            if (visited[i] == false) {
                visited[i] = true;
                
                queue.add(i);
                recursiveBFS(graph, queue, discovered);
            }
        }
        
    }
}

/*
 * To get the minimum throws required to win the snake and ladder game
 */
package algorithms.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author Sushanth Bangera
 */
public class SnakeLadderGame {

    private Graph createBoardGraph(Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap, int N) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int src = i;

            for (int j = 1; j <= 6 && i + j <= N; j++) {

                int dest;

                int ladderDest = ladderMap.containsKey(i + j) ? ladderMap.get(i + j) : 0;
                int snakeDest = snakeMap.containsKey(i + j) ? snakeMap.get(i + j) : 0;

                if (ladderDest != 0 || snakeDest != 0) {
                    dest = ladderDest + snakeDest;
                } else {
                    dest = i + j;
                }
                edges.add(new Edge(src, dest));
            }
        }
        return new Graph(edges, N, false);
    }

    public void minThrows(Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap) {
        int N = 10 * 10;
        Graph graph = createBoardGraph(ladderMap, snakeMap, N);
        BFS(graph, 0, N);
    }

    private void BFS(Graph graph, int source, int N) {
        boolean visited[] = new boolean[N + 1];
        Queue<Node> queue = new ArrayDeque<>();

        Node node = new Node(source, 0);
        queue.add(node);

        visited[source] = true;

        while (!queue.isEmpty()) {

            node = queue.poll();

            // if it reaches the nth Node
            if (node.vertex == N) {
                System.out.println("The min Distance: " + node.minDist);
                break;
            }

            List<Integer> destList = graph.adjacencyList.get(node.vertex);

            for (Integer u : destList) {
                if (!visited[u]) {
                    visited[source] = true;
                    Node nextNode = new Node(u, node.minDist + 1);
                    queue.add(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) {

        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        // insert ladders into the map
        ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);

        // insert snakes into the map
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);

        SnakeLadderGame snk = new SnakeLadderGame();
        snk.minThrows(ladder, snake);
    }

    private class Node {

        // stores the 
        public int vertex;

        // stores the minimum distance from the 
        public int minDist;

        public Node(int vertex, int minDist) {
            this.vertex = vertex;
            this.minDist = minDist;
        }
    }
}

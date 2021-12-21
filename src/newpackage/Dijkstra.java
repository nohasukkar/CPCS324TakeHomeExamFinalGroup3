
package newpackage;

public class Dijkstra {

    static String[] Vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", 'A', i, distance[i]));
        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
        int In = 999999999;
        int g[][] = new int[][]{
        {0, 2,3,0,0},
        {2,0,4,0,3},
        {3,0,0,2,0},
        {0,4,2,0,1},
        {0,3,0,1,0}};
        
        int graph1[][] = new int[][]{
            {0, 0, 1, 2, 0, 0, 0}, {0, 0, 2, 0, 0, 3, 0}, {1, 2, 0, 1, 3, 0, 0},
            {2, 0, 1, 0, 0, 0, 1}, {0, 0, 3, 0, 0, 2, 0}, {0, 3, 0, 0, 2, 0, 1}, {0, 0, 0, 1, 0, 1, 0}};

        int Graph1[][] = new int[][]{
            {0, 10, In, In, In, 5, In, In, In, In}, // A
            {In, 0, 3, In, 3, In, In, In, In, In}, // B
            {In, In, 0, 4, In, In, In, 5, In, In}, // C
            {In, In, In, 0, In, In, In, In, 4, In}, // D
            {In, In, 4, In, 0, In, 2, In, In, In}, // E
            {In, 3, In, In, In, 0, In, In, In, 2}, // F
            {In, In, In, 7, In, In, 0, In, In, In}, // G
            {In, In, In, 4, In, In, In, 0, 3, In}, // H
            {In, In, In, In, In, In, In, In, 0, In}, // I
            {In, 6, In, In, In, In, 8, In, In, 0}, // J
        };
        Dijkstra T = new Dijkstra();
        T.dijkstra(g, 0);
    }
}

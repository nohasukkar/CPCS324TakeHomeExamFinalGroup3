/*
 Noha Abbas Sukkar
 EBtehaj Albadri
 JoudJabalawi
 */
package FinalTakeHomeExam;

import java.util.ArrayList;

public class Dijkstra {

    static int In = 999999999; // In = Infinity
    static String tree = "";
    static String visited = "";
    static ArrayList<edge> Edges = new ArrayList();
    static String[] Vertices;//{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    static int[] distance;
    static int SrcVertex = 0;

    public static void main(String[] args) {

        //************************************************************************************
        // 4 Graphs representing by two dimention arrays for Implementing Dijkstra Algorithm 
        int[][] Graph1 = {
            // Converting graph into two dimintional array
            // This Graph #1 consist of : 10 Vertices (A -J) & 15- 20 Edges 
            // A   B   C   D   E   F   G   H   I   J
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

        int[][] Graph2 = {
            // Converting graph into two dimintional array
            // This Graph #2 consist of : 15 Vertices (A - O) & 15- 20 Edges 
            //  A  B  C   D   E   F   G   H   I   J   K   L   M   N   O
            {0, 3, In, In, In, In, In, In, In, In, In, In, In, In, 4},
            {In, 0, 5, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, 0, 6, In, In, In, In, In, In, In, In, 8, In, In},
            {In, In, In, 0, 3, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, 0, In, In, In, In, 10, In, In, In, In, In},
            {In, In, In, In, In, 0, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, 3, 3, 0, 3, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, 0, 9, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, 0, 4, In, In, In, In, In},
            {In, In, In, In, In, 5, In, In, In, 0, In, In, 6, In, In},
            {In, In, In, In, In, In, In, In, In, 7, 0, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, 6, 0, 4, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, 0, In, 5},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, 3, 0},};

        int[][] Graph3 = {
            // converting graph into two dimintional array
            // This Graph #3 consist of : 20 Vertices (A - T) & 20 - 25 Edges 
            //A  B  C  D  E    F   G   H   I   J   K   L   M   N   O   P   Q   R  S   T
            {0, 3, In, In, In, In, In, In, In, In, In, In, In, In, In, 3, In, In, In, In},
            {In, 0, In, In, In, In, In, In, In, In, In, In, In, In, In, 4, In, In, In, In},
            {In, In, 0, 6, In, In, In, In, In, 8, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, 0, In, 10, In, In, In, 7, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, 0, In, 8, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, 9, 0, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, 0, 5, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, 0, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, 3, 0, 7, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, 0, In, 6, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, 0, In, In, In, 3, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, 0, 5, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, 10, In, 0, 3, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, 4, In, In, 0, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, 6, 7, In, In, In},
            {In, In, 5, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, 3, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, 4},
            {4, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, In, 5, 0}
        };

        int[][] Graph4 = {
            // converting graph into two dimintional array
            // This Graph #4 consist of : 25 Vertices (A - Y) & 35 - 40 Edges 
            //A  B  C  D   E   F   G   H   I   J   K   L   M   N   O   P   Q   R  S   T   U   V   W   X   Y
            {0, 3, In, In, In, In, In, In, In, In, In, In, In, In, In, 5, In, In, In, In, In, In, In, In, In},
            {In, 0, In, In, In, In, In, In, In, In, In, In, In, In, In, 4, In, In, In, In, In, In, In, In, In},
            {In, In, 0, 7, In, In, In, In, In, 4, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, 0, In, 5, In, In, In, 6, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, 0, In, 3, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, 3, 0, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, 0, 4, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, 0, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 9},
            {In, In, In, In, In, In, In, 6, 0, 7, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, 0, In, 3, In, In, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, 0, In, In, In, 8, In, In, In, In, In, 10, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, 0, 10, In, In, In, In, In, In, In, 3, In, In, 10, In},
            {In, In, In, In, In, In, In, In, In, In, 5, In, 0, 8, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, 3, In, In, 0, In, In, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, 3, 7, In, In, In, In, In, In, In, In},
            {In, In, 5, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, In, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, 6, In, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, 3, In, In, In, In, In},
            {6, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, In, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 4, 0, In, In, 9, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, 3, In, In, In, In, In, 0, In, In, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 5, In, 4, In, 0, 10, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 0, In},
            {In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, In, 8, 0}
        };

        System.out.println("-------------------------------------------------------------");
        System.out.println("                         The Graph                           ");
        System.out.println("-------------------------------------------------------------\n");
        PrintMatrix(Graph4);
        System.out.println("-------------------------------------------------------------");
        System.out.println("                     Dijkstra Algorithm            ");
        System.out.println("-------------------------------------------------------------");
  
        long StartTime_Dijkstra = System.nanoTime();
        Print(dijkstra(Graph4, SrcVertex));
        long EndTime_Dijkstra = System.nanoTime();
        long totalTime_Dijkstra = EndTime_Dijkstra - StartTime_Dijkstra;

        System.out.println("\n-------------------- The Total Time -----------------------");
        System.out.println("The Time Efficiency : " + totalTime_Dijkstra / 1000000
                + " milliseconds");
    }

    public static int[] dijkstra(int[][] graph, int Src) {
        int len = graph.length;
        boolean[] visitedVerArr = new boolean[len];
        Vertices = new String[len];
        distance = new int[len];
        // initialize visitedVerArr and distance arrays
        for (int i = 0; i < len; i++) {
            visitedVerArr[i] = false;
            Vertices[i] = ((char) (65 + i) + "");

            distance[i] = Integer.MAX_VALUE;
            Edges.add(new edge(Src));
        }

        // Distance of self loop is zero
        distance[Src] = 0;
        for (int i = 0; i < len; i++) {
            // Update the distance between neighbouring vertex and Src vertex
            int min = SearchMinDist(distance, visitedVerArr);
            visitedVerArr[min] = true;

            // Update all the neighbouring vertex distances
            for (int k = 0; k < len; k++) {

                if (!visitedVerArr[k] && graph[min][k] != 0 && (distance[min] + graph[min][k] < distance[k])) {
                    distance[k] = distance[min] + graph[min][k];
                    Edges.get(k).setSource(min); // save the intermediate Src
                    visited += Vertices[k];  // save the visited nodes labels

                }
            }
            // Update all the neighbouring vertex distances
            for (int k = 0; k < len; k++) {
                if (!visitedVerArr[k] && graph[min][k] != 0 && (distance[min] + graph[min][k] < distance[k])) {
                    distance[k] = distance[min] + graph[min][k];
                }
            }
        }

        return distance;
    }

    public static void Print(int[] distance) {
        System.out.println("\nThe Shortest Paths from " + Vertices[SrcVertex] + " to all other Vertices are:");
        for (int i = 0; i < distance.length; i++) {
          
            if(distance[i] == In){
                System.out.println(String.format(">> The Shortest Paths from %-2s to %-2s is %-2s", Vertices[SrcVertex], Vertices[i], "can't reach it"));
                continue;
            }
            System.out.println(String.format(">> The Shortest Paths from %-2s to %-2s is %-2d", Vertices[SrcVertex], Vertices[i], distance[i]));
   
        }

    }

    public static void PrintMatrix(int matrix[][]) {

        // For printing the header of the m1
        System.out.print("    ");

        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(((char) ('A' + i)) + "    ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(((char) (i + 'A')) + "    ");
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 999999999) {
                    System.out.printf("%-4s", "∞");
                } else {
                    System.out.printf("%-5d", matrix[i][j]);
                }
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public static int SearchMinDist(int[] distanceArr, boolean[] VisitedVertexArr) {
       
        int Index_MinVertex = -1; // Varible for store the index of minimum distance vertex 
        int MinDist = Integer.MAX_VALUE; // Varible for store the value of minimum distance vertex
                                         //& use it to compare inside the loop
        
        // for loop to search in distance Array for minimum distance
        for (int i = 0; i < distanceArr.length; i++) {
            // 
            if (!VisitedVertexArr[i] && distanceArr[i] < MinDist) {
                MinDist = distanceArr[i];
                Index_MinVertex = i;
            }
        }
        return Index_MinVertex;
    }

    // ******************** Edge class ****************
    static class edge {

        int vert;
        int source;
        
        //  ----- creat constructor -----
        edge(int src) {
            this.source = src;
        }

        // ----- Class's methods for get and set attributes ---- 
        public int getVert() {
            return vert;
        }

        public void setVert(int vert) {
            this.vert = vert;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }
    }
}

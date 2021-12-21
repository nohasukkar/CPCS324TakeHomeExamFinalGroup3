/*
 Noha Abbas Sukkar
 EBtehaj Albadri
 JoudJabalawi
 */
package FinalTakeHomeExam;

import java.util.LinkedList;


public class ED{
    static final int V = 6;
        
        //BFS supporting method to find the max-flow
        public static void main (String[] args) throws java.lang.Exception {
            
        int graph[][] =new int[][] { {0, 2, 7, 0, 0, 0},
                                     {0, 0, 0, 3, 4, 0},
                                     {0, 0, 0, 4, 2, 0},
                                     {0, 0, 0, 0, 0, 1},
                                     {0, 0, 0, 0, 0, 5},
                                     {0, 0, 0, 0, 0, 0}
                                   };
        ED j = new ED();
        j.FF(graph, 0, graph.length-1);
    }
        
        //BFS supporting method to find the max-flow
	public boolean bfs(int[][] resGraph, int SVertex, int t, int parent[]) {
        
        //Create a visited array and mark all vertices as not visited
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;
         
        //Create a queue, enqueue source vertex and mark source vertex as visited
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(SVertex);
        visited[SVertex] = true;
        parent[SVertex]=-1;
        // Standard BFS Loop
        while (!queue.isEmpty())
        {
            int u = queue.poll();
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && resGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        //If we reached sink in BFS starting from source, then return true, else false
        return (visited[t] == true);
    }
        
        //DFS supporting method to find the minimum-cut
        public void dfs(int [][] graph, int s, boolean[]visited){
        visited[s]=true;
        for (int i = 0; i < graph.length; i++) {
            if(graph[s][i]>0&&!visited[i])
                dfs(graph,i,visited);
        }
    }
      
        //maximum-flow algorithm using BFS to find the maximum flow of the network, and the corresponding minimum-cut
        public void FF(int graph[][], int source, int t)
        {
        System.out.println("\n------------------------------------------------");
        System.out.println("\t\t   Maximum flow");
        System.out.println("------------------------------------------------\n");
        System.out.println("Augiminting paths:");
        int u, v;
      
        //Create a residual graph and fill the residual graph with given capacities in the original graph as
        //residual capacities in residual graph
 		 
        //Residual graph where rGraph[i][j] indicates residual capacity of edge from i to j (if there
        //is an edge. If rGraph[i][j] is 0, then there is not)
        int[][] resGraph = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                resGraph[u][v] = graph[u][v];
        // This array is filled by BFS and to store path
        int parent[] = new int[V];
        int max_flow = 0;  // There is no flow initially
    
        //augment the flow while there is path from source to sink
        while (bfs(resGraph, source, t, parent))
        {
            String path = "";
            
          
            //Find minimum residual capacity of the edges along the path filled by BFS
            //find the maximum flow through the path found.
            int pathFlow = Integer.MAX_VALUE;
            for (v=t; v!=source; v=parent[v])
            {
                String direction="←";
                u = parent[v];
                pathFlow = Math.min(pathFlow, resGraph[u][v]);
                if(graph[u][v]!=0) direction="→";
                path=direction+(v+1)+path;
            }
            path=(v+1)+path;
            System.out.printf("%-17s %s %d \n",path,"flow: ",pathFlow);
            
            //update residual capacities of the edges and reverse edges along the path
            for (v=t; v != source; v=parent[v])
            {
                u = parent[v];
                resGraph[u][v] -= pathFlow;
                resGraph[v][u] += pathFlow;
            }
            // Add path flow to overall flow
            max_flow += pathFlow;
            System.out.println("flow: "+max_flow+"\n");
            
        }
        
        // print max-flow
        System.out.println("The maximum flow is "+max_flow);
        System.out.println("\n------------------------------------------------");
        System.out.println("\t\t   Minimum cut");
        System.out.println("------------------------------------------------");
        // print min-cut edges
        System.out.println("\nEdges included in the minimum-cut");
        boolean[] isVisited = new boolean[graph.length];      
        dfs(resGraph, source, isVisited); 
          
        // Print all edges that are from a reachable vertex to 
        // non-reachable vertex in the original graph
        int min_cut=0;
        for (int i = 0; i < graph.length; i++) { 
            for (int j = 0; j < graph.length; j++) { 
                if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) { 
                    System.out.print("\nEdge: "+(i+1) + "-" + (j+1)); 
                    System.out.println(" , capacity = "+graph[i][j]);
                    min_cut+=graph[i][j];
                    System.out.println("minimum-cut capicity: "+min_cut);
                } 
            } 
        }
        System.out.println("\nThe total minimum-cut capacity is "+min_cut+"\n");
    }
    
}
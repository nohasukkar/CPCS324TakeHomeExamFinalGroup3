/*
 Noha Abbas Sukkar
 EBtehaj Albadri
 JoudJabalawi
 */
package FinalTakeHomeExam;

/**
 *
 * @author Noha
 */
import java.util.ArrayList;
public class MBM {
     //Constructing the applicants and the hospitals arrays 
    String[] Alist = {"Ahmed", "Mahmoud", "Eman", "Fatimah", "Kamel", "Nojood"};
    String[] Hlist = {"King Abdelaziz University", "King Fahd", "East Jeddah", "King Fahad Armed Forces", "King Faisal Specialist", "Ministry of National Guard"};
    ArrayList<Integer> J = new ArrayList<>();

    int M = Alist.length, N = Hlist.length;
    int[][] graph = new int[][]{ //A graph with M applicant and N hospitals
        {1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1}
    };
    int[] App = new int[N];
    
     public static void main(String[] args) {
        MBM g = new MBM();
        System.out.println("The maximum possible number of applicants can be assigned to hospitals: " + g.maxMatch()+"\n");
    }
     
    //maximum matching method
    int maxMatch() {
        int assign[] = new int[N];    //an array to track which hospital is assigned to which applicant
        for (int i = 0; i < N; i++) {
            assign[i] = -1;    //initially set all jobs are available
            J.add(-1);     //initialize the set J 
        }
        int mCount = 0;

        for (int u = 0; u < M; u++) {    //for all applicants
            boolean visited[] = new boolean[N];
            if (bipMatch(u, visited, assign)) //when u get a hospital
            {
                System.out.println("set J: \n");
                for (int i = 0; i < J.size(); i++) {
                    if(J.get(i)>-1)
                    System.out.print("("+Alist[i]+" - "+Hlist[J.get(i)]+") \n");
                }
                System.out.println("\n------------------------------------------------------------");
                mCount++;
            }

        }
        return mCount;
    }
     
    //check if a matching for applicant is possible 
    boolean bipMatch(int u, boolean visited[], int assign[]) {
        for (int v = 0; v < N; v++) {    //for all hospital 0 to N-1
            if (graph[u][v] == 1 && !visited[v]) {    //when hospital v is not visited and u is interested
                visited[v] = true;    //mark as hospital v is visited
                //when v is not assigned or previously assigned
                if (assign[v] < 0 || bipMatch(assign[v], visited, assign)) {
                    assign[v] = u;    //assign hospital v to applicant u
                    System.out.println(Alist[u] + " is assigned to " + Hlist[v]+"\n");
                    J.set(u, v); // add the edge to matching set M
                    App[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
    
}


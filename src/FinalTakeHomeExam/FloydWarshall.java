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
public class FloydWarshall {

    public static void main(String[] args) {
        // TODO code application logic here

        int In = 999999999; // In = Infinity
        int[][] g1 // graph 1 with 10 vertices
                = {
                    // converting graph into two dimintional array
                    // A  B  C  D  E  F  G  H  I  J
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

        int[][] g2 // graph 2 with 15 vertices
                = {
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

        int[][] g3 // graph 3 with 20 vertices
                = {
                    // converting graph into two dimintional array
                    // A  B  C  D  E  F  G  H  I  J  K   L   M   N   O   P   Q   R  S
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

        int[][] g4 // graph 4 with 25 vertices
                = {
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
        System.out.println("------------------------ The Graph --------------------------");
        System.out.println("-------------------------------------------------------------\n");
        PrintMatrix(g1); // printing the matrix 
        System.out.println("-------------------------------------------------------------");
        System.out.println("---------------- Floyd-Warshall Algorithm -------------------");
        System.out.println("-------------------------------------------------------------\n");
        double start = System.currentTimeMillis(); // start time
        FloydWarshall(g1);
        double finish = System.currentTimeMillis(); // finish time
        System.out.println("---------------------- The Total Time -----------------------");
        double total = finish - start; // compute total time
        System.out.println("The total time is: " + total + " milliseconds ");

    }

    public static void FloydWarshall(int[][] matrix) {
        int n = matrix.length; // n as the matrix length
        
        for (int i = 0; i < n; i++) { // first loop for row
            System.out.println("Iterarion " + (i + 1) + "\n"); // printing iteration number

            for (int j = 0; j < n; j++) { // loop for reading colomns 
                for (int k = 0; k < n; k++) { // loop for checking the numbers
                    matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                }
            }
            PrintMatrix(matrix); //print matrix in each loop
        }
    }

    public static void PrintMatrix(int matrix[][]) {

        // For printing the header of the m1
        System.out.print("    ");

        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(((char) ('A' + i)) + "     ");
        }
        System.out.println();
        // printing the colomn
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(((char) (i + 'A')) + "   ");
            // printing 2d array
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 999999999) {
                    System.out.printf("%-5s", "∞");
                } else {
                    System.out.printf("%-5d ", matrix[i][j]);
                }
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

}

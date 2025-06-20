import java.util.Scanner;

public class ShortestPath {
  
  // METHOD TO DISPLAY THE MATRIX
  public static void displayMatrix(char[][] matrix){

      for (char[] matrix1 : matrix) {
          for (int j = 0; j<matrix.length; j++) {
              System.out.print(matrix1[j] + " ");
          }
          System.out.println();
      }
  }

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the dimension of the Matrix : ");
    int n = scan.nextInt();

    char[][] matrix = new char[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++){
        matrix[i][j] = '0';
      }
      
    }


    System.out.print("Enter Runner Position : ");
    
    // IF (0, 2)
    int aRow = scan.nextInt(); // 0 
    int aCol = scan.nextInt(); // 2

    // Change the value in matrix[aRow][aCol]
    matrix[aRow][aCol] = 'A';

    System.out.print("Destination of Runner : ");

    //IF (3, 4)
    int dRow = scan.nextInt(); // 3
    int dCol = scan.nextInt(); // 4
    
    // Change the value in matrix[dRow][dCol]
    matrix[dRow][dCol] = 'D';


    displayMatrix(matrix);
    
    int shortestPath = findShortestPath(aRow, aCol, dRow, dCol);

    System.out.println("The shortest path is : " + shortestPath);

    scan.close();
  }

  private static int findShortestPath(int x1, int y1, int x2, int y2){
    
    // EUCLIDEAN'S SHORTEST DISTANCE FORMULA

    return Math.max((x2 - x1), (y2 - y1));
  }
}

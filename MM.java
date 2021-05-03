
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;

 /**
  *
  * @author ayoka
  * JAVA matrix multiplication. Gets input from two files and writes to a third
  * file the product of the two matricies.
  */
 public class MM {

     public static void main(String[] args) throws FileNotFoundException {

         File A = new File("matrixA.txt");
         File B = new File("matrixB.txt");
         int numrow = 0;
         int numcol = 0;
         String line = "";

         int rowA = 0;
         int colA = 0;
         int rowB = 0;
         int colB = 0;

         //Getting the initial number of rows and cols for matrixA size
         try {
             Scanner reader1 = new Scanner(A);
             while (reader1.hasNextLine()) {
                 line = reader1.nextLine();
                 String[] data1 = line.split(" ");
                 numrow++;
                 numcol = data1.length;
             }

         } catch (FileNotFoundException e) {
             System.out.println("Matrix A file is not found");
             // e.printStackTrace();
         }
         //filling in values for number of rows and cols
         int[][] matrixA = new int[numrow][numcol];
         //reset num row
         numrow = 0;
         //adding each value in matrixA file into matrixA array
         try {
             Scanner reader = new Scanner(A);

             while (reader.hasNextLine()) {

                 line = reader.nextLine();
                 String[] data = line.split(" ");

                 for (int i = 0; i < data.length; i++) {
                     matrixA[numrow][i] = Integer.parseInt(data[i]);

                 }
                 numrow++;
                 numcol = data.length;
             }
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             // e.printStackTrace();
         }

         rowA = numrow;
         colA = numcol;

 //------------------------------------------------------------------------------
         numrow = 0;
         //Getting the initial number of rows and cols for matrixB size
         try {
             Scanner reader1 = new Scanner(B);
             while (reader1.hasNextLine()) {
                 line = reader1.nextLine();
                 String[] data1 = line.split(" ");
                 numrow++;
                 numcol = data1.length;
             }

         } catch (FileNotFoundException e) {
             System.out.println("Matrix B file is not found");
             // e.printStackTrace();
         }
         //filling in values for number of rows and cols
         int[][] matrixB = new int[numrow][numcol];
         //reset num row
         numrow = 0;
         //adding each value in matrixB file into matrixB array
         try {
             Scanner reader = new Scanner(B);

             while (reader.hasNextLine()) {

                 line = reader.nextLine();
                 String[] data = line.split(" ");

                 for (int i = 0; i < data.length; i++) {
                     matrixB[numrow][i] = Integer.parseInt(data[i]);

                 }
                 numrow++;
             }
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             // e.printStackTrace();
         }
         rowB = numrow;
         colB = numcol;

 //------------------------------------------------------------------------------
         if (colA == rowB) {
             int[][] matrixAnswer = new int[rowA][colB];

             //filling in the matrix answer array with values
             for (int row = 0; row < rowA; row++) {
                 for (int col = 0; col < colB; col++) {

                     //Matrix multiplication of values
                     for (int i = 0; i < matrixA[0].length; i++) {
                         matrixAnswer[row][col] += matrixA[row][i] * matrixB[i][col];
                     }

                 }
             }

             //writing to the file
             try {
                 FileWriter C = new FileWriter("matrixAnswer.txt");

                 for (int row = 0; row < rowA; row++) {
                     for (int col = 0; col < colB; col++) {
                         C.write(matrixAnswer[row][col] + " ");
                     }
                     C.write("\n");
                 }

                 C.close();
             } catch (IOException io) {
                 System.out.println("An error occurred.");
                 io.printStackTrace();
             }

         } else {
             System.out.println("You cannot multiply these two matricies");
         }

     }

 }

import java.util.Scanner;

public class Work_2_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите размерность матрицы");
            scanner.next();
        }
        int lenmass = Math.abs(scanner.nextInt());
        System.out.println("Введите элементы матрицы:");
        int [][] nums = new int[lenmass][lenmass];
        for (int i = 0; i < lenmass; i++) {
            for (int j = 0; j < lenmass; j++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Введено некоректное значение");
                    scanner.next();
                }
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Определитель матрицы: "+determinant(nums));
    }
     static int determinant(int[][]matrix){
         if(matrix.length == 1)
             return matrix[0][0];
         if(matrix.length == 2)
             return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
         else{
            int det = 0;
            for (int i = 0; i < matrix.length; i++){
                det +=((int) Math.pow(-1,i) * matrix[0][i] * determinant(small_matrix(i,matrix)));
            }
            return det;}
    }
    static int[][] small_matrix(int col,int[][] matrix){
        int[][] m = new int[matrix.length-1][matrix.length-1];
        int rm = 0;
        for(int i = 1; i < matrix.length; i++) {
            int cm = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (j == col)
                    continue;
                m[rm][cm] = matrix[i][j];
                cm++;
            }
            rm++;
        }
        return m;
}
}


//1 1 1 1
//0 2 2 2
//0 0 3 3
//0 0 0 4

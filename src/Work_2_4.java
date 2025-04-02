import java.util.Scanner;

public class Work_2_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] nums = new int[2][2];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                while (!scanner.hasNextInt()){
                    System.out.println("Введено некоректное значение");
                    scanner.next();
                }
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Определитель матрицы: " +(nums[0][0]*nums[1][1] - nums[1][0]*nums[0][1]));
    }
}

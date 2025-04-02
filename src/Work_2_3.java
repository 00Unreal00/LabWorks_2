import java.util.Arrays;
import java.util.Scanner;

public class Work_2_3 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы: ");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите размерность матрицы: ");
            scanner.next();
        }
        int lenmass = Math.abs(scanner.nextInt());
        int[][] mass = new int[lenmass][lenmass];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < lenmass; i++) {
            for (int j = 0; j < lenmass; j++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Введено некоректное значение");
                    scanner.next();
                }
                mass[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Матрица после отражения:");
        for (int i = lenmass-1; i >-1; i--) {
            for (int j = lenmass-1; j>-1; j--) {
                mass[i][j] = mass[j][i];
            }
        }
        for (int i = 0; i < lenmass; i++) {
            System.out.println(Arrays.toString(mass[i]));
        }
    }
}

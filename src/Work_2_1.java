import java.util.Arrays;
import java.util.Scanner;

public class Work_2_1 {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк:");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите количество строк:");
            scanner.next();
        }
        int lenmass1 = Math.abs(scanner.nextInt());
        System.out.println("Введите количество столбцов:");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите количество столбцов:");
            scanner.next();
        }
        int lenmass2 = Math.abs(scanner.nextInt());
        System.out.println("Введите элементы матрицы:");
        int [][] nums = new int[lenmass1][lenmass2];
        for (int i = 0; i < lenmass1; i++) {
            for (int j = 0; j < lenmass2; j++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Введено некоректное значение");
                    scanner.next();
                }
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Массив:");
        int mnum = nums[0][0];
        for(int i = 0; i <lenmass1; i++){
            System.out.println(Arrays.toString(nums[i]));
            for(int j = 0; j < lenmass2; j++){
                if (nums[i][j] < mnum) {
                    mnum = nums[i][j];
                }}}
        System.out.println("Минимальное число: "+mnum);
    }
}


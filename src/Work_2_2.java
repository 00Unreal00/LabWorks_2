import java.util.Scanner;
import java.util.Arrays;
public class Work_2_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во вводимых данных:");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите кол-во вводимых данных:");
            scanner.next();
        }
        int cntvag = Math.abs(scanner.nextInt());
        int[][] vags = new int[cntvag][3];
        for(int i = 0; i < cntvag; i++){
            System.out.println("Введите номер поезда");
            while (!scanner.hasNextInt()){
                System.out.println("Введено некоректное значение");
                scanner.next();
            }
            vags[i][0] = scanner.nextInt();
            System.out.println("Введите номер вагона и кол-во пассажиров");
            for(int j = 1; j < 3; j++){
                while (!scanner.hasNextInt()){
                    System.out.println("Введено некоректное значение");
                    scanner.next();
                }
                vags[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Введите номер поезда:");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            scanner.next();
        }
        int train = Math.abs(scanner.nextInt());
        int sumpas = 0;
        for(int i = 0; i < cntvag; i++) {
            System.out.println(Arrays.toString(vags[i]));
            if (vags[i][0] == train) {
                sumpas += vags[i][2];
            }
        }
        if(sumpas != 0)
            System.out.println("Количество пассажиров в поезде - " + sumpas);
        else
            System.out.println("Error");
    }
}

import java.util.Scanner;
import java.util.Arrays;
public class Work_1_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массив через пробел");
        String s1 = scanner.nextLine();
        String[] mass1 = s1.split(" ");
        System.out.println("Введите количество вращений: ");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите количество вращений: ");
            scanner.next();
        }
        String h;
        int rot = Math.abs(scanner.nextInt());
    for(int i = 0; i < rot; i++){
        for(int j = 0; j < mass1.length - 1; j++){
            h = mass1[j];
            mass1[j] = mass1[j+1];
            mass1[j+1] = h;
        }}
    System.out.println("Массив после вращения");
        System.out.println(Arrays.toString(mass1));

    }
}

import java.util.Scanner;
public class Work_1_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество вагонов: ");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите количество вагонов: ");
            scanner.next();
        }
        int vag = Math.abs(scanner.nextInt());
        int[] train = new int[vag];
        for(int i = 0; i < vag; i ++){
            System.out.println("Введите кол-во пассажиров:");
            while (!scanner.hasNextInt()){
                System.out.println("Введено некоректное значение, повторите ввод");
                scanner.next();
            }
            train[i] = Math.abs(scanner.nextInt());
        }
        System.out.println("Итоговый поезд");
        int count = 0;
        for(int v : train){
            System.out.print(v + " ");
            count += v;
        }
        System.out.println("\nОбщее число пассажиров: " + count);

}
}

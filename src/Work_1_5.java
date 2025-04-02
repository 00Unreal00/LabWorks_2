import java.util.Scanner;
public class Work_1_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int[] mass2 = new int[0];
        while(flag){
            System.out.println("Введите массив целых чисел через пробел");
            String s1 = scanner.nextLine();
            String[] mass1 = s1.trim().split(" ");
            Scanner scanner2 = new Scanner(s1);
            mass2 = new int[mass1.length];
            int cnt = 0;
            while (scanner2.hasNext()){
                try{
                    mass2[cnt] = Integer.parseInt(scanner2.next());
                    cnt++;
                } catch (NumberFormatException e) {
                    System.out.println("Введены не целочисленные данные");
                    break;
                }
            }
            if(cnt == mass1.length)
                flag = false;
        }
        System.out.println("Введите сумму: ");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите сумму: ");
            scanner.next();
        }
        int rsum = Math.abs(scanner.nextInt());
        String numbers = "";
        for(int i = 0; i < mass2.length; i++){
            for(int j = i+1; j < mass2.length; j++) {
                if (mass2[i] + mass2[j] == rsum
                        && !numbers.contains(String.valueOf(mass2[i]))
                        && !numbers.contains(String.valueOf(mass2[j]))) {
                    numbers += mass2[i] +" " + mass2[j];
                    System.out.println(mass2[i] + " " + mass2[j]);
                }
            }
        }
    }
}

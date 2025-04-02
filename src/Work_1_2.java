//import java.util.Scanner;
//public class Work_1_2 {
//    public static void main(String[] args){
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Введите любые символы через пробел");
//    String l1 = scanner.nextLine();
//    String l2 = scanner.nextLine();
//    String[] mass1 = l1.split(" ");
//    String[] mass2 = l2.split(" ");
//    String ck = "";
//    for(String i: mass2){
//        for(String j: mass1){
//            if(i.equals(j) && !ck.contains(i)){
//                System.out.print(i + " ");
//                ck += (i + " ");
//        }}}
//    }
//}
import java.util.Arrays;
import java.util.Scanner;
public class Work_1_2 {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите любые символы через пробел");
    String l1 = scanner.nextLine();
    String l2 = scanner.nextLine();
    String[] mass1 = l1.split(" ");
    String[] mass2 = l2.split(" ");
    for(String i: mass2){
        for(String j: mass1){
            boolean flag = true;
            if (i.length() != j.length()){
                flag = false;
            }
            else {
                for(int k = 0; k < i.length(); k ++){
                    if (i.charAt(k) != j.charAt(k)){
                        flag = false;
                        break;
                    }
                }
            }
        if(flag){
            System.out.print(i + " ");
        }
    }}}}




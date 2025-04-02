import java.util.Arrays;
import java.util.Scanner;

public class Work_3_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во человек");
        while (!scanner.hasNextInt()){
            System.out.println("Введено некоректное значение");
            System.out.println("Введите кол-во человек");
            scanner.next();
        }
        int count = Math.abs(scanner.nextInt());
        Person[] persons = new Person[count];
        for(int i = 0; i < count; i++){
            System.out.println("Введите через пробел Имя и возраст");
            String line = "";
            while(line.isEmpty()) {
                line =  scanner.nextLine();
                if (!line.isEmpty()){
            try {
                String[] p = line.trim().split(" ");
                persons[i] = new Person(p[0].trim(), Math.abs(Integer.parseInt(p[1].trim())));
            } catch (Exception e) {
                line = "";
                System.out.println("Введено неверное значение");
            }}}
        }
        Arrays.sort(persons,(p1, p2) -> p1.get_name().compareTo(p2.get_name()));
        System.out.println("Пользователи старше 30 лет, отсортированные в алфавитном порядке:");
        for(Person per: persons){
            if(per.get_age() > 30)
                System.out.println(per.toString2());
        }


    }
}
class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public int get_age(){
        return this.age;}
    public String get_name(){
        return this.name;}
    public String toString2(){
        return name +" — " + age;}

}
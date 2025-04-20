import java.util.Scanner;

class Chicken{
    private String name;
    private int age;
    private boolean flag = true;
    public Chicken(String name, int age){
        setName(name);
        setAge(age);
    }
    private void setName(String name){
        if(name.isEmpty()){
            System.out.println("Имя не может быть пустым");this.flag = false;}
        else
            this.name = name;
    }
    private void setAge(int age){
        if(age > 0 & age <= 15)
            this.age = age;
        else{
            System.out.println("Возраст должен быть между 0 и 15");this.flag = false;}
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean getFlag(){
        return this.flag;
    }
    public double  productPerDay(){
        return calculateProductPerDay();
    }
    private double calculateProductPerDay(){
        if (getAge() < 6)
            return 2;
        if (getAge() >= 6 && getAge()<13)
            return 1;
        else
            return 0.75;
    }
}
public class Work_4_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Chicken chicken = null;
        System.out.println("Введите через пробел имя и возраст курицы");
        String line = "";
        while(line.isEmpty()) {
            line =  scanner.nextLine();
            if (!line.isEmpty()){
                try {
                    String[] p = line.trim().split(" ");
                    chicken = new Chicken(p[0].trim(), Math.abs(Integer.parseInt(p[1].trim())));
                } catch (Exception e) {
                    line = "";
                    System.out.println("Неверно введены имя и возраст, повторите ввод");
                }}}
        if(chicken.getFlag())
            System.out.println("Курица "+chicken.getName()+" (возраст "+chicken.getAge()+" лет) "+ "может производить "+chicken.productPerDay()+" яйцо(-а) в день");
    }
}
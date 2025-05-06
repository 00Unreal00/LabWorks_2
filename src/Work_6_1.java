import java.util.Scanner;

class Polygon{
    protected int[] sides = {};
    public Polygon(int[] sides){
        for(int i: sides){
            try {
            if(i <= 0)
                throw new IllegalArgumentException("Negative value to side length Negative value to side length "+i);
        } catch (IllegalArgumentException e) {
                System.err.println("Negative value to side length Negative value to side length "+i);
                System.exit(0);
            }
        }

        this.sides = sides;
    }
    private int getSidesCount(){
        return sides.length;
    }
    protected double getPerimeter(){
        double summa = 0;
        for(double i: sides)
            summa += i;
        return summa;
    }
    @Override
    public String toString(){
       return "Polygon contains "+ sides.length+" sides\nIts perimeter is "+getPerimeter();
    }
}
class Triangle extends Polygon {

    public Triangle(int[] sides) {
        super(sides);
        int summa = 0;
        for(int i: sides)
            summa += i;
        for (int i: sides) {
            try {
            if (i > summa - i)
                throw new IllegalArgumentException("Wrong value to side length " + i);
        } catch (IllegalArgumentException e) {
                System.err.println("Wrong value to side length " + i);
                System.exit(0);
            }
        }
    }

    private double getInRadius(){
        return 0.5*Math.pow((double) (-sides[0]+sides[1]+sides[2])*
                (sides[0]-sides[1]+sides[2])
                *(sides[0]+sides[1]-sides[2]) / (sides[0]+sides[1]+sides[2]), 0.5);
    }

    @Override
    public String toString(){
        return "Triangle contains 3 sides\n" +
                "Its perimeter is " +getPerimeter()+"\n" +
                "Its radius of incircle is " +String.format("%.2f",getInRadius());
    }
}


class Quadrilateral extends Polygon{
    public Quadrilateral(int[] sides) {
        super(sides);
        int summa = 0;
        for(int i: sides)
            summa += i;
        for (int i: sides) {
            try {
                if (i > summa - i)
                    throw new IllegalArgumentException("Wrong value to side length " + i);
            } catch (IllegalArgumentException e) {
                System.err.println("Wrong value to side length " + i);
                System.exit(0);
            }
        }
    }
}
class Parallelogram extends Quadrilateral{
    public Parallelogram(int[] sides) {
        super(sides);
    }
}
class Rhombus extends Parallelogram{

    public Rhombus(int[] sides) {
        super(sides);
    }
    @Override
    public String toString(){
        return
"Rhombus contains 4 equal sides\n"
        +"Its perimeter is "+getPerimeter();
    }
}
class Circle extends Polygon{

    public Circle(int[] sides) {
        super(sides);
    }
    @Override
    protected double getPerimeter(){
        return 2*Math.PI*sides[0];
    }
    private double getArea(){
        return Math.PI * Math.pow(sides[0], 2);
    }
    @Override
    public String toString(){
        return
        "Circle radius is " + sides[0]+
        "\nIts perimeter is " + String.format("%.2f",getPerimeter())+
        "\nIts area is " + String.format("%.2f",getArea());
    }
}
public class Work_6_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] line1;
        int[] line2;
        while (true) {
            try {
                System.out.println("Введите стороны(-у) фигуры через пробел");
                line1 = scanner.nextLine().split(" ");
                line2 = new int[line1.length];
                for (int i = 0; i < line1.length; i++) {
                    line2[i] = Integer.parseInt(line1[i]);
                }
                break;
            } catch (Exception e) {
                System.out.println("Неверный ввод");
            }
        }

        if (line1.length == 1)
            System.out.println(new Circle(line2));
        else if (line2.length == 3) {
            System.out.println(new Triangle(line2));
        } else if (checkParallelogram(line2) && line2.length==4) {
            System.out.println(new Parallelogram(line2));
        } else if (checkRhombus(line2) && line2.length==4) {
            System.out.println(new Rhombus(line2));
        } else if(line2.length >= 4)
            System.out.println(new Quadrilateral(line2));
        else
            throw new IllegalArgumentException("Invalid value to sides number");
    }
    public static boolean checkParallelogram(int[] line2){
        int cnt = 0;
        for(int i = 0; i < line2.length-1; i++){
            for(int j = i+1; j < line2.length; j++){
                if (line2[i] == line2[j])
                    cnt++;
            }}
            return cnt == 2;
    }
    public static boolean checkRhombus(int[] line2){
        int cnt = 0;
        for(int i = 0; i < line2.length-1; i++){
            if (line2[0] == line2[i])
                cnt++;
        }
        return cnt == 3;
    }
}
import java.util.Scanner;
import java.util.Locale;

public class Work_3_4 {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);
    double[] mass = new double[3];

    System.out.println("Введите длину: ");
    while (!scanner.hasNextDouble()){
        System.out.println("Введено некоректное значение");
        System.out.println("Введите длину: ");
        scanner.next();
    }
    mass[0] = Math.abs(scanner.nextDouble());
    System.out.println("Введите ширину: ");
    while (!scanner.hasNextDouble()){
        System.out.println("Введено некоректное значение");
        System.out.println("Введите ширину: ");
        scanner.next();
    }
    mass[1] = Math.abs(scanner.nextDouble());
    System.out.println("Введите высоту: ");
    while (!scanner.hasNextDouble()){
        System.out.println("Введено некоректное значение");
        System.out.println("Введите высоту: ");
        scanner.next();
    }
    mass[2] = Math.abs(scanner.nextDouble());
    Box b = new Box(mass[0], mass[1], mass[2]);
    System.out.println("Площадь поверхности — " + String.format("%.2f", b.calculateSurfaceArea())+
            "\nПлощадь боковой поверхности — " + String.format("%.2f",b.calculateLateralSurfaceArea())+
            "\nОбъём — "+ String.format("%.2f",b.calculateVolume()));
}
}
//class Box{
//    private final double length;
//    private final double width;
//    private final double height;
//    public Box(double length, double width, double height){
//        this.length = length;
//        this.width = width;
//        this.height = height;
//    }
//    public double calculateSurfaceArea (){
//        return 2*length*height + 2*width*height + 2*length*width;
//    }
//    public double calculateLateralSurfaceArea (){
//        return 2*length*height + 2*width*height;
//    }
//    public double calculateVolume() {
//        return length * height * width;
//    }
//}

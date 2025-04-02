import java.util.Scanner;
import java.util.Locale;


class Box{
    private double length;
    private double width;
    private double height;
    private boolean yes = true;
    public Box(double length, double width, double height){
        set_length(length);
        set_width(width);
        set_height(height);
    }
    private void set_length(double length) {
        if (length <= 0) {
            this.yes = false;
            System.out.println("Длина не может быть ноль или отрицательной.");
        }
        this.length = length;
    }
    private void set_width(double width) {
        if (width <= 0) {
            this.yes = false;
            System.out.println("Ширина не может быть ноль или отрицательной.");
        }
        this.width = width;
    }
    private void set_height(double height) {
        if (height <= 0) {
            this.yes = false;
            System.out.println("Высота не может быть ноль или отрицательной.");
        }
        this.height = height;
    }
    public boolean get_yes(){
        return this.yes;
    }
    public double calculateSurfaceArea (){
        return 2*length*height + 2*width*height + 2*length*width;
    }
    public double calculateLateralSurfaceArea (){
        return 2*length*height + 2*width*height;
    }
    public double calculateVolume() {
        return length * height * width;
    }
}


public class Work_4_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double[] mass = new double[3];

        System.out.println("Введите длину: ");
        while (!scanner.hasNextDouble()){
            System.out.println("Введено некорректное значение");
            System.out.println("Введите длину: ");
            scanner.next();
        }
        mass[0] = scanner.nextDouble();
        System.out.println("Введите ширину: ");
        while (!scanner.hasNextDouble()){
            System.out.println("Введено некорректное значение");
            System.out.println("Введите ширину: ");
            scanner.next();
        }
        mass[1] = scanner.nextDouble();
        System.out.println("Введите высоту: ");
        while (!scanner.hasNextDouble()){
            System.out.println("Введено некорректное значение");
            System.out.println("Введите высоту: ");
            scanner.next();
        }
        mass[2] = scanner.nextDouble();
        Box b = new Box(mass[0], mass[1], mass[2]);
        if (b.get_yes())
            System.out.println("Площадь поверхности — " + String.format("%.2f", b.calculateSurfaceArea())+
                    "\nПлощадь боковой поверхности — " + String.format("%.2f",b.calculateLateralSurfaceArea())+
                    "\nОбъём — "+ String.format("%.2f",b.calculateVolume()));
    }
}

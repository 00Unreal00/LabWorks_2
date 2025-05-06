import java.util.Scanner;

class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;}
    private void setFirstName(String firstName){
        if(!Character.isUpperCase(firstName.charAt(0))) {
            System.out.println("Имя должно начинатся с большой буквы");
            throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");
        }else if(firstName.length() < 4){
            System.out.println("Имя должно быть не менее 4 символов длиной");
            throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
        }
        else
            this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;}
    protected void setLastName(String lastName){
        if(!Character.isUpperCase(lastName.charAt(0))) {
            System.out.println("Фамилия должна начинатся с большой буквы");
            throw new IllegalArgumentException("Expected upper case letter! Argument: lastName");
        }else if(lastName.length() < 3){
            System.out.println("Фамилия должна быть не менее 3 символов длиной");
            throw new IllegalArgumentException("Expected length at least 3 symbols! Argument: lastName");
        }
        else
            this.lastName = lastName;
    }
}

class Student extends Human{
    private String facultyNumber;
    public Student(String firstName,String lastName,String facultyNumber){
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);

    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber){
        if(facultyNumber.length() <= 10 && facultyNumber.length()>=5){
            this.facultyNumber = facultyNumber;
        }
        else
            throw new IllegalArgumentException("Invalid faculty number!");
    }
    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                "Faculty number: " + getFacultyNumber();
    }
}

class Worker extends Human{
    private double weekSalary;
    private double workHoursPerDay;
    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay){
        super(firstName, lastName);
        setLastName(lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
    }
    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols! Argument: lastName");
        }
        else
            super.setLastName(lastName);
    }
    public double getWeekSalary() {
        return this.weekSalary;}

    private void setWeekSalary(double weekSalary){
        if(weekSalary <= 10)
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        else
            this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;}

    private void setWorkHoursPerDay(double workHoursPerDay){
        if(workHoursPerDay >= 1 && workHoursPerDay <=12)
            this.workHoursPerDay = workHoursPerDay;
        else
            throw new IllegalArgumentException("Expected value mismatch! Argument: workHoursPerDay");
    }
    @Override
    public String toString() {
        double salaryPerHour = weekSalary / (workHoursPerDay * 7);
        return "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                String.format("Week Salary: %.2f\n", weekSalary) +
                String.format("Hours per day: %.2f\n", workHoursPerDay) +
                String.format("Salary per hour: %.2f", salaryPerHour);
    }
}
public class Work_5_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] s;
        Student student;
        Worker worker;
        while (true){
        try {
        System.out.println("Введите через пробел Имя Фамилию и факультет");
        s = scanner.nextLine().split(" ");
        student = new Student(s[0],s[1],s[2]);
        break;}
        catch(Exception _){System.out.println("Повторите ввод");}
        }
        String[] w;
        while (true){
            try {
                System.out.println("Введите через пробел Имя Фамилию зарплату и кол-во рабочих часов");
                w = scanner.nextLine().split(" ");
                worker = new Worker(w[0],w[1], Double.parseDouble(w[2]), Double.parseDouble(w[3]));
                break;}
            catch(Exception _){System.out.println("Повторите ввод");}
        }
        System.out.println(student);
        System.out.println(worker);
    }
}

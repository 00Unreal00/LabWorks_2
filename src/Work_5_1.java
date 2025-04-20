import java.util.Scanner;

class Vehicle{
    private int passengers;
    public Vehicle(int passengers) throws Exception {
        setPassengers(passengers);
    }
    private void setPassengers(int passengers) throws Exception{
        if(passengers < 0){
            System.out.println("Количество пассажиров должно быть положительным");
            throw new Exception("Invalid negative number");
        }
        else if(passengers == 0){
            System.out.println("Необходим хотя бы один пассажир");
            throw new Exception("Need passengers to drive");

        }
        else
            this.passengers = passengers;

    }
    public int getPassengers() {
        return this.passengers;
    }
}
class Car extends Vehicle{
    private int horsePower;
    private String model;
    public Car(int passengers,int horsePower, String model) throws Exception{
        super(passengers);
        setHorsePower(horsePower);
        setModel(model);
    }
    private void setHorsePower(int horsePower) throws Exception{
        if(horsePower <= 0){
            System.out.println("Количество лошадиных сил должно быть положительным");
            throw new Exception("Invalid negative number");
        }
        else
            this.horsePower = horsePower;
    }
    private void setModel(String model) throws Exception {
        if (model.length() <2){
            System.out.println("Название должно быть не короче 2-х символов");
            throw new Exception("Invalid short value");

        }
        else
            this.model = model;}
    public int getHorsePower() {
        return horsePower;}
    public String getModel() {
        return model;}
}
class Boat extends Vehicle{
    private int oarsCount;
    public Boat(int passengers, int oarsCount) throws Exception {
        super(passengers);
        setOarsCount(oarsCount);
    }
    private void setOarsCount(int oarsCount) throws Exception{
        if(oarsCount < 0){
            System.out.println("Количество весел должно быть положительным");
            throw new Exception("Invalid negative number");
        }
        else if(oarsCount == 0){
            System.out.println("Количество весел не должно быть равно 0");
            throw new Exception("Need oars to swim");}
        else if(oarsCount > 2*getPassengers()){
            System.out.println("Количество весел не должно превышать количество рук пассажиров");
            throw new Exception("One too many oars");
        }
        else
            this.oarsCount = oarsCount;
    }
    public int getOarsCount() {
        return oarsCount;}
}
class Airplane extends Vehicle{
    private int wingsCount;
    private int enginesCount;
    private boolean isHydroplane;
    public Airplane(int passengers, int wingsCount, int enginesCount, boolean isHydroplane) throws Exception {
        super(passengers);
        setWingsCount(wingsCount);
        setEnginesCount(enginesCount);
        setHydroplane(isHydroplane);
    }

    public int getWingsCount() {
        return this.wingsCount;
    }

    private void setWingsCount(int wingsCount) throws Exception {
        if(wingsCount < 0){
            System.out.println("Количество крыльев аэроплана должно быть положительным");
            throw new Exception("Invalid negative number");
        }
        else if(wingsCount == 0){
            System.out.println("Необходимо хотя бы одно крыло для полета");
            throw new Exception("Need wings to fly");}
        else
            this.wingsCount = wingsCount;
    }

    public int getEnginesCount() {
        return this.enginesCount;
    }

    private void setEnginesCount(int enginesCount) throws Exception {
        if(enginesCount < 0){
            System.out.println("Количество двигателей аэроплана должно быть положительным");
            throw new Exception("Invalid negative number");
        }
        else if(enginesCount <= 8 || enginesCount == 10 || enginesCount == 12){
            this.enginesCount = enginesCount;}
        else{
            System.out.println("Количество двигателей в аэроплане может соответствовать значениям 0 – 8, 10 или 12 штук");
        throw new Exception("Invalid engines number");}
    }

    public boolean isHydroplane() {
        return isHydroplane;
    }

    private void setHydroplane(boolean isHydroplane) {
        this.isHydroplane = isHydroplane;
    }
}


public class Work_5_1 {
    public static void  main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Если автомобиль введите через запятую:
                Car, кол-во пассажиров, кол-во лошадиных сил, название модели
                Если лодка введите через запятую:
                Boat, кол-во пассажиров, кол-во вёсел
                Если самолёт, введите через запятую:
                Airplane, кол-во пассажиров, кол-во крыльев, кол-во двигателей,
                true - может садится на воду/ false не может
                """);
        String line = "";
        while(line.isEmpty()) {
            line =  scanner.nextLine();
            if (!line.isEmpty()){
                String[] line2 = line.trim().split(",");
                try {
                    switch (line2[0]){
                        case "Car":
                            Car car = new Car(Integer.parseInt(line2[1].trim()), Integer.parseInt(line2[2].trim()), line2[3].trim());
                            System.out.println(" In a Car "+car.getPassengers()+"passengers\n"+
                                    "With "+car.getHorsePower()+" horse power on "+car.getModel());
                            break;
                        case "Boat":
                            Boat boat = new Boat(Integer.parseInt(line2[1].trim()), Integer.parseInt(line2[2].trim()));
                            System.out.println("In a Boat "+boat.getPassengers()+" passengers\n" +
                                    "With "+boat.getOarsCount()+" oars");
                            break;
                        case "Airplane":
                            Airplane airplane = new Airplane(Integer.parseInt(line2[1].trim()), Integer.parseInt(line2[2].trim()), Integer.parseInt(line2[3].trim()), Boolean.parseBoolean(line2[4].trim().toLowerCase()));
                            if(airplane.isHydroplane()){
                                System.out.println("In a Hydroplane "+airplane.getPassengers()+" passengers\n"
                                        +"With "+airplane.getWingsCount()+" wings and "+airplane.getEnginesCount()+" engines");
                            }
                            else {
                                System.out.println("In a Airplane "+airplane.getPassengers()+" passengers\n"
                                        +"With "+airplane.getWingsCount()+" wings and "+airplane.getEnginesCount()+" engines");
                            }
                            break;}
                } catch (Exception e) {
                    line = "";
                    System.out.println("Неверно введены данные, повторите ввод");
                }}}
    }
}

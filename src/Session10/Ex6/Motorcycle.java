package Session10.Ex6;

public class Motorcycle extends MotorVehicle {

    public Motorcycle() {
        super();
    }

    public Motorcycle(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " (Motorcycle) engine starts: Brum Brum!");
    }

    public void doWheelie() {
        System.out.println(getBrand() + " is doing a wheelie!");
    }
}
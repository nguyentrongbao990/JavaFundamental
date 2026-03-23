package Session10.Ex6;

public class Car extends MotorVehicle {

    public Car() {
        super();
    }

    public Car(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " (Car) engine starts: Vroom Vroom!");
    }

    public void openTrunk() {
        System.out.println(getBrand() + " trunk is opening...");
    }
}
package Session10.Ex6;

public class Truck extends MotorVehicle {

    public Truck() {
        super();
    }

    public Truck(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " (Truck) engine starts: RRRRRR!");
    }

    public void loadCargo() {
        System.out.println(getBrand() + " is loading cargo...");
    }
}
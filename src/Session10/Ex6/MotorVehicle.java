package Session10.Ex6;

public class MotorVehicle extends Vehicle {
    private String fuelType;

    public MotorVehicle() {
        super();
        this.fuelType = "";
    }

    public MotorVehicle(String brand, int year, String fuelType) {
        super(brand, year);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Fuel Type: " + fuelType);
    }
}
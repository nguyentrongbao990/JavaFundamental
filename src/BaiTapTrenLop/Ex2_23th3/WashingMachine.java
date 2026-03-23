package BaiTapTrenLop.Ex2_23th3;

import java.util.Scanner;

public class WashingMachine extends Machine {
    private double capacity;
    private boolean hasDryer;

    public WashingMachine() {
        super();
        this.capacity = 0.0;
        this.hasDryer = false;
    }

    public WashingMachine(String model, String manufacturer, int yearOfManufacture, double power,
                          double capacity, boolean hasDryer) {
        super(model, manufacturer, yearOfManufacture, power);
        this.capacity = capacity;
        this.hasDryer = hasDryer;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean isHasDryer() {
        return hasDryer;
    }

    public void setHasDryer(boolean hasDryer) {
        this.hasDryer = hasDryer;
    }

    public void input(Scanner sc) {
        super.input(sc);

        System.out.print("Nhập dung tích máy giặt (kg): ");
        capacity = Double.parseDouble(sc.nextLine());

        System.out.print("Có tính năng sấy không? (true/false): ");
        hasDryer = Boolean.parseBoolean(sc.nextLine());
    }

    public void display() {
        System.out.println("===== THÔNG TIN MÁY GIẶT =====");
        super.display();
        System.out.println("Capacity: " + capacity + " kg");
        System.out.println("Has dryer: " + hasDryer);
    }
}

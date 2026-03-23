package BaiTapTrenLop.Ex2_23th3;

import java.util.Scanner;

public class AirConditioner extends Machine {
    private int coolingCapacity;
    private String energyEfficiency;

    public AirConditioner() {
        super();
        this.coolingCapacity = 0;
        this.energyEfficiency = "";
    }

    public AirConditioner(String model, String manufacturer, int yearOfManufacture, double power,
                          int coolingCapacity, String energyEfficiency) {
        super(model, manufacturer, yearOfManufacture, power);
        this.coolingCapacity = coolingCapacity;
        this.energyEfficiency = energyEfficiency;
    }

    public int getCoolingCapacity() {
        return coolingCapacity;
    }

    public void setCoolingCapacity(int coolingCapacity) {
        this.coolingCapacity = coolingCapacity;
    }

    public String getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(String energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    public void input(Scanner sc) {
        super.input(sc);

        System.out.print("Nhập công suất làm lạnh (BTU): ");
        coolingCapacity = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập hiệu suất năng lượng: ");
        energyEfficiency = sc.nextLine();
    }

    public void display() {
        System.out.println("===== THÔNG TIN ĐIỀU HÒA =====");
        super.display();
        System.out.println("Cooling capacity: " + coolingCapacity + " BTU");
        System.out.println("Energy efficiency: " + energyEfficiency);
    }
}

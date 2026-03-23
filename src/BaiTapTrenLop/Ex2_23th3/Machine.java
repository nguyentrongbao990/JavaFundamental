package BaiTapTrenLop.Ex2_23th3;

import java.util.Scanner;

public class Machine {
    private String model;
    private String manufacturer;
    private int yearOfManufacture;
    private double power;

    public Machine() {
        this.model = "";
        this.manufacturer = "";
        this.yearOfManufacture = 0;
        this.power = 0.0;
    }

    public Machine(String model, String manufacturer, int yearOfManufacture, double power) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void input(Scanner sc) {
        System.out.print("Nhập model: ");
        model = sc.nextLine();

        System.out.print("Nhập nhà sản xuất: ");
        manufacturer = sc.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        yearOfManufacture = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập công suất (kW): ");
        power = Double.parseDouble(sc.nextLine());
    }

    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year of manufacture: " + yearOfManufacture);
        System.out.println("Power: " + power + " kW");
    }
}
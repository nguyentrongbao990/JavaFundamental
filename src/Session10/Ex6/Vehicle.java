package Session10.Ex6;

public class Vehicle {
    private String brand;
    private int year;

    public Vehicle() {
        this.brand = "";
        this.year = 0;
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }

    public void startEngine() {
        System.out.println(brand + " engine starts.");
    }

    // Overloading
    public void move() {
        System.out.println(brand + " is moving.");
    }

    public void move(int speed) {
        System.out.println(brand + " is moving at " + speed + " km/h.");
    }
}
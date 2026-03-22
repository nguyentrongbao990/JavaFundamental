package Session8.Ex6;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;

    private static int AUTO_ID = 1;
    private final String WAREHOUSE_CODE = "KHO-01";

    public Product() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public void input(Scanner input) {
        System.out.print("Nhập tên sản phẩm: ");
        this.name = input.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        this.price = Double.parseDouble(input.nextLine());
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Mã kho: " + WAREHOUSE_CODE);
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalProduct() {
        return AUTO_ID - 1;
    }
}
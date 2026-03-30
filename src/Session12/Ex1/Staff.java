package Session12.Ex1;

import java.util.Scanner;

public abstract class Staff {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Staff() {
    }

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        while (id == null || id.trim().isEmpty()) {
            System.out.println("ID không được để trống.");
            return;
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        while (name == null || name.trim().isEmpty()) {
            System.out.println("Tên không được để trống.");
            return;
        }
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Lương cơ bản phải lớn hơn 0.");
        }
    }

    public void inputBasicInfo(Scanner scanner) {
        this.id = inputId(scanner);
        this.name = inputName(scanner);
        this.baseSalary = inputBaseSalary(scanner);
    }

    protected String inputId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập id: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("ID không được để trống.");
        }
    }

    protected String inputName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Tên không được để trống.");
        }
    }

    protected double inputBaseSalary(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập lương cơ bản: ");
                double salary = Double.parseDouble(scanner.nextLine().trim());
                if (salary > 0) {
                    return salary;
                }
                System.out.println("Lương cơ bản phải > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
    }

    public abstract double calculateTotalSalary();
}
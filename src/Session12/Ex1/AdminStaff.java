package Session12.Ex1;

import java.util.Scanner;

public class AdminStaff extends Staff implements ICapability {
    private double bonus;

    public AdminStaff() {
    }

    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        } else {
            System.out.println("Thưởng không hợp lệ.");
        }
    }

    public void inputData(Scanner scanner) {
        inputBasicInfo(scanner);
        this.bonus = inputBonus(scanner);
    }

    public double inputBonus(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập thưởng: ");
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("Thưởng phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        if (bonus >= 1000000) {
            System.out.println("Hiệu suất: Nhân viên hành chính làm việc tốt.");
        } else {
            System.out.println("Hiệu suất: Nhân viên hành chính đạt mức cơ bản.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Loại nhân sự: Nhân viên hành chính");
        super.displayInfo();
        System.out.println("Thưởng: " + bonus);
        System.out.println("Tổng lương: " + calculateTotalSalary());
    }
}
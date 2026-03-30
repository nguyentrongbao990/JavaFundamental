package Session12.Ex1;

import java.util.Scanner;

public class Lecturer extends Staff implements ICapability {
    private int teachingHours;

    public Lecturer() {
    }

    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        if (teachingHours >= 0) {
            this.teachingHours = teachingHours;
        } else {
            System.out.println("Số giờ dạy không hợp lệ.");
        }
    }

    public void inputData(Scanner scanner) {
        inputBasicInfo(scanner);
        this.teachingHours = inputTeachingHours(scanner);
    }

    public int inputTeachingHours(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập số giờ dạy: ");
                int hours = Integer.parseInt(scanner.nextLine().trim());
                if (hours >= 0) {
                    return hours;
                }
                System.out.println("Số giờ dạy phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + teachingHours * 200000;
    }

    @Override
    public void checkPerformance() {
        if (teachingHours >= 20) {
            System.out.println("Hiệu suất: Giảng viên hoàn thành tốt.");
        } else {
            System.out.println("Hiệu suất: Giảng viên cần tăng số giờ dạy.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Loại nhân sự: Giảng viên");
        super.displayInfo();
        System.out.println("Số giờ dạy: " + teachingHours);
        System.out.println("Tổng lương: " + calculateTotalSalary());
    }
}
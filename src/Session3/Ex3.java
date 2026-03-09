package Session3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Double> salaries = new ArrayList<>();
    static DecimalFormat df = new DecimalFormat("#,###");

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    enterSalaries();
                    break;
                case 2:
                    showStatistics();
                    break;
                case 3:
                    calculateTotalBonus();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Nhập lương nhân viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Tính tổng số tiền thưởng nhân viên");
        System.out.println("4. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static int readMenuChoice() {
        while (true) {
            String line = input.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.print("Lựa chọn không hợp lệ (chỉ từ 1-4). Nhập lại: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Lựa chọn không hợp lệ (phải là số). Nhập lại: ");
            }
        }
    }

    public static void enterSalaries() {
        System.out.println("\n--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");

        while (true) {
            System.out.print("Nhập lương: ");
            String line = input.nextLine().trim();

            double salary;
            try {
                salary = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Lương không hợp lệ. Nhập lại.");
                continue;
            }

            if (salary == -1) {
                break;
            }

            if (salary < 0 || salary > 500_000_000) {
                System.out.println("Lương không hợp lệ. Lương phải từ 0 đến 500,000,000.");
                continue;
            }

            salaries.add(salary);
            System.out.println("-> Phân loại: " + classifySalary(salary));
        }
    }

    public static String classifySalary(double salary) {
        if (salary < 5_000_000) {
            return "Thấp";
        } else if (salary < 15_000_000) {
            return "Trung bình";
        } else if (salary <= 50_000_000) {
            return "Khá";
        } else {
            return "Cao";
        }
    }

    public static void showStatistics() {
        System.out.println("\n--- Thống kê ---");

        if (salaries.isEmpty()) {
            System.out.println("Chưa có dữ liệu.");
            return;
        }

        int count = salaries.size();
        double totalSalary = 0;
        double min = salaries.get(0);
        double max = salaries.get(0);

        for (double salary : salaries) {
            totalSalary += salary;

            if (salary < min) {
                min = salary;
            }

            if (salary > max) {
                max = salary;
            }
        }

        double average = totalSalary / count;

        System.out.println("Số nhân viên đã nhập: " + count);
        System.out.println("Tổng lương: " + formatMoney(totalSalary));
        System.out.println("Lương trung bình: " + formatMoney(average));
        System.out.println("Lương cao nhất: " + formatMoney(max));
        System.out.println("Lương thấp nhất: " + formatMoney(min));
    }

    public static void calculateTotalBonus() {
        System.out.println("\n--- Tính tổng số tiền thưởng nhân viên ---");

        if (salaries.isEmpty()) {
            System.out.println("Chưa có dữ liệu.");
            return;
        }

        double totalBonus = 0;

        for (double salary : salaries) {
            totalBonus += salary * getBonusRate(salary);
        }

        System.out.println("Tổng tiền thưởng nhân viên: " + formatMoney(totalBonus));
    }

    public static double getBonusRate(double salary) {
        if (salary < 5_000_000) {
            return 0.05;
        } else if (salary < 15_000_000) {
            return 0.10;
        } else if (salary < 50_000_000) {
            return 0.15;
        } else if (salary <= 100_000_000) {
            return 0.20;
        } else {
            return 0.25;
        }
    }

    public static String formatMoney(double money) {
        return df.format(money) + " VND";
    }
}
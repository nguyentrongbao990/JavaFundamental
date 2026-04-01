package Session13.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n============== MENU ==============");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("0. Thoát chương trình");
            System.out.println("==================================");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    inputStudentList();
                    break;
                case "2":
                    displayStudentList();
                    break;
                case "3":
                    searchStudentByName();
                    break;
                case "4":
                    classifyStudents();
                    break;
                case "0":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void inputStudentList() {
        int n;
        while (true) {
            try {
                System.out.print("Nhập số lượng sinh viên muốn thêm: ");
                n = Integer.parseInt(scanner.nextLine().trim());
                if (n > 0) {
                    break;
                }
                System.out.println("Số lượng phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1) + ":");
            String name = inputName();
            double gpa = inputGpa();

            Student student = new Student(name, gpa);
            studentList.add(student);
        }

        System.out.println("Thêm danh sách sinh viên thành công.");
    }

    private static void displayStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        System.out.println("\n===== DANH SÁCH SINH VIÊN =====");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void searchStudentByName() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        System.out.print("Nhập tên sinh viên cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("Tên tìm kiếm không được để trống.");
            return;
        }

        boolean found = false;
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(keyword)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào.");
        }
    }

    private static void classifyStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        System.out.println("\n===== PHÂN LOẠI SINH VIÊN THEO GPA =====");
        for (Student student : studentList) {
            System.out.println("ID: " + student.getId()
                    + " | Họ tên: " + student.getName()
                    + " | GPA: " + String.format("%.2f", student.getGpa())
                    + " | Xếp loại: " + student.getRank());
        }
    }

    private static String inputName() {
        while (true) {
            System.out.print("Nhập họ tên sinh viên: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Tên sinh viên không được để trống.");
        }
    }

    private static double inputGpa() {
        while (true) {
            try {
                System.out.print("Nhập GPA (0 - 10): ");
                double gpa = Double.parseDouble(scanner.nextLine().trim());
                if (gpa >= 0 && gpa <= 10) {
                    return gpa;
                }
                System.out.println("GPA phải nằm trong khoảng từ 0 đến 10.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }
}
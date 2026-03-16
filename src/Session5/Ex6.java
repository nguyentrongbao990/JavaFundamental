package Session5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();

        while (true) {
            System.out.println("\n==================== QUẢN LÝ TÊN SINH VIÊN ====================");
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào");
            System.out.println("5. Sắp xếp danh sách tên theo thứ tự A-Z");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = input.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Tên không được để trống.");
                    } else {
                        students.add(name);
                        System.out.println("Đã thêm: " + name);
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống.");
                    } else {
                        System.out.println("Danh sách sinh viên:");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống.");
                        break;
                    }

                    System.out.print("Nhập từ khóa cần tìm: ");
                    String keyword = input.nextLine().trim().toLowerCase();
                    boolean found = false;

                    System.out.println("Kết quả tìm kiếm:");
                    for (String student : students) {
                        if (student.toLowerCase().contains(keyword)) {
                            System.out.println("- " + student);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên nào.");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống.");
                        break;
                    }

                    System.out.print("Nhập chữ cái cần đếm: ");
                    String letterInput = input.nextLine().trim().toLowerCase();

                    if (letterInput.isEmpty()) {
                        System.out.println("Bạn chưa nhập chữ cái.");
                        break;
                    }

                    char firstChar = letterInput.charAt(0);
                    int count = 0;

                    for (String student : students) {
                        String trimmedName = student.trim().toLowerCase();
                        if (!trimmedName.isEmpty() && trimmedName.charAt(0) == firstChar) {
                            count++;
                        }
                    }

                    System.out.println("Số sinh viên có tên bắt đầu bằng '" + firstChar + "': " + count);
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống.");
                    } else {
                        Collections.sort(students, String.CASE_INSENSITIVE_ORDER);
                        System.out.println("Danh sách đã được sắp xếp A-Z.");
                    }
                    break;

                case 6:
                    System.out.println("Tạm biệt!");
                    input.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
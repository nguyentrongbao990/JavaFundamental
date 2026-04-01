package Session13.Ex2;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AttendanceManager manager = new AttendanceManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*************** MENU QUẢN LÝ ĐIỂM DANH ***************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    displayStudents();
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 5.");
            }
        }
    }

    private static void addStudent() {
        int id = inputStudentId();

        if (manager.isDuplicateId(id)) {
            System.out.println("ID sinh viên đã tồn tại.");
            return;
        }

        String name = inputStudentName();
        Student student = new Student(id, name);
        manager.add(student);

        System.out.println("Sinh viên đã được thêm thành công.");
    }

    private static void updateStudent() {
        if (manager.size() == 0) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        manager.display();
        int id = inputPositiveInt("Nhập id sinh viên cần sửa: ");
        int index = manager.findIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        String newName = inputStudentName("Nhập tên mới sinh viên: ");
        Student updatedStudent = new Student(id, newName);
        manager.update(index, updatedStudent);

        System.out.println("Sinh viên đã được sửa thành công.");
    }

    private static void deleteStudent() {
        if (manager.size() == 0) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        manager.display();
        int id = inputPositiveInt("Nhập id sinh viên cần xóa: ");
        int index = manager.findIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        manager.delete(index);
        System.out.println("Đã xóa thành công sinh viên.");
    }

    private static void displayStudents() {
        manager.display();
    }

    private static int inputStudentId() {
        return inputPositiveInt("Nhập id sinh viên: ");
    }

    private static int inputPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("Giá trị phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static String inputStudentName() {
        return inputStudentName("Nhập tên sinh viên: ");
    }

    private static String inputStudentName(String message) {
        while (true) {
            System.out.print(message);
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Tên sinh viên không được để trống.");
        }
    }
}
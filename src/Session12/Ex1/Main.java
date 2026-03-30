package Session12.Ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Staff> staffList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ NHÂN SỰ EDUCAREER =========");
            System.out.println("1. Thêm mới");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStaff();
                    break;
                case "2":
                    displayStaffList();
                    break;
                case "3":
                    updateStaff();
                    break;
                case "4":
                    deleteStaff();
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void addStaff() {
        System.out.println("\n--- THÊM MỚI NHÂN SỰ ---");
        System.out.println("1. Thêm Giảng viên");
        System.out.println("2. Thêm Nhân viên hành chính");
        System.out.print("Chọn loại nhân sự: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                Lecturer lecturer = new Lecturer();
                lecturer.inputData(scanner);
                if (findById(lecturer.getId()) != null) {
                    System.out.println("ID đã tồn tại.");
                    return;
                }
                staffList.add(lecturer);
                System.out.println("Đã thêm giảng viên.");
                break;
            case "2":
                AdminStaff admin = new AdminStaff();
                admin.inputData(scanner);
                if (findById(admin.getId()) != null) {
                    System.out.println("ID đã tồn tại.");
                    return;
                }
                staffList.add(admin);
                System.out.println("Đã thêm nhân viên hành chính.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void displayStaffList() {
        if (staffList.isEmpty()) {
            System.out.println("Danh sách nhân sự trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH NHÂN SỰ ---");
        for (Staff staff : staffList) {
            staff.displayInfo();
            if (staff instanceof ICapability) {
                ((ICapability) staff).checkPerformance();
            }
            System.out.println("--------------------------------");
        }
    }

    public static void updateStaff() {
        System.out.print("Nhập id cần cập nhật: ");
        String id = scanner.nextLine().trim();

        Staff staff = findById(id);
        if (staff == null) {
            System.out.println("Không tìm thấy nhân sự.");
            return;
        }

        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine().trim();
        while (newName.isEmpty()) {
            System.out.print("Tên không được để trống. Nhập lại: ");
            newName = scanner.nextLine().trim();
        }
        staff.setName(newName);

        double newBaseSalary;
        while (true) {
            try {
                System.out.print("Nhập lương cơ bản mới: ");
                newBaseSalary = Double.parseDouble(scanner.nextLine().trim());
                if (newBaseSalary > 0) {
                    break;
                }
                System.out.println("Lương cơ bản phải > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
        staff.setBaseSalary(newBaseSalary);

        if (staff instanceof Lecturer) {
            Lecturer lecturer = (Lecturer) staff;
            lecturer.setTeachingHours(lecturer.inputTeachingHours(scanner));
        } else if (staff instanceof AdminStaff) {
            AdminStaff admin = (AdminStaff) staff;
            admin.setBonus(admin.inputBonus(scanner));
        }

        System.out.println("Cập nhật thành công.");
    }

    public static void deleteStaff() {
        System.out.print("Nhập id cần xóa: ");
        String id = scanner.nextLine().trim();

        Staff staff = findById(id);
        if (staff == null) {
            System.out.println("Không tìm thấy nhân sự.");
            return;
        }

        staffList.remove(staff);
        System.out.println("Xóa thành công.");
    }

    public static Staff findById(String id) {
        for (Staff staff : staffList) {
            if (staff.getId().equalsIgnoreCase(id)) {
                return staff;
            }
        }
        return null;
    }
}
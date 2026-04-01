package Session13.Ex6;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactManager manager = new ContactManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo số điện thoại");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("0. Thoát");
            System.out.println("======================================");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    removeContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    manager.displayAll();
                    break;
                case "0":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addContact() {
        String name = inputNotEmpty("Nhập tên liên lạc: ");
        String phone = inputNotEmpty("Nhập số điện thoại: ");

        Contact contact = new Contact(name, phone);
        manager.addContact(contact);
    }

    private static void removeContact() {
        if (manager.isEmpty()) {
            System.out.println("Danh bạ đang trống.");
            return;
        }

        String phone = inputNotEmpty("Nhập số điện thoại cần xóa: ");
        manager.removeByPhone(phone);
    }

    private static void searchContact() {
        if (manager.isEmpty()) {
            System.out.println("Danh bạ đang trống.");
            return;
        }

        String phone = inputNotEmpty("Nhập số điện thoại cần tìm: ");
        Contact contact = manager.searchByPhone(phone);

        if (contact != null) {
            System.out.println("Tìm thấy liên lạc:");
            System.out.println(contact);
        } else {
            System.out.println("Không tồn tại liên lạc.");
        }
    }

    private static String inputNotEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Vui lòng không để trống.");
        }
    }
}
package Session13.Ex1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static final LinkedList<Person> personList = new LinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n************** MENU QUẢN LÝ NGƯỜI DÙNG **************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    deletePersonByEmail();
                    break;
                case "3":
                    displayPersonList();
                    break;
                case "4":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 4.");
            }
        }
    }

    private static void addPerson() {
        String name = inputNotEmpty("Nhập tên người dùng: ");
        String email = inputNotEmpty("Nhập email người dùng: ");
        String phone = inputNotEmpty("Nhập số điện thoại người dùng: ");

        Person person = new Person(name, email, phone);
        personList.add(person);

        System.out.println("Người dùng đã được thêm thành công.");
    }

    private static void deletePersonByEmail() {
        if (personList.isEmpty()) {
            System.out.println("Danh sách người dùng đang trống.");
            return;
        }

        String email = inputNotEmpty("Nhập email người dùng để xóa: ");

        Person foundPerson = null;
        for (Person person : personList) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                foundPerson = person;
                break;
            }
        }

        if (foundPerson != null) {
            personList.remove(foundPerson);
            System.out.println("Người dùng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy người dùng với email này.");
        }
    }

    private static void displayPersonList() {
        if (personList.isEmpty()) {
            System.out.println("Danh sách người dùng đang trống.");
            return;
        }

        System.out.println("Danh sách người dùng:");
        for (Person person : personList) {
            person.displayData();
        }
    }

    private static String inputNotEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Vui lòng không để trống!");
        }
    }
}
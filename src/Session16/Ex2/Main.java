package Session16.Ex2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager manager = new EventManager();

        int choice;

        do {
            showMenu();

            try {
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addEvent(scanner, manager);
                        break;
                    case 2:
                        manager.displayEvents();
                        break;
                    case 3:
                        manager.checkEventStatus();
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n========= EVENT MENU =========");
        System.out.println("1. Thêm sự kiện");
        System.out.println("2. Hiển thị danh sách sự kiện");
        System.out.println("3. Kiểm tra trạng thái sự kiện");
        System.out.println("0. Thoát");
        System.out.println("==============================");
    }

    public static void addEvent(Scanner scanner, EventManager manager) {
        String name;

        while (true) {
            System.out.print("Nhập tên sự kiện: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Lỗi: Tên sự kiện không được để trống!");
            } else {
                break;
            }
        }

        LocalDateTime startDate = inputDateTime(scanner, "Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");

        LocalDateTime endDate;
        while (true) {
            endDate = inputDateTime(scanner, "Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");

            if (endDate.isBefore(startDate) || endDate.isEqual(startDate)) {
                System.out.println("Lỗi: Thời gian kết thúc phải sau thời gian bắt đầu!");
            } else {
                break;
            }
        }

        Event event = new Event(name, startDate, endDate);
        manager.addEvent(event);

        System.out.println("Thêm sự kiện thành công.");
    }

    public static LocalDateTime inputDateTime(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                return LocalDateTime.parse(input, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Vui lòng nhập đúng định dạng dd/MM/yyyy HH:mm!");
            }
        }
    }
}
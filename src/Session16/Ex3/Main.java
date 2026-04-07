package Session16.Ex3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatManager chatManager = new ChatManager();

        int choice;

        do {
            showMenu();

            try {
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        sendMessage(scanner, chatManager);
                        break;
                    case 2:
                        chatManager.showChatHistory();
                        break;
                    case 3:
                        filterBySender(scanner, chatManager);
                        break;
                    case 4:
                        filterByDate(scanner, chatManager);
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
        System.out.println("\n========= CHAT MENU =========");
        System.out.println("1. Gửi tin nhắn");
        System.out.println("2. Xem lịch sử chat");
        System.out.println("3. Lọc tin nhắn theo người gửi");
        System.out.println("4. Lọc tin nhắn theo ngày");
        System.out.println("0. Thoát");
        System.out.println("=============================");
    }

    public static void sendMessage(Scanner scanner, ChatManager chatManager) {
        String sender;
        String content;

        while (true) {
            System.out.print("Nhập tên người gửi: ");
            sender = scanner.nextLine().trim();

            if (sender.isEmpty()) {
                System.out.println("Lỗi: Tên người gửi không được để trống!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Nhập nội dung tin nhắn: ");
            content = scanner.nextLine().trim();

            if (content.isEmpty()) {
                System.out.println("Lỗi: Nội dung tin nhắn không được để trống!");
            } else {
                break;
            }
        }

        chatManager.sendMessage(sender, content);
        System.out.println("Gửi tin nhắn thành công.");
    }

    public static void filterBySender(Scanner scanner, ChatManager chatManager) {
        System.out.print("Nhập tên người gửi cần lọc: ");
        String sender = scanner.nextLine().trim();

        List<Message> result = chatManager.filterBySender(sender);

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn của người gửi này.");
            return;
        }

        System.out.println("Tin nhắn của " + sender + ":");
        result.forEach(System.out::println);
    }

    public static void filterByDate(Scanner scanner, ChatManager chatManager) {
        try {
            System.out.print("Nhập ngày cần lọc (dd/MM/yyyy): ");
            String inputDate = scanner.nextLine();

            LocalDate date = LocalDate.parse(inputDate, DATE_FORMATTER);
            List<Message> result = chatManager.filterByDate(date);

            if (result.isEmpty()) {
                System.out.println("Không có tin nhắn nào trong ngày này.");
                return;
            }

            System.out.println("Tin nhắn trong ngày " + inputDate + ":");
            result.forEach(System.out::println);

        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Ngày phải đúng định dạng dd/MM/yyyy!");
        }
    }
}
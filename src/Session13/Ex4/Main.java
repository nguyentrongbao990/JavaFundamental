package Session13.Ex4;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OrderManager manager = new OrderManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*************** MENU QUẢN LÝ ĐƠN HÀNG ***************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addOrder();
                    break;
                case "2":
                    updateOrder();
                    break;
                case "3":
                    deleteOrder();
                    break;
                case "4":
                    displayOrders();
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 5.");
            }
        }
    }

    private static void addOrder() {
        String orderCode = inputNotEmpty("Nhập mã đơn hàng: ");

        if (manager.isDuplicateOrderCode(orderCode)) {
            System.out.println("Mã đơn hàng đã tồn tại.");
            return;
        }

        String customerName = inputNotEmpty("Nhập tên khách hàng: ");
        Order order = new Order(orderCode, customerName);
        manager.add(order);

        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    private static void updateOrder() {
        if (manager.size() == 0) {
            System.out.println("Danh sách đơn hàng đang trống.");
            return;
        }

        manager.display();
        String orderCode = inputNotEmpty("Nhập mã đơn hàng cần sửa: ");
        int index = manager.findIndexByOrderCode(orderCode);

        if (index == -1) {
            System.out.println("Không tìm thấy đơn hàng.");
            return;
        }

        String newCustomerName = inputNotEmpty("Nhập tên khách hàng mới: ");
        Order updatedOrder = new Order(orderCode, newCustomerName);
        manager.update(index, updatedOrder);

        System.out.println("Đơn hàng đã được sửa thành công.");
    }

    private static void deleteOrder() {
        if (manager.size() == 0) {
            System.out.println("Danh sách đơn hàng đang trống.");
            return;
        }

        manager.display();
        String orderCode = inputNotEmpty("Nhập mã đơn hàng cần xóa: ");
        int index = manager.findIndexByOrderCode(orderCode);

        if (index == -1) {
            System.out.println("Không tìm thấy đơn hàng.");
            return;
        }

        manager.delete(index);
        System.out.println("Đơn hàng đã được xóa thành công.");
    }

    private static void displayOrders() {
        manager.display();
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
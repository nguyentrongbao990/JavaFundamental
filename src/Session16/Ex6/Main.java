package Session16.Ex6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, "Nguyen Van A", LocalDate.of(2025, 3, 15), LocalDate.of(2025, 3, 18)));
        orders.add(new Order(2, "Tran Thi B", LocalDate.of(2025, 3, 16), null));
        orders.add(new Order(3, "Le Van C", LocalDate.of(2025, 3, 17), LocalDate.of(2025, 3, 20)));
        orders.add(new Order(4, "Pham Thi D", LocalDate.of(2025, 3, 18), LocalDate.of(2025, 3, 23)));
        orders.add(new Order(5, "Hoang Van E", LocalDate.of(2025, 3, 19), null));

        System.out.println("===== DANH SÁCH TẤT CẢ ĐƠN HÀNG =====");
        printOrders(orders);

        List<Order> deliveredOrders = orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent())
                .collect(Collectors.toList());

        System.out.println("\n===== ĐƠN HÀNG ĐÃ ĐƯỢC GIAO =====");
        printOrders(deliveredOrders);

        List<Order> undeliveredOrders = orders.stream()
                .filter(order -> !order.getDeliveryDate().isPresent())
                .collect(Collectors.toList());

        System.out.println("\n===== ĐƠN HÀNG CHƯA ĐƯỢC GIAO =====");
        printOrders(undeliveredOrders);

        LocalDate fromDate = LocalDate.of(2025, 3, 17);
        LocalDate toDate = LocalDate.of(2025, 3, 23);

        long countDeliveredInRange = orders.stream()
                .filter(order -> order.getDeliveryDate()
                        .filter(date -> !date.isBefore(fromDate) && !date.isAfter(toDate))
                        .isPresent())
                .count();

        System.out.println("\n===== THỐNG KÊ =====");
        System.out.println("Số đơn hàng đã giao trong khoảng từ 2025-03-17 đến 2025-03-23: "
                + countDeliveredInRange);
    }

    public static void printOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
            return;
        }

        System.out.println("ID | Tên KH | Ngày đặt | Ngày giao");
        for (Order order : orders) {
            System.out.println(order.toDisplayString());
        }
    }
}
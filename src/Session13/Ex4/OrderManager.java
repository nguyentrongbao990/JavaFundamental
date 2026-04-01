package Session13.Ex4;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private final ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void add(Order item) {
        orders.add(item);
    }

    @Override
    public void update(int index, Order item) {
        if (index >= 0 && index < orders.size()) {
            orders.set(index, item);
        } else {
            System.out.println("Vị trí cập nhật không hợp lệ.");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
        } else {
            System.out.println("Vị trí xóa không hợp lệ.");
        }
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng đang trống.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i));
        }
    }

    public int findIndexByOrderCode(String orderCode) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderCode().equalsIgnoreCase(orderCode)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isDuplicateOrderCode(String orderCode) {
        return findIndexByOrderCode(orderCode) != -1;
    }

    public int size() {
        return orders.size();
    }
}
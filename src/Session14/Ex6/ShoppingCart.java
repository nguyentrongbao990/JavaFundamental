package Session14.Ex6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addToCart(Product product, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Lỗi: Số lượng không hợp lệ!");
        }

        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId) throws Exception {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(productId)) {
                items.remove(item);
                return;
            }
        }
        throw new Exception("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }

        System.out.println("===== GIỎ HÀNG =====");
        for (CartItem item : items) {
            System.out.println("Mã SP: " + item.getProduct().getId()
                    + " | Tên SP: " + item.getProduct().getName()
                    + " | Giá: " + item.getProduct().getPrice()
                    + " | Số lượng: " + item.getQuantity()
                    + " | Thành tiền: " + item.getSubtotal());
        }
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng đang trống. Không thể thanh toán.");
            return;
        }

        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }

        System.out.println("Tổng tiền cần thanh toán: " + total + " đồng");
    }
}
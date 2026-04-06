package Session14.Ex6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("P01", "Bút bi", 5000));
        productList.add(new Product("P02", "Vở", 10000));
        productList.add(new Product("P03", "Thước", 7000));
        productList.add(new Product("P04", "Tẩy", 3000));

        ShoppingCart cart = new ShoppingCart();

        int choice;

        do {
            System.out.println("\n============ MENU ============");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("0. Thoát");
            System.out.println("==============================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("===== DANH SÁCH SẢN PHẨM =====");
                        for (Product product : productList) {
                            System.out.println(product);
                        }
                        break;

                    case 2:
                        System.out.print("Nhập mã sản phẩm cần thêm: ");
                        String addId = scanner.nextLine();

                        Product foundProduct = findProductById(productList, addId);
                        if (foundProduct == null) {
                            System.out.println("Lỗi: Không tìm thấy sản phẩm!");
                            break;
                        }

                        System.out.print("Nhập số lượng: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        cart.addToCart(foundProduct, quantity);
                        System.out.println("Thêm vào giỏ hàng thành công!");
                        break;

                    case 3:
                        System.out.print("Nhập mã sản phẩm cần xóa khỏi giỏ: ");
                        String removeId = scanner.nextLine();

                        cart.removeFromCart(removeId);
                        System.out.println("Xóa sản phẩm khỏi giỏ hàng thành công!");
                        break;

                    case 4:
                        cart.displayCart();
                        break;

                    case 5:
                        cart.displayCart();
                        cart.checkout();
                        break;

                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập đúng kiểu dữ liệu!");
                scanner.nextLine();
                choice = -1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
    }

    public static Product findProductById(List<Product> productList, String id) {
        for (Product product : productList) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }
}
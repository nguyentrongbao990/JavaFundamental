package Session15.Ex3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final List<Product> productList = new ArrayList<>();
    private static final Map<String, Order> orderMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dữ liệu mẫu
        productList.add(new Product(1, "Chuột", 150000));
        productList.add(new Product(2, "Bàn phím", 300000));
        productList.add(new Product(3, "Tai nghe", 450000));

        int choice = -1;

        do {
            showMenu();
            try {
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addProduct(scanner);
                        break;
                    case 2:
                        removeProduct(scanner);
                        break;
                    case 3:
                        displayProducts();
                        break;
                    case 4:
                        createOrder(scanner);
                        break;
                    case 5:
                        addProductToOrder(scanner);
                        break;
                    case 6:
                        displayOrder(scanner);
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập đúng kiểu số!");
            } catch (InvalidProductPriceException
                     | ProductNotFoundException
                     | OrderNotFoundException e) {
                System.out.println("Lỗi: " + e.getMessage());
            } finally {
                System.out.println("----------------------------------------");
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\n============= MENU =============");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Hiển thị sản phẩm");
        System.out.println("4. Tạo đơn hàng");
        System.out.println("5. Thêm sản phẩm vào đơn hàng");
        System.out.println("6. Hiển thị đơn hàng");
        System.out.println("0. Thoát");
        System.out.println("================================");
    }

    public static void addProduct(Scanner scanner) throws InvalidProductPriceException {
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (findProductById(id) != null) {
            System.out.println("Sản phẩm đã tồn tại id này!");
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (price <= 0) {
            throw new InvalidProductPriceException("Giá sản phẩm phải lớn hơn 0!");
        }

        productList.add(new Product(id, name, price));
        System.out.println("Thêm sản phẩm thành công.");
    }

    public static void removeProduct(Scanner scanner) throws ProductNotFoundException {
        System.out.print("Nhập id sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = findProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có id = " + id);
        }

        productList.remove(product);
        System.out.println("Xóa sản phẩm thành công.");
    }

    public static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm đang trống.");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void createOrder(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        String key = String.valueOf(orderId);

        if (orderMap.containsKey(key)) {
            System.out.println("Đơn hàng đã tồn tại!");
            return;
        }

        Order order = new Order(orderId);
        orderMap.put(key, order);
        System.out.println("Tạo đơn hàng thành công.");
    }

    public static void addProductToOrder(Scanner scanner)
            throws OrderNotFoundException, ProductNotFoundException {

        System.out.print("Nhập mã đơn hàng: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        Order order = getOrderById(orderId);

        System.out.print("Nhập id sản phẩm cần thêm vào đơn: ");
        int productId = Integer.parseInt(scanner.nextLine());

        Product product = findProductById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có id = " + productId);
        }

        order.addProduct(product);
        System.out.println("Thêm sản phẩm vào đơn hàng thành công.");
    }

    public static void displayOrder(Scanner scanner) throws OrderNotFoundException {
        System.out.print("Nhập mã đơn hàng cần hiển thị: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        Order order = getOrderById(orderId);
        System.out.println(order);
    }

    public static Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static Order getOrderById(int orderId) throws OrderNotFoundException {
        String key = String.valueOf(orderId);

        if (!orderMap.containsKey(key)) {
            throw new OrderNotFoundException("Không tìm thấy đơn hàng có mã = " + orderId);
        }

        return orderMap.get(key);
    }
}